package org.ai.roulettesystem.roulette;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static org.ai.roulettesystem.roulette.Color.BLACK;
import static org.ai.roulettesystem.roulette.Color.GREEN;
import static org.ai.roulettesystem.roulette.Color.RED;

/**
 * A class to represent a roulette boule.
 * A boule is a number between 0 and 36 included and can have some characteristics apart from the zero number:
 * - is ODD or EVEN
 * - is RED or BLACK
 * - is part of one of the three dozens 1_12, 13_24, 25_36
 * - is part of one of three column
 * - is MANQUE (1-19) or PASSE (19-36)
 *
 * The zero is a special boule, it does not have above characteristics and it has a GREEN color.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Boule {

  private static final Boule[] BOULES = new Boule[] {
      new Boule(0, GREEN),
      new Boule(1, RED),
      new Boule(2, BLACK),
      new Boule(3, RED),
      new Boule(4, BLACK),
      new Boule(5, RED),
      new Boule(6, BLACK),
      new Boule(7, RED),
      new Boule(8, BLACK),
      new Boule(9, RED),
      new Boule(10, BLACK),
      new Boule(11, BLACK),
      new Boule(12, RED),
      new Boule(13, BLACK),
      new Boule(14, RED),
      new Boule(15, BLACK),
      new Boule(16, RED),
      new Boule(17, BLACK),
      new Boule(18, RED),
      new Boule(19, RED),
      new Boule(20, BLACK),
      new Boule(21, RED),
      new Boule(22, BLACK),
      new Boule(23, RED),
      new Boule(24, BLACK),
      new Boule(25, RED),
      new Boule(26, BLACK),
      new Boule(27, RED),
      new Boule(28, BLACK),
      new Boule(29, BLACK),
      new Boule(30, RED),
      new Boule(31, BLACK),
      new Boule(32, RED),
      new Boule(33, BLACK),
      new Boule(34, RED),
      new Boule(35, BLACK),
      new Boule(36, RED),
  };

  private Integer number;
  private Color color;

  public static Boule get(int number) {
    return BOULES[number];
  }

  public boolean isEven() {
    return number != 0 && number % 2 == 0;
  }
  public boolean isOdd() {
    return number != 0 && number % 2 != 0;
  }
  public boolean isManque() {
    return number != 0 && number <= 18;
  }
  public boolean isPasse() {
    return number != 0 && number >= 19;
  }
  public boolean isRed() {
    return number != 0 && RED == color;
  }
  public boolean isBlack() {
    return number != 0 && BLACK == color;
  }
  public boolean is1_12() {
    return number != 0 && number <= 12;
  }
  public boolean is13_24() {
    return number != 0 && number > 12 && number <= 24;
  }
  public boolean is25_36() {
    return number != 0 && number > 24 && number <= 36;
  }
  public boolean isFirstColumn() {
    return number != 0 && number % 3 == 0;
  }
  public boolean isSecondColumn() {
    return number != 0 && number % 3 == 2;
  }
  public boolean isThirdColumn() {
    return number != 0 && number % 3 == 1;
  }
}
