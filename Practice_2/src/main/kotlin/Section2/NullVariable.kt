package Section2

fun main() {
    /*
    null의 정의: 비어 있는 값
    val favoriteActor = null

    var favoriteActor: String = "Sandra Oh"
    favoriteActor = null --> String은 null을 가질수 없는 datatype
     */

    var favoriteActor: String? = "Sandra Oh" // String?은 nullable data type임.
    println("nullable string is $favoriteActor")

    favoriteActor = null
    println("nullable string is $favoriteActor")

    /*
    println("nullable string length is ${favoriteActor.length}")
    - Kotlin 에서는 null 변수의 멤버에 접근하는 것을 방지하기 위해, 즉 null 변수의 멤버에 접근할 때 런타임 에러가 발생하는 것을 방지하기 위해 null 검사를 강제
    - nullable 변수의 속성을 참조하려면 safe call이나 non-null assert call을 진행해야함

    safe call
    - favoriteActor?.length 처럼 ?를 붙여 사용
    - 변수가 null이 아니라면 그대로 length에 대해 출력
    - 변수가 null이라면 null을 출력
    - 따라서 어떤 경우라도 비정상적으로 종료되지 않음

    non null assert call
    - favoriteAcotr!!.length 처럼 !!을 붙여 사용
    - 변수가 null이 아님을 assertion함 -> 변수가 만약 null이라면 런타임 에러 발생
    - null 비허용 변수이거나 적절한 예외처리가 있어야 함
     */

    // if else문의 condition에 nullable 변수를 설정
    if (favoriteActor != null) {
        // null 검사를 if문에서 진행했기 때문에 safe or non-null assert call을 안해도 됨
        println("The number of characteristic is ${favoriteActor.length}")
    } else {
        println("You must input data")
    }

    // elvis 연산자
    val lengthOfName = favoriteActor?.length ?: 0
    println("result of elvis operator : $lengthOfName")

    var number: Int? = 10
    println("nullable Int is $number")

    number = null
    println("nullable Int is $number")

}