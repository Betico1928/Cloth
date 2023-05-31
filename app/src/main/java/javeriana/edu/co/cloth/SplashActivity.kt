package javeriana.edu.co.cloth

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import javeriana.edu.co.cloth.databinding.ActivitySplashBinding
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Se inicia la barra de progreso en un nuevo hilo
        thread(start = true) {
            for (i in 0..100 step 2) {
                runOnUiThread {
                    binding.progressBar.progress = i
                }
                Thread.sleep(100) // Ajustar este valor si necesitas que se llene más rápido o más lento
            }
            // Se inicia GeneratedOutfitActivity una vez se completa el llenado de la barra de progreso
            runOnUiThread {
                startActivity(Intent(this, GeneratedOutfitActivity::class.java))
                finish()
            }
        }
    }
}

