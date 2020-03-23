package com.example.recyclerdinamico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*FORMA DINAMICA
    fun generarItem(view: View) {

        for (i in 0..50){
            val img = ImageView(this)

            //indice es par == modulo
            if(i.rem(2) == 0){
                img.setImageResource(R.drawable.ic_happy)
            }else{
                img.setImageResource(R.drawable.ic_sad)
            }

            //SETEAR ANCHO Y ALTO
            var parametros = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            img.id = View.generateViewId()
            img.tag = "Imagen con id ${img.id}"
            img.setOnClickListener {
                Toast.makeText(applicationContext,img.tag.toString(), Toast.LENGTH_LONG).show()
            }

            img.layoutParams = parametros

            //Agregar al contenedor
            contenedor.addView(img)
        }
    }*/

    fun generarRecyler(view: View) {
        var lista = ArrayList<Int>()

        for (i in 0 .. 25){
            lista.add(R.drawable.ic_happy)
            lista.add(R.drawable.ic_sad)
        }

        var miManager = LinearLayoutManager(this)
        //var miManager = GridLayoutManager(this, 2)
        //var miManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var miAdaptador = Adaptador(lista)

        miRecycler.layoutManager = miManager
        miRecycler.adapter = miAdaptador
    }

    fun generarRecylerPublicacion(view: View) {
        var lista = ArrayList<Publicacion>()

        for (i in 1 .. 5){
            var idFoto =
                if(i.rem(2) == 0){
                    R.drawable.ic_happy
                }else{
                    R.drawable.ic_sad
                }
            val p = Publicacion(idFoto, R.drawable.ic_face, "Este es un comentario")

            lista.add(p)
        }

        var miManager = LinearLayoutManager(this)
        var miAdaptador = AdaptadorPublicacion(lista)

        miAdaptador.setOnClickListener(View.OnClickListener {
            view -> Toast.makeText(applicationContext, "Selección ${lista[miRecycler.getChildAdapterPosition(view)]}",Toast.LENGTH_SHORT).show()
        })

        miRecycler.layoutManager = miManager
        miRecycler.adapter = miAdaptador
    }
}
