package com.example.outsideintdd.unitTests

import com.example.outsideintdd.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runBlockingTest  {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureGraduallyWhenItTurnOn() = runBlockingTest {
        val flow: Flow<Int> = engine.turnOn()
        val actual: List<Int> = flow.toList()

        assertEquals(listOf(25, 50, 95), actual)
    }
}