package io.thecoati.adventofcode.days

import io.thecoati.adventofcode.FileInput
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class Day3Test {
    private val day = Day3()
    private val input = FileInput("day3")

    @Test
    fun part1() {
        val expected = "0"
        val result = this.day.part1(this.input)

        assertEquals(expected, result)
    }

    @Test
    fun part2() {
        val expected = "0"
        val result = this.day.part2(this.input)

        assertEquals(expected, result)
    }
}