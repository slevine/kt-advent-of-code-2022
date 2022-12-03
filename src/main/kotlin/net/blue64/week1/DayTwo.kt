package net.blue64.week1

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/2/22
 */
object DayTwo {

  private const val ROCK = 1
  private const val PAPER = 2
  private const val SCISSORS = 3

  private const val WIN = 6
  private const val DRAW = 3
  private const val LOSS = 0

  private fun innerCalculateScore(pairs: List<Pair<String, String>>): Int =
    pairs.fold(0) { acc, pair ->
      when (pair.second) {
        "X" -> ROCK + when (pair.first) {
          "A" -> acc + DRAW
          "B" -> acc + LOSS
          else -> acc + WIN
        }
        "Y" -> PAPER + when (pair.first) {
          "A" -> acc + WIN
          "B" -> acc + DRAW
          else -> acc + LOSS
        }
        else -> SCISSORS + when (pair.first) {
          "A" -> acc + LOSS
          "B" -> acc + WIN
          else -> acc + DRAW
        }
      }
    }

  /**
   * A|X Rock = Lose
   * B|Y Paper = Draw
   * C|Z Scissors = WIN
   */
  private fun innerTransform(pairs: List<Pair<String, String>>): List<Pair<String, String>> =
    pairs.map {
      when (it.second) {
        "X" -> when (it.first) {
          "A" -> Pair("A", "Y")
          "B" -> Pair("B", "X")
          else -> Pair("C", "Z")
        }
        "Y" -> when (it.first) {
          "A" -> Pair("A", "X")
          "B" -> Pair("B", "Y")
          else -> Pair("C", "Z")
        }
        else -> when (it.first) {
          "A" -> Pair("A", "Y")
          "B" -> Pair("B", "Z")
          else -> Pair("C", "X")
        }
      }
    }

  private fun parsePairs(pairs: List<String>): List<Pair<String, String>> = pairs.map {
    val (first, second) = it.split(" ")
    Pair(first, second)
  }

  fun calculateScores(pairs: List<String>): Int = innerCalculateScore(parsePairs(pairs))

  fun calculateNewScores(pairs: List<String>): Int = innerCalculateScore(
    innerTransform(parsePairs(pairs))
  )
}
