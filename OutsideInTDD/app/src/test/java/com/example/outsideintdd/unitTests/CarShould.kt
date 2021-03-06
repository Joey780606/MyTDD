package com.example.outsideintdd.unitTests

import com.example.outsideintdd.Car
import com.example.outsideintdd.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test


class CarShould {
    private val engine: Engine = mock()
    //private val car = Car(engine,5.0)
    private val car : Car

    init {
        runBlockingTest {
            whenever(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(25)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)
            })
        }
        car = Car(engine,5.0)   //記得要放在這裡
    }

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenITurnOn(): Unit = runBlockingTest {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runBlockingTest  {
        car.turnOn()    //如果這個不加,會錯,因為下方的判斷,是engine的turnOn()期待會被invoke一次

        verify(engine, times(1)).turnOn()
        // 如果 times 改成 2, 也會出錯,因表示期待engine的turnOn()期待會被呼叫二次,但實際只有一
    }
}