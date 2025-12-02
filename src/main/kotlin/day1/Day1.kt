package com.github.rileymichael.aoc2025.day1

import com.github.rileymichael.aoc2025.Puzzle
import kotlin.math.absoluteValue

object Day1 : Puzzle<Sequence<Rotation>>(1) {
    override fun parse(input: Sequence<String>): Sequence<Rotation> = input.map(Rotation::parse)

    override fun part1(input: Sequence<Rotation>): Any = input.runningFold(
        Dial(50), Dial::apply
    ).count { it.position == 0 }

    override fun part2(input: Sequence<Rotation>): Any = input.runningFold(
        Dial(50), Dial::apply
    ).sumOf { it.zeroCount }
}

data class Dial(
    val position: Int,
    val zeroCount: Int = 0,
) {
    fun apply(rotation: Rotation): Dial {
        val turn = position + rotation.distance

        val offset = if (rotation.distance < 0) -1 else 0
        val start = (position + offset).floorDiv(SIZE)
        val end = (turn + offset).floorDiv(SIZE)

        return copy(
            position = turn % SIZE,
            zeroCount = (end - start).absoluteValue
        )
    }

    companion object {
        private const val SIZE = 100
    }
}

data class Rotation(
    val distance: Int,
) {
    companion object {
        fun parse(value: String): Rotation {
            val clicks = value.replaceFirstChar {
                if (it == 'L') '-' else '+'
            }.toInt()
            return Rotation(clicks)
        }
    }
}

