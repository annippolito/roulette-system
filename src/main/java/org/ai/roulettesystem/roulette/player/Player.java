package org.ai.roulettesystem.roulette.player;

import java.util.function.Consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ai.roulettesystem.roulette.Boule;
import reactor.core.Disposable;
import reactor.core.publisher.ConnectableFlux;

@Slf4j
@RequiredArgsConstructor
public class Player implements Consumer<Boule> {

  private final String id;
  private Disposable subscription;

  public void accept(Boule boule) {
    //TODO implement strategy to play
    log.info(id + ": see " + boule);
  }

  public void subscribe(ConnectableFlux<Boule> rouletteSpinner) {
    subscription = rouletteSpinner.subscribe(this);
  }

  public void unsubscribe() {
    if(subscription == null || subscription.isDisposed()) return;
    subscription.dispose();
  }

}
