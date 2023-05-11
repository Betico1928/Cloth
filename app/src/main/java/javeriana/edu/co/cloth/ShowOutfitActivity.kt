package javeriana.edu.co.cloth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javeriana.edu.co.cloth.databinding.ActivityShowOutfitBinding

class ShowOutfitActivity : AppCompatActivity()
{

    private lateinit var showOutfitBinding: ActivityShowOutfitBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        showOutfitBinding = ActivityShowOutfitBinding.inflate(layoutInflater)
        setContentView(showOutfitBinding.root)

        val imagePath = intent.getStringExtra("imagePath")

        if (imagePath != null)
        {
            Log.i("Cloth - Show outfit path", imagePath)
        }

        when (imagePath)
        {
            "outfit_01.jpg" -> showOutfitBinding.imageShowOutfit.setImageResource(R.drawable.outfit_01)
            "outfit_02.jpg" -> showOutfitBinding.imageShowOutfit.setImageResource(R.drawable.outfit_02)
            "outfit_03.jpg" -> showOutfitBinding.imageShowOutfit.setImageResource(R.drawable.outfit_03)
            "outfit_04.jpg" -> showOutfitBinding.imageShowOutfit.setImageResource(R.drawable.outfit_04)
            "outfit_05.jpg" -> showOutfitBinding.imageShowOutfit.setImageResource(R.drawable.outfit_05)
        }
    }
}
