package com.myaplication.policarrito


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myaplication.policarrito.Adapters.ProductDisplayAdapter
import com.myaplication.policarrito.Adapters.ProductOnClickInterface
import com.myaplication.policarrito.Models.ProductosModel
import com.myaplication.policarrito.databinding.FragmentProductosBinding


class ProductosFragment : Fragment(R.layout.fragment_productos),
    ProductOnClickInterface {


    private lateinit var binding: FragmentProductosBinding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var productList: ArrayList<ProductosModel>
    private lateinit var productAdapter: ProductDisplayAdapter
    private lateinit var auth: FirebaseAuth


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductosBinding.bind(view)
        productList = ArrayList()
        databaseReference = FirebaseDatabase.getInstance().getReference("Productos/Frutas")
        auth = FirebaseAuth.getInstance()


        // region implements products Recycler view

        val productLayoutManager = GridLayoutManager(context, 1)
        productAdapter = ProductDisplayAdapter(requireContext(), productList, this)


        binding.ReViDatosList.layoutManager = productLayoutManager
        binding.ReViDatosList.adapter = productAdapter

        setProductsData()

        // endregion implements products Recycler view

    }


    private fun setProductsData() {

        val valueEvent = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                productList.clear()

                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val products = dataSnapshot.getValue(ProductosModel::class.java)
                        productList.add(products!!)
                    }

                    productAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
            }
        }
        databaseReference.addValueEventListener(valueEvent)
    }


    override fun onClickProduct(item: ProductosModel) {

        val direction = ProductosFragmentDirections
            .actionMainFragmentToDetailsFragment(item.Nombre!!)

        Navigation.findNavController(requireView())
            .navigate(direction)
    }
}





