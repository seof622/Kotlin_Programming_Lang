package level3

fun main() {
    val numCase = readLine()!!.toInt()
    val firstNumber = arrayOfNulls<Int>(numCase)
    val secondNumber = arrayOfNulls<Int>(numCase)
    var indexNumber = 1
    repeat(numCase) {
        val twoNumber = readLine()!!.split(" ")
        firstNumber[indexNumber - 1] = twoNumber!!.get(0).toInt()
        secondNumber[indexNumber - 1] = twoNumber!!.get(1).toInt()
        indexNumber ++
    }
    var sum = 0
    for (index in 0..<firstNumber.size) {
        println("Case #${index + 1}: ${firstNumber[index]} + ${secondNumber[index]} = ${firstNumber[index]!! + secondNumber[index]!!}")
    }
}