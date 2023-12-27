package level3

fun main() {
    val sumList = mutableListOf<Int>()
    while (true) {
        val input = readLine()?.split(" ")
        if (input.isNullOrEmpty()) break
        sumList.add(input!!.get(0).toInt() + input!!.get(1).toInt())
    }

    for (sum in sumList) {
        println(sum)
    }
}