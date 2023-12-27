package Section3.practice

enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

data class EventDataClass(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

val EventDataClass.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
//    val event = EventDataClass(
//        "Study Kotlin",
//        "Commit to studying Kotlin at least 15 minutes per day",
//        Daypart.EVENING,
//        15
//        )

//    println(event.toString())
    val events = mutableListOf(
        EventDataClass(
            title = "Wake up",
            description = "Time to get up",
            daypart = Daypart.MORNING,
            durationInMinutes = 0
        ),
        EventDataClass(
            title = "Wake up",
            description = "Time to get up",
            daypart = Daypart.MORNING,
            durationInMinutes = 0
        ),
        EventDataClass(
            title = "Learn about Kotlin",
            daypart = Daypart.AFTERNOON,
            durationInMinutes = 30
        ),
        EventDataClass(
            title = "Practice Compose",
            daypart = Daypart.AFTERNOON,
            durationInMinutes = 60
        ),
        EventDataClass(
            title = "Watch latest DevBytes video",
            daypart = Daypart.AFTERNOON,
            durationInMinutes = 10
        ),
        EventDataClass(
            title = "Check out latest Android Jetpack library",
            daypart = Daypart.EVENING,
            durationInMinutes = 45
        )
    )

    val shortEvent = events.filter {
        it.durationInMinutes < 60
    }

    shortEvent.forEach {
        println("${it.title} is short event: duration time is ${it.durationInMinutes}")
    }

    val dayTimeEvent = events.groupBy {
        it.daypart
    }

    dayTimeEvent.forEach {
        println("${it.key}: ${it.value.size} events")
    }

    /*
    아래 코드도 가능
    dayTimeEvent.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
     */

}

