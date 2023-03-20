package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

fun main() {
    println("Please enter a date with the format <yyyy-MM-dd>")
    val inputDate = supportNullableString(readLine())
        .takeUnless { // solo validamos que el input no es nulo ni vacio
            dateIsInformed(it)
        }?.let {
            LocalDate.parse(it)
        }

    if (inputDate == null) {
        println("The introduced date is null")
        exitProcess(1)
    } else {
        inputDate.also { // y ademas, metodo side-effect
            println("You wrote the date $it")
        }
        val currentDate = LocalDate.now()
        with(Period.between(inputDate, currentDate)) {
            println("The difference between the date you wrote an today is ${this.years} years")
        }
    }

    println("Bye!")
}

private fun dateIsInformed(it: String?) = it.isNullOrEmpty() || it.isNullOrBlank()

private fun supportNullableString(line: String?) = line
