package net.blue64.days.week1

import net.blue64.util.FileUtil
import net.blue64.util.FileUtil.TEST_DIR
import net.blue64.util.FileUtil.readStringsFromFile
import net.blue64.week1.DayThree
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/2/22
 */
class DayThreeTest {

  @Test
  fun testSplitter() {
    assertEquals(
      Pair("vJrwpWtwJgWr", "hcsFMMfFFhFp"),
      DayThree.splitItem("vJrwpWtwJgWrhcsFMMfFFhFp")
    )
    assertEquals(
      Pair("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL"),
      DayThree.splitItem("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")
    )
    assertEquals(
      Pair("PmmdzqPrV", "vPwwTWBwg"),
      DayThree.splitItem("PmmdzqPrVvPwwTWBwg")
    )
  }

  @Test
  fun testFindCommon() {
    assertEquals('p', DayThree.findCommonItem("vJrwpWtwJgWrhcsFMMfFFhFp"))
    assertEquals('L', DayThree.findCommonItem("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"))
    assertEquals('P', DayThree.findCommonItem("PmmdzqPrVvPwwTWBwg"))
  }

  @Test
  fun testFindCommonTriple() {
    assertEquals(
      'r',
      DayThree.findCommonItem(
        Triple(
          "vJrwpWtwJgWrhcsFMMfFFhFp",
          "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
          "PmmdzqPrVvPwwTWBwg"
        )
      )
    )
  }

  @Test
  fun testPartOne() {
    assertEquals(
      157,
      DayThree.findPriorities(readStringsFromFile(TEST_DIR, "DayThreeTest.txt"))
    )
  }

  @Test
  fun testPartTwo() {
    assertEquals(
      70,
      DayThree.findCommonItemType(readStringsFromFile(TEST_DIR, "DayThreeTest.txt"))
    )
  }

  @Test
  fun testPartOneSubmitted() {
    assertEquals(
      8252,
      DayThree.findPriorities(readStringsFromFile(FileUtil.SRC_DIR, "DayThree.txt"))
    )
  }

  @Test
  fun testPartTwoSubmitted() {
    assertEquals(
      2828,
      DayThree.findCommonItemType(readStringsFromFile(FileUtil.SRC_DIR, "DayThree.txt"))
    )
  }
}
