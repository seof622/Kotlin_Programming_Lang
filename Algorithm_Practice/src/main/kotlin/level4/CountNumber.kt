package level4

fun main() {
    val numberOfInteger = readLine()!!.toInt()
    val inputArray = readLine()!!.split(" ")
    val objectNumber = readLine()!!.toInt()
    var count = 0
    for (index in 0..<numberOfInteger) {
        if (objectNumber ==inputArray.get(index).toInt()) count++
    }
    print(count)
}