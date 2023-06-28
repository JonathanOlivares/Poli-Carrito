package com.myaplication.policarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    // - Agregado - Declara una instancia de FirebaseAuth.
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        window.statusBarColor = ContextCompat.getColor(this, R.color.Politecnico)


        // - Agregado - Initialize Firebase Auth
        auth = Firebase.auth

        Check_LoginUser()

        /* - - - - - Agregado - Cambio a Signup - - - - - */
        val BotonRegistro: TextView = findViewById( R.id.Btn_Signup )

        BotonRegistro.setOnClickListener {
            CanbioActivity_Singup()
        }

        // - Agregado - Login
        val BotonLogin: TextView = findViewById( R.id.Btn_Login )
        BotonLogin.setOnClickListener {
            EjecutaLogin()
        }

    }

    /* - - - - - Agregado - Login Automatico - - - - - */
    private fun Check_LoginUser() {
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = FirebaseAuth.getInstance().currentUser

        if (currentUser != null) {
            // User is signed in
            CanbioActivity_Menu()

        } else {
            // No user is signed in
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
                        CanbioActivity_Menu()

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

    /* - - - - - Agregado - Funciones Basicas - - - - - */
    private fun CanbioActivity_Singup() {
        val win_singup = Intent( this, SingupActivity::class.java )
        startActivity( win_singup )
    }

    private fun CanbioActivity_Menu() {
        val win_menu = Intent(this, MenuActivity::class.java)
        startActivity(win_menu)
    }
}