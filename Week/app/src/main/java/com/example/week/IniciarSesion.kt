package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IniciarSesion : AppCompatActivity() {

    lateinit var dbHelper: BaseDatosWeek

    fun iniciarSesion() {
        val input = findViewById<EditText>(R.id.editTextCorreo).text.toString()
        val contraseña = findViewById<EditText>(R.id.editTextContraseña).text.toString()

        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuarios WHERE (CORREO=? OR NOMBRE=?) AND PASSWORD=?", arrayOf(input, input, contraseña))

        if (cursor.count > 0) {
            Toast.makeText(this, "Inicio correcto", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SesionIniciada::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "El correo o el usuario y la contraseña no coinciden", Toast.LENGTH_SHORT).show()
        }

        cursor.close()
        db.close()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciar_sesion)

        dbHelper = BaseDatosWeek(this)

        val btnIniciarSesion: Button = findViewById(R.id.buttoniniciarsesion)
        btnIniciarSesion.setOnClickListener {
            iniciarSesion()
        }
    }
}
