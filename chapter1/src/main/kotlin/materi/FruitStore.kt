package materi

interface Store {
    fun run()
}

abstract class FruitStore(private val fruitDealer: FruitSupplier) : Store {

    private var selectedFruit : Fruit? = null

    override fun run() {
        printHeader()
        printMenu()
        getUserChoice()
    }

    abstract fun getStoreName() : String

    open fun getCalculatePrice(realPrice : Double) : Double {
        return (realPrice + (realPrice * 0.15))
    }

    private fun printHeader(){
        println(
            """
            ------------------------
            Welcome to Fruit Store ${getStoreName()}
            ------------------------
        """.trimIndent()
        )
    }

    private fun printMenu(){
        println("Available Fruit for Today !")
        println(fruitDealer.getAvailableFruit().joinToString("\n") { fruit -> "${fruit.id}. ${fruit.fruitName} : $${getCalculatePrice(fruit.pricePerPcs)}" })
        println("------------------------")
        println("What do you want to buy ? ")
    }

    private fun getUserChoice(){
        inputMenuLoop@ while (true) {
            val input = readlnOrNull()?.trim()
            val fruitResult = fruitDealer.getAvailableFruit().find { fruit -> fruit.id == input }
            if (fruitResult != null) {
                selectedFruit = fruitResult
                break@inputMenuLoop
            } else {
                println("You input wrong value")
            }
        }
        println("You select ${selectedFruit?.fruitName}")
    }


}

class FruitStoreA(private val fruitDealer: FruitSupplier) : FruitStore(fruitDealer) {
    override fun getStoreName(): String = "A"

}

class FruitStoreB(private val fruitDealer: FruitSupplier) :FruitStore(fruitDealer) {

    private val promoDiscount = 0.75 // Percent

    override fun getStoreName(): String = "B"

    override fun getCalculatePrice(realPrice: Double): Double {
        return super.getCalculatePrice(realPrice) * promoDiscount
    }

}

interface  FruitSupplier {
    fun getAvailableFruit(): List<Fruit>
}

class FruitSupplierA : FruitSupplier{
    override fun getAvailableFruit(): List<Fruit> {
        return listOf(
            Fruit(id = "1", fruitName = "Melon", 20000.0),
            Fruit(id = "2", fruitName = "Apple", 6000.0),
            Fruit(id = "3", fruitName = "Mango", 10000.0),
            Fruit(id = "4", fruitName = "Avocado", 8000.0),
            Fruit(id = "5", fruitName = "Watermelon", 21000.0),
        )
    }
}


class FruitSupplierB : FruitSupplier{
    override fun getAvailableFruit(): List<Fruit> {
        return listOf(
            Fruit(id = "1", fruitName = "Melon", 20000.0),
            Fruit(id = "2", fruitName = "Salak", 6000.0),
            Fruit(id = "3", fruitName = "Strawberry", 10000.0),
            Fruit(id = "4", fruitName = "Orange", 8000.0),
            Fruit(id = "5", fruitName = "Durian", 21000.0),
        )
    }
}

data class Fruit(val id: String, val fruitName: String, val pricePerPcs: Double)


class App(private val store: FruitStore ) {
     fun start() {
        store.run()
    }
}

fun main() {
    val dealer = FruitSupplierB()
    val app = App(FruitStoreA(dealer))
    app.start()
}