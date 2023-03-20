package com.codely.demo.shared

import java.time.LocalDate
import java.time.Period

object AgeCalculator { // singleton donde tenemos funciones  todo dentro pero sin tener que hacer new, instancia
    fun calculate(birthDate: LocalDate, now: LocalDate) = Period.between(birthDate, now)
}
