package com.example.outsideintdd.unitTests

import com.example.outsideintdd.Car
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CarShould {

    val car = Car(5.0)

    @Test
    fun looseFuelWhenITurnOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }
}