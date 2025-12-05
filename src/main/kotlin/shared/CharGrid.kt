package com.github.rileymichael.aoc2025.shared

class CharGrid(
    val width: Int,
    val height: Int,
    init: (Vector2) -> Char,
) : Iterable<Pair<Vector2, Char>> {

    val xRange = 0..<width
    val yRange = 0..<height

    init {
        require(width > 0)
        require(height > 0)
    }

    private val values = CharArray(width * height) { position ->
        val x = position % width
        val y = position / width
        init(Vector2(x, y))
    }

    operator fun set(position: Vector2, value: Char) {
        values[index(position)] = value
    }

    operator fun get(position: Vector2): Char {
        return values[index(position)]
    }

    operator fun contains(position: Vector2): Boolean {
        return position.x in xRange && position.y in yRange
    }

    private fun index(position: Vector2): Int {
        require(position.x in xRange && position.y in yRange)
        return (position.y * width) + position.x
    }

    override fun iterator(): Iterator<Pair<Vector2, Char>> {
        return iterator {
            yRange.forEach { y ->
                xRange.forEach { x ->
                    val position = Vector2(x, y)
                    val value = get(position)
                    yield(position to value)
                }
            }
        }
    }

    override fun toString(): String {
        return yRange.joinToString(separator = "\n") { y ->
            xRange.map { x -> this[Vector2(x, y)] }.joinToString(separator = "")
        }
    }

    companion object {
        fun parse(lines: List<String>): CharGrid {
            val width = lines.first().length
            val height = lines.size

            return CharGrid(width, height) { (x, y) ->
                val line = lines[y]
                val char = line[x]
                char
            }
        }
    }
}