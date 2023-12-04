package chap02.section3

fun main() {
    /*
    val a : Int = 30
    val b : String = "Hello"

    // 코틀린의 변수 선언은 기본적으로 null을 허용 하지 않음
    val non_nullable_a : Int = null
    val non_nullable_b : String = null

    // null 가능한 선언은 아래와 같이 이루어져야 함
    val nullable_a : Int? = null
    val nullable_b : String? = null


    NPE (NullPointException)
    - Null  값인 변수에 접근하면서 생기는 예외
    - Null을 단순히 출력하는 것은 가능하지만, 연산할 경우 에러가 발생
    print(nullable_a) -> OK
    nullable_c = nullable_a + nullable_b -> No
     */

    var str1 : String?
    str1 = null
    /*
      str1의 member인 length는 str1이 null type이기 떄문에 soft call (? 연산자) 혹은 non null assert call (!! 연산자)를 사용해야함.
      만일 safe call을 활용할 경우 str1이 null이라면 member가 출력되는 것이 아니라 str1이 출력이 됨.
      str1이 null이면 NPE가 발생할 수 있기 때문에, 체크 후 member에 접근하지 않음

      만약 non null assert call을 수행하면 해당 변수가 null 일리 없다고 가정하고 member에 접근하지만 null 값이기 때문에 NPE가 발생한다.
     */
//    val len = if (str1 != null) str1.length else -1
    val len = str1?.length ?: -1 // elvis expression : str1이 null이라면, -1 아니라면 str1.length 값을 가지도록 설정
    println("str1: $str1, length: $len")
}
