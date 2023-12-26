package level3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    repeat(bufferedReader.readLine().toInt()) {
        val twoNumber = bufferedReader.readLine().split(" ")
        val sum = twoNumber.get(0).toInt() + twoNumber.get(1).toInt()
        bufferedWriter.write(sum.toString() + "\n")
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}