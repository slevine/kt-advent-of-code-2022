package net.blue64.days.week2

import net.blue64.util.FileUtil.SRC_DIR
import net.blue64.util.FileUtil.TEST_DIR
import net.blue64.util.FileUtil.readStringsFromFile
import net.blue64.week2.DayFive
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/11/22
 */
class DayFiveTest {

  @Test
  fun testPartOne() {
    assertEquals(
      listOf('C', 'M', 'Z'),
      DayFive.rearrangeCrates(readStringsFromFile(TEST_DIR, "DayFiveTest.txt"))
    )
  }

  @Test
  fun testPartOneSolution() {
    assertEquals(
      listOf('T', 'P', 'G', 'V', 'Q', 'P', 'F', 'D', 'H'),
      DayFive.rearrangeCrates(readStringsFromFile(SRC_DIR, "DayFive.txt"))
    )
  }

  @Test
  fun testPartTwo() {
    assertEquals(
      listOf('M', 'C', 'D'),
      DayFive.rearrangeMultipleCrates(readStringsFromFile(TEST_DIR, "DayFiveTest.txt"))
    )
  }

  @Test
  fun testPartTwoSolution() {
    assertEquals(
      listOf('D', 'M', 'R', 'D', 'F', 'R', 'H', 'H', 'H'),
      DayFive.rearrangeMultipleCrates(readStringsFromFile(SRC_DIR, "DayFive.txt"))
    )
  }
}
