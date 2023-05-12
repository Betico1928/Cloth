package javeriana.edu.co.cloth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javeriana.edu.co.cloth.databinding.ActivityClothingCareBinding

class ClothingCareActivity : AppCompatActivity()
{

    private lateinit var clothingCareBinding : ActivityClothingCareBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        clothingCareBinding = ActivityClothingCareBinding.inflate(layoutInflater)
        setContentView(clothingCareBinding.root)
    }
}