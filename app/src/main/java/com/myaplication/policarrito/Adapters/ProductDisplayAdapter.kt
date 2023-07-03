package com.myaplication.policarrito.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myaplication.policarrito.Models.ProductosModel
import com.myaplication.policarrito.ProductosFragment
import com.myaplication.policarrito.databinding.ProductosItemBinding

class ProductDisplayAdapter(
    private val context:Context,
    private val FrutasList: ArrayList<ProductosModel>,
    private val productClickInterface: ProductosFragment

    ) : RecyclerView.Adapter<ProductDisplayAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: ProductosItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ProductosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = FrutasList[position]

        Glide
            .with(context)
            .load(currentItem.Imagen)
            .into(holder.binding.productoImagen)

        holder.binding.TeViNombre.text = currentItem.Nombre
        holder.binding.TeViPrecio.text = "$${currentItem.Precio}"
        holder.binding.TeViExistencia.text = currentItem.Cantidad


        holder.itemView.setOnClickListener {
            productClickInterface.onClickProduct(FrutasList[position])
        }
    }

    override fun getItemCount(): Int {
        return FrutasList.size
    }
}

interface ProductOnClickInterface {
    fun onClickProduct(item: ProductosModel)
}