package materi

class BranchingApp {
    /*
    fun run(){
        //
        val fruits = listOf("Nanas", "Apel", "Alpukat")
        // "Nanas", "Apel", "Alpukat" --> Map
        // "nanas", "apel", "alpukat" contains "alpukat
        if (fruits.map { fruits ->fruits.lowercase() } .contains("alpukat".lowercase())){
            println("Iya ada alpukat")
        } else {
            println("Engga ada alpukat")
        }
    }
    */

    private val fruits = listOf("Nanas", "Apel", "Alpukat")

    fun run(){
        if (fruitContains("alpukat")){
            println("Iya ada alpukat")
        } else if(fruitContains("apel")){
            println("Iya ada apel")
        } else {
            println("Engga ada alpukat")
        }
    }

    private fun fruitContains(value : String) : Boolean{
        return fruits.map { fruits -> fruits.lowercase() }.contains(value.lowercase())
    }
}

fun main(){
    BranchingApp().run()
}