package io.thecoati.adventofcode

import io.thecoati.adventofcode.days.Day
import org.reflections.Reflections
import java.util.ArrayList

class Story
{
    private val days: MutableList<Day> = ArrayList()

    fun load(from: String?) {
        val reflections = Reflections(from)
        val classes = reflections.getSubTypesOf(Day::class.java)

        for (aClass in classes) {
            val constructor = aClass.getConstructor()
            val day = constructor.newInstance()

            this.days.add(day)
        }
    }

    fun output() {
        for (day in this.days) {
            println(day.title())
            System.out.printf("Result 1 = %s%n", day.part1(day.input()))
            System.out.printf("Result 2 = %s%n", day.part2(day.input()))
            println() /* Break line */
        }
    }
}