package com.github.rileymichael.aoc2025.day2

import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun `part 1 example`() {
        assert(Day2.solve(Day2::part1, input) == 1227775554L)
    }

    @Test
    fun `part 1 solution`() {
        assert(Day2.solve(Day2::part1) == 21139440284L)
    }

    @Test
    fun `part 2 example`() {
        assert(Day2.solve(Day2::part2, input) == 4174379265)
    }

    @Test
    fun `part 2 solution`() {
        assert(Day2.solve(Day2::part2) == 38731915928)
    }

    companion object {
        private val input = """
11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
        """.trimIndent()
    }
}