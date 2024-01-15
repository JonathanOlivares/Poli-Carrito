package com.myaplication.policarrito

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val list = mutableListOf<CarouselItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_categorias, container, false)

        val BotonFrutas = view.findViewById<TextView>(R.id.Btn_Fru)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)

        BotonFrutas?.setOnClickListener{
            activity?.let{
                val frutas = Intent (it, ProductosActivity::class.java)
                it.startActivity(frutas)
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
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carousel: ImageCarousel = view.findViewById(R.id.carousel)

        carousel.registerLifecycle(lifecycle)

        list.add(CarouselItem("https://images.unsplash.com/photo-1558123567-01c8e1aca56f?auto=format&fit=crop&q=60&w=800&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjN8fGNhbXBpbmd8ZW58MHwwfDB8fHww"))
        list.add(CarouselItem("https://images.unsplash.com/photo-1464207687429-7505649dae38?auto=format&fit=crop&q=60&w=800&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NzB8fGNhbXBpbmd8ZW58MHwwfDB8fHww"))
        list.add(CarouselItem("https://images.unsplash.com/photo-1609788063095-d71bf3c1f01f?auto=format&fit=crop&q=60&w=800&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTR8fGNhbXBpbmd8ZW58MHwwfDB8fHww"))
        list.add(CarouselItem("https://images.unsplash.com/photo-1625834509314-3b12c6153624?auto=format&fit=crop&q=60&w=800&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjh8fGNhbXBpbmd8ZW58MHwwfDB8fHww"))
        list.add(CarouselItem("https://images.unsplash.com/photo-1578645510447-e20b4311e3ce?auto=format&fit=crop&q=60&w=800&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzV8fGNhbXBpbmd8ZW58MHwwfDB8fHww"))
        carousel.setData(list)
    }

    /*override fun onResume() {
        super.onResume()


    }*/

}