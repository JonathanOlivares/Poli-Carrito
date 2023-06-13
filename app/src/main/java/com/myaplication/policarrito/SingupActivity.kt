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

class SingupActivity : AppCompatActivity() {

    // - Agregado - Declara una instancia de FirebaseAuth.
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)


        // - Agregado - Initialize Firebase Auth
        auth = Firebase.auth


        /* - - - - - Agregado - Cambio a Login - - - - - */
        val BotonInicio: TextView = findViewById( R.id.Btn_Login )

        BotonInicio.setOnClickListener {
            val win_login = Intent( this, LoginActivity::class.java )
            startActivity( win_login )
        }


        // - Agregado - Registro
        val BotonLogin: TextView = findViewById( R.id.Btn_Signup )
        BotonLogin.setOnClickListener {
            EjecutaLogin()
        }

    }


    /* - - - - - Agregado - Registro - - - - - */
    private fun EjecutaLogin(){
        val Email = findViewById<EditText>( R.id.TeInEdTe_EmailSingup )
        val Pass01 = findViewById<EditText>( R.id.TeInEdTe_Password01 )
        val Pass02 = findViewById<EditText>( R.id.TeInEdTe_Password02 )

        val inputEmail = Email.text.toString()
        val inputPass01 = Pass01.text.toString()
        val inputPass02 = Pass02.text.toString()

        if ( inputEmail.isEmpty() || inputPass01.isEmpty() || inputPass02.isEmpty() ) {
            // If sign in fails, display a message to the user.
            Toast.makeText(
                this,
                "Faltan Campos por Llenar",
                Toast.LENGTH_SHORT,
            ).show()
        }else {
            if (inputPass01 == inputPass02) {
                auth.createUserWithEmailAndPassword(inputEmail, inputPass01)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, let move to the next activity
                            val win_menu = Intent(this, LoginActivity::class.java)
                            startActivity(win_menu)

                            Toast.makeText(
                                baseContext,
                                "Registro Exitoso",
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

            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(
                    baseContext,
                    "La Contraseña no Coincide",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }
}