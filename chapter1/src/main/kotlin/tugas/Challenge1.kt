package tugas

import java.lang.NumberFormatException
import java.util.Timer
import kotlin.concurrent.schedule

class OrderingFoodApp {

    private var selectedMenu : Menu? = null
    private var payment : Int = 0
    private var deliveryItem : Int = 0
    private var calculateProcess : Double = 0.0

    private fun printHeader(){
       println("""
           ==========================================
           ==    Selamat Datang di Warung Binar    ==
           ==========================================
       """.trimIndent())
    }

    private fun printMenu(){
        println("\t\t\tList Menu Makanan")
        println(MenuListData.menuListItem().joinToString("\n") { menuItem -> "${menuItem.id}. ${menuItem.menuName} = Rp. ${menuItem.pricePerPortion}/porsi"  })
        println("----------------------------------------------")
        print("Pilih menu makanan : ")
    }

    private fun userInputMenu(){
        while (true){
            val input = readlnOrNull()?.trim()
            val menuResult = MenuListData.menuListItem().find { menuList -> menuList.id == input }
            if (menuResult != null ){
                selectedMenu = menuResult
                break
            } else {
                println("Menu tidak tersedia, silakan pilih kembali")
                printMenu()
            }
        }
        println("""
            Kamu memilih menu ${selectedMenu?.id}
            Nama menu : ${selectedMenu?.menuName}
            Harga     : ${selectedMenu?.pricePerPortion}
        """.trimIndent())
    }

    private fun userInputPayment(){
        println("----------------------------------------------")
        print("Masukkan pembayaran : ")
        try {
            val input = readlnOrNull()?.trim()
            payment = input?.toInt() ?: 0
        } catch (e : NumberFormatException){
            println("Masukkan dengan format angka")
            userInputPayment()
        }catch (e : Exception){
            println("Error : $e")
            userInputPayment()
        }
    }

    private fun calculatePayment(){
        if (payment < selectedMenu!!.pricePerPortion){
            calculateProcess = -1 * (payment - selectedMenu!!.pricePerPortion)
            println("Pembayaran yang anda inputkan Rp. $payment")
            println("Maaf, pembayaran Anda kurang = Rp. $calculateProcess")
            userInputPayment()
            calculatePayment()
        } else{
            calculateProcess = payment - selectedMenu!!.pricePerPortion
            println("Pembayaran yang anda inputkan Rp. $payment")
            println("Terima kasih, Anda berhasil memesan makanan")
            println("Kembalian = Rp. $calculateProcess")
        }
    }

    private fun userInputDelivery() {
        println("----------------------------------------------")
        println(
            """
            Metode Pengiriman Makanan
            1. Take Away
            2. Delivery
        """.trimIndent()
        )
        print("Pilih metode : ")
        try {
            val input = readlnOrNull()?.trim()
            deliveryItem = input?.toInt() ?: 0
        } catch (e : Exception){
            println("Error : $e")
            userInputDelivery()
        }
    }

    private fun prosesDelivery(){
        when (deliveryItem) {
            1 -> {
                println("Metode yang dipilih : Take Away")
                println("----------------------------------------------")
                println("Konfirmasi ke resto ...")
                Timer().schedule(5000){
                    println("Makananmu sedang dimasak (5 detik) .....")
                }
                Timer().schedule(10000){
                    println("Makananmu Sudah Siap! Silakan ambil di resto ya! (5 detik) .....")
                }
                Timer().schedule(13000){
                    println("Pesanan Selesai! (3 detik) ...")
                }
            }
            2 -> {
                println("Metode yang dipilih : Delivery")
                println("----------------------------------------------")
                println("Konfirmasi ke resto ...")
                Timer().schedule(5000){

                    println("Makananmu sedang dimasak (5 detik) .....")
                }
                Timer().schedule(10000){
                    println("Makananmu Sudah Siap! Driver segera menuju tempatmu! (5 detik) .....")
                }
                Timer().schedule(13000){
                    println("Driver sampai! Pesanan selesai! (3 detik) ...")
                }
            }
            else -> {
                println("Inputan Anda salah!")
            }
        }
    }

    fun run(){
        do {
            println()
            printHeader()
            printMenu()
            userInputMenu()
            userInputPayment()
            calculatePayment()
            userInputDelivery()
            prosesDelivery()
            Timer().schedule(15000){
                println("\n\t-- Selamat Menikmati --")
                print("Apakah Anda ingin memesan lagi ? (y/n)")
            }
            val input = readlnOrNull()?.trim().toString()
        } while (input == "y" || input == "Y")
        println("""
                    Terima Kasih
            -- Silakan Datang Kembali --
        """.trimIndent())
    }
}

data class Menu(val id: String, val menuName: String, val pricePerPortion : Double)

object MenuListData {
    fun menuListItem(): List<Menu> {
        return listOf(
            Menu("1","Ayam Bakar",50000.0),
            Menu("2","Ayam Goreng",40000.0),
            Menu("3","Ayam Geprek",40000.0),
            Menu("4","Kulit Ayam Crispy",15000.0),
            Menu("5","Sate Usus Ayam",5000.0)
        )
    }
}

fun main(){
    OrderingFoodApp().run()
}

