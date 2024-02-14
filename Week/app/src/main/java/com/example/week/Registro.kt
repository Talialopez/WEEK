package com.example.week

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {

    private lateinit var dbHelper: BaseDatosWeek

    private fun registrarUsuario() {
        val correo = findViewById<EditText>(R.id.editTextCorreo).text.toString()
        val contraseña = findViewById<EditText>(R.id.editTextContraseña).text.toString()
        val nombreUsuario = findViewById<EditText>(R.id.editTextUser).text.toString()

        val passwordRegex = Regex("^(?=.*\\d{6,})(?=.*[a-z])(?=.*[A-Z]).{8,}\$")
        if (!passwordRegex.matches(contraseña)) {
            Toast.makeText(
                this,
                "La contraseña debe tener al menos 8 caracteres, una letra mayúscula, una letra minúscula y al menos seis números.",
                Toast.LENGTH_SHORT
            ).show()
            return
        } else {
            val intent = Intent(this, ConfirmarRegistro::class.java)
            startActivity(intent)
        }

        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put("CORREO", correo)
            put("NOMBRE", nombreUsuario)
            put("PASSWORD", contraseña)
        }

        val newRowId = db.insert("usuarios", null, values)

        db.close()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        dbHelper = BaseDatosWeek(this)

        val btnRegistrar: Button = findViewById(R.id.continuar)
        btnRegistrar.setOnClickListener {
            registrarUsuario()
        }
    }

}
