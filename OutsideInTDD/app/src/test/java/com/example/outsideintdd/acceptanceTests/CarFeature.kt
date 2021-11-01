package com.example.outsideintdd.acceptanceTests

import com.example.outsideintdd.Car
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue

import org.junit.Test

class CarFeature {
    private val engine = Engine()
    val car = Car(6.0, engine)

    @Test
    fun carIsLoosingFuelWhenItTurnOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItEngineAndIncreaseTheTemperature() {
        car.turnOn()

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurningOn)
    }
}