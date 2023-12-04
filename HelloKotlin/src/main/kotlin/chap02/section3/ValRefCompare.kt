package chap02.section3

fun main() {
//    equalOperator()
    smartCast()
//    checkDataType()
}

fun equalOperator() {
    val a : Int = 128
    val b = a

    println(a === b) // stack에 값을 저장하므로 같은 주소, 값을 가지게 됨: true

    val c : Int? = a
    val d : Int? = a
    val e : Int? = c

    println(c == d)
    println(c === d) // c와 d는 객체이므로 다른 동적 공간에 할당되므로, 주소가 다름
    println(c === e) // 같은 객체이므로 주소가 동일한 값을 가짐.
    // 참고로 코틀린은 -128~127의 값들은 캐시에 저장하므로, 참조형에 대한 연산을 진행하면 모두 true를 반환할 수 있음: 같은 값은 모두 주소가 동일
}

fun smartCast() {
    // Number Type은 숫자가 될 수 있는 자료형의 상위 자료형으로 어느 숫자 자료형이나 캐스팅이 가능
    var test: Number = 12.2
    println("$test")

    test = 12 // Int형으로 smartcast
    println("$test")

    test = 120L // Long형으로 smartcast
    println("$test")

    // Any Type은 모든 자료형 클래스의 상위 자료형: String도 캐스팅 가능
    var a: Any = 1
    a = "Hello"
    println("a: $a type: ${a.javaClass}")
}

fun checkDataType() {
    // 만약 num이 Any type이라면, is 연산자가 항상 True가 된다.
    // 만약 num이 Number type이라면, 숫자 값에 대한 is 연산자가 항상 True가 될 듯.
    val num = 256

    if (num is Int) {
        print("Int: $num")
    } else if (num !is Int) {
        print("Not a Int")
    }
}