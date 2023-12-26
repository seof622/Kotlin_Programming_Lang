package level3

fun main() {
    val numCase = readLine()!!.toInt()
    val sumArray = arrayOfNulls<Int>(numCase)
    var indexNumber = 1
    repeat(numCase) {
        val twoNumber = readLine()!!.split(" ")
        sumArray[indexNumber - 1] = twoNumber.get(0).toInt() + twoNumber.get(1).toInt()
        indexNumber ++
    }
    for (index in 0..<sumArray.size) {
        println("Case #${index + 1}: ${sumArray[index]}")
    }
}