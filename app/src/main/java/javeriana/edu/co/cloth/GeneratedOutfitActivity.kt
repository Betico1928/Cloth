package javeriana.edu.co.cloth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javeriana.edu.co.cloth.databinding.ActivityGeneratedOutfitBinding

class GeneratedOutfitActivity : AppCompatActivity()
{
    private lateinit var bindingGeneratedOutfit: ActivityGeneratedOutfitBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingGeneratedOutfit = ActivityGeneratedOutfitBinding.inflate(layoutInflater)
        setContentView(bindingGeneratedOutfit.root)

        bindingGeneratedOutfit.buttonGenerateAnotherOutfit.setOnClickListener {
            Log.i("Generated Outfit Activity", "Another Outfit button")

            val goToTodoActivity = Intent(baseContext, TODOActivity::class.java)
            startActivity(goToTodoActivity)
        }
    }
}