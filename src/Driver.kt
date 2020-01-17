import java.io.File
import java.util.stream.Stream

fun main(args: Array<String>) {
    println("hello world")

    // step one, ask to load trip or start new trip
    Driver.loadTrip()
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
        val names = Array(numberOfPeopleOnTrip) {""}
        for(i in 0 until numberOfPeopleOnTrip) {
            names[i] = Terminal.printInputString("Enter person ${i+1}")
        }

    }

    fun loadTrip() {
        val files = ArrayList<String>()

        File("./Trips/").walk().forEach {
            if (it.toString().contains(".json")) {
                files.add(it.nameWithoutExtension)
            }
        }
        files.trimToSize()
        val selection = Terminal.printSelection("Select the trip you would like to open.", files)
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

    // outputs corrected value
    public fun printSelection(instruction: String, options: ArrayList<String>): Int {
        println("\n" + instruction)
        var input = -1
        while(input > options.size || input < 1) {
            for (i in 0 until options.size) {
                println("$i: ${options[i]}")
            }
            input = readLine()!!.toInt() - 1
        }
        return input
    }
}