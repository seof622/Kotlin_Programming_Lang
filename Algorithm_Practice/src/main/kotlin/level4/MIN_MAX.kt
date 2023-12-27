package level4

fun main() {
    val numberOfInteger = readLine()!!.toInt()
    val inputArray = readLine()!!.split(" ")
    var maxNumber = -1000000
    var minNumber = 1000000

    for (input in inputArray) {
        if (input.toInt() > maxNumber) maxNumber = input.toInt()
        if (input.toInt() < minNumber) minNumber = input.toInt()
    }

    print("$minNumber $maxNumber")
}