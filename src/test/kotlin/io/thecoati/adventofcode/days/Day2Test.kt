package io.thecoati.adventofcode.days

import io.thecoati.adventofcode.FileInput
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class Day2Test {
    private val day = Day2()
    private val input = FileInput("day2")

    @Test
    fun part1() {
        val expected = "15"
        val result = this.day.part1(this.input)

        assertEquals(expected, result)
    }

    @Test
    fun part2() {
        val expected = "12"
        val result = this.day.part2(this.input)

        assertEquals(expected, result)
    }
}