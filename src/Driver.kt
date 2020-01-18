import java.io.File
import kotlin.String as String1

fun main(args: Array<String1>) {
    println("hello world")

    // step one, ask to load trip or start new trip
    Driver.startTrip()
    Driver.tripMenu()
}

object Driver{
    lateinit var trip: Trip
    init {

    }


    fun initialize() {
    }

    fun startTrip() {
        trip = Trip()

        trip.tripName = Terminal.printInputString("Enter trip name: ")
        val numberOfPeopleOnTrip: Int = Terminal.printInputInt("How many People were on this trip?")
        val travellers = Array(numberOfPeopleOnTrip) {Traveller("", -1)}
        val travellerNames = Array(numberOfPeopleOnTrip) {""}
        var name = ""
        for(i in 0 until numberOfPeopleOnTrip) {

            name = Terminal.printInputString("Enter traveler #${i+1}")
            travellers[i] = Traveller(name, i)
            travellerNames[i] = name
        }
        trip.travellers = travellers
        trip.travellerNames = travellerNames
    }

    fun tripMenu() {
        val options =  arrayOf("Add purchases", "View trip", "Save")
        val choice = Terminal.printSelectionIndex("What would you like to  do?", options)
        when (choice) {
           0 -> addPurchases()
        }
    }

    fun addPurchases() {

        val amount = Terminal.printInputFloat("Enter amount of purchase")
        val purchase = Purchase(amount)
        purchase.purchaser = Terminal.printSelectionString("Enter name of purchaser", trip.travellerNames)

   }

    fun loadTrip() {
        val files = ArrayList<String1>()

        File("./Trips/").walk().forEach {
            if (it.toString().contains(".json")) {
                files.add(it.nameWithoutExtension)
            }
        }
        files.trimToSize()
        val selection = Terminal.printSelectionIndex("Select the trip you would like to open.", files.toTypedArray())
    }
}

object Terminal {
    public fun print(string: String1) {
        println(string)
    }

    public fun printInputString(instruction: String1): String1 {
        println(instruction)
        val input = readLine().toString()
        return input
    }

    public fun printInputInt(instruction: String1): Int {
        var input = -1
        while (input < 1) {
            println(instruction)
            input = readLine().toString().toInt()
        }
        return input
    }

    fun printInputFloat(instruction: String1): Float {
        var input = -1.0f
        while (input < 0) {
            println(instruction)
            input = readLine()!!.toFloat()
        }
        return input
    }

    // outputs corrected value
    public fun printSelectionIndex(instruction: String1, options: Array<String1>): Int {
        println("\n" + instruction)
        var input = -1
        while(input > options.size || input < 1) {
            for (i in options.indices) {
                println("${i+1}: ${options[i]}")
            }
            input = readLine()!!.toInt() - 1
        }
        return input
    }

    public fun printSelectionString(instruction: String1, options: Array<String1>): String1 {
        println("\n" + instruction)
        var input = -1
        while(input > options.size || input < 1) {
            for (i in options.indices) {
                println("${i+1}: ${options[i]}")
            }
            input = readLine()!!.toInt() - 1
        }
        return options[input]
    }
}