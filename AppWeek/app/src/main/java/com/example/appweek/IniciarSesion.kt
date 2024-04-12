package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import android.content.Context
import android.content.SharedPreferences


class IniciarSesion : AppCompatActivity() {

    private lateinit var dbHelper: BaseDatos // Asegurándonos de usar el nombre correcto de la clase BaseDatos
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciar_sesion) // Confirma que este es el nombre correcto de tu archivo de layout XML

        dbHelper = BaseDatos(this) // Inicialización correcta de dbHelper con el nombre correcto de la clase

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Ajustamos los IDs según tu layout
        val btnIniciarSesion: Button = findViewById(R.id.continuar_inicio_sesion)
        btnIniciarSesion.setOnClickListener {
            iniciarSesion()
        }
    }

    private fun iniciarSesion() {
        // Ajustando el ID del EditText para el nombre de usuario
        val input = findViewById<EditText>(R.id.asignar_nombre_inicio_sesion).text.toString().trim()
        // Ajustando el ID del EditText para la contraseña, según tu layout
        val contraseña = findViewById<EditText>(R.id.editTextTextPassword).text.toString().trim()

        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuarios WHERE (CORREO=? OR NOMBRE=?) AND PASSWORD=?", arrayOf(input, input, contraseña))

        if (cursor.moveToFirst()) {
            // El usuario ha iniciado sesión correctamente
            Toast.makeText(this, "Inicio correcto", Toast.LENGTH_SHORT).show()
            val isFirstLogin = sharedPreferences.getBoolean("isFirstLogin", true)

            if (isFirstLogin) {
                // Si es la primera vez que el usuario inicia sesión, lo dirigimos a DatosPersonales
                val editor = sharedPreferences.edit()
                editor.putBoolean("isFirstLogin", false)
                editor.apply()

                val intent = Intent(this, DatosPersonales::class.java)
                startActivity(intent)
            } else {
                // Si no es la primera vez, lo dirigimos a SesionIniciada
                val intent = Intent(this, SesionIniciada::class.java)
                startActivity(intent)
            }
        } else {
            // El usuario no ha iniciado sesión correctamente
            Toast.makeText(this, "El correo o el usuario y la contraseña no coinciden", Toast.LENGTH_SHORT).show()
        }

        cursor.close()
    }
}
