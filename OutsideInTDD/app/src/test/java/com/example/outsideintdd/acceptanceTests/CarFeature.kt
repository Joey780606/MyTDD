package com.example.outsideintdd.acceptanceTests

import com.example.outsideintdd.Car
import com.example.outsideintdd.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule

import org.junit.Test

class CarFeature {
    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnOn() = runBlockingTest {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItEngineAndIncreaseTheTemperatureGradually() = runBlockingTest {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(25, car.engine.temperature)

        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(50, car.engine.temperature)

        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(95, car.engine.temperature)

        assertTrue(car.engine.isTurnedOn)
    }
}