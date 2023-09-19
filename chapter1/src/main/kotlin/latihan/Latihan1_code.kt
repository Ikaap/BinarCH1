package latihan

class Jarvis {

    private var property: IronManProperty = IronManProperty(
        suitVersion = 85,
        batteryPercentage = 50.0,
        isPropulsionReady = true,
        weapons = listOf("Some", "weapon"),
        architecture = Architecture.NANOTECH
    )

    fun run() {
        IronManPropertyHandler.printProperty(getOwnerName(), property)
    }

    private fun printSuitVersion(version: Int) {
        println("Suit Version $version")
    }

    private fun getOwnerName(): String {
        return "Tony Stark"
    }
}

//suatu class untuk menghandle many types of data in 1 object
data class IronManProperty(
    val suitVersion: Int?,
    val batteryPercentage: Double,
    val isPropulsionReady: Boolean,
    val weapons: List<String>,
    val architecture: Architecture
)

//enum class
enum class Architecture {
    SOLID_METAL, NANOTECH
}

object IronManPropertyHandler {
    fun printProperty(ownerName: String, property: IronManProperty) {
        println()
        println("========================")
        println("Welcome ${ownerName} !")
        println("========================")
        println("Iron Man is Online")
        println("========================")
        println()
        println("Property Check")
        println()
        println("Suit Version ${property?.suitVersion}")
        println("Energy left is ${property?.batteryPercentage}%")
        println("Propulsion Status  : ${property?.isPropulsionReady}")
        println("Weapon Ready  : ${property?.weapons}")
    }
}

fun main(args: Array<String>) {
    Jarvis().run()
}