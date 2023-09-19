package materi

fun main(args: Array<String>) {
    // how to define variable
    // var / val ?
    val teamName = "Avenger"
    var name : String = "Ikap"
    name = "Ika Purwanti"
    println(name)
    val author : Any = "huhuuhuh"
    // Naming ---
    // untuk penamaan variabal boolean : biasanya depannya menggunakan kata is / has
    val isSingle : Boolean = true
    val hasValue : Boolean = true

    val addressNumber = 123
    val universityName = "AMIKOM"
    val addressList = listOf("Condet", "Depok")
    // camelCase
    // nama harus menjelaskan apa arti dari variable tersebut
    // nama dan isi harus selaras artinya


    // tipe data ditulis ketika sebuah variabel belum di inisialisasi value/datanya

    // ketika menggunakan sebuah collection kita bisa meng inisialisasi dengan banyak tipe data dalam 1 variabel jika tidak mendeklarasinya tipedatanya

    val fruit = "Apple" // single
    val fruits = listOf("Apple", "Mango", "orange") // plural

    val arrAdress = arrayOf("congcat", "sleman")
    // array hanya bisa di get dan set, tidak bisa menambahkan

    val avegerMembers = listOf("Iron Man", "Black Window", "Hawkeye")
    // bisa memanipulasi datanya, tapi panjangnya tidak bisa kita tambah

    val groceries = mutableListOf("Pepaya", "jeruk", "apel")
    groceries.add("melon")
    println(groceries)
    groceries.remove("apel")
    println(groceries)
    groceries.removeAll(groceries)
    println(groceries)


    // kalo men difine list, silakan difine sebagai jamak

    val data = listOf("bfba", "ggasga")
    // data itu sudah jamak/plural
}