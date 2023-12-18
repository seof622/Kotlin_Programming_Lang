package level2

/*
문제를 잘 보자
- 입력 값의 범위를 잘 확인하자

if문 위치 잘 신경쓰자
- completeHour에 관한 조건문이 completeMinute 조건문에 중첩으로 들어가서 23 00 120 이런식으로 넣으면 25 00 으로 출력됐음
 */
fun main() {
    val currentTime = readLine()!!.split(" ")
    val hour = currentTime.get(0).toInt()
    val minute = currentTime.get(1).toInt()

    val requiredTime = readLine()!!.toInt()

    val requiredHour: Int
    val requiredMinute: Int

    if (requiredTime > 60) {
        requiredHour = requiredTime / 60
        requiredMinute = requiredTime % 60
    } else {
        requiredHour = 0
        requiredMinute = requiredTime
    }

    var completeHour = hour + requiredHour
    var completeMinute = minute + requiredMinute

    if (completeMinute >= 60) {
        completeHour++
        completeMinute -= 60
    }

    if (completeHour >= 24) {
        completeHour -= 24
    }

    println("$completeHour $completeMinute")
}