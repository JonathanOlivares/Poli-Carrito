package com.myaplication.policarrito


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val FrutasList : ArrayList<Frutas>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.productos_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = FrutasList[position]

        holder.Nombre.text = currentitem.Nombre
        holder.Precio.text = currentitem.Precio
        holder.Existencia.text = currentitem.Cantidad

    }

    override fun getItemCount(): Int {

        return FrutasList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val Nombre : TextView = itemView.findViewById(R.id.TeVi_Nombre)
        val Precio : TextView = itemView.findViewById(R.id.TeVi_Precio)
        val Existencia : TextView = itemView.findViewById(R.id.TeVi_Existencia)

    }

}