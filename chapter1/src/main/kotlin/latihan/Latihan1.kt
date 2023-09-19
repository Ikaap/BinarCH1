package latihan/*
 I am Iron man, As an owner of iron man suit
 I want to know my iron man suit status using a single program which shows version of iron man suit ,
 suit battery percentage, my propulsion status, and list of weapons that ready in my suit.

 */

fun property(version : Int, battery : Double, isStatus : Boolean, weaspons : List<String>){
    println("Suit Version $version")
    println("Energy left is $battery%")
    println("Propulsion Status : $isStatus")
    println("Weapon Ready : $weaspons")
}


fun main(){
    var nama : String = "Tony Stark"
    println("======================================")
    println("Welcome $nama !")
    println("======================================")
    println("Iron Man is Online")
    println("======================================")

    println("Property Check")
    println()
    property(42,40.0,true, listOf("rocket", "laser"))

}