package materi

// sebuah class tanpa constructor tidak bisa menjadi object
// kalo ada val nya dia variabel constructor
// kalo gada val/var dia constructor dan harus diproses di method init{}
class Jarvis (private val ownerName:String = "Stark"){
    fun start(){
        println("Hello $ownerName")
    }
}

class Jarvis2(ownerName: String){
    init {
        println("Hello $ownerName")
    }
//    fun start(){
//        println("Hello $ownerName")
//    }
}
// kalo di sebuah class constructor nya sudah di isi (default) kalo di latihan.main sudah menjadi object maka sunnah untuk diisikan
// namun ketika belum di inisialisasi maka di latihan.main/objectnya wajib diisikan value dari constructornya
fun main(){
//    val jarvis = Jarvis(
//        ownerName = "Tony Stark"
//    )
    val jarvis = Jarvis() // tidak wajib diisi
    val jarvis2 = Jarvis("Anthony Stark")
    jarvis.start()
    jarvis2.start()
}