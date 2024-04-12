package com.example.appweek

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {

    private lateinit var dbHelper: BaseDatos

    fun registrarUsuario() {
        val correo = findViewById<EditText>(R.id.editar_correo).text.toString()
        val contraseña = findViewById<EditText>(R.id.editar_contraseña).text.toString()
        val nombreUsuario = findViewById<EditText>(R.id.editTextText).text.toString()

        // Expresión regular simplificada para validar contraseña
        val passwordRegex = Regex("^(?=.*[A-Z])(?=.*\\d).{8,}\$")

        if (!passwordRegex.matches(contraseña)) {
            Toast.makeText(
                this,
                "La contraseña debe tener al menos una letra mayúscula, un número y una longitud mínima de ocho caracteres.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val db = dbHelper.writableDatabase

        // Verificar si el correo ya está registrado
        if (existeUsuario(db, "CORREO", correo)) {
            Toast.makeText(this, "El correo ya está registrado.", Toast.LENGTH_SHORT).show()
            db.close()
            return
        }

        // Verificar si el nombre de usuario ya está en uso
        if (existeUsuario(db, "NOMBRE", nombreUsuario)) {
            Toast.makeText(this, "El nombre de usuario ya está en uso.", Toast.LENGTH_SHORT).show()
            db.close()
            return
        }

        try {
            val values = ContentValues().apply {
                put("CORREO", correo)
                put("NOMBRE", nombreUsuario)
                put("PASSWORD", contraseña)
            }

            // Insertar el nuevo usuario en la base de datos
            val newRowId = db.insert("usuarios", null, values)
            db.close()

            // Si el registro fue exitoso, mostrar confirmación y dirigir a IniciarSesion
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)

        } catch (e: Exception) {
            Toast.makeText(this, "Error al registrar el usuario.", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para verificar si un usuario ya existe en la base de datos
    private fun existeUsuario(db: SQLiteDatabase, columna: String, valor: String): Boolean {
        val cursor: Cursor = db.rawQuery("SELECT * FROM usuarios WHERE $columna=?", arrayOf(valor))
        val existe = cursor.count > 0
        cursor.close()
        return existe
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        dbHelper = BaseDatos(this)

        val btnRegistrar: Button = findViewById(R.id.continuar_registro)
        btnRegistrar.setOnClickListener {
            registrarUsuario()
        }
    }
}