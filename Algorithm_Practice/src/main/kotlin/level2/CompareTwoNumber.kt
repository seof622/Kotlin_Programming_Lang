package level2

fun main() {
    var input = readLine()
    var split = input!!.split(" ")

    var number1 = split!!.get(0).toInt()
    var number2 = split!!.get(1).toInt()

    if (number1 < number2) {
        println("<")
    } else if (number1 > number2) {
        println(">")
    } else {
        print("==")
    }
}