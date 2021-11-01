package com.example.outsideintdd.acceptanceTests

import org.junit.Assert.assertEquals
import org.junit.Test

class CarFeature {

    val car = Car(6.0)

    @Test
    fun carIsLoosingFuelWhenItTurnOn() {

        car.turnOn()

        assertEquals(5.5, car.fuel, 0.001)  //Follow latest parameter
    }
}