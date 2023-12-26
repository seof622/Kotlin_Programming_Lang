package Section3

// 질문의 난이도를 특수 클래스인 enum class로 정의
enum class Difficulty {
    EASY, MEDIUM, HARD
}

class EnumQuestion<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

fun main() {
    val question1 = EnumQuestion<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = EnumQuestion<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
    val question3 = EnumQuestion<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
}


