package com.example.paises

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paises.databinding.CardListaBinding
import com.example.paises.models.PaisModel

class ItemLinhaAdapter : RecyclerView.Adapter<ItemLinhaAdapter.ItemLinhaHolder>() {

    val lista: MutableList<PaisModel> = mutableListOf()

    class ItemLinhaHolder(val itemListaView: CardListaBinding) :
        RecyclerView.ViewHolder(itemListaView.root) {
        fun bind(item: PaisModel) {
            itemListaView.tvPais.text = item.pais
            itemListaView.tvContinente.text = item.continente

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLinhaHolder {
        return ItemLinhaHolder(
            CardListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemLinhaHolder, position: Int) {
        holder.bind(lista[position])
        holder.itemListaView.btClose.setOnClickListener {
            removeItem(lista[position])
        }
    }

    override fun getItemCount(): Int = lista.size

    fun setLista(listaItem: MutableList<PaisModel>) {
        lista.clear()
        lista.addAll(listaItem)
        notifyDataSetChanged()
    }

    fun removeItem(removed: PaisModel) {
        val removedIndex = lista.indexOf(removed)
        lista.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, lista.size)
    }
}