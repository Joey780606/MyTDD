package com.example.outsideintdd

class Engine(var temperature: Int,
             var isTurnedOn: Boolean = false)
{
    fun turnOn() {
        isTurnedOn = true
        temperature = 95
    }
}