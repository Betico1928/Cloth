package javeriana.edu.co.cloth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javeriana.edu.co.cloth.databinding.ActivityClothingCareExtensionBinding

class ClothingCareExtensionActivity : AppCompatActivity()
{
    private lateinit var clothingCareExtensionBinding : ActivityClothingCareExtensionBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        clothingCareExtensionBinding = ActivityClothingCareExtensionBinding.inflate(layoutInflater)
        setContentView(clothingCareExtensionBinding.root)

        val clothType = intent.getStringExtra("clothType")

        clothingCareExtensionBinding.textViewTitle.text = clothType
    }
}