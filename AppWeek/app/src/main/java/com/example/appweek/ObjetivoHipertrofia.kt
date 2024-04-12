package com.example.appweek

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ObjetivoHipertrofia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.objetivo_hipertrofia)

        val bPopUp: Button = findViewById(R.id.entrenamiento_con_pesas)
        bPopUp.setOnClickListener {
            mostrarPopup()
        }
    }

    private fun mostrarPopup() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.popup_entrenamiento_con_pesas, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        dialog.show()
    }
}