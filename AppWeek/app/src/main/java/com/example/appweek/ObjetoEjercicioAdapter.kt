package com.example.appweek

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ObjetoEjercicioAdapter(private val listaObjetosEjercicio: List<ObjetoEjercicio>) : RecyclerView.Adapter<ObjetoEjercicioAdapter.ObjetoEjercicioViewHolder>() {

    class ObjetoEjercicioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imagenEjercicio)
        val textView: TextView = view.findViewById(R.id.tituloEjercicio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjetoEjercicioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.objeto_ejercicio, parent, false)
        return ObjetoEjercicioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjetoEjercicioViewHolder, position: Int) {
        val contexto = holder.itemView.context
        val objetoEjercicio = listaObjetosEjercicio[position]
        holder.textView.text = objetoEjercicio.titulo

        Glide.with(holder.imageView.context)
            .asGif()
            .load(objetoEjercicio.imagenUrl)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            when (position) {
                0 -> {
                    val intent = Intent(contexto, CurlsBiceps::class.java)
                    contexto.startActivity(intent)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return listaObjetosEjercicio.size
    }
}
