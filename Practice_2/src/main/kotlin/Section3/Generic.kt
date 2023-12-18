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
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or False", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
}

