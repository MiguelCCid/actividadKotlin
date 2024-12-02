fun main() {
    val x=0
    println("Introduzca la capacidad de la agenda")
    var capacidadAgenda = readLine()?.toInt() ?: 10
    val agenda: Array<Contacto?> = Array(capacidadAgenda){null}
    while (x==0){
        menu()
        println("Escriba una de las opciones")
        var opcion = readLine()?.toInt()
        when(opcion){
            1 -> anadirContacto(agenda)
            2 -> listarContactos(agenda)
            3 -> buscarContacto(agenda)
            4 -> existeContacto(agenda)
            5 -> eliminarContacto(agenda)
            6 -> numeroDeHuecosLibres(agenda)
            7 -> comprobarAgendaLlena(agenda)
            8 -> break
            else -> println("Introduzca un numero de las opciones porfavor")
        }
    }
}

fun menu(){
    println("------------------------")
    println("1.Añadir Contacto")
    println("2.Listar Contactos")
    println("3.Buscar Contacto")
    println("4.Existe Contacto")
    println("5.Eliminar Contacto")
    println("6.Contactos Disponibles")
    println("7.Agenda llena")
    println("8.Salir")
    println("------------------------")
}
fun anadirContacto(agenda:Array<Contacto?>){
    var contactoExiste: Boolean
    println("Escriba el nombre")
    var nombre = readLine()
    println("Escriba el numero")
    var numero = readLine()
    for (i in agenda) {
        if (nombre == i?.nombre) {
            contactoExiste = true
            println("El contacto con ese nombre ya existe.")
            return
        }
    }

    for (x in agenda.indices) {
        if (agenda[x] == null) {
            agenda[x] = Contacto(nombre, numero)
            println("Se ha añadido el contacto.")
            return
        }
    }
    println("La agenda está llena. No se pueden meter más contactos.")

}
fun listarContactos(agenda: Array<Contacto?>){
    for (x in agenda){
        if (x!=null) {
            println("Nombre: ${x.nombre}, Telefono: ${x.telefono}")
        }
    }
}

fun buscarContacto(agenda: Array<Contacto?>){
    var contactoEncontrado: Boolean = false
    println("Escriba un nombre")
    var nombre = readLine()
    for (i in agenda) {
        if (nombre == i?.nombre) {
            contactoEncontrado = true
            println("Su telefono es: ${i?.telefono}")
            break
        }
    }
    if (contactoEncontrado==false){
        println("No se ha encontrado el contacto")
    }
}

fun existeContacto(agenda: Array<Contacto?>){
    var contactoEncontrado: Boolean = false
    println("Escriba un nombre")
    var nombre = readLine()
    for (i in agenda) {
        if (nombre == i?.nombre) {
            contactoEncontrado = true
        }
    }
    if (contactoEncontrado){
        println("Existe contacto")
    } else {
        println("No existe contacto")
    }
}

fun eliminarContacto(agenda: Array<Contacto?>){
    var contactoEncontrado: Boolean = false
    println("Escriba un nombre")
    var nombre = readLine()

    for (i in agenda.indices) {
        if (agenda[i]?.nombre == nombre) {
            agenda[i] = null
            contactoEncontrado = true
            println("Se ha eliminado el contacto")
            break
        }
    }
    if (contactoEncontrado==false){
        println("No se ha eliminado el contacto")
    }
}

fun numeroDeHuecosLibres(agenda: Array<Contacto?>){
    var huecosLibres=0
    for (i in agenda) {
        if (i==null) {
            huecosLibres++
        }
    }
    println("Hay $huecosLibres contacto/s libre/s")
}

fun comprobarAgendaLlena(agenda: Array<Contacto?>){
    var huecosLibres=0
    for (i in agenda) {
        if (i==null) {
            huecosLibres++
        }
    }
    if (huecosLibres==0){
        println("La agenda está llena")
    } else {
        println("Aun se pueden meter contactos")
    }
}



