package com.example.week


import android.widget.Button
import android.widget.EditText
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegistroTest {

    @Test
    fun `registro exitoso`() {
        // Iniciar la actividad
        ActivityScenario.launch(Registro::class.java).use { scenario ->
            // Esperar a que la actividad esté lista
            scenario.onActivity { activity ->
                // Modificar el estado de los EditText con datos de prueba
                activity.findViewById<EditText>(R.id.editTextCorreo).setText("usuario@example.com")
                activity.findViewById<EditText>(R.id.editTextContraseña).setText("Password1")
                activity.findViewById<EditText>(R.id.editTextUser).setText("UsuarioTest")

                // Ejecutar el método de registro
                activity.registrarUsuario()

                // Verificar que no se muestre ningún mensaje de error
                assertThat(activity.supportFragmentManager.fragments.isEmpty(), equalTo(true))
            }
        }
    }

    @Test
    fun `registro con contraseña inválida`() {
        // Iniciar la actividad
        ActivityScenario.launch(Registro::class.java).use { scenario ->
            // Esperar a que la actividad esté lista
            scenario.onActivity { activity ->
                // Modificar el estado de los EditText con datos de prueba (contraseña inválida)
                activity.findViewById<EditText>(R.id.editTextCorreo).setText("usuario@example.com")
                activity.findViewById<EditText>(R.id.editTextContraseña).setText("123456")
                activity.findViewById<EditText>(R.id.editTextUser).setText("UsuarioTest")

                // Ejecutar el método de registro
                activity.registrarUsuario()

                // Verificar que se muestre un mensaje de error
                assertThat(activity.supportFragmentManager.fragments.isNotEmpty(), equalTo(true))
            }
        }
    }
}
