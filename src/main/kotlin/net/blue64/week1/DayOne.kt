package net.blue64.week1

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/1/22
 */
object DayOne {

  private const val TOP_THREE = 3

  private fun innerFind(cals: List<String>, acc: List<Int>, totals: List<Int>): List<Int> =
    if (cals.isEmpty()) {
      totals + acc.sum()
    } else if (cals.first() == "") {
      innerFind(cals.drop(1), listOf(), totals + acc.sum())
    } else {
      innerFind(cals.drop(1), (acc + cals.first().toInt()), totals)
    }

  fun findMaxCalories(calories: List<String>): Int = innerFind(calories, listOf(), listOf()).max()

  fun findTopThreeCalories(calories: List<String>): Int =
    innerFind(calories, listOf(), listOf()).sortedDescending().take(TOP_THREE).sum()
}
