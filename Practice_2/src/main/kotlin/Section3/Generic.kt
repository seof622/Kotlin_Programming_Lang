package Section3

/*
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)
위와 같이 질문에 대한 클래스를 나누어서 정의를 한다고 했을 때,
- 코드의 불필요한 반복이 많음
- questionText, difficulty 속성을 가지는 슈퍼 클래스를 선언하고 상속할 수 있지만, answer가 데이터 유형만 다른 똑같은 의미를 가짐
- 이럴 때, 일반 데이터 유형을 활용한다 (제네릭)
- 클래스 정의에서는 일반 유형을 가지다가 인스턴스화 할 때 구체적인 데이터 유형을 정해줌.
 */

// T(type의 약자)는 일반 유형을 나타내며, 클래스에 여러 일반 유형이 필요한 경우 T 이외에 다른 대문자가 표시되는 경우가 많음.
// data class로 정의하면, 코틀린 컴파일러에서 특정 가정을 하고 일부 메서드를 자동으로 구현할 수 있음.
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

/*
인터페이스
- 기존 클래스에 더해서 동일한 추가 속성과 메서드를 갖는 여러 클래스가 필요한 경우 인터페이스를 활용하여 정의할 수 있음
- 예를 들면, progress function을 quiz, survey, recipe 클래스에 대해서 interface화 할 수 있음.
- interface에서 선언한 속성 및 메서드는 확장하려고 하는 클래스에서 필수적으로 구현해야 함.
 */

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}


class Quiz : ProgressPrintable {
    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or False", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")

    /*
     싱글톤 객체는 프로그램 내에서 클래스를 활용해야 하는데 하나의 객체만 필요한 경우 사용하는 문법임.
     companion 객체를 통해 클래스 내에서 싱글톤 객체를 정의
     정의한 싱글톤 객체의 속성이나 메서드는 아래 main 문과 같이 껎데기 클래스 + . 연산을 통해 접근이 가능함.
     */

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    /*
    범위 함수
    - let 키워드를 통해 반복적으로 호출해야 하는 변수의 이름을 it으로 줄여서 표기할 수 있음.
     */
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

/*
데이터 유형을 확장하는 문법 (StudentProgress 객체에 속성 및 메서드 유형을 확장)
기존 클래스에서 사용자가 필요한 부분인 속성 및 메서드를 확장시키는 문법
android programming에서 padding이나 UI 크기를 지정할 때에 double + .dp or .sp 를 사용하는 원리가 이와 같은 원리
 */
//val Quiz.StudentProgress.progressText: String
//    get() = "${answered} of ${total} answered"
//
//fun Quiz.StudentProgress.printProgressBar() {
//    repeat(Quiz.answered) { print("▓") }
//    repeat(Quiz.total - Quiz.answered) { print("▒") }
//    println()
//    println(Quiz.progressText)
//}
fun main() {
//    println("${Quiz.answered} of ${Quiz.total} answered.")
//    println(Quiz.progressText)
//    Quiz.printProgressBar()
//    Quiz().printProgressBar()
//    val quiz = Quiz()
//    quiz.printQuiz()
    // apply 함수를 통해 객체를 변수에 할당하지 않고도 메서드를 호출할 수 있음
    // Quiz().method 도 가능하지만, 여러가지의 함수를 실행시키는 경우 apply를 잘 활용할 수 있을 듯
    Quiz().apply {
        printQuiz()
    }
}

