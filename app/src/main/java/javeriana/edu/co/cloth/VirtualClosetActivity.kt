package javeriana.edu.co.cloth

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import javeriana.edu.co.cloth.databinding.ActivityVirtualClosetBinding
import javeriana.edu.co.cloth.ml.LiteModelSsdMobilenetV11Metadata2
import org.tensorflow.lite.support.image.TensorImage

class VirtualClosetActivity : AppCompatActivity() {
    private lateinit var virtualClosetBinding: ActivityVirtualClosetBinding

    private val galleryRequest = registerForActivityResult(ActivityResultContracts.GetContent(), ActivityResultCallback { imagePath: Uri? -> loadImage(imagePath) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        virtualClosetBinding = ActivityVirtualClosetBinding.inflate(layoutInflater)
        setContentView(virtualClosetBinding.root)

        initializeElements()
    }

    private fun initializeElements() {
        virtualClosetBinding.buttonAddClothesFromGallery.setOnClickListener {
            galleryRequest.launch("image/*")
        }
    }

    private fun loadImage(imagePath: Uri?) {
        val imageStream = contentResolver.openInputStream(imagePath!!)
        val image = BitmapFactory.decodeStream(imageStream)

        predictImage(image)

        virtualClosetBinding.imageView5.setImageBitmap(image)
    }

    private fun predictImage(bitmap: Bitmap) {
        val model = LiteModelSsdMobilenetV11Metadata2.newInstance(this)

        val image = TensorImage.fromBitmap(bitmap)

        val outputs = model.process(image)
        val detectionResult = outputs.detectionResultList[0]

        val location = detectionResult.locationAsRectF
        val category = detectionResult.categoryAsString
        val score = detectionResult.scoreAsFloat

        // Aquí puedes usar `location`, `category` y `score` como necesites.
        // Por ejemplo, puedes imprimirlos en la consola:
        Toast.makeText(baseContext, "Ubicación: $location", Toast.LENGTH_SHORT).show()
        Toast.makeText(baseContext, "Categoría: $category", Toast.LENGTH_SHORT).show()
        Toast.makeText(baseContext, "Puntuación: $score", Toast.LENGTH_SHORT).show()
        println("Ubicación: $location")
        println("Categoría: $category")
        println("Puntuación: $score")

        model.close()
    }
}
