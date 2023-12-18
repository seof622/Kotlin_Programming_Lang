package level2

fun main() {
    val input = readLine()
    val integerInput = input!!.toInt()

    if (integerInput % 4 == 0) {
        if (integerInput % 400 == 0) {
            println("1")
        } else if (integerInput % 100 == 0) {
            println("0")
        } else {
            println("1")
        }
    } else{
        println("0")
    }
}