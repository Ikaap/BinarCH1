package latihan

class Resep {

    private val namaResep = listOf("Nasi Goreng", "Bakso")
    val recipeData1: recipeItem = recipeItem("Nasi", 500, "gram")
    val recipeData2: recipeItem = recipeItem("Sambal", 2, "tbs")
    val recipeData3: recipeItem = recipeItem("Egg", 2, "pcs")
    val recipeData4: recipeItem = recipeItem("Bakso", 20, "pcs")
    val recipeData5: recipeItem = recipeItem("Daging", 100, "gram")
    val recipeData6: recipeItem = recipeItem("Broth", 200, "ml")

    fun tampilResep() {
        for (a in 0..namaResep.size - 1) {
            println("Recipe number : ${a + 1}")
            println("========================================")
            println("How to make ${namaResep[a]}")

        }
    }

    //    fun recipeData (){
//        val recipeDataList = arrayListOf<recipeItem>()
//        recipeDataList.add(recipeItem("Nasi",500, "gram"))
//        recipeDataList.add(recipeItem("Sambal",2, "tbs"))
//        recipeDataList.add(recipeItem("Egg",2, "pcs"))
//        recipeDataList.add(recipeItem("Bakso",20, "pcs"))
//        recipeDataList.add(recipeItem("Daging",100, "gram"))
//        recipeDataList.add(recipeItem("Broth",200, "ml"))
//
//    }

    fun tampilIngredient() {
        for (a in 0..namaResep.size - 1) {
            println("Portion : 1 Per  People")
            println("Ingredients : ")
            if (a == 0) {
                println("${recipeData1.nama} : ${recipeData1.banyak} ${recipeData1.satuan}")
                println("${recipeData2.nama} : ${recipeData2.banyak} ${recipeData2.satuan}")
                println("${recipeData3.nama} : ${recipeData3.banyak} ${recipeData3.satuan}")
                println()
                println("Step to make : ")
                println("Just stir fry nasi with sambal and eggs")
                println()
            } else if (a == 1) {
                println("${recipeData4.nama} : ${recipeData4.banyak} ${recipeData4.satuan}")
                println("${recipeData5.nama} : ${recipeData5.banyak} ${recipeData5.satuan}")
                println("${recipeData6.nama} : ${recipeData6.banyak} ${recipeData6.satuan}")
                println()
                println("Step to make : ")
                println("Just stir fry nasi with sambal and eggs")
                println()
            }
        }

    }


    fun run() {
        println("========================================")
//        tampilResep()
//        tampilIngredient()
        for (a in 0..namaResep.size - 1) {
            println("Recipe number : ${a + 1}")
            println("========================================")
            println("How to make ${namaResep[a]}")
            println("----------------------------------------")
            println("Portion : 1 Per  People")
            println("Ingredients : ")
            if (a == 0) {
                println("${recipeData1.nama} : ${recipeData1.banyak} ${recipeData1.satuan}")
                println("${recipeData2.nama} : ${recipeData2.banyak} ${recipeData2.satuan}")
                println("${recipeData3.nama} : ${recipeData3.banyak} ${recipeData3.satuan}")
                println()
                println("Step to make : ")
                println("Just stir fry nasi with sambal and eggs")
                println()
            } else if (a == 1) {
                println("${recipeData4.nama} : ${recipeData4.banyak} ${recipeData4.satuan}")
                println("${recipeData5.nama} : ${recipeData5.banyak} ${recipeData5.satuan}")
                println("${recipeData6.nama} : ${recipeData6.banyak} ${recipeData6.satuan}")
                println()
                println("Step to make : ")
                println("Just stir fry nasi with sambal and eggs")
                println()
            }
        }
    }
}

data class recipeItem(
    val nama : String,
    val banyak : Int,
    val satuan : String,
)


fun main(){
    Resep().run()

}
