package Section3

fun main() {
    /*
    **********************************************
    컬렉션에서 val과 var은 모두 요소는 바꿀 수 있지만 컬렉션 객체 자체를 재할당 할 수 있느냐 없느냐 여부에 따라 달라진다.
    **********************************************
     arrayOf
     val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
     val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

     val solarSystem = rockPlanets + gasPlanets
     solarSystem[3] = "Little Earth"
     // solarSystem[8] = "Pluto] --> ArrayIndexOutOfBounds 에러 발생
     */

    /*
    listOf
    val solarSystem  = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem[2]) // == println(solarSystem.get(2))
    println(solarSystem.indexOf("Earth"))
    for (planet in solarSystem) {
        println(planet)
    }
     */

    /*
    mutableListOf
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"

    println(solarSystem[3])
    println(solarSystem[9])

    solarSystem.removeAt(9)
    solarSystem.remove("Future Moon")

    println(solarSystem.contains("Pluto"))
    println("Future Moon" in solarSystem)
     */

    /*
    set
    - 특정 순서가 없고 중복 값을 허용하지 않는 컬렉션
    - Kotlin class에서 지원하는 hashCode() 메서드에서 생성된 Int 값으로 중복을 가려냄
    - 특정 요소를 검색하는 경우 List의 indexOf 보다 set이 더 빠름. List는 처음부터 요소를 검색해야하기 때문
    - set은 같은 데이터에 대해서 다른 컬렉션보다 더 많은 메모리를 차지함. -> hash화 때문에 더 많은 index가 필요하기 때문

    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    solarSystem.add("Pluto")
    println(solarSystem.size) // 9

    solarSystem.add("Pluto")
    println(solarSystem.size) // 9

     */

    /*
    map
    - 키와 값으로 이루어진 컬렉션
    - 키는 고유하나 값은 고유하지 않을 수 있음
    - 큰 목록에서 요소를 검색하는 것보다 map에서 키로 검색하는 것이 더 빠를 수 있음

     */

    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem.size)

    solarSystem["Pluto"] = 5

    println(solarSystem["Pluto"])
    println(solarSystem.get("Theia"))

    solarSystem.remove("Pluto")

    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"])
}