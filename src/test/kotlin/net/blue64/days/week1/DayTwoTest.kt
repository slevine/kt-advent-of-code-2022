package net.blue64.days.week1

import net.blue64.util.FileUtil.SRC_DIR
import net.blue64.util.FileUtil.TEST_DIR
import net.blue64.util.FileUtil.readStringsFromFile
import net.blue64.week1.DayTwo
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/2/22
 */
class DayTwoTest {

  @Test
  fun testPartOne() {
    assertEquals(
      15,
      DayTwo.calculateScores(readStringsFromFile(TEST_DIR, "DayTwoTest.txt"))
    )
  }

  @Test
  fun testPartTwo() {
    assertEquals(
      12,
      DayTwo.calculateNewScores(readStringsFromFile(TEST_DIR, "DayTwoTest.txt"))
    )
  }

  @Test
  fun testPartOneSubmitted() {
    assertEquals(
      12586,
      DayTwo.calculateScores(readStringsFromFile(SRC_DIR, "DayTwo.txt"))
    )
  }

  @Test
  fun testPartTwoSubmitted() {
    assertEquals(
      14220,
      DayTwo.calculateNewScores(readStringsFromFile(SRC_DIR, "DayTwo.txt"))
    )
  }
}
