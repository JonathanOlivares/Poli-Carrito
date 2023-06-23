package com.myaplication.policarrito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductosActivity : AppCompatActivity() {


    //


    val query = FirebaseDatabase.getInstance().reference.child("publicaciones")

    /*
    private val query = FirebaseDatabase.getInstance("https://smart-cart-41df4-default-rtdb.firebaseio.com/")
        .reference.child("Frutas")

     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)




    }
}



