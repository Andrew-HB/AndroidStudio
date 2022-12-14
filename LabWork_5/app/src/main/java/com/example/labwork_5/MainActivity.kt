package com.example.labwork_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counterLine:TextView? = null
    private var counter = 0
    private var step = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterLine = findViewById<TextView>(R.id.counterView)

        val sw1 = findViewById<Switch>(R.id.switchStandard)
        sw1?.setOnCheckedChangeListener({ _ , isChecked ->
            if (isChecked) {
                step = 100
            } else {
                step = 1
            }
        })
    }

    fun onClickCounter(view: View) {
        counter += step
        counterLine?.setText(counter.toString())
    }

    fun onClickReset(view: View) {
        counter = 0
        counterLine?.setText(counter.toString())
    }


}