package chapter13

class Wheel {
    lateinit var aligment : String

    fun initAligment() {
        aligment = "Good"
    }

    fun printAligment() {
        if (::aligment.isInitialized) println(aligment)
    }
}