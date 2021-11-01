package com.example.outsideintdd.unitTests

import com.example.outsideintdd.Car
import com.example.outsideintdd.Engine
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test


class CarShould {
    private val engine: Engine = mock()
    private val car = Car(engine,5.0)

    @Test
    fun looseFuelWhenITurnOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()    //如果這個不加,會錯,因為下方的判斷,是engine的turnOn()期待會被invoke一次

        verify(engine, times(1)).turnOn()
        // 如果 times 改成 2, 也會出錯,因表示期待engine的turnOn()期待會被呼叫二次,但實際只有一
    }
}