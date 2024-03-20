import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.week.ConfirmarEjercicio
import com.example.week.R

class CrearEjercicio : AppCompatActivity() {
    lateinit var btGuardar: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crear_ejercicio)

        btGuardar = findViewById(R.id.continuar)
        btGuardar.setOnClickListener {
            val intent = Intent(this, ConfirmarEjercicio::class.java)
            startActivity(intent)
        }
    }
}
