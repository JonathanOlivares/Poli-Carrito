package com.myaplication.policarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductosActivity : AppCompatActivity() {


    private lateinit var myDataBaseReference : DatabaseReference
    private lateinit var myRecyclerview : RecyclerView
    private lateinit var productosArrayList : ArrayList<Productos>
    private lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        // Cambia el color de la barra de estado
        window.statusBarColor = ContextCompat.getColor(this, R.color.Politecnico)


        myRecyclerview = findViewById(R.id.ReVi_DatosList)
        myRecyclerview.setHasFixedSize(true)
        myRecyclerview.layoutManager = LinearLayoutManager(this)

        productosArrayList = arrayListOf<Productos>()

        // Coloca los datos de la base de datos en el RecyclerView
        getUserData()
    }

    private fun getUserData() {
        myRecyclerview.visibility = View.GONE

        myDataBaseReference = FirebaseDatabase.getInstance().getReference("Productos/Frutas")

        myDataBaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val Frutas_02 = userSnapshot.getValue(Productos::class.java)
                        productosArrayList.add(Frutas_02!!)
                    }
                    myAdapter = MyAdapter(productosArrayList)
                    myRecyclerview.adapter = myAdapter

                    myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener
                    {
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@ProductosActivity, DetallesActivity::class.java)

                            intent.putExtra("frutaNombre", productosArrayList[position].Nombre)
                            intent.putExtra("frutaPrecio", productosArrayList[position].Precio)

                            startActivity(intent)
                        }

                    })
                    myRecyclerview.visibility = View.VISIBLE
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}


