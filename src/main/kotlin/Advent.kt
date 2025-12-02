package com.github.rileymichael.aoc2025

import com.github.rileymichael.aoc2025.day1.Day1

fun main() {
    val days = listOf(
        Day1,
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