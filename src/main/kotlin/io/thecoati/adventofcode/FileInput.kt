package io.thecoati.adventofcode

import java.io.BufferedReader
import java.io.InputStreamReader

class FileInput(
    resource: String,
): ArrayList<String>() {
    init {
        val inStream = this.javaClass.classLoader.getResourceAsStream(resource)
        val inReader = InputStreamReader(inStream!!)
        val bufReader = BufferedReader(inReader)
        var current = ""

        while (bufReader.readLine()?.also { current = it } != null) {
            this.add(current)
        }
    }
}