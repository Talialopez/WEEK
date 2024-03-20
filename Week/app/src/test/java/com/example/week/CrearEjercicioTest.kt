package com.example.week

import CrearEjercicio
import android.content.Intent
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class CrearEjercicioTest {

    private lateinit var crearEjercicio: CrearEjercicio

    @Before
    fun setUp() {
        crearEjercicio = CrearEjercicio()
    }

    @Test
    fun testBotonGuardar() {
        val intent = mock(Intent::class.java)
        val mockContext = mock(CrearEjercicio::class.java)

        `when`(mockContext.startActivity(intent)).then {}

        crearEjercicio.onCreate(null)
        crearEjercicio.btGuardar.performClick()

        verify(mockContext).startActivity(intent)
    }
}
