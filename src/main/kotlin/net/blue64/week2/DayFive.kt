package net.blue64.week2

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/9/22
 */

fun <T> List<T>.split() = Pair(take(1), drop(1))

typealias Moves = List<Move>
typealias Stacks = List<ArrayDeque<Char>>

const val STACK_SIZE = 4
const val MOVE_NUM = 1
const val SRC_NUM = 3

data class Move(val num: Int, val src: Int, val dest: Int) {
  companion object Factory {
    fun fromString(moveString: String): Move {
      val moveChars = moveString.split(" ")
      return Move(moveChars[MOVE_NUM].toInt(), moveChars[SRC_NUM].toInt(), moveChars.last().toInt())
    }
  }
}

object DayFive {

  private fun parseInput(input: List<String>): Pair<Stacks, Moves> {
    fun createEmptyStacks(size: Int): Stacks {
      return (0 until size).map {
        ArrayDeque()
      }
    }

    fun createStacks(stacks: List<String>, size: Int): Stacks {

      val s = createEmptyStacks(size)
      stacks.forEach {
        it.chunked(STACK_SIZE).forEachIndexed { i, c ->
          if (c.isNotBlank()) s[i].addLast(c.toCharArray()[1])
        }
      }
      return s
    }

    fun parseMovesAndBoard(
      input: List<String>,
      stacks: List<String>,
      moves: List<Move>,
      size: Int
    ): Triple<List<String>, List<Move>, Int> {
      val (x, xs) = input.split()
      return when {
        xs.isEmpty() -> return Triple(stacks, moves + Move.fromString(x[0]), size)
        x[0].startsWith("move") -> parseMovesAndBoard(
          xs,
          stacks,
          moves + Move.fromString(x[0]),
          size
        )
        x[0].isBlank() -> parseMovesAndBoard(xs, stacks, moves, size)
        x[0].startsWith(" 1") -> {
          parseMovesAndBoard(xs, stacks, moves, x[0].split(" ").last().toInt())
        }

        else -> parseMovesAndBoard(xs, stacks + x[0], moves, size)
      }
    }

    val (b, m, s) = parseMovesAndBoard(input, listOf(), listOf(), 0)
    return Pair(createStacks(b, s), m)
  }

  fun rearrangeCrates(input: List<String>): List<Char> {
    val (board, moves) = parseInput(input)
    println(board)
    moves.forEach { move ->
      println(move)
      val crates = board[move.src - 1].take(move.num)
      crates.forEach {
        board[move.dest - 1].addFirst(it)
      }
      board[move.src - 1].removeAll(crates)
      println(board)
    }
    return board.map { it.getOrElse(0) { ' ' } }.filter { it != ' ' }
  }
}
