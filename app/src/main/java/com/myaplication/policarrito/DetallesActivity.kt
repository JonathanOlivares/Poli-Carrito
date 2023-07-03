package com.myaplication.policarrito

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class DetallesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        window.statusBarColor = ContextCompat.getColor(this, R.color.Politecnico)

        var nombreTextBox : TextView = findViewById(R.id.tvDetailsProductName)
        var precioTextBox : TextView = findViewById(R.id.tvDetailsProductPrice)
        val nombre = CamaraActivity.GlobalVariables.globalString

        // imprime en el logcat lo que tiene: nombre
        Log.d("AQUI", CamaraActivity.GlobalVariables.globalString)

        nombreTextBox.text = intent.getStringExtra("frutaNombre")
        precioTextBox.text = intent.getStringExtra("frutaPrecio")

        val returnBoton: TextView = findViewById( R.id.detailActualToolbar )

        returnBoton.setOnClickListener {
            val win_menu = Intent(this, ProductosActivity::class.java)
            startActivity(win_menu)
            finish()
        }

    }
}