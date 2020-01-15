import java.io.File
import java.util.stream.Stream

fun main(args: Array<String>) {

}

object Driver{
    lateinit var trip: Trip
    init {

    }


    fun initialize() {
        //TODO 1: Ask if new trip or load trip
    }

    fun startTrip() {
        val numberOfPeopleOnTrip: Int
        //TODO 2: Enter name of those on trip
        numberOfPeopleOnTrip = Terminal.printInputInt("How many People were on this trip?")
        for(i in 1..numberOfPeopleOnTrip) {

        }
    }

    fun loadTrip() {
        val files = ArrayList<String>()

        File("/Trips").walk().forEach {
            files.add(it.nameWithoutExtension)

        }
    }
}

object Terminal {
    public fun print(string: String) {
        println(string)
    }

    public fun printInputString(instruction: String): String {
        println(instruction)
        val input = readLine().toString()
        return input
    }

    public fun printInputInt(instruction: String): Int {
        var input = -1
        while (input < 1) {
            println(instruction)
            input = readLine().toString().toInt()
        }
        return input
    }

    public fun printSelection(instruction: String, options: Array<String>): Int {
        println("\n" + instruction)
        var input = -1
        while(input > options.size || input < 1) {
            for (i in 1..options.size) {
                println("$i: ${options[i]}")
            }
            input = readLine()!!.toInt()
        }
        return input
    }
}