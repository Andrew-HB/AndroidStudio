package com.project6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import com.project6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener{

            val data = binding.editTextTextPersonName.text.toString().split(" ")
            val userData = UserData(data[0], data[1].toInt(), data[2].toBooleanStrict())
            startActivity(Intent(this, ThirdActivity::class.java).apply {
                putExtra("userData", userData)
                putExtra("quantity", 1)
            })
        }
    }
}