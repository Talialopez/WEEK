package com.example.appweek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SeleccionarEjercicio: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var objetoEjercicioAdapter: ObjetoEjercicioAdapter
    private lateinit var listaObjetosEjercicio: List<ObjetoEjercicio>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seleccionar_ejercicio)

        recyclerView = findViewById(R.id.recyclerViewEjercicios)
        recyclerView.layoutManager = LinearLayoutManager(this)

        listaObjetosEjercicio = listOf(
            ObjetoEjercicio("Ejercicio 1", R.drawable.curlbiceps),
            ObjetoEjercicio("Ejercicio 2", R.drawable.ejercicio2),
            ObjetoEjercicio("Ejercicio 3", R.drawable.ejercicio3),
            ObjetoEjercicio("Ejercicio 4", R.drawable.ejercicio4),
            ObjetoEjercicio("Ejercicio 5", R.drawable.ejercicio5),
            ObjetoEjercicio("Ejercicio 6", R.drawable.ejercicio6),
            ObjetoEjercicio("Ejercicio 7", R.drawable.ejercicio7),
            )

        objetoEjercicioAdapter = ObjetoEjercicioAdapter(listaObjetosEjercicio)
        recyclerView.adapter = objetoEjercicioAdapter
    }
}
