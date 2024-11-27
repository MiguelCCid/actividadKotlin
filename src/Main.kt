fun main() {
    val atleta:List<accion> = listOf(accion.correr, accion.saltar, accion.saltar, accion.correr)
    val carrera:List<carrera> = listOf(carrera.suelo, carrera.valla, carrera.suelo, carrera.suelo, carrera.valla, carrera.valla, carrera.valla)

    println(dibujarCarrera(atleta, carrera) + " "+ completaCarrera(atleta,carrera))
}
enum class accion(val action:String){
    correr("correr"),
    saltar("saltar")
}

enum class carrera(val momento:String){
    suelo("_"),
    valla("|")
}

fun completaCarrera(atleta: List<accion>, carrera: List<carrera>): Boolean{
    val longitudCarrera: Int = carrera.size
    var obstaculosBien :Int = 0
    if(atleta.size!=carrera.size){
        return false
    }

    for (x:Int in 0 ..longitudCarrera-1){
        if (atleta[x].action == "correr" && carrera[x].momento == "_" || atleta[x].action == "saltar" && carrera[x].momento == "|" ){
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
    val longitudCarrera: Int = carrera.size -1
    var pasosExtra: Int = if (atleta.size > carrera.size) {
        atleta.size - carrera.size
    } else {
        carrera.size - atleta.size
    }
    var carreraDibujada: String=""
    for (x:Int in 0 ..longitudCarrera - pasosExtra){
       if(atleta[x].action == "correr" && carrera[x].momento == "_"){
           carreraDibujada=carreraDibujada+"_"
       } else if(atleta[x].action == "saltar" && carrera[x].momento == "|") {
           carreraDibujada=carreraDibujada+"|"
       } else if(atleta[x].action == "saltar" && carrera[x].momento == "_") {
           carreraDibujada=carreraDibujada+"x"
       } else if(atleta[x].action == "correr" && carrera[x].momento == "|") {
           carreraDibujada=carreraDibujada+"/"
       } else {
           carreraDibujada=carreraDibujada+"?"
       }

    }

    while (pasosExtra>0){
        carreraDibujada=carreraDibujada+"?"
        pasosExtra--
    }
    return carreraDibujada
    }




