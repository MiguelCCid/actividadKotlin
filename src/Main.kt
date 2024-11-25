
fun main() {
    for(numero in 1..100)
        if (numero%3 == 0 && numero%5 != 0 ){
            println("tri")
        } else if (numero%5 == 0 && numero%3 != 0) {
                println("qui")
        } else if (numero%5 == 0  && numero%3==0) {
            println("triqui")
        } else {
            println(numero)
        }

    }


