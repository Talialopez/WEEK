package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CurlsDeBiceps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.curls_de_biceps_mancuerna)

        val btflechaconsejos: ImageView = findViewById(R.id.botonconsejos)
        btflechaconsejos.setOnClickListener {
            val intent = Intent(this, ConsejosActivity::class.java)
            startActivity(intent)

            val btflecha: ImageView = findViewById(R.id.botonestadisticas)
            btflecha.setOnClickListener {
                val intent = Intent(this, Estadistica::class.java)
                startActivity(intent)

            }
        }
    }
}