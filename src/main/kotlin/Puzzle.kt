package com.github.rileymichael.aoc2025

import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

typealias Solution<T> = (T) -> Any

abstract class Puzzle<T>(val day: Int) {
    fun solveTimed(solution: Solution<T>): Pair<TimedValue<T>, TimedValue<Any>> {
        val input = this::class.java.classLoader.getResourceAsStream("Day$day.txt")
        requireNotNull(input) { "Input for day $day not found" }
        input.bufferedReader().useLines {
            val parse = measureTimedValue { parse(it) }
            val answer = measureTimedValue { solution(parse.value) }
            return parse to answer
        }
    }

    fun solve(solution: Solution<T>) = solveTimed(solution).second.value

    fun solve(solution: Solution<T>, input: String) = solution(parse(input.trimIndent().lineSequence()))

    abstract fun parse(input: Sequence<String>): T

    abstract fun part1(input: T): Any

    abstract fun part2(input: T): Any
}