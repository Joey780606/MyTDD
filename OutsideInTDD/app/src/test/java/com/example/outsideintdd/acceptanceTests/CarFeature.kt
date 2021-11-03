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
    fun carIsTurningOnItEngineAndIncreaseTheTemperature() = runBlockingTest {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(6000)
        //多等六秒,配合Engine.kt 的 delay(6000), 若改成 5000,就會出錯

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }
}