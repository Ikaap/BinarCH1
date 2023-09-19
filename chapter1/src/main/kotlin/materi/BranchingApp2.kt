package materi

import java.lang.NumberFormatException

data class Fruit0(val id: String, val fruitName: String, val pricePerPcs: Double)

class BranchingApp2 {
    private var selectedFruit: Fruit? = null
    private var totalFruit : Int = 0
    private var totalPrice : Double = 0.0

    private val fruits = listOf(
        Fruit("1", "Melon",20000.0),
        Fruit("2", "Apel",6000.0),
        Fruit("3", "Mango",10000.0),
        Fruit("4", "Avocado",8000.0),
        Fruit("5", "Watermelon",21000.0),
    )

    fun printMenu(){
        println("""
            ========================
            Welcome to Fruit Store !
            ========================
            Our Fruits today :
            1. Melon
            2. Apple
            3. Mango
            4. Avocado
            5. Watermelon
            
            What do you want to buy ? 1/2/3/4/5
        """.trimIndent()
        )
    }

    fun run(){
        printMenu()
        readUserInputMenu()
        readTotalFruitUser()
        calculateTotalPrice()
    }

    fun readUserInputMenu(){
       // val selectedFruit: Fruit0?
        inputMenuLoop@ while (true){
            val input = readlnOrNull()?.trim()
            val fruitResult = fruits.find { fruit -> fruit.id == input  }
//            val fruitResult = fruits.find { fruit -> fruit.id == input }
            if (fruitResult != null){
                selectedFruit=fruitResult
                break@inputMenuLoop
            } else{
                println("You input wrong value")
                printMenu()
            }
        }
        println("You selected ${selectedFruit?.fruitName}")
    }

    fun readTotalFruitUser(){
        println("---------------------------")
        println("How many ${selectedFruit?.fruitName} you wanna buy ? ")
        try {
            val input = readlnOrNull()?.trim()
            totalFruit = input?.toInt() ?: 0
        }catch (e : NumberFormatException){
            println("Masukkan dengan format angka !")
            readTotalFruitUser()
        }
        catch (e : Exception){
            println("Terjadi eror, silakan diulangi!")
            readTotalFruitUser()
        }

    }

    fun calculateTotalPrice(){
        totalPrice = totalFruit * (selectedFruit?.pricePerPcs ?: 0.0)
        println("Total price : $totalPrice")
        when {
            totalPrice in 100000.0 .. 150000.0 -> {
                println("You got extra 1 Watermelon")
            }
            totalPrice in 150000.0 .. 200000.0 -> {
                println("You got extra 2 Melon")
            }
            totalPrice in 200000.0 .. 250000.0 -> {
                println("You got extra 6 Avocado")
            }
            totalPrice in 250000.0 .. totalPrice -> {
                println("You got extra 20 Avocado")
            }
            else -> { println("You got no bonus Item") }

        }
    }
}

fun main(){
    BranchingApp2().run()
}