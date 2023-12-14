package com.example.week

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

class SesionIniciada : AppCompatActivity() {

    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(SavedInstanceState: Bundle?) {
        super.onCreate(SavedInstanceState)
        setContentView(R.layout.sesion_iniciada)

        setSupportActionBar(toolbar)

        val drawerLayout = findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<com.google.android.material.navigation.NavigationView>(R.id.nav_view)

        // Configurar el botón de hamburguesa
        drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Manejar clics en el menú
        navView.setNavigationItemSelectedListener { menuItem ->
            // Lógica para manejar clics en el menú
            when (menuItem.itemId) {
                R.id.opcion1 -> {/* Acción para la opción 1 */}
                R.id.opcion2 -> {/* Acción para la opción 2 */}
                R.id.opcion3 -> {/* Acción para la opción 3 */}
            }
            true
        }
    }
    }
}