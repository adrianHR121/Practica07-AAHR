package com.example.practica7

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Adaptador(private var lista:ArrayList<Pelicula>, private var contexto: Context):
    RecyclerView.Adapter<Adaptador.vercontenido>() {

    class vercontenido (var view: View, var contexto:Context):RecyclerView.ViewHolder(view) {
        var ctitulo = view.findViewById<TextView>(R.id.gtitulo)
        var cgenero = view.findViewById<TextView>(R.id.ggenero)
        var ccalif = view.findViewById<RatingBar>(R.id.gcalif)
        var cima = view.findViewById<ImageView>(R.id.gimagen)

        fun bind(pelicula: Pelicula) {
            ctitulo.text = pelicula.titulo
            cgenero.text = pelicula.genero
            ccalif.rating = pelicula.calificacion.toFloat()
            cima.setImageResource(pelicula.imagen)

            cima.setOnClickListener{
                contexto.startActivity(
                    Intent(contexto, VerImagen::class.java).putExtra("peli", pelicula)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vercontenido {
        return vercontenido(LayoutInflater.from(parent.context).inflate(R.layout.listapelis,
            parent, false), contexto)
    }

    override fun getItemCount(): Int {
        return  lista.size
    }

    override fun onBindViewHolder(holder: vercontenido, position: Int) {
        holder.bind(lista[position])
    }

}