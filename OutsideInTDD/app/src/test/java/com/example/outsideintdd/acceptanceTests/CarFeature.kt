package com.example.outsideintdd.acceptanceTests

import com.example.outsideintdd.Car
import com.example.outsideintdd.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue

import org.junit.Test

class CarFeature {
    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @Test
    fun carIsLoosingFuelWhenItTurnOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItEngineAndIncreaseTheTemperature() {
        car.turnOn()

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }
}