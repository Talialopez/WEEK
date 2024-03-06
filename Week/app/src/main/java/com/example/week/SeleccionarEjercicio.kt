package com.example.week

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SeleccionarEjercicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seleccionar_ejercicio)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val datos = listOf("Curl de Biceps", "Martillo con Mancuernas", "Extensiones de Triceps",
            "Pull-ups Agarre Supinado", "Triceps en Polea Alta", "Curl de Biceps Invertido", "Flexiones de Triceps",
            "Curl de Biceps con Mancuernas", "Press de Banca con Agarre Cerrado", "Elevaciones Laterales con Mancuernas",
            "Flexiones en pared", "Triceps en Barra Fija", "Triceps en Máquina de Fondos", "Curl de Biceps con Barra Z",
            "Curl de Biceps en Máquina de Scott") // Tu lista de datos
        val adapter = Adaptador(datos)
        recyclerView.adapter = adapter
    }
}
