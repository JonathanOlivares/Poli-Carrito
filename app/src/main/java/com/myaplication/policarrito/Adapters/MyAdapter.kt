package com.myaplication.policarrito.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myaplication.policarrito.Models.ProductosModel
import com.myaplication.policarrito.SwipeToDelete
import com.myaplication.policarrito.databinding.CartproductItemBinding


class MyAdapter(
    private val context: android.content.Context,
    private val FrutasList : ArrayList<ProductosModel>,
    private val onLongClickRemove: OnLongClickRemove
    ): RecyclerView.Adapter<MyAdapter.ProductosViewHolder>() {


    interface OnLongClickRemove{
        fun onLongRemove(item: ProductosModel, position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        return ProductosViewHolder(CartproductItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {

        val currentItem = FrutasList[position]

        Glide
            .with(context)
            .load(currentItem.Imagen)
            .into(holder.binding.ivCartProduct)

        holder.binding.tvCartProductNombre.text = currentItem.Nombre
        holder.binding.tvCartProductPrecio.text = "$${currentItem.Precio}"
        holder.binding.tvCartProductExistencia.text = currentItem.Cantidad

        var count = holder.binding.tvCartItemCount.text.toString().toInt()

        holder.binding.btnCartItemAdd.setOnClickListener {
            //            count++
            // TODO: Update Quantity in Database also
            //            holder.binding.tvCartItemCount.text = count.toString()

        }

        holder.binding.btnCartItemMinus.setOnClickListener {
            //            count--
            // TODO: Update Quantity in Database also
            //            holder.binding.tvCartItemCount.text = count.toString()
        }

        holder.itemView.setOnLongClickListener {
            onLongClickRemove.onLongRemove(currentItem , position)
            true
        }
    }

    override fun getItemCount(): Int {

        return FrutasList.size
    }

    inner class ProductosViewHolder(val binding: CartproductItemBinding) : RecyclerView.ViewHolder(binding.root){

        private val onSwipeDelete = object : SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                FrutasList.removeAt(position)
            }
        }
    }
}