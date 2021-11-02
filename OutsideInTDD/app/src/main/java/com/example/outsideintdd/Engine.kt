package com.example.outsideintdd

import android.util.Log
import kotlinx.coroutines.delay

class Engine(var temperature: Int = 15,
             var isTurnedOn: Boolean = false)
{
    suspend fun turnOn() {
        isTurnedOn = true

        //Thread.sleep(6000)
        delay(6000)
        temperature = 95

        Log.d("COURSE", "Engine has turned on")
    }
}