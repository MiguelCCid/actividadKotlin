import java.util.*

fun main() {
    val palabras= Scanner(System.`in`)
    val anagrama: Boolean
    print("Introduzca una palabra: ")
    val palabra1= palabras.nextLine()
    print("Introduzca otra palabra: ")
    val palabra2= palabras.nextLine()
    anagrama=anagramas(palabra1,palabra2)
    print("Las palabras $")


    }
    fun anagramas(palabra1:String, palabra2: String): Boolean{
        if (palabra1.length != palabra2.length){
            return false
        }
        return palabra1.toCharArray().sorted() == palabra2.toCharArray().sorted()
}


