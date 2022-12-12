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
 * Date: 12/9/22
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
      listOf('B', 'L', 'W'),
      DayFive.rearrangeCrates(readStringsFromFile(SRC_DIR, "DayFive.txt"))
    )
  }

}
