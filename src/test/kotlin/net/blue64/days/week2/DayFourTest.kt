package net.blue64.days.week2

import net.blue64.util.FileUtil.SRC_DIR
import net.blue64.util.FileUtil.TEST_DIR
import net.blue64.util.FileUtil.readStringsFromFile
import net.blue64.week2.DayFour
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/8/22
 */
class DayFourTest {

  @Test
  fun testPartOne() {
    assertEquals(
      2,
      DayFour.findOverlaps(readStringsFromFile(TEST_DIR, "DayFourTest.txt"))
    )
  }

  @Test
  fun testPartTwo() {
    assertEquals(
      4,
      DayFour.findAnyOverlap(readStringsFromFile(TEST_DIR, "DayFourTest.txt"))
    )
  }

  @Test
  fun testPartOneSolution() {
    assertEquals(
      413,
      DayFour.findOverlaps(readStringsFromFile(SRC_DIR, "DayFour.txt"))
    )
  }

  @Test
  fun testPartTwoSolution() {
    assertEquals(
      806,
      DayFour.findAnyOverlap(readStringsFromFile(SRC_DIR, "DayFour.txt"))
    )
  }
}
