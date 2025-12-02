package com.github.rileymichael.aoc2025.day1

import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun `part 1 example`() {
        assert(Day1.solve(Day1::part1, input) == 3)
    }

    @Test
    fun `part 1 solution`() {
        assert(Day1.solve(Day1::part1) == 997)
    }

    @Test
    fun `part 2 example`() {
        assert(Day1.solve(Day1::part2, input) == 6)
    }

    @Test
    fun `part 2 solution`() {
        assert(Day1.solve(Day1::part2) == 5978)
    }

    companion object {
        private val input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent()
    }
}