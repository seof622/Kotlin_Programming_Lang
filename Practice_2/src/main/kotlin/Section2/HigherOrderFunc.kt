//package Section2
//
//fun main() {
//    /*
//    Kotlin에서 함수는 최고 구성체이므로 변수와 같은 형태로 값으로 쓰일 수 있음.
//    함수를 값으로 참조하기 위한 :: 연산
//    - val trickFunction = ::trick()
//    람다 함수 예시
//    val trickFunction = trick
//    trick()
//    trickFunction()
//    treat()
//     */
//
//    /*
//    람다 표현식은 return 키워드가 없음
//    val coins: (Int) -> String = {quantity ->
//        "$quantity quarters"
//    }
//     */
//
//    /*
//     람다 표현식 약식 문법
//     - 함수에 매개변수가 하나 있고, 이름이 지정되지 않은 경우 kotlin에서는 기본적으로 매개변수를 it으로 지정
//     - 아래와 같이 매개변수 이름을 생략할 수 있음
//
//     val coins: (Int) -> String = {
//        "$it quarters"
//    }
//    val treatFunction = trickOrTreat(false, coins)
//
//    위 식을 아래와 같은 약식으로 표현할 수 있음
//    val treatFunction = trickOrTreat(false) { "$it quarters" }
//
//    후행 람다 문법
//    - 함수의 매개변수 마지막이 함수일 경우 후행 람다 문법을 사용할 수 있음
//    - 닫는 괄호 다음에 람다 표현식을 사용함
//
//    고차 함수
//    - 함수를 반환하는 함수
//    - 함수를 인자로 취하는 함수
//
//    repeat(times: Int, action:(Int) -> Unit)
//    - 함수를 반복 호출해주는 고차함수
//    - times 매개변수는 반복횟수, action 함수의 Int는 iteration
//    - 마지막 매개변수가 함수이므로 후행 람다 문법을 적용할 수 있음
//     */
//
//    val treatFunction = trickOrTreat(false) { "$it quarters" }
//    val trickFunction = trickOrTreat(true, null)
//    repeat(4) {// treatFunction이 4번 호출됨
//        treatFunction()
//    }
//    trickFunction()
////    treatFunction()
////    trickFunction()
//}
//
//// extraTreat 함수가 nullable일 때 아래와 같이 input, output type에 괄호를 씌우고 ? 를 채워주면 된다.
//fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
//    if (isTrick) {
//        return trick
//    } else {
//        if (extraTreat != null) println(extraTreat(5))
//        return treat
//    }
//}
//
//// Lambda Expression
//val trick = {
//    println("No treats!")
//}
//
//val treat: () -> Unit = {
//    println("Have a treat!")
//}
//
////fun trick() {
////    println("No treats")
////}


fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        println(extraTreat(5))
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat")
}