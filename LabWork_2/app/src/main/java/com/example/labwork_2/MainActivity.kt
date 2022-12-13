package com.example.labwork_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

interface AnimalVoice {
    fun VoiceQuiet()
    fun VoiceLoud()
    fun VoiceManyTimes(count:Int)
}

open class Animal {
    protected var m_Type:String = "Undefined"
    protected var m_Class:String = "Undefined"

    public fun getType():String {
        return m_Type
    }

    public fun getClass():String {
        return m_Class
    }

    public fun getKingdom():String {
        return "Animalia"
    }

    private fun info() {
        // This is a function without an assignment.
        // The programmer did not come up with anything sensible because a private function is not inherited.
    }
}

class Dog : Animal, AnimalVoice {
    private var m_Name:String = ""

    init {
        m_Type = "Dog"
        m_Class = "Mammalia"
    }

    constructor(name:String) {
        m_Name = name
    }

    fun getName():String {
        return m_Name
    }

    // Interface
    override fun VoiceQuiet() {
        println("woof, woof.")
    }

    override fun VoiceLoud() {
        println("WOOF, WOOF!!!")
    }

    override fun VoiceManyTimes(count:Int) {
        var str:String = ""
        for (i in 1..count) {
            str += "Woof "
        }
        println(str)
    }
}

class Bird : Animal, AnimalVoice {
    private var m_Name:String = ""

    init {
        m_Type = "Bird"
        m_Class = "Aves"
    }

    constructor(name:String) {
        m_Name = name
    }

    fun getName():String {
        return m_Name
    }

    // Interface
    override fun VoiceQuiet() {
        println("chirp, chirp.")
    }

    override fun VoiceLoud() {
        println("CHIRP, CHIRP!!!")
    }

    override fun VoiceManyTimes(count:Int) {
        var str:String = ""
        for (i in 1..count) {
            str += "Chirp "
        }
        println(str)
    }
}

class Fish : Animal {
    private var m_Name:String = ""

    init {
        m_Type = "Fish"
        m_Class = "Actinopterygii"
    }

    constructor(name:String) {
        m_Name = name
    }

    fun getName():String {
        return m_Name
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDog = Dog("Bob")
        val myBird = Bird("Kesha")
        val myFish = Fish("AquaFish")

        println(myDog.getName())
        println(myDog.getType())
        println(myDog.getClass())
        println(myDog.getKingdom())

        myDog.VoiceQuiet()
        myDog.VoiceLoud()
        myDog.VoiceManyTimes(10)

        println("\n\n")

        //------------------------

        println(myBird.getName())
        println(myBird.getType())
        println(myBird.getClass())
        println(myBird.getKingdom())

        myBird.VoiceQuiet()
        myBird.VoiceLoud()
        myBird.VoiceManyTimes(10)

        println("\n\n")

        //------------------------

        println(myFish.getName())
        println(myFish.getType())
        println(myFish.getClass())
        println(myFish.getKingdom())
    }
}