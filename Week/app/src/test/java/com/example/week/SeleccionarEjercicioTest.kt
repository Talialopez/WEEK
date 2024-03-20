import com.example.week.SeleccionarEjercicio
import org.junit.Test
import org.junit.Assert.assertEquals

class SeleccionarEjercicioTest {

    @Test
    fun `obtenerDatos() devuelve la lista de datos correctamente`() {
        val seleccionarEjercicio = SeleccionarEjercicio()
        val datosEsperados = listOf(
            "Curl de Biceps", "Martillo con Mancuernas", "Extensiones de Triceps",
            "Pull-ups Agarre Supinado", "Triceps en Polea Alta", "Curl de Biceps Invertido", "Flexiones de Triceps",
            "Curl de Biceps con Mancuernas", "Press de Banca con Agarre Cerrado", "Elevaciones Laterales con Mancuernas",
            "Flexiones en pared", "Triceps en Barra Fija", "Triceps en Máquina de Fondos", "Curl de Biceps con Barra Z",
            "Curl de Biceps en Máquina de Scott"
        )
        val datosObtenidos = seleccionarEjercicio.obtenerDatos()
        assertEquals(datosEsperados, datosObtenidos)
    }
}
