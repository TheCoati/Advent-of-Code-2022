package io.thecoati.adventofcode.days

import io.thecoati.adventofcode.FileInput

class Day2: Day {
    private val input = FileInput("day2")

    override fun day(): Int {
        return 2
    }

    override fun title(): String {
        return "Rock Paper Scissors"
    }

    override fun input(): FileInput {
        return this.input
    }

    override fun part1(input: FileInput): String {
        var totalScore = 0

        for (line in input) {
            val result = line.split(" ")

            val p2 = Hand.fromString(result[0]) // Opponent Hand
            val p1 = Hand.fromString(result[1]) // Own Hand

            totalScore += this.getScore(p1, p2)
        }

        return totalScore.toString()
    }

    override fun part2(input: FileInput): String {
        var totalScore = 0

        for (line in input) {
            val result = line.split(" ")

            val p2 = Hand.fromString(result[0]) // Opponent Hand
            val p1 = when(result[1]) { // Own Hand
                "X" -> p2.winsFrom()
                "Y" -> p2
                "Z" -> p2.losesFrom()
                else -> throw IndexOutOfBoundsException()
            }

            totalScore += this.getScore(p1, p2)
        }

        return totalScore.toString()
    }

    /**
     * Get the score based of p1 based on the input of p2.
     * @param p1 The input of p1
     * @param p2 The input of p2
     * @return The score of p1
     */
    private fun getScore(p1: Hand, p2: Hand): Int {
        /* Draw */
        if (p1 == p2) {
            return p1.points + 3
        }

        /* Win */
        if (p1.winsFrom() == p2) {
            return p1.points + 6
        }

        /* Lose */
        return p1.points
    }

    private enum class Hand(
        val points: Int,
        vararg val letters: String,
    ) {
        ROCK( 1, "A", "X"),
        PAPER(2, "B", "Y"),
        SCISSORS(3, "C", "Z");

        /**
         * Get the opposite result the hand wins from.
         * @return The hand the current hand wins from
         */
        fun winsFrom(): Hand {
            return when(this) {
                ROCK -> SCISSORS
                PAPER -> ROCK
                SCISSORS -> PAPER
            }
        }

        /**
         * Get the opposite result the hand loses from.
         * @return The hand the current hand loses from
         */
        fun losesFrom(): Hand {
            return when(this) {
                ROCK -> PAPER
                PAPER -> SCISSORS
                SCISSORS -> ROCK
            }
        }

        companion object {
            /**
             * Get the hand enum type based on the string input.
             * @param string The letter to match with a hand
             * @return The hand matching the given letter
             */
            fun fromString(string: String): Hand {
                return Hand.values().first { it.letters.contains(string) }
            }
        }
    }
}