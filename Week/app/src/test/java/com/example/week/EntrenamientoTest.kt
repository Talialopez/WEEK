import android.content.Context
import android.content.Intent
import com.example.week.Perfil
import com.example.week.SesionIniciada
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.*

class EntrenamientoTest {

    private lateinit var entrenamiento: Entrenamiento

    @Mock
    private lateinit var mockContext: Context

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        entrenamiento = Entrenamiento()
    }

    @Test
    fun testBotonInicio() {
        val intent = mock(Intent::class.java)
        `when`(mockContext.startActivity(intent)).then {}

        entrenamiento.iniciarActividad(SesionIniciada::class.java)

        verify(mockContext).startActivity(intent)
    }

    @Test
    fun testBotonEntrenamiento() {
        val intent = mock(Intent::class.java)
        `when`(mockContext.startActivity(intent)).then {}

        entrenamiento.iniciarActividad(Entrenamiento::class.java)

        verify(mockContext).startActivity(intent)
    }

    @Test
    fun testBotonPerfil() {
        val intent = mock(Intent::class.java)
        `when`(mockContext.startActivity(intent)).then {}

        entrenamiento.iniciarActividad(Perfil::class.java)

        verify(mockContext).startActivity(intent)
    }
}
