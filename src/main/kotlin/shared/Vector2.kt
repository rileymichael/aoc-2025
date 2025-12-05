package com.github.rileymichael.aoc2025.shared

data class Vector2(
    val x: Int,
    val y: Int,
) {
    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)

    companion object {
        val NEIGHBORS = buildSet {
            (-1..1).forEach { y ->
                (-1..1).forEach { x ->
                    if (y != 0 || x != 0) {
                        add(Vector2(x, y))
                    }
                }
            }
        }
    }
}

