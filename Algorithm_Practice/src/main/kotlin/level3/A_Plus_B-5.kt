package level3

fun main() {
    val sumList = mutableListOf<Int>()
    while (true) {
        val input = readLine()!!.split(" ")
        if ((input.get(0).toInt() == 0) && (input.get(1).toInt() == 0)) break
        sumList.add(input.get(0).toInt() + input.get(1).toInt())
    }

    for (sum in sumList) {
        println(sum)
    }
}