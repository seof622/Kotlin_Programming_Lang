package Section2

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
constructor
 - class의 괄호는 생성자의 매개변수
 - 생성자를 통해 클래스의 속성들을 초기화 할 수 있음

 상속
 - open 키워드는 클래스의 확장 가능성을 컴파일러에게 알림 -> 상속 가능성

 접근 제한자
 - constructor에 공개 상태 수정자 (접근 제한)을 추가하는 경우 매개변수 여부에 관계 없이 괄호를 유지해야함
 - 공개 상태 수정자에 대한 좀 더 자세한 내용은 https://kotlinlang.org/docs/visibility-modifiers.html#packages
 - package의 top level 요소들에 대해서는 protected는 사용할 수 없고, private는 같은 파일 내에만 접근 가능하다
 - Class member나 Constructor에 대해서는 다르게 적용될 수 있음.
 */

open class SmartDevice protected constructor (val name: String, val category: String){
    // class attribute
    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unkwon"
        }
    }

    /*
    // class attribute의 setter 함수를 설정: speakerVolume이 0에서 100 사이에 놓이도록
    open var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                // filed는 내부적으로 정의된 클래스 변수, 이 변수를 메모리에 저장시킴
                // filed를 활용하여 get(), set()등의 함수를 사용할 수 있음
                field = value
                println("speakerVolume of Device is $value")
            } else {
                println("You must set volume between 0 and 100")
            }
        }
     */

    open fun turnOn() {
        deviceStatus = "online"
    }

    open fun turnOff() {
        deviceStatus = "offline"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// SmartDevice의 subclass인 SmartTvDevice class
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    // override를 통해 슈퍼클래스 속성도 재정의
    override val deviceType = "Smart TV"

    private val initialSpeakerVolume = if (super.deviceStatus == "online") 2 else 0

    /*
    속성 위임
    - 속성 위임을 통해 setter, getter 함수의 재사용이 가능
    - 속성 위임은 by 키워드와 getter 및 setter함수를 처리하는 객체로 이루어짐
     */
    private var speakerVolume by RangeRegulator(initialValue = initialSpeakerVolume, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decrease to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel Number increased to $channelNumber.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel Number decreased to $channelNumber")
    }

    override fun turnOn() {
        // super 키워드를 사용하여 서브클래스에서 슈퍼클래스 코드 사용, 즉 클래스 외부에서 메서드를 호출
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber.")
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart Light"

    private val initialBrightnessLevel = if (super.deviceStatus == "online") 2 else 0

    private var brightnessLevel by RangeRegulator(initialValue = initialBrightnessLevel, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }
    // override 키워드는 서브 클래스에 정의된 메서드를 실행하도록 컴파일러에게 알림

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun workSmartTv(task: String) {
        if (smartTvDevice.deviceStatus == "online") {
            when(task) {
                "increaseVolume" -> smartTvDevice.increaseSpeakerVolume()
                "decreaseVolume" -> smartTvDevice.decreaseSpeakerVolume()
                "nextChannel" -> smartTvDevice.nextChannel()
                "previousChannel" -> smartTvDevice.previousChannel()
                else -> println("There are not exist such task")
            }
        }
    }

    fun workSmartLight(task: String) {
        if (smartLightDevice.deviceStatus == "online") {
            when(task) {
                "increaseBrightness" -> smartLightDevice.increaseBrightness()
                "decreaseBrightness" -> smartLightDevice.decreaseBrightness()
                else -> println("There are not exist such task")
            }
        }
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
}

/*
 클래스 멤버를 특정 값 안에 존재하도록 하는 setter 작업을 하는 속성 위임 클래스를 구현
 ReadWriteProperty라는 인터페이스를 상속받는데, 여기에 getValue, setValue를 구현하도록 강제받는 것 같음
 */
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    // KProperty는 속성을 나타내는 인터페이스
    // getter 함수 역할
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    // setter 함수 역할
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    // val 키워드로 변수를 선언하면, smartTvDevice를 다른 객체로 재할당은 불가능하나 객체의 속성 값을 업데이트 하는 것은 가능
    // smartTvDevice = SmartDevice() -> 에러 발생
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()

    var smartHome: SmartHome = SmartHome(
        SmartTvDevice("Android TV", "Entertainment"),
        SmartLightDevice("Google Light", "Utility")
    )

    smartHome.workSmartTv("increaseVolume")
    smartHome.workSmartLight("increaseBrightness")


//    smartTvDevice.speakerVolume = 98
//    println("Device name is: ${smartTvDevice.name}")
//    smartTvDevice.turnOn()
//    smartTvDevice.turnOff()
}