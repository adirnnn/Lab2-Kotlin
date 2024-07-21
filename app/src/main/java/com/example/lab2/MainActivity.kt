package com.example.lab2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme

//Para Ejercicio 1
var numeros=listOf(4, 4, 4, 4)

fun calcularPromedio(numeros:List<Int>): Int {
    val suma=numeros.reduce {acc, num -> acc + num}
    return suma/numeros.size
}

//Para Ejercicio 2
var numeros2=listOf(1, 2, 3, 4)

//Para Ejercicio 3
fun isPalindrome(cadena:String): Boolean {
    val cadenalimpia=cadena.replace("//s".toRegex(), "").lowercase()
    return cadenalimpia==cadenalimpia.reversed()
}

//Para Ejercicio 4
var nombres=listOf("Charles", "Lando", "Kendrick", "Charlie")

//Para Ejercicio 5
fun performOperation(a:Int, b:Int, operation:(Int,Int)->Int): Int {
    return operation(a,b)
}

//Para Ejercicio 6
data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

fun personaAEstudiante(person: Person, studentId: String): Student {
    return Student(person.name, person.age, person.gender, studentId)
}

val personas=listOf(
    Person("Lando", 24, "Masculino"),
    Person("Kendrick", 32, "Masculino"),
    Person("Max", 26, "Masculino")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                //Ej 1
                val promedio=calcularPromedio(numeros)
                println(promedio)
                println("")

                //Ej 2
                val impares=numeros2.filter {it % 2 != 0}
                println(impares)
                println("")

                //Ej 3
                val palabras=listOf("palindromo","racecar")
                for (palabra in palabras) {
                    println(isPalindrome(palabra))
                }
                println("")

                //Ej 4
                val saludos=nombres.map {nombre ->"¡Hola, $nombre!"}
                println(saludos)
                println("")

                //Ej 5
                val suma={x:Int, y:Int -> x+y}
                val resta={x:Int, y:Int -> x-y}
                val multi={x:Int, y:Int -> x*y}
                val divi={x:Int, y:Int -> x/y}

                println(performOperation(4, 2, suma))
                println(performOperation(4, 2, resta))
                println(performOperation(4, 2, multi))
                println(performOperation(4, 2, divi))

                //Ej 6
                val estudiantes=personas.mapIndexed {index, person -> personaAEstudiante(person, "S${index + 1}")}
                estudiantes.forEach {estudiante -> println("El estudiante ${estudiante.name} tiene ${estudiante.age}")}
            }
        }
    }
}