package com.example.outsideintdd.unitTests

import com.example.outsideintdd.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @Test
    fun turnOn() {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureWhenItTurnOn() {
        engine.turnOn()

        assertEquals(95, engine.temperature)
    }
}