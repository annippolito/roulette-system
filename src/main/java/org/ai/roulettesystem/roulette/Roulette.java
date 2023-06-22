package org.ai.roulettesystem.roulette;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ai.roulettesystem.roulette.player.Player;
import reactor.core.Disposable;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

/**
 * A class to represent a roulette object as an infinite stream
 * Each spin of the roulette provides a boule
 */
@Slf4j
@RequiredArgsConstructor
public final class Roulette {
  private static final Random random = new Random();
  @Getter
  private ConnectableFlux<Boule> boulesPublisher;
  @Getter
  private final int numberOfSpin;
  @Getter
  private final List<Player> players;
  @Getter
  private Disposable subscription;

  public void start() {
    var bouleStream = Stream.generate(() -> random.nextInt(35)).map(Boule::get);

    boulesPublisher = Flux.fromStream(bouleStream)
        .take(numberOfSpin)
        .doOnComplete(this::dispose)
        .publish();
    players.forEach(p -> p.subscribe(boulesPublisher));
    subscription = boulesPublisher.connect();
  }

  private void dispose() {
    if(subscription != null && !subscription.isDisposed()) {
      subscription.dispose();
    }
    players.forEach(Player::unsubscribe);
  }

  public static void main(String[] args) {
    var player1 = new Player("P1");
    var player2 = new Player("P2");

    new Roulette(10, List.of(player1, player2)).start();
  }

}
