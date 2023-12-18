package level3

fun main() {
    val input = readLine()!!.toInt()

    for (value in 1..9){
        println("$input * $value = ${input * value}")
    }
}