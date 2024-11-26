
fun main() {
    val atleta:List<accion> = listOf(accion.correr, accion.saltar, accion.saltar, accion.correr)
    val carrera:List<carrera> = listOf(carrera.suelo, carrera.valla, carrera.suelo, carrera.suelo)

    println(dibujarCarrera(atleta, carrera) + " "+ completaCarrera(atleta,carrera))
}
enum class accion(val action:String){
    correr("_"),
    saltar("|")
}

enum class carrera(val momento:String){
    suelo("suelo"),
    valla("valla")
}
fun completaCarrera(atleta: List<accion>, carrera: List<carrera>): Boolean{
    val longitudCarrera: Int = carrera.size
    var obstaculosBien :Int = 0
    if(atleta.size!=carrera.size){
        return false
    }
    for (x:Int in 0 ..longitudCarrera-1){
        if (atleta[x].action == "_" && carrera[x].momento == "suelo" || atleta[x].action == "|" && carrera[x].momento == "valla" ){
            obstaculosBien++
        }

    }
    if (obstaculosBien==longitudCarrera){
        return true
    } else {
        return false
    }

}

fun dibujarCarrera(atleta: List<accion>, carrera: List<carrera>): String{
    val longitudCarrera: Int = carrera.size
    var carreraDibujada: String=""
    for (x:Int in 0 ..longitudCarrera-1){
       if(atleta[x].action == "_" && carrera[x].momento == "suelo"){
           carreraDibujada=carreraDibujada+"_"
       } else if(atleta[x].action == "|" && carrera[x].momento == "valla") {
           carreraDibujada=carreraDibujada+"|"
       } else if(atleta[x].action == "|" && carrera[x].momento == "suelo") {
           carreraDibujada=carreraDibujada+"x"
       } else if(atleta[x].action == "_" && carrera[x].momento == "valla") {
           carreraDibujada=carreraDibujada+"/"
       } else {
           carreraDibujada=carreraDibujada+"?"
       }

    }
    return carreraDibujada
    }




