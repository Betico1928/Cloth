package javeriana.edu.co.cloth

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import javeriana.edu.co.cloth.databinding.ActivityVirtualClosetBinding
import java.io.File

class VirtualClosetActivity : AppCompatActivity()
{
    private lateinit var virtualClosetBinding : ActivityVirtualClosetBinding
    // Binding
    //private lateinit var bindingCamera: ActivityCameraBinding

    // Request Gallery
    private val galleryRequest = registerForActivityResult(ActivityResultContracts.GetContent(), ActivityResultCallback { imagePath : Uri? -> loadImage(imagePath) })


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        virtualClosetBinding = ActivityVirtualClosetBinding.inflate(layoutInflater)
        setContentView(virtualClosetBinding.root)

        initializeElements()
    }

    private fun initializeElements()
    {
        //initializeFileFromCamera()

        virtualClosetBinding.buttonAddClothesFromGallery.setOnClickListener {
            // Open gallery
            galleryRequest.launch("image/*")
        }
    }

    private fun initializeFileFromCamera()
    {
        val fileToLoad = File(filesDir, "fileFromCamera")
        //cameraPath = FileProvider.getUriForFile( this, applicationContext.packageName + ".fileprovider", fileToLoad)
    }



    // Load the image in the activity (from gallery or camera)
    private fun loadImage( imagePath : Uri? )
    {
        val imageStream = contentResolver.openInputStream( imagePath!! )
        val image = BitmapFactory.decodeStream( imageStream )

        // IMPLEMENTARLO AQUI


        virtualClosetBinding.imageView5.setImageBitmap( image )
    }
}