package Section3

class Cookie (
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)


fun main() {
    /*
    forEach
    forEach 고차함수를 활용한 컬렉션의 반복
    컬렉션을 매개변수로 받고 반환 값은 없는 함수가 고차함수의 매개변수로 들어간다.
    cookies.forEach {
        println("Menu item: ${it.name}")
    }
     */

    /*
    map
    map을 사용하여 목록에 있는 특정 string 혹은 다른 데이터 유형으로 String type 데이터를 만들어낼 수 있음
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }

    println("Full menu: ")

    fullMenu.forEach {
        println(it)
    }
     */


    /*
    filter
    - filter 람다문 안에 반환 값이 true이면 새로운 컬렉션에 포함 false이면 새로운 컬렉션에 미포함
    val softBakedMenu = cookies.filter {
        it.softBaked
    }

    println("Soft cookies")
    softBakedMenu.forEach {
        println(" ${it.name} - $${it.price}")
    }
     */

    /*
    groupBy
    - list to Map
    - groupBy method를 활용하여 list 컬렉션을 특정 조건에 해당하는 형태의 Map으로 묶을 수 있다.
    - map의 key가 null일 수 있기 때문에 map을 사용할 때에는 elvis 연산자를 종종 사용하게 됨.

    val groupedMenu = cookies.groupBy {
        it.softBaked
    }

    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: emptyList()

    println("Soft cookies: ")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    println("Crunchy cookies: ")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
     */

    /*
    fold
    - 여러 요소들의 합을 구하거나 평균을 구하는 데 사용
    - fold 함수의 매개변수로는 초깃값과 람다 표현식
    - 람다 표현식의 매개변수로는 초깃값과 동일한 유형을 가지는 매개변수와 컬렉션의 각 요소와 동일한 유형의 데이터

    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }

    println("Total Price: $${totalPrice}")
     */


    /*
    sortedBy
    - 객체의 경우 sort() 함수를 사용한다고 해서 기준을 정할 수 없음.
    - sortedBy() 함수를 활용하여 객체의 정렬 기준을 세워줌.

        val alphabeticalMenu = cookies.sortedBy {
        it.name
    }

    println("Alphabetical menu: ")
    alphabeticalMenu.forEach {
        println(it.name)
    }

    val priceSortedMenu = cookies.sortedBy {
        it.price
    }

    println("Price Sorted Menu: ")
    priceSortedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
     */

}