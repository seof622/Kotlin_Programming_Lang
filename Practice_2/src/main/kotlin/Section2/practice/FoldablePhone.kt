package Section2.practice

fun main() {
    val phone = Phone()
    val foldablePhone = FoldablePhone()

    phone.switchOn()
    phone.checkPhoneScreenLight()

    foldablePhone.openFold()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
}

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFoldableScreenLightOn: Boolean = false):
Phone(isFoldableScreenLightOn) {
    private var isFold = true
    override fun switchOn() {
        if (!isFold) super.switchOn()
    }

    fun openFold() {
        isFold = false
    }

    fun closeFold() {
        isFold = true
    }
}

