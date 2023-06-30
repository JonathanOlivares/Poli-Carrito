package com.myaplication.policarrito


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val FrutasList : ArrayList<Productos>)
    : RecyclerView.Adapter<MyAdapter.ProductosViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.productos_item, parent,false)
        return ProductosViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {

        val currentItem = FrutasList[position]

        holder.Nombre.text = currentItem.Nombre
        holder.Precio.text = currentItem.Precio
        holder.Existencia.text = currentItem.Cantidad
    }

    override fun getItemCount(): Int {

        return FrutasList.size
    }

    class ProductosViewHolder(itemView : View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val Nombre : TextView = itemView.findViewById(R.id.TeVi_Nombre)
        val Precio : TextView = itemView.findViewById(R.id.TeVi_Precio)
        val Existencia : TextView = itemView.findViewById(R.id.TeVi_Existencia)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }
}