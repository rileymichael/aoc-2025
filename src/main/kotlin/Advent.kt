package com.github.rileymichael.aoc2025

import com.github.rileymichael.aoc2025.day1.Day1
import com.github.rileymichael.aoc2025.day2.Day2
import com.github.rileymichael.aoc2025.day3.Day3

fun main() {
    val days = listOf(
        Day1,
        Day2,
        Day3,
    )
    days.lastOrNull()?.run { solve() }
}

private fun <T> Puzzle<T>.solve() {
    println("----Day $day----")
    listOf(::part1, ::part2).forEachIndexed { index, solution ->
        val (parse, answer) = solveTimed(solution)
        println(
            """
- Part ${index + 1} -
parsed in: ${parse.duration}
solved in: ${answer.duration}
solution: 
${answer.value}
            """.trimIndent()
        )
    }
}