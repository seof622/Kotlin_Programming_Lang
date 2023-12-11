package level1

// Problem 11382
// https://www.acmicpc.net/problem/11382
fun main() {
    var inputNumber = readLine()
    val splitInput = inputNumber!!.split(" ")

    val a = splitInput[0].toLong()
    val b = splitInput[1].toLong()
    val c = splitInput[2].toLong()
    print(a + b + c)

    /*
    !!!문제를 잘 읽자!!!
    첨에 아래 코드로 동작했는데 Runtime Error (NumberFormat)
    나는 input에 null이 들어올 수 있는 가능성을 고려하고 NPE에 대한 해결책을 마련하려고 했으나,
    다시 문제를 확인해보니 Input은 항상 3개에 값이 1부터 10^12 사이라서 String으로 받고,
    toInt() 할 때에, 문제가 생기는 거였다. 10^12을 Integer로 담을수가 없는 거지.
    그래서 toLong()으로 바꾸어서 적용했더니 됨...
    var name = readLine()
    val split = name?.split(" ")

    val a = split?.get(0)!!.toLong()
    val b = split?.get(1)!!.toLong()
    val c = split?.get(2)!!.toLong()
    print(a + b + c)

     */
}