import javax.swing.text.html.StyleSheet.BoxPainter

fun main() {
    val tabla1: Array<Array<String>> = arrayOf(arrayOf("X","O","X"), arrayOf("O","X","O"), arrayOf("O","O","X"))
    val tabla2: Array<Array<String>> = arrayOf(arrayOf("","O","X"), arrayOf("","X","O"), arrayOf("","O","X"))
    val tabla3: Array<Array<String>> = arrayOf(arrayOf("O","O","O"), arrayOf("O","X","X"), arrayOf("O","X","X"))
    val tabla4: Array<Array<String>> = arrayOf(arrayOf("O","O","X"), arrayOf("X","X","O"), arrayOf("X","X","X"))
    println(comprobarResultado(tabla1))
    println(comprobarResultado(tabla2))
    println(comprobarResultado(tabla3))
    println(comprobarResultado(tabla4))
}

fun comprobarResultado(tabla: Array<Array<String>>):String{
    var ganaO: Boolean = false
    var ganaX: Boolean = false
    var cantidadX:Int=0
    var cantidadO:Int=0
    var diferenciaDeXyO: Int
    for (x in 0 ..2) {
        if (tabla[x][0] == tabla[x][1] && tabla[x][1] == tabla[x][2] && tabla[x][0] != "") {
            if (tabla[x][0] == "X") {
                ganaX = true
            } else if (tabla[x][0] == "O") {
                ganaO = true
            }
        }

        if (tabla[0][x] == tabla[1][x] && tabla[1][x] == tabla[2][x] && tabla[0][x] != "") {
            if (tabla[0][x] == "X"){
                ganaX = true
            } else if (tabla[0][x] == "O"){
                ganaO = true
            }
        }
    }

    if (tabla[0][0] == tabla[1][1] && tabla[1][1] == tabla[2][2] && tabla[0][0] != "") {
        if (tabla[0][0] == "X"){
            ganaX = true
        } else if (tabla[0][0] == "O") {
            ganaO = true
        }
    }
    if (tabla[0][2] == tabla[1][1] && tabla[1][1] == tabla[2][0] && tabla[0][2] != "") {
        if (tabla[0][2] == "X") {
            ganaX = true
        } else if (tabla[0][2] == "O"){
            ganaO = true
        }
    }

    for (x in 0..2) {
        for (y in 0..2) {
            if (tabla[x][y] == "X") {
                cantidadX++
            } else if (tabla[x][y] == "O"){
                cantidadO++
            }
         }
    }
    if (cantidadO>cantidadX){
        diferenciaDeXyO=cantidadO-cantidadX
    } else {
        diferenciaDeXyO=cantidadX-cantidadO
    }

    if(ganaX==true && ganaO==true || diferenciaDeXyO!=1){
        return "Nulo"
    } else if (ganaX==false && ganaO==false){
        return "Empate"
    } else if (ganaX==true && ganaO==false){
        return "X"
    } else if (ganaO==true && ganaX==false){
        return "O"
    } else {
        return "Nulo"
    }

}





