package org.ai.roulettesystem.roulette;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.ai.roulettesystem.testdataproviders.PlayerDataProvider.PLAYERS;

class RouletteTest {

  @Test
  void getFreshInstance() {
    Roulette roulette = new Roulette(10, PLAYERS);

    Assertions.assertNotNull(roulette);
    Assertions.assertEquals(PLAYERS, roulette.getPlayers());
    Assertions.assertEquals(10, roulette.getNumberOfSpin());
    Assertions.assertNull(roulette.getBoulesPublisher());
    Assertions.assertNull(roulette.getSubscription());

  }

  @Test
  void start() {
    Roulette roulette = new Roulette(10, PLAYERS);
    Assertions.assertDoesNotThrow(roulette::start);

    var spinner = roulette.getBoulesPublisher();
    Assertions.assertNotNull(spinner);
    Assertions.assertNotNull(roulette.getSubscription());
    Assertions.assertTrue(roulette.getSubscription().isDisposed());
  }
}