package io.thecoati.adventofcode

import io.thecoati.adventofcode.days.Day
import org.reflections.Reflections
import java.util.ArrayList

class Story {
    private val color = mapOf(
        Pair("reset", "\u001b[0m"),
        Pair("green", "\u001b[32m"),
        Pair("white", "\u001b[37m"),
    )

    private val days: MutableList<Day> = ArrayList()

    /**
     * Load story from the given namespace by reflection.
     * @param namespace The namespace containing the day classes
     */
    fun load(namespace: String?) {
        val reflections = Reflections(namespace)
        val classes = reflections.getSubTypesOf(Day::class.java)

        for (aClass in classes) {
            val constructor = aClass.getConstructor()
            val day = constructor.newInstance()

            this.days.add(day)
        }

        this.days.sortBy { it.day() }
    }

    /**
     * Print the output of the loaded days from the namespace.
     */
    fun output() {
        println("\uD83C\uDF84 Welcome to the ${this.color["green"]}Advent of Code ${this.color["reset"]}2022")
        println() /* Break line */

        for (day in this.days) {
            val start = System.currentTimeMillis()

            println("${day.day()} Dec 2022 - ${day.title()}")
            System.out.printf("Result 1 = ${this.color["white"]}%s%n${this.color["reset"]}", day.part1(day.input()))
            System.out.printf("Result 2 = ${this.color["white"]}%s%n${this.color["reset"]}", day.part2(day.input()))

            val duration = System.currentTimeMillis() - start
            println("Results calculated in ${duration}ms")
            println() /* Break line */
        }

        println("\uD83D\uDC4B\uD83C\uDFFD 48 61 70 70 79 20 48 6f 6c 69 64 61 79 73 21")
    }
}