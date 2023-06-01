package org.ai.roulettesystem.roulette;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RouletteTest {

  private Roulette roulette;

  @BeforeEach
  void init() {
    roulette = Roulette.getInstance();
  }

  @AfterEach
  void after() {
    roulette.getDisposable().dispose();
  }

  @Test
  void getFreshInstance() {
    Assertions.assertNotNull(roulette);
  }

  @Test
  void getInstanceShouldReturnTheSameInstance() {
    var roulette2 = Roulette.getInstance();

    Assertions.assertSame(roulette, roulette2);
  }

  @Test
  void start() {
    Assertions.assertDoesNotThrow(roulette::start);
    Assertions.assertFalse(roulette.getDisposable().isDisposed());
  }

  @Test
  void stop() {
    roulette.start();

    Assertions.assertDoesNotThrow(roulette::stop);
    Assertions.assertTrue(roulette.getDisposable().isDisposed());
  }
}