package io.thecoati.adventofcode

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val story = Story()
        story.load("io.thecoati.adventofcode.days")
        story.output()
    }
}