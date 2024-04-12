package com.example.week

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {

    private lateinit var dbHelper: BaseDatosWeek // Asegúrate de que BaseDatosWeek es el nombre correcto de tu clase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        dbHelper = BaseDatosWeek(this)

        val btnRegistrar: Button = findViewById(R.id.continuar) // Confirma que 'continuar' es el ID correcto de tu botón
        btnRegistrar.setOnClickListener {
            registrarUsuario()
        }
    }

    private fun registrarUsuario() {
        val correo = findViewById<EditText>(R.id.editTextCorreo).text.toString().trim()
        val contraseña = findViewById<EditText>(R.id.editTextContraseña).text.toString().trim()
        val nombreUsuario = findViewById<EditText>(R.id.editTextUser).text.toString().trim()

        // Expresión regular ajustada para la validación de la contraseña
        val passwordRegex = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")
        if (!passwordRegex.matches(contraseña)) {
            Toast.makeText(
                this,
                "La contraseña debe tener al menos 8 caracteres, incluyendo un número, una letra mayúscula y una letra minúscula.",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        val db = dbHelper.readableDatabase
        val correoCursor = db.rawQuery("SELECT * FROM usuarios WHERE CORREO=?", arrayOf(correo))
        if (correoCursor.count > 0) {
            Toast.makeText(this, "El correo ya está registrado.", Toast.LENGTH_SHORT).show()
            correoCursor.close()
            return
        }
        correoCursor.close()

        val usuarioCursor = db.rawQuery("SELECT * FROM usuarios WHERE NOMBRE=?", arrayOf(nombreUsuario))
        if (usuarioCursor.count > 0) {
            Toast.makeText(this, "El nombre de usuario ya está en uso.", Toast.LENGTH_SHORT).show()
            usuarioCursor.close()
            return
        }
        usuarioCursor.close()

        try {
            val dbWrite = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put("CORREO", correo)
                put("NOMBRE", nombreUsuario)
                put("PASSWORD", contraseña)
            }

            dbWrite.insert("usuarios", null, values)
            dbWrite.close()

            // Redirigir a ConfirmarRegistro u otra actividad según el flujo de tu app
            val intent = Intent(this, ConfirmarRegistro::class.java)
            startActivity(intent)
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al registrar el usuario.", Toast.LENGTH_SHORT).show()
        }
    }
}
