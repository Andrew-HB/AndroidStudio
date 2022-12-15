package com.project6

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.service.autofill.UserData
import android.util.Log
import android.widget.TextView
import com.project6.databinding.ActivitySecondBinding
import com.project6.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.button3.setOnClickListener{

            val intentUserData = intent.getParcelableArrayExtra("userData")

            val intentQuantity = intent.getIntExtra("quantity", -1)

            intentUserData?.let {
                println(it)
                if (intentQuantity != -1){

                binding.textView3.text = "${it.toString()} ${intentQuantity.toString()}"

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Project6", "OnDestroy Call")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("Project6", "onSaveInstanceState Call")
        val a = outState.apply {
            putString("userData", binding.textView3.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("Project6", "onRestoreInstancestate Call")
        savedInstanceState.run{
            binding.textView3.text = getString("userData")
        }
    }
}