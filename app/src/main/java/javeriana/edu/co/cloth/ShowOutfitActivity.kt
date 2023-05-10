package javeriana.edu.co.cloth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        //showOutfitBinding.imageShowOutfit.setBackgroundResource()
    }
}
