package org.ai.roulettesystem.testdataproviders;

import java.util.List;

import lombok.experimental.UtilityClass;
import org.ai.roulettesystem.roulette.player.Player;

@UtilityClass
public class PlayerDataProvider {

  public static final Player PLAYER_1 = new Player("P1");
  public static final Player PLAYER_2 = new Player("P2");
  public static final List<Player> PLAYERS = List.of(PLAYER_1, PLAYER_2);

}
