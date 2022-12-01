package io.thecoati.adventofcode.days

import io.thecoati.adventofcode.FileInput

class Day1: Day {
    override fun title(): String {
        return "Day 1 - Calorie Counting"
    }

    override fun input(): FileInput {
        return FileInput("day1")
    }

    override fun part1(input: FileInput): String {
        return input.split().maxOf { it.sum() }.toString()
    }

    override fun part2(input: FileInput): String {
        return input.split().map { it.sum() }
            .sortedByDescending { it }
            .take(3)
            .sum()
            .toString()
    }

    private fun FileInput.split(): List<List<Int>> {
        return this.joinToString("|")
            .split("||")
            .map { it.split("|") }
            .map { it.map { v -> v.toInt() } }
    }
}