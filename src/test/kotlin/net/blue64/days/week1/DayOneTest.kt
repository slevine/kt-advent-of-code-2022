package net.blue64.days.week1

import net.blue64.util.FileUtil.SRC_DIR
import net.blue64.util.FileUtil.TEST_DIR
import net.blue64.util.FileUtil.readStringsFromFile
import net.blue64.week1.DayOne
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/1/22
 */
class DayOneTest {

  @Test
  fun testFindMaxCalories() {
    assertEquals(
      24000,
      DayOne.findMaxCalories(
        readStringsFromFile(TEST_DIR, "DayOneTest.txt")
      )
    )
  }

  @Test
  fun testFindTopThreeCalories() {
    assertEquals(
      45000,
      DayOne.findTopThreeCalories(
        readStringsFromFile(TEST_DIR, "DayOneTest.txt")
      )
    )
  }

  @Test
  fun testPartOneSubmitted() {
    assertEquals(
      66186,
      DayOne.findMaxCalories(
        readStringsFromFile(SRC_DIR, "DayOne.txt")
      )
    )
  }

  @Test
  fun testPartTwoSubmitted() {
    assertEquals(
      196804,
      DayOne.findTopThreeCalories(
        readStringsFromFile(SRC_DIR, "DayOne.txt")
      )
    )
  }
}
