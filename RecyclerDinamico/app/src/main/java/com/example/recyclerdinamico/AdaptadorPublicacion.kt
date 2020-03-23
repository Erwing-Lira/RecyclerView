package com.example.recyclerdinamico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class AdaptadorPublicacion(val lista: ArrayList<Publicacion>)
    : RecyclerView.Adapter<AdaptadorPublicacion.MyViewHolder>(),
    View.OnClickListener
    {
        //Escuchador
        lateinit var listener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)

        //Poner a escuchar
        vista.setOnClickListener(this)

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
        fun enlazarItem(publicacion: Publicacion) {
            itemView.imgFoto.setImageResource(publicacion.idFoto)
            itemView.imgPerfil.setImageResource(publicacion.idPerfil)
            itemView.txtComentario.text = publicacion.comentario
            /*itemView.verDetalle.setOnClickListener {
                Toast.makeText(itemView.context, "Ver detalle",Toast.LENGTH_SHORT).show()
            }*/
        }
    }

        fun setOnClickListener(listener: View.OnClickListener){
            this.listener = listener
        }

        override fun onClick(v: View?) {
            if(listener != null){
                listener.onClick(v)
            }
        }

    }