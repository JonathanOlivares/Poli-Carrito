package com.myaplication.policarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    // - Agregado - Declara una instancia de FirebaseAuth.
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        // - Agregado - Initialize Firebase Auth
        auth = Firebase.auth


        /* - - - - - Agregado - Cambio a Signup - - - - - */
        val BotonRegistro: TextView = findViewById( R.id.Btn_Signup )

        BotonRegistro.setOnClickListener {
            val win_singup = Intent( this, SingupActivity::class.java )
            startActivity( win_singup )
        }


        // - Agregado - Login
        val BotonLogin: TextView = findViewById( R.id.Btn_Login )
        BotonLogin.setOnClickListener {
            EjecutaLogin()
        }

    }


    /* - - - - - Agregado - Registro - - - - - */
    private fun EjecutaLogin(){
        val Email = findViewById<EditText>( R.id.TeInEdTe_EmailLogin )
        val Pass = findViewById<EditText>( R.id.TeInEdTe_Password )

        val inputEmail = Email.text.toString()
        val inputPass = Pass.text.toString()

        if ( inputEmail.isEmpty() || inputPass.isEmpty() ) {
            // If sign in fails, display a message to the user.
            Toast.makeText(
                this,
                "Faltan Campos por Llenar",
                Toast.LENGTH_SHORT,
            ).show()
        }else {
            auth.signInWithEmailAndPassword(inputEmail, inputPass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, navigate to the MainActivity
                        val win_menu = Intent(this, MenuActivity::class.java)
                        startActivity(win_menu)

                        Toast.makeText(
                            baseContext,
                            "Bienvenido",
                            Toast.LENGTH_SHORT,
                        ).show()

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this,
                        "Error occurred ${it.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

        }
    }
}