package level3

fun main() {
    val inputTotalAccount = readLine()!!.toLong()
    val numOfItems = readLine()!!.toInt()

    var totalAccount = 0

    for (iter in 1..numOfItems) {
        val accountDetail = readLine()!!.split(" ")
        val account = accountDetail.get(0).toInt()
        val itemNumber = accountDetail.get(1).toInt()

        totalAccount += (account * itemNumber)
    }

    if (totalAccount.toLong() == inputTotalAccount) {
        println("Yes")
    } else {
        println("No")
    }
}

