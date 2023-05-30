package javeriana.edu.co.cloth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javeriana.edu.co.cloth.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity()
{

    private lateinit var mainMenuBinding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        mainMenuBinding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(mainMenuBinding.root)

        initializeElements()
    }

    private fun initializeElements()
    {
        mainMenuBinding.imageOutfit01.setOnClickListener {
            val outfitPath = "outfit_01.jpg"
            openImage(outfitPath)
        }

        mainMenuBinding.imageOutfit02.setOnClickListener {
            val outfitPath = "outfit_02.jpg"
            openImage(outfitPath)
        }

        mainMenuBinding.imageOutfit03.setOnClickListener {
            val outfitPath = "outfit_03.jpg"
            openImage(outfitPath)
        }

        mainMenuBinding.imageOutfit04.setOnClickListener {
            val outfitPath = "outfit_04.jpg"
            openImage(outfitPath)
        }

        mainMenuBinding.imageOutfit05.setOnClickListener {
            val outfitPath = "outfit_05.jpg"
            openImage(outfitPath)
        }

        mainMenuBinding.buttonVirtualCloset.setOnClickListener {
            val goToVirtualClosetActivity = Intent(baseContext, VirtualClosetActivity::class.java)
            startActivity(goToVirtualClosetActivity)
        }

        mainMenuBinding.buttonClothingCare.setOnClickListener {
            val goToClothingCareActivity = Intent(baseContext, ClothingCareActivity::class.java)
            startActivity(goToClothingCareActivity)
        }
    }

    private fun openImage(outfitPath : String)
    {
        val goToShowOutfitActivity = Intent(baseContext, ShowOutfitActivity::class.java)
        goToShowOutfitActivity.putExtra("imagePath", outfitPath)
        startActivity(goToShowOutfitActivity)
    }
}