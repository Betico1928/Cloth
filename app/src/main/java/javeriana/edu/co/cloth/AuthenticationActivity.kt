package javeriana.edu.co.cloth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import javeriana.edu.co.cloth.databinding.ActivityAuthenticationBinding

class AuthenticationActivity : AppCompatActivity()
{
    private lateinit var authenticationBinding : ActivityAuthenticationBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        authenticationBinding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(authenticationBinding.root)

        initializeElements()
    }

    private fun initializeElements()
    {
        // Buttons
        authenticationBinding.loginButton.setOnClickListener{
            Log.i("Authentication Activity", "LogIn Button")

            val goToMainMenu = Intent(baseContext, MainMenuActivity::class.java)
            startActivity(goToMainMenu)
        }

        authenticationBinding.registerButton.setOnClickListener {
            Log.i("Authentication Activity", "Register Button")

            val goToTodoActivity = Intent(baseContext, TODOActivity::class.java)
            startActivity(goToTodoActivity)
        }
    }
}