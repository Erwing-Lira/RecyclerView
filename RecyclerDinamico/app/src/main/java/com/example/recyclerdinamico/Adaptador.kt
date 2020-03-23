package com.example.recyclerdinamico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class Adaptador(val lista: ArrayList<Int>) : RecyclerView.Adapter<Adaptador.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Recuperar el item de la lista y settearlo al imageview
        var item = lista.get(position)
        holder.enlazarItem(item)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun enlazarItem(item: Int) {
            itemView.imgFoto.setImageResource(item)
            itemView.imgFoto.setOnClickListener {
                Toast.makeText(itemView.context, "Click desde el adaptador",Toast.LENGTH_SHORT).show()
            }
            itemView.imgPerfil.setImageResource(R.drawable.ic_face)
            itemView.txtComentario.text = "Comentario desde el Adaptador"
        }
    }

}