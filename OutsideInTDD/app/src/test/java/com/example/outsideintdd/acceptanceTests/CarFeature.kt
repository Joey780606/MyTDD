package com.example.outsideintdd.acceptanceTests

import com.example.outsideintdd.Car
import junit.framework.TestCase.assertEquals

import org.junit.Test

class CarFeature {

    val car = Car(6.0)

    @Test
    fun carIsLoosingFuelWhenItTurnOn() {

        car.turnOn()

        assertEquals(5.5, car.fuel)
    }
}