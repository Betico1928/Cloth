package javeriana.edu.co.cloth

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import javeriana.edu.co.cloth.databinding.ActivityVirtualClosetBinding
import javeriana.edu.co.cloth.ml.LiteModelSsdMobilenetV11Metadata2
import org.tensorflow.lite.support.image.TensorImage

class VirtualClosetActivity : AppCompatActivity()
{
    private lateinit var virtualClosetBinding: ActivityVirtualClosetBinding

    private val galleryRequest = registerForActivityResult(ActivityResultContracts.GetContent(), ActivityResultCallback { imagePath: Uri? -> loadImage(imagePath) })

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        virtualClosetBinding = ActivityVirtualClosetBinding.inflate(layoutInflater)
        setContentView(virtualClosetBinding.root)

        initializeElements()
    }

    private fun initializeElements()
    {
        virtualClosetBinding.buttonAddClothesFromGallery.setOnClickListener {
            galleryRequest.launch("image/*")
        }

        virtualClosetBinding.deleteClothButton.setOnClickListener {
            val goToTODOActivity = Intent(baseContext, TODOActivity::class.java)
            startActivity(goToTODOActivity)
        }

        virtualClosetBinding.saveClothButton.setOnClickListener {
            val goToTODOActivity = Intent(baseContext, TODOActivity::class.java)
            startActivity(goToTODOActivity)
        }
    }

    private fun loadImage(imagePath: Uri?) {
        val imageStream = contentResolver.openInputStream(imagePath!!)
        val image = BitmapFactory.decodeStream(imageStream)

        predictImage(image)
    }

    private fun predictImage(bitmap: Bitmap) {
        val model = LiteModelSsdMobilenetV11Metadata2.newInstance(this)

        val image = TensorImage.fromBitmap(bitmap)

        val outputs = model.process(image)
        val detectionResult = outputs.detectionResultList[0]

        val location = detectionResult.locationAsRectF
        val category = detectionResult.categoryAsString
        val score = detectionResult.scoreAsFloat
        val javaClass = detectionResult.javaClass

        println("Ubicación: $location")
        println("Categoría: $category")
        println("Puntuación: $score")
        println("Java Class: $javaClass")

        virtualClosetBinding.mlLocationText.text = "ML Location (debug): $location"
        virtualClosetBinding.mlCategoryText.text = "Category: $category"
        virtualClosetBinding.mlScoreText.text = "Score (debug): $score"

        val bitmapWithLocation = drawLocationOnBitmap(bitmap, location)

        virtualClosetBinding.imageView5.setImageBitmap(bitmapWithLocation)

        model.close()
    }



    private fun drawLocationOnBitmap(bitmap: Bitmap, location: RectF): Bitmap {
        val mutableBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true)
        val canvas = Canvas(mutableBitmap)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f

        canvas.drawRect(location, paint)

        return mutableBitmap
    }
}