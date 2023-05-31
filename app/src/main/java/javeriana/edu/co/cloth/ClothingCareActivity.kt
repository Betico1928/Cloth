package javeriana.edu.co.cloth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javeriana.edu.co.cloth.databinding.ActivityClothingCareBinding

class ClothingCareActivity : AppCompatActivity()
{

    private lateinit var clothingCareBinding : ActivityClothingCareBinding

    private var clothType : String? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        clothingCareBinding = ActivityClothingCareBinding.inflate(layoutInflater)
        setContentView(clothingCareBinding.root)

        initializeElements()
    }

    private fun initializeElements()
    {
        // Wool
        clothingCareBinding.imageViewWool.setOnClickListener {
            clothType = "Wool"

            val pasarAClothingCareExtension = Intent(baseContext, ClothingCareExtensionActivity::class.java)
            pasarAClothingCareExtension.putExtra("clothType", clothType)
            startActivity(pasarAClothingCareExtension)
        }

        clothingCareBinding.textViewWool.setOnClickListener {
            clothType = "Wool"

            val pasarAClothingCareExtension = Intent(baseContext, ClothingCareExtensionActivity::class.java)
            pasarAClothingCareExtension.putExtra("clothType", clothType)
            startActivity(pasarAClothingCareExtension)
        }



        // Cotton
        clothingCareBinding.imageViewCotton.setOnClickListener {
            clothType = "Cotton"

            val pasarAClothingCareExtension = Intent(baseContext, ClothingCareExtensionActivity::class.java)
            pasarAClothingCareExtension.putExtra("clothType", clothType)
            startActivity(pasarAClothingCareExtension)
        }

        clothingCareBinding.textViewCotton.setOnClickListener {
            clothType = "Cotton"

            val pasarAClothingCareExtension =
                Intent(baseContext, ClothingCareExtensionActivity::class.java)
            pasarAClothingCareExtension.putExtra("clothType", clothType)
            startActivity(pasarAClothingCareExtension)
        }



        // Jeans
        clothingCareBinding.imageViewJeans.setOnClickListener {
            clothType = "Jeans"

            val pasarAClothingCareExtension =
                Intent(baseContext, ClothingCareExtensionActivity::class.java)
            pasarAClothingCareExtension.putExtra("clothType", clothType)
            startActivity(pasarAClothingCareExtension)
        }

        clothingCareBinding.textViewJeans.setOnClickListener {
            clothType = "Jeans"

            val pasarAClothingCareExtension =
                Intent(baseContext, ClothingCareExtensionActivity::class.java)
            pasarAClothingCareExtension.putExtra("clothType", clothType)
            startActivity(pasarAClothingCareExtension)
        }



        // Poliester
        clothingCareBinding.imageViewPoliester.setOnClickListener {
            clothType = "Poliester"

            val pasarAClothingCareExtension =
                Intent(baseContext, ClothingCareExtensionActivity::class.java)
            pasarAClothingCareExtension.putExtra("clothType", clothType)
            startActivity(pasarAClothingCareExtension)
        }

        clothingCareBinding.textViewPoliester.setOnClickListener {
            clothType = "Poliester"

            val pasarAClothingCareExtension =
                Intent(baseContext, ClothingCareExtensionActivity::class.java)
            pasarAClothingCareExtension.putExtra("clothType", clothType)
            startActivity(pasarAClothingCareExtension)
        }
    }
}