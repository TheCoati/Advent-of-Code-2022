package io.thecoati.adventofcode.days

import io.thecoati.adventofcode.FileInput

class Day1: Day {
    private val input = FileInput("day1")

    override fun day(): Int {
        return 1
    }

    override fun title(): String {
        return "Calorie Counting"
    }

    override fun input(): FileInput {
        return this.input
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

    /**
     * Split the file input in parts per empty line.
     * @return Split lists with lists per entry
     */
    private fun FileInput.split(): List<List<Int>> {
        return this.joinToString("|")
            .split("||")
            .map { it.split("|") }
            .map { it.map { v -> v.toInt() } }
    }
}