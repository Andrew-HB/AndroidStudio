package com.example.labwork_1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var nameEdit:EditText? = null
    private var phoneEdit:EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEdit = findViewById<EditText>(R.id.editTextTextPersonName)
        phoneEdit = findViewById<EditText>(R.id.editTextPhone)

    }

    fun onClickLogInButton(view: View) {
        var nameInput:String = nameEdit?.text.toString()
        var phoneInput:String = phoneEdit?.text.toString()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Сaught you!")
        builder.setMessage("Now, ${nameInput}, I will call you every hour on this number: ${phoneInput}!")
        builder.show()
    }
}