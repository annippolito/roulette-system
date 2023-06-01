package org.ai.roulettesystem.roulette;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * A class to represent a roulette object as an infinite stream
 * Each spin of the roulette provides a boule
 */
@Slf4j
public final class Roulette {
  private static final Random random = new Random();
  private static Roulette roulette;
  private Stream<Boule> bouleStream;
  @Getter
  private Disposable disposable;
  private Roulette() {
    init();
  }

  public static Roulette getInstance() {
    if(roulette == null){
      roulette = new Roulette();
    }
    return roulette;
  }

  private void init() {
    bouleStream = Stream.generate(() -> random.nextInt(35)).map(Boule::get);
  }

  public void start() {
    disposable = Flowable.fromStream(bouleStream)
        .subscribeOn(Schedulers.from(Executors.newSingleThreadExecutor()))
        .onBackpressureBuffer(5, null, BackpressureOverflowStrategy.ERROR)
        .subscribe(item -> {
          log.info(item.toString());
          Thread.sleep(1000);
        });
  }

  public void stop() {
    if (!disposable.isDisposed()) {
      disposable.dispose();
    }
  }

}
