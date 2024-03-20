import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.week.Perfil
import com.example.week.R
import com.example.week.SesionIniciada

class Entrenamiento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entrenamiento)

        val btInicio: ImageButton = findViewById(R.id.botonAbajo1)
        btInicio.setOnClickListener {
            iniciarActividad(SesionIniciada::class.java)
        }

        val btEntrenamiento: ImageButton = findViewById(R.id.botonAbajo2)
        btEntrenamiento.setOnClickListener {
            iniciarActividad(Entrenamiento::class.java)
        }

        val btPerfil: ImageButton = findViewById(R.id.botonAbajo3)
        btPerfil.setOnClickListener {
            iniciarActividad(Perfil::class.java)
        }
    }

    fun iniciarActividad(clase: Class<*>) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}
