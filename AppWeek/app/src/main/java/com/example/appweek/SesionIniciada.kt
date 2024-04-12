package com.example.appweek

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SesionIniciada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sesion_iniciada)

        val btAyuda: Button = findViewById(R.id.ayuda)
        btAyuda.setOnClickListener{
            val intent = Intent(this, Ayuda::class.java)
            startActivity(intent)
        }

        val btCalendario: Button = findViewById(R.id.calendario)
        btCalendario.setOnClickListener{
            val intent = Intent(this, Calendario::class.java)
            startActivity(intent)
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)

        calendarView.setDate(System.currentTimeMillis(), false, true)

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.politica_privacidad -> {
                val intent = Intent(this, PoliticaPrivacidad::class.java)
                startActivity(intent)
                return true
            }
            R.id.contacto -> {
                val intent = Intent(this, Contacto::class.java)
                startActivity(intent)
                return true
            }
            R.id.Reporte -> {
                val intent = Intent(this, Reporte::class.java)
                startActivity(intent)
                return true
            }
            R.id.CerrarSesion -> {
                cerrarSesion()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun cerrarSesion() {
        // Aquí puedes realizar las acciones necesarias para cerrar la sesión actual,
        // como limpiar SharedPreferences, borrar datos de sesión, etc.

        // Por ejemplo, podrías limpiar el indicador de inicio de sesión en SharedPreferences:
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isFirstLogin", true) // Marcar como primera vez al iniciar sesión nuevamente
        editor.apply()

        // Luego, redirige al usuario a la pantalla de inicio de sesión
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Opcional: termina la actividad actual para evitar que el usuario regrese presionando el botón de retroceso
    }

    /*
        override fun onBackPressed() {
        // Si estás en SesionIniciada, no hagas nada al presionar el botón de retroceso
        if (this::class.java != SesionIniciada::class.java) {
            super.onBackPressed()
        }
    }
     */

    fun irAShareList(view: android.view.View) {
        // Aquí pones el código para manejar el click en el ImageView que tiene el método irAShareList
        // Por ejemplo, iniciar una nueva actividad:
        val intent = Intent(this, SesionIniciada::class.java)
        startActivity(intent)
    }

    fun irASaved(view: android.view.View) {
        // Aquí pones el código para manejar el click en el ImageView que tiene el método irAShareList
        // Por ejemplo, iniciar una nueva actividad:
        val intent = Intent(this, Entrenamiento::class.java)
        startActivity(intent)
    }

    /**fun irAFilter(view: android.view.View) {
    // Aquí pones el código para manejar el click en el ImageView que tiene el método irAShareList
    // Por ejemplo, iniciar una nueva actividad:
    val intent = Intent(this, Perfil::class.java)
    startActivity(intent)
    }*/
}