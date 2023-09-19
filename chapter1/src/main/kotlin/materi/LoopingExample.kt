import kotlin.math.max

class LoopingExample {

    fun forLoop() {
        //contoh range sederhana
        for (i in 1..8) {
            print(i)
        }
        println()
        //contoh range memakai until
        for (i in 1 until 8) {
            print(i)
        }
        println()
        //longkap angka
        for (i in 1..8 step 2) {
            print(i)
        }
        println()
        //downto hitung mundur
        for (i in 8 downTo 1) {
            print(i)
        }
    }

    fun doWhileExample() {
        var isLoopRunning = true
        do {
            println("Is loop running : $isLoopRunning")
            isLoopRunning = false
        } while (isLoopRunning)
    }

    fun whileExample() {
        var maxItteration = 0
        while (maxItteration <= 5) {
            println(maxItteration)
            maxItteration = maxItteration + 1
        }
    }

    // < less than
    // <= less than or equal
    // > greater than
    // >= greater than or equal
    // == equals
    // === equals reference

    data class Fruit(val name: String, val weightPerPcs: Double, val totalPcs: Int)

    fun loopInCollectionExample() {
        val list = listOf(
                Fruit("Nanas",500.0,3),
                Fruit("Apel",100.0,5),
                Fruit("Melon",700.0,4),
        )
        forEachExample(list)
    }

    fun forEachExample(list: List<Fruit>) {
        list.forEachIndexed { index, fruit ->
            println("""
                ===================
                Buah ke-${index + 1}
                Nama buah : ${fruit.name}
                Berat buah per pcs: ${fruit.weightPerPcs}
                Total yang dibeli : ${fruit.totalPcs}
                Total Berat : ${fruit.totalPcs * fruit.weightPerPcs}
            """.trimIndent())

            /*            println("===============")
                        println("Buah ke-${index + 1}")
                        println("Nama buah : ${fruit.name}")
                        println("Berat buah per pcs: ${fruit.weightPerPcs}")
                        println("Total yang dibeli : ${fruit.totalPcs}")
                        println("Total Berat : ${fruit.totalPcs * fruit.weightPerPcs}")*/
        }
    }

}

fun main() {
    //LoopingExample().forLoop()
    //LoopingExample().doWhileExample()
    LoopingExample().loopInCollectionExample()
}