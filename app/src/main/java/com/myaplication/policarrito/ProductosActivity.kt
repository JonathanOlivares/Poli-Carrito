package com.myaplication.policarrito


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth


class ProductosActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        // Cambia el color de la barra de estado
        window.statusBarColor = ContextCompat.getColor(this, R.color.Politecnico)


        auth = FirebaseAuth.getInstance()
    }


/*
    private fun getUserData() {
        myRecyclerview.visibility = View.GONE

        myDataBaseReference = FirebaseDatabase.getInstance().getReference("Productos/Frutas")

        myDataBaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                productosArrayList.clear()

                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val Frutas_02 = userSnapshot.getValue(Productos::class.java)
                        productosArrayList.add(Frutas_02!!)
                    }
                    myAdapter = MyAdapter(productosArrayList, this@ProductosActivity)
                    myRecyclerview.adapter = myAdapter

                    myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener
                    {
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@ProductosActivity, DetallesActivity::class.java)

                            intent.putExtra("frutaNombre", productosArrayList[position].Nombre)
                            intent.putExtra("frutaPrecio", productosArrayList[position].Precio)

                            startActivity(intent)
                            finish()
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
    */
}