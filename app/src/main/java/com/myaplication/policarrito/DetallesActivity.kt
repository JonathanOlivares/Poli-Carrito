package com.myaplication.policarrito

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetallesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        var nombreTextBox : TextView = findViewById(R.id.tvDetailsProductName)
        var precioTextBox : TextView = findViewById(R.id.tvDetailsProductPrice)

        nombreTextBox.text = intent.getStringExtra("frutaNombre")
        precioTextBox.text = intent.getStringExtra("frutaPrecio")

    }
}