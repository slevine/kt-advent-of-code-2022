package net.blue64.week2

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/8/22
 */
object DayFour {

  fun findOverlaps(assignments: List<String>): Int {
    return assignments.count {
      val (r1, r2) = parseLine(it)
      val intersection = r1 intersect r2
      (intersection == r1.toList().toSet() || intersection == r2.toList().toSet())
    }
  }

  fun findAnyOverlap(assignments: List<String>): Int {
    return assignments.count {
      val (r1, r2) = parseLine(it)
      (r1 intersect r2).isNotEmpty()
    }
  }

  private fun parseLine(line: String): Pair<IntRange, IntRange> {
    val (f, s) = line.split(",")

    fun parsePair(pair: String) = IntRange(
      pair.split("-").first().toInt(),
      pair.split("-").last().toInt()
    )

    return Pair(parsePair(f), parsePair(s))
  }
}
