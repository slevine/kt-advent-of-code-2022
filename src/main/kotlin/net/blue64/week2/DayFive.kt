package net.blue64.week2

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/11/22
 */

data class Move(val num: Int, val src: Int, val dest: Int) {
  companion object Factory {
    fun fromString(moveString: String): Move {
      val moveInts = moveString.split(" ").filter {
        it.toCharArray()[0].isDigit()
      }.map { it.toInt() }
      return Move(moveInts[0], moveInts[1], moveInts[2])
    }
  }
}

typealias Moves = List<Move>
typealias Stacks = List<ArrayDeque<Char>>

object DayFive {
  private const val STACK_CHAR_SIZE = 4

  private fun parseInput(input: List<String>): Pair<Stacks, Moves> {
    fun createEmptyStacks(size: Int): Stacks = (0 until size).map { ArrayDeque() }

    fun createStacks(stackStrings: List<String>, size: Int): Stacks {
      val stacks = createEmptyStacks(size)
      stackStrings.forEach {
        it.chunked(STACK_CHAR_SIZE).forEachIndexed { i, c ->
          if (c.isNotBlank()) stacks[i].addLast(c.toCharArray()[1])
        }
      }
      return stacks
    }

    fun parseMovesAndBoard(
      input: List<String>,
      stacks: List<String>,
      moves: List<Move>,
      size: Int
    ): Triple<List<String>, Moves, Int> {
      val (x, xs) = Pair(input.take(1), input.drop(1))
      return when {
        xs.isEmpty() ->
          return Triple(stacks, moves + Move.fromString(x[0]), size)
        x.first().startsWith("move") ->
          parseMovesAndBoard(xs, stacks, moves + Move.fromString(x[0]), size)
        x.first().isBlank() ->
          parseMovesAndBoard(xs, stacks, moves, size)
        x.first().startsWith(" 1") ->
          parseMovesAndBoard(xs, stacks, moves, x.first().split(" ").last().toInt())
        else ->
          parseMovesAndBoard(xs, stacks + x.first(), moves, size)
      }
    }

    val (stacks, moves, size) = parseMovesAndBoard(input, listOf(), listOf(), 0)
    return Pair(createStacks(stacks, size), moves)
  }

  fun rearrangeCrates(input: List<String>): List<Char> {
    val (board, moves) = parseInput(input)
    moves.forEach { move ->
      repeat(move.num) {
        val crates = board[move.src - 1].removeFirst()
        board[move.dest - 1].addFirst(crates)
      }
    }
    return board.map { it.first() }
  }

  fun rearrangeMultipleCrates(input: List<String>): List<Char> {
    val (board, moves) = parseInput(input)
    moves.forEach { move ->
      val crates = board[move.src - 1].take(move.num)
      repeat(move.num) {
        board[move.src - 1].removeFirst()
      }
      crates.reversed().forEach { board[move.dest - 1].addFirst(it) }
    }
    return board.map { it.first() }
  }
}
