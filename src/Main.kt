import java.util.*
import kotlin.Boolean
import kotlin.Boolean as B

fun main() {
val a="{a + b [c] * (2x2)}"
val b="{ [ a * ( c + d ) ] - 5 }"
val c="{ a * ( c + d ) ] - 5 }"
val d="{a^4 + (((ax4)}"
val e="{ ] a * ( c + d ) + ( 2 - 3 )[ - 5 }"
val f="{{{{{{(}}}}}}"
val g="(a"

    println(comprobar(a))
}

fun comprobar(expresion: String): Boolean{
    val longitud: Int = expresion.length
    var cantidadLlave: Int = 0
    var cantidadLlaveCerrada: Int = 0
    var cantidadCorchete: Int = 0
    var cantidadParentesis: Int = 0
    var cantidadCorcheteCerrado: Int = 0
    var cantidadParentesisCerrado: Int = 0
    var cantidad: Boolean
    var empiezaBien: Boolean
    var primero: Char = 'x'
    var llave=1
    var corchete=1
    var parentesis=1
    var llaveE =expresion.length
    var corcheteE =expresion.length
    var parentesisS = expresion.length

    for(x:Char in expresion){
        if (x=='{' || x=='}' || x=='[' || x==']' || x=='(' || x==')'){
            primero = x
            break;
        }
    }

    if (primero=='}' ||primero==']' ||primero==')'){
        empiezaBien=false
    } else {
        empiezaBien=true
    }

    while (llave>0 && llaveE>0){
        for(x: Char in expresion){
            when(x){
                '{'->llave=llave+1
                '}'->llave=llave-1
            }
            llaveE=llaveE-1
        }
    }
    while (parentesis>0 && parentesisS>0){
        for(x: Char in expresion){
            when(x){
                '('->parentesis=parentesis+1
                ')'->parentesis=parentesis-1
            }
            parentesisS=parentesisS-1
        }
    }
    while (corchete>0 && corcheteE>0){
        for(x: Char in expresion){
            when(x){
                '['->corchete=corchete+1
                ']'->corchete=corchete-1
            }
            corcheteE=corcheteE-1
        }
    }

    for(x: Char in expresion){
        when(x){
            '{' -> cantidadLlave= cantidadLlave+1
            '}' -> cantidadLlaveCerrada=cantidadLlaveCerrada+1
            '[' -> cantidadCorchete=cantidadCorchete+1
            ']' -> cantidadCorcheteCerrado=cantidadCorcheteCerrado+1
            '(' -> cantidadParentesis=cantidadParentesis+1
            ')' -> cantidadParentesisCerrado=cantidadParentesisCerrado+1
        }
    }

    if(cantidadLlave==cantidadLlaveCerrada && cantidadCorchete==cantidadCorcheteCerrado && cantidadParentesis==cantidadParentesisCerrado){
        cantidad=true
    } else{
        cantidad= false
    }
   if (llave==1 && parentesis==1 && corchete==1 && cantidad==true && empiezaBien == true){
       return true
   } else {
       return false
   }
}



