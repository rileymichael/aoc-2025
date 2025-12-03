package com.github.rileymichael.aoc2025.day2

import com.github.rileymichael.aoc2025.Puzzle

object Day2 : Puzzle<Sequence<ProductIdRange>>(2) {
    override fun parse(input: Sequence<String>): Sequence<ProductIdRange> = input.flatMap { line ->
        line.split(",").map { range ->
            val (start, end) = range.split("-").map(ProductId::from)
            start..end
        }
    }

    override fun part1(input: Sequence<ProductIdRange>) = input.sumOf { range ->
        range.sumOfInvalidIds(validator = exactRepeatingDigitValidator)
    }

    override fun part2(input: Sequence<ProductIdRange>) = input.sumOf { range ->
        range.sumOfInvalidIds(validator = minimumRepeatingDigitValidator)
    }
}

@JvmInline
value class ProductId(val value: Long) : Comparable<ProductId> {
    override fun compareTo(other: ProductId): Int = value.compareTo(other.value)

    operator fun rangeTo(other: ProductId): ProductIdRange = ProductIdRange(this, other)

    companion object {
        fun from(input: String): ProductId = ProductId(input.toLong())
    }
}

class ProductIdRange(override val start: ProductId, override val endInclusive: ProductId) :
    ClosedRange<ProductId>, Iterable<ProductId> {

    override fun iterator(): Iterator<ProductId> =
        (start.value..endInclusive.value).asSequence().map(::ProductId).iterator()
}

private typealias ProductIdValidator = ProductId.() -> Boolean

private fun ProductIdRange.sumOfInvalidIds(validator: ProductIdValidator): Long =
    filterNot { validator.invoke(it) }.sumOf(ProductId::value)

private val exactRepeatingDigitValidator: ProductIdValidator = {
    val s = value.toString()
    val length = s.length
    if (length % 2 != 0) {
        true
    } else {
        s.take(length / 2) != s.drop(length / 2)
    }
}

private val minimumRepeatingDigitValidator: ProductIdValidator = {
    val s = value.toString()
    val length = s.length
    val chunks = (1..length / 2).mapNotNull {
        if (length % it != 0) {
            null
        } else {
            s.chunked(it)
        }
    }
    chunks.none { chunk ->
//        chunk.distinct().size == 1
        chunk.all { it == chunk.first() }
    }
}
