package latihan

import java.lang.NumberFormatException
import java.util.*
import kotlin.concurrent.schedule


data class Vehicle(
    val id: String,
    val vehicleType: String,
    val price: Double
)

data class WashMethodItems(
    val idMethod: String,
    val methodName: String,
    val price: Double
)


class VehicleWashApp{
    private val vehicleList : List<Vehicle> = listOf(
        Vehicle("1", "Hatchback", 50000.0),
        Vehicle("2", "Sedan", 50000.0),
        Vehicle("3", "SUV", 60000.0),
        Vehicle("4", "Small Motorcycle", 20000.0),
        Vehicle("5", "Super Motorcycle", 35000.0)
    )

    private var selectedMenu:  Vehicle? = null
    private var totalPrice: Double = 0.0
    private val methodItems = mutableListOf<WashMethodItems>(
        WashMethodItems("1","Snow Wash", 5000.0),
        WashMethodItems("2","Normal Wash", 0.0)
    )
    private var selectedMehod:  WashMethodItems? = null
    private var payment : Int = 0
    private var calculateProcess : Double = 0.0

    private fun printHeader(){
        println("""
           ==========================================
           ==    Welcome to Car/Motorcycle Wash    ==
           ==========================================
       """.trimIndent())
    }

    private fun printMenu(){
        println("Please Select your vehicle : ")
        println("----------------------------------------------")
        println(vehicleList.joinToString("\n")
        { vehicleList -> "${vehicleList.id}. ${vehicleList.vehicleType} = IDR ${vehicleList.price}"  })
        println("----------------------------------------------")

    }

    private fun readInputSelectMenu(){
        val input = readlnOrNull()?.trim()
        val selected = vehicleList.find{it.id == input}
        if(selected  != null){
            selectedMenu = selected
            println("Your vehicle is : ${selected.vehicleType}")
            println("------------------------------------------------")

        } else {
            println("You  input wrong menu, Try Again")
            readInputSelectMenu()
        }
    }

    private fun printMethod(){
        println("Please select Wash Method: ")
        println("------------------------------------------------")
        println(methodItems.joinToString("\n") { method -> "${method.idMethod}. ${method.methodName} = IDR ${method.price} Additional Price" })
        println("------------------------------------------------")
    }

    private fun readUserMethod(){
        val input = readlnOrNull()?.trim()
        val methodResult = methodItems.find{it.idMethod == input}
        if(methodResult  != null){
            selectedMehod = methodResult
            println("Selected Wash Method : ${methodResult.methodName}")
            totalPrice = selectedMenu!!.price + selectedMehod!!.price
            println("------------------------------------------------")
            println("Your total price is : $totalPrice")
            println("------------------------------------------------")

        } else {
            println("You  input wrong menu, Try Again")
            readUserMethod()
        }

    }

    private fun userInputPayment(){
        println("Payment method is Cashless....")
        println("Please input according to the total price : ")
        try {
            val input = readlnOrNull()?.trim()
            payment = input?.toInt() ?: 0
        }catch (e : NumberFormatException){
            println("Masukkan dengan format angka")
            userInputPayment()
        }catch (e : Exception){
            println("Error : $e")
            userInputPayment()
        }

    }

    private fun calculatePayment(){
        if (payment < totalPrice){
            calculateProcess = -1 * (payment - totalPrice)
            println("Your money is less than the total payment. Retrying payment...")
            println("------------------------------------------------")
            userInputPayment()
            calculatePayment()
        } else{
            calculateProcess = payment - totalPrice
            println("Your Change is : Rp. $calculateProcess")
            println("------------------------------------------------")
        }
    }

    private fun washInfo(){
        println("Preparing to wash your vehicle....")
        Timer().schedule(2000){
            println("Spraying water to your vehicle....")
        }
        Timer().schedule(4000){
            println("Washing your vehicle....")
        }
        Timer().schedule(8000){
            println("Drying your vehicle")
        }
        Timer().schedule(10000){
            println("Your vehicle is ready !")
        }
    }

    fun run(){
        printHeader()
        printMenu()
        readInputSelectMenu()
        printMethod()
        readUserMethod()
        userInputPayment()
        calculatePayment()
        washInfo()
    }
}


fun main() {
    VehicleWashApp().run()
}