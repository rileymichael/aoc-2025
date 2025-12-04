package com.github.rileymichael.aoc2025.day3

import com.github.rileymichael.aoc2025.Puzzle

object Day3 : Puzzle<Sequence<JoltageBank>>(3) {
    override fun parse(input: Sequence<String>) = input

    override fun part1(input: Sequence<JoltageBank>) = input.sumOf { bank -> bank.potential(n = 2) }

    override fun part2(input: Sequence<JoltageBank>) = input.sumOf { bank -> bank.potential(n = 12) }
}

typealias Joltage = Char
typealias JoltageBank = String

private fun JoltageBank.potential(n: Int): Long {
    val stack = ArrayDeque<Joltage>(n)
    var removalsLeft = length - n

    for (num in this) {
        while (stack.isNotEmpty() && removalsLeft > 0 && stack.last() < num) {
            stack.removeLast()
            removalsLeft--
        }
        stack.addLast(num)
    }

    return stack.take(n).joinToString(separator = "").toLong()
}