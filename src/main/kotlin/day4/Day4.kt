package com.github.rileymichael.aoc2025.day4

import com.github.rileymichael.aoc2025.Puzzle
import com.github.rileymichael.aoc2025.shared.CharGrid
import com.github.rileymichael.aoc2025.shared.Vector2

object Day4 : Puzzle<Diagram>(4) {
    override fun parse(input: Sequence<String>): Diagram = CharGrid.parse(input.toList())

    override fun part1(input: Diagram): Any {
        return input.count { position -> forkliftAccessible(input, position.first, position.second) }
    }

    override fun part2(input: Diagram): Any {
        var removed = 0
        while (true) {
            val accessible = input.filter { position -> forkliftAccessible(input, position.first, position.second) }
            if (accessible.isEmpty()) {
                break
            }
            for (pos in accessible) {
                input[pos.first] = EMPTY
                removed++
            }
        }

        return removed
    }
}

typealias Diagram = CharGrid

private const val EMPTY = '.'
private const val MARKER = '@'

private fun forkliftAccessible(diagram: Diagram, position: Vector2, char: Char): Boolean {
    if (char != MARKER) {
        return false
    }
    val adjacent = adjacentSymbols(diagram, position).count { it.second == MARKER }
    return adjacent < 4
}

private fun adjacentSymbols(diagram: Diagram, position: Vector2): List<Pair<Vector2, Char>> {
    val symbols = mutableListOf<Pair<Vector2, Char>>()
    for (n in Vector2.NEIGHBORS) {
        val pos = position + n
        if (diagram.contains(pos) && diagram[pos] != EMPTY) {
            symbols += pos to diagram[pos]
        }
    }
    return symbols.toList()
}