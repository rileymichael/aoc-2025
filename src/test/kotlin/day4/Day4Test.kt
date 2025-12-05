package com.github.rileymichael.aoc2025.day4

import org.junit.jupiter.api.Test

class Day4Test {
    @Test
    fun `part 1 example`() {
        assert(Day4.solve(Day4::part1, input) == 13)
    }

    @Test
    fun `part 1 solution`() {
        assert(Day4.solve(Day4::part1) == 1502)
    }

    @Test
    fun `part 2 example`() {
        assert(Day4.solve(Day4::part2, input) == 43)
    }

    @Test
    fun `part 2 solution`() {
        assert(Day4.solve(Day4::part2) == 9083)
    }

    companion object {
        private val input = """
..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.
        """.trimIndent()
    }
}