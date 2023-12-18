package Section2

fun main() {
    val trafficLightColor = "Black"
//    ifElseCondition(trafficLightColor)
//    whenCondition(trafficLightColor)
//    println(conditionExpression(trafficLightColor))

    val x = 11
//    conditionExample(x)

    val personAge = 14
    val checkAdult = if (personAge > 19) {
        true
    } else {
        false
    }
}

// If else 조건문에 따른 명령문 실행
fun ifelseCondition(condition: Any){
    if (condition == "Red") {
        println("Stop")
    } else if (condition == "Yellow") {
        println("Slow")
    } else if (condition == "Green"){
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
}

// when 조건문에 따른 명령문 실행
fun whenCondition(condition: Any) {
    when(condition) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
}

// when 조건문에서 더 다양한 활용에 대한 예시
fun conditionExample(condition: Any) {
    when(condition) {
        // comma condition
        2,3,5,7 -> println("Number is a prime number between 1 and 10")
        // in keyword
        in 1..10 -> println("Number is a between 1 and 10, but not a prime number")
        is Int -> print("Number is an integer, but not between 1 and 10")
        else -> println("Number is not a prime number between 1 and 10")
    }
}

// 변수를 지정하는 방식을 조건문으로 표현하는 방버
fun conditionExpression (condition: Any): String {
//    val message =
//        if (condition == "Red") "Stop"
//        else if(condition == "Yellow") "Slow"
//        else if(condition == "Green") "Go"
//        else "Invalid traffic-light color"
    val message = when(condition) {
        "Red" -> "Stop"
        "Yellow" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    return message
}
