package io.thecoati.adventofcode.days

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class Day1Test {
    private val day1 = Day1()

    @Test
    fun part1() {
        val expected = "71300"
        val result = this.day1.part1(this.day1.input())

        assertEquals(expected, result)
    }

    @Test
    fun part2() {
        val expected = "209691"
        val result = this.day1.part2(this.day1.input())

        assertEquals(expected, result)
    }
}