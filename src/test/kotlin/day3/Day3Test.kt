package com.github.rileymichael.aoc2025.day3

import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun `part 1 example`() {
        assert(Day3.solve(Day3::part1, input) == 357L)
    }

    @Test
    fun `part 1 solution`() {
        assert(Day3.solve(Day3::part1) == 16973L)
    }

    @Test
    fun `part 2 example`() {
        assert(Day3.solve(Day3::part2, input) == 3121910778619)
    }

    @Test
    fun `part 2 solution`() {
        assert(Day3.solve(Day3::part2) == 168027167146027)
    }

    companion object {
        private val input = """
987654321111111
811111111111119
234234234234278
818181911112111
        """.trimIndent()
    }
}