package com.example.outsideintdd

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Engine(var temperature: Int = 15,
             var isTurnedOn: Boolean = false)
{
    suspend fun turnOn(): Flow<Int> {
        isTurnedOn = true

        //Thread.sleep(6000)
        //delay(6000)
        return flow {
            delay(2000)
            temperature = 25
            emit(temperature)

            delay(2000)
            temperature = 50
            emit(temperature)

            delay(2000)
            temperature = 95
            emit(temperature)
            Log.d("COURSE", "Engine has turned on")
        }

        //throw Exception()
    }
}