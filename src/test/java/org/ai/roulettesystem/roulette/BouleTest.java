package org.ai.roulettesystem.roulette;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BouleTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 35})
  void testBouleIsOdd(int number) {
    Assertions.assertTrue(Boule.get(number).isOdd());
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36})
  void testBouleIsEven(int number) {
    Assertions.assertTrue(Boule.get(number).isEven());
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36})
  void testBouleIsRed(int number) {
    Assertions.assertTrue(Boule.get(number).isRed());
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35})
  void testBouleIsBlack(int number) {
    Assertions.assertTrue(Boule.get(number).isBlack());
  }

  @ParameterizedTest
  @ValueSource(ints = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36})
  void testBouleIsFirstColumn(int number) {
    Assertions.assertTrue(Boule.get(number).isFirstColumn());
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35})
  void testBouleIsSecondColumn(int number) {
    Assertions.assertTrue(Boule.get(number).isSecondColumn());
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34})
  void testBouleIsThirdColumn(int number) {
    Assertions.assertTrue(Boule.get(number).isThirdColumn());
  }

  @Test
  void testBouleIsManque() {
    IntStream.range(1, 19)
        .mapToObj(Boule::get)
        .forEach(b -> Assertions.assertTrue(b.isManque()));
  }

  @Test
  void testBouleIsPasse() {
    IntStream.range(19, 37)
        .mapToObj(Boule::get)
        .forEach(b -> Assertions.assertTrue(b.isPasse()));
  }

  @Test
  void testBouleIs1_12() {
    IntStream.range(1, 13)
        .mapToObj(Boule::get)
        .forEach(b -> Assertions.assertTrue(b.is1_12()));
  }

  @Test
  void testBouleIs13_24() {
    IntStream.range(13, 25)
        .mapToObj(Boule::get)
        .forEach(b -> Assertions.assertTrue(b.is13_24()));
  }

  @Test
  void testBouleIs15_36() {
    IntStream.range(25, 36)
        .mapToObj(Boule::get)
        .forEach(b -> Assertions.assertTrue(b.is25_36()));
  }

  @Test
  void testNegativeAnsUpperLowerBounds() {
    Assertions.assertAll(
        () -> Assertions.assertFalse(Boule.get(2).isOdd()),
        () -> Assertions.assertFalse(Boule.get(1).isEven()),
        () -> Assertions.assertFalse(Boule.get(19).isManque()),
        () -> Assertions.assertFalse(Boule.get(18).isPasse()),
        () -> Assertions.assertFalse(Boule.get(13).is1_12()),
        () -> Assertions.assertFalse(Boule.get(12).is13_24()),
        () -> Assertions.assertFalse(Boule.get(25).is13_24()),
        () -> Assertions.assertFalse(Boule.get(24).is25_36())
    );
  }

  @Test
  void testZeroIsNothing() {
    Assertions.assertAll(
        () -> Assertions.assertFalse(Boule.get(0).isOdd()),
        () -> Assertions.assertFalse(Boule.get(0).isEven()),
        () -> Assertions.assertFalse(Boule.get(0).isBlack()),
        () -> Assertions.assertFalse(Boule.get(0).isRed()),
        () -> Assertions.assertFalse(Boule.get(0).isPasse()),
        () -> Assertions.assertFalse(Boule.get(0).isManque()),
        () -> Assertions.assertFalse(Boule.get(0).is1_12()),
        () -> Assertions.assertFalse(Boule.get(0).is13_24()),
        () -> Assertions.assertFalse(Boule.get(0).is25_36()),
        () -> Assertions.assertFalse(Boule.get(0).isFirstColumn()),
        () -> Assertions.assertFalse(Boule.get(0).isSecondColumn()),
        () -> Assertions.assertFalse(Boule.get(0).isThirdColumn())
    );
  }
}