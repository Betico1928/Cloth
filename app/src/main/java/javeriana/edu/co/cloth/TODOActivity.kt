package javeriana.edu.co.cloth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javeriana.edu.co.cloth.databinding.ActivityTodoactivityBinding

class TODOActivity : AppCompatActivity()
{

    private lateinit var todoBinding : ActivityTodoactivityBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        todoBinding = ActivityTodoactivityBinding.inflate(layoutInflater)
        setContentView(todoBinding.root)
    }
}