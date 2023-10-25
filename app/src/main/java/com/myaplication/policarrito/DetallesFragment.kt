package com.myaplication.policarrito

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.myaplication.policarrito.Extensions.toast
import com.myaplication.policarrito.Models.ProductOrderModel
import com.myaplication.policarrito.Models.ProductosModel
import com.myaplication.policarrito.databinding.FragmentDetallesBinding




class DetallesFragment : Fragment(R.layout.fragment_detalles) {


    private lateinit var binding: FragmentDetallesBinding
    private lateinit var productDatabaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth


    //private val orderDatabaseReference = Firebase.firestore.collection("orders")

    private lateinit var currentUID :  String
    private lateinit var orderImageUrl:String
    private lateinit var orderName:String
    private var orderSize:String?  = null
    private var orderQuantity:Int  = 1
    private lateinit var orderPrice:String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetallesBinding.bind(view)

        productDatabaseReference = FirebaseDatabase.getInstance().getReference("products")

      /*  val productId = args.productId
        auth = FirebaseAuth.getInstance()

        currentUID = auth.currentUser!!.uid

        binding.detailActualToolbar.setNavigationOnClickListener {
            Navigation.findNavController(requireView()).popBackStack()
        }
        // region implements firebase product display
        val valueEvent = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val products = dataSnapshot.getValue(ProductosModel::class.java)

                        if (products!!.Nombre == productId) {
                            Glide
                                .with(requireContext())
                                .load(products.Imagen)
                                .into(binding.ivDetails)

                            orderImageUrl = products.Imagen!!
                            orderName = products.Nombre!!
                            orderPrice = products.Precio!!

                            binding.tvDetailsProductPrice.text = "₹${products.Precio}"
                            binding.tvDetailsProductName.text = products.Nombre
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
*/
        //productDatabaseReference.addValueEventListener(valueEvent)


        binding.btnDetailsAddToCart.setOnClickListener {

            val orderedProduct = ProductOrderModel(orderName,orderPrice,orderImageUrl)

            //addDataToOrdersDatabase(orderedProduct)

            //Navigation.findNavController(view).navigate(com.google.firebase.database.R.id.)
        }

    }


    /*
    private fun addDataToOrdersDatabase(orderedProduct: ProductOrderModel) {

        orderDatabaseReference.add(orderedProduct).addOnCompleteListener{task ->
            if(task.isSuccessful){
                requireActivity().toast("Order Successfully Delivered")
            }else{
                requireActivity().toast(task.exception!!.localizedMessage!!)
            }
        }

    }
    */


}