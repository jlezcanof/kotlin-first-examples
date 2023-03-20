package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

fun main() {
    println("Please enter a date with the format <yyyy-MM-dd>")
    supportNullableString(readLine())
        .takeUnless {
            it.isNullOrEmpty()
        }?.let {
            LocalDate.parse(it)
        }.apply {
            if (this == null) {
                println("The introduced date <$this> is not valid")
                exitProcess(1)
            }
        }.also {
            println("You wrote the date $it")
        }.takeIf {
            it != null
        }?.run {
            calculateDifferenceUntilToday()
        }

    println("Bye!")
}

private fun supportNullableString(line: String?) = line

// extended function, pueden ser privadas o públicas, cuidadito con esto
private fun LocalDate.calculateDifferenceUntilToday() = with(Period.between(this, LocalDate.now())) {
    when {
        this.years > 18 -> println("Te has columnpiado, ${this.years} son muchos años")
        this.years > 0 -> println("The difference between the date you wrote an today is ${this.years} years")
        this.months > 0 -> println("The difference between the date you wrote an today is ${this.months} months")
        this.days > 0 -> println("The difference between the date you wrote an today is ${this.days} days")
    }
}
