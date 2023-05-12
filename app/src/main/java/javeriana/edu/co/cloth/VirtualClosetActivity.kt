package javeriana.edu.co.cloth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javeriana.edu.co.cloth.databinding.ActivityVirtualClosetBinding

class VirtualClosetActivity : AppCompatActivity()
{

    private lateinit var virtualClosetBinding : ActivityVirtualClosetBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        virtualClosetBinding = ActivityVirtualClosetBinding.inflate(layoutInflater)
        setContentView(virtualClosetBinding.root)
    }
}