package tugas

class Pemesanan {
   private val listMenu = listOf(
       "Ayam Bakar", 50000,
       "Ayam Goreng", 40000,
       "Ayam Geprek", 40000,
       "Kulit Ayam Crispy", 15000,
       "Sate Usus Ayam", 5000)

    fun tampilMenu(){

        for (i in 0 .. listMenu.size-1 step 2){

            println(" ${listMenu.get(i)} = Rp. ${listMenu.get(i + 1)}/porsi")

        }
    }
/*
    fun tampilPilihMenu(nomorMenu : Int){
        if (nomorMenu == 1){
            println("Kamu memilih menu $nomorMenu")
            println("Nama menu : ${listMenu[nomorMenu-1]}")
            println("Harga : Rp. ${listMenu[nomorMenu]}")
        }
        else if (nomorMenu == 2){
            println("Kamu memilih menu $nomorMenu")
            println("Nama menu : ${listMenu[nomorMenu-1]}")
            println("Harga : Rp. ${listMenu[nomorMenu]}")
        }
        else if (nomorMenu == 3){
            println("Kamu memilih menu $nomorMenu")
            println("Nama menu : ${listMenu[nomorMenu-1]}")
            println("Harga : Rp. ${listMenu[nomorMenu]}")
        }
        else if (nomorMenu == 4){
            println("Kamu memilih menu $nomorMenu")
            println("Nama menu : ${listMenu[nomorMenu-1]}")
            println("Harga : Rp. ${listMenu[nomorMenu]}")
        }
        else if (nomorMenu == 5){
            println("Kamu memilih menu $nomorMenu")
            println("Nama menu : ${listMenu[nomorMenu-1]}")
            println("Harga : Rp. ${listMenu[nomorMenu]}")
        }
        else {
            println("Data yang diinputkan salah")
        }
    }
    */

    fun printPemesanan(){
        println()
        println("===== Selamat Datang di Warung Binar =====")
        println()
        println("List Menu Makanan")
        tampilMenu()
        println("---------------------------------------")
        print("Pilih Menu Makanan : ")
        val pilihMenu = readLine()!!.toInt()
        if (pilihMenu == 1){
            println("Kamu memilih menu $pilihMenu")
            println("Nama menu : ${listMenu[pilihMenu-1]}")
            println("Harga : Rp. ${listMenu[pilihMenu]}")
            println("---------------------------------------")
            print("Masukkan Pembayaran : ")
            val bayar = readLine()!!.toInt()
            val isStatusBayar = false
            do{
                print("Masukkan Pembayaran : ")
                val bayar = readLine()!!.toInt()
                if (bayar.toString() < listMenu[pilihMenu].toString()) {
                    println("Maaf, pembayaran anda gagal!")

                }

                else{
                    println("Terima kasih, Anda berhasil memesan makanan")

                }
            }while (isStatusBayar)


         //   }
//            else{
//                println("Terima kasih, Anda berhasil memesan makanan")
//            }

        }
        else if (pilihMenu == 2){
            println("Kamu memilih menu $pilihMenu")
            println("Nama menu : ${listMenu[pilihMenu]}")
            println("Harga : Rp. ${listMenu[pilihMenu+1]}")
            println("---------------------------------------")
            print("Masukkan Pembayaran : ")
            val bayar = readLine()!!.toInt()
            if (bayar.toString() < listMenu[pilihMenu+1].toString()){
                println("Maaf, pembayaran anda gagal!")
            }
            else{
                println("Terima kasih, Anda berhasil memesan makanan")
            }

        }
        else if (pilihMenu == 3){
            println("Kamu memilih menu $pilihMenu")
            println("Nama menu : ${listMenu[pilihMenu+1]}")
            println("Harga : Rp. ${listMenu[pilihMenu+2]}")
            println("---------------------------------------")
            print("Masukkan Pembayaran : ")
            val bayar = readLine()!!.toInt()
            if (bayar.toString() < listMenu[pilihMenu+2].toString()){
                println("Maaf, pembayaran anda gagal!")
            }
            else{
                println("Terima kasih, Anda berhasil memesan makanan")
            }

        }
        else if (pilihMenu == 4){
            println("Kamu memilih menu $pilihMenu")
            println("Nama menu : ${listMenu[pilihMenu+2]}")
            println("Harga : Rp. ${listMenu[pilihMenu+3]}")
            println("---------------------------------------")
            print("Masukkan Pembayaran : ")
            val bayar = readLine()!!.toInt()
            if (bayar.toString() < listMenu[pilihMenu+3].toString()){
                println("Maaf, pembayaran anda gagal!")

            }
            else{
                println("Terima kasih, Anda berhasil memesan makanan")
            }

        }
        else if (pilihMenu == 5){
            println("Kamu memilih menu $pilihMenu")
            println("Nama menu : ${listMenu[pilihMenu+3]}")
            println("Harga : Rp. ${listMenu[pilihMenu+4]}")
            println("---------------------------------------")
            print("Masukkan Pembayaran : ")
            val bayar = readLine()!!.toInt()
            if (bayar.toString() < listMenu[pilihMenu+4].toString()){
                println("Maaf, pembayaran anda gagal!")
            }
            else{
                println("Terima kasih, Anda berhasil memesan makanan")
            }

        }
        else {
            println("Data yang diinputkan salah")
        }





        println("---------------------------------------")
        println("Metode Pengiriman Makanan : ")
        println("1. Take Away\n2. Delivery")
        print("Masukkan pilihan anda : ")
        val  metodePengiriman= readLine()!!.toInt()
        if (metodePengiriman == 1){
            println("Metode Pengiriman : Take Away")
        } else {
            println("Metode Pengiriman : Delivery")
        }


    }
}



fun main(){
    Pemesanan().printPemesanan()

}