package net.blue64.week1

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/3/22
 */
object DayThree {

  private const val ALPHABET_SIZE = 26
  private const val GROUP_SIZE = 3

  private val priorityMap =
    ('a'..'z').mapIndexed { i, c -> c to i + 1 }.toMap()
      .plus(('A'..'Z').mapIndexed { i, c -> c to (i + 1) + ALPHABET_SIZE }.toMap())

  fun splitItem(items: String): Pair<String, String> =
    Pair(items.take(items.length / 2), items.drop(items.length / 2))

  /**
   * Step 1: Split list of items in half
   * Step 2: Filter any chars that do not appear in both lists
   * Step 3: Pull remaining char (one we are looking for)
   */
  fun findCommonItem(items: String): Char {
    val (f, s) = splitItem(items)
    return f.filter(s::contains).take(1)[0]
  }

  fun findCommonItem(items: Triple<String, String, String>): Char {
    return items.first
      .filter(items.second::contains)
      .filter(items.third::contains)
      .take(1)[0]
  }

  /**
   * Step 1: Find the common item
   * Step 2: Find its value in the priorityMap
   * Step 3: Return sum
   */
  fun findPriorities(items: List<String>): Int = items.sumOf {
    val commonItem = findCommonItem(it)
    priorityMap[commonItem]!!
  }

  fun findCommonItemType(items: List<String>): Int = items.chunked(GROUP_SIZE)
    .map { group -> findCommonItem(Triple(group[0], group[1], group[2])) }
    .sumOf { i -> priorityMap.getOrElse(i) { 0 } }
}
