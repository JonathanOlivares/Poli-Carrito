package com.myaplication.policarrito

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarritoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarritoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    /* - - - - - Agregado - Informacion Correo - - - - - */
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


        // - Agregado - Initialize Firebase Auth
        auth = Firebase.auth


    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View?
    {
        /* - - - - - Agregado - Informacion Correo - - - - - */
        val view: View = inflater.inflate(R.layout.carrito, container, false)

        val BotonPagar = view.findViewById<TextView>(R.id.Btn_Logout02)

        BotonPagar.setOnClickListener{
            activity?.let{
                //val win_login = Intent (it, PagosActivity::class.java)

                val montoPago = view.findViewById<TextView>(R.id.TeVi_MontoPago).toString()

                val intent = Intent(requireContext(), PagosActivity::class.java)

                intent.putExtra("monto_pago", montoPago)
                startActivity(intent)

                //it.startActivity(win_login)
            }
        }





        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarritoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarritoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}