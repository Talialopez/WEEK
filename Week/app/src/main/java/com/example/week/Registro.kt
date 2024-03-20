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

    fun registrarUsuario() {
        val correo = findViewById<EditText>(R.id.editTextCorreo).text.toString()
        val contraseña = findViewById<EditText>(R.id.editTextContraseña).text.toString()
        val nombreUsuario = findViewById<EditText>(R.id.editTextUser).text.toString()

        val passwordRegex = Regex("^(?=.*\\d{6,})(?=.*[a-z])(?=.*[A-Z]).{8,}\$")
        if (!passwordRegex.matches(contraseña)) {
            Toast.makeText(
                this,
                "La contraseña debe tener al menos seis números, una letra mayúscula, una letra minúscula.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val db = dbHelper.readableDatabase
        val correoCursor = db.rawQuery("SELECT * FROM usuarios WHERE CORREO=?", arrayOf(correo))
        if (correoCursor.count > 0) {
            Toast.makeText(this, "El correo ya está registrado.", Toast.LENGTH_SHORT).show()
            correoCursor.close()
            db.close()
            return
        }
        correoCursor.close()

        val usuarioCursor = db.rawQuery("SELECT * FROM usuarios WHERE NOMBRE=?", arrayOf(nombreUsuario))
        if (usuarioCursor.count > 0) {
            Toast.makeText(this, "El nombre de usuario ya está en uso.", Toast.LENGTH_SHORT).show()
            usuarioCursor.close()
            db.close()
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

            val newRowId = dbWrite.insert("usuarios", null, values)

            dbWrite.close()

            val intent = Intent(this, ConfirmarRegistro::class.java)
            startActivity(intent)

        } catch (e: Exception) {
            Toast.makeText(this, "Error al registrar el usuario.", Toast.LENGTH_SHORT).show()
        }
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
