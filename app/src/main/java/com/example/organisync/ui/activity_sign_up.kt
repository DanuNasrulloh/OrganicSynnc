package com.example.organisync.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.organisync.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class activity_sign_up : AppCompatActivity() {
    private lateinit var emailInput: TextInputEditText
    private lateinit var usernameInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var addFaceButton: MaterialButton
    private lateinit var signInButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        emailInput = findViewById(R.id.emailInput)
        usernameInput = findViewById(R.id.usernameInput)
        passwordInput = findViewById(R.id.passwordInput)
        addFaceButton = findViewById(R.id.addFaceButton)
        signInButton = findViewById(R.id.signInButton)

        // Set up click listeners
        addFaceButton.setOnClickListener {
            // Implement face registration logic here
            Toast.makeText(this, "Tambah wajah clicked", Toast.LENGTH_SHORT).show()
        }

        signInButton.setOnClickListener {
            if (validateInputs()) {
                performSignUp()
            }
        }
        addFaceButton.setOnClickListener {
            startFaceCapture.launch(Intent(this, FaceCaptureActivity::class.java))
        }
    }

    private val startFaceCapture = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Face registered successfully!", Toast.LENGTH_SHORT).show()
            // Here you can save the face data or update UI
        }
    }


    private fun validateInputs(): Boolean {
        var isValid = true

        val email = emailInput.text.toString()
        val username = usernameInput.text.toString()
        val password = passwordInput.text.toString()

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.error = "Please enter a valid email"
            isValid = false
        }

        if (username.isEmpty()) {
            usernameInput.error = "Username is required"
            isValid = false
        }

        if (password.isEmpty() || password.length < 6) {
            passwordInput.error = "Password must be at least 6 characters"
            isValid = false
        }

        return isValid
    }

    private fun performSignUp() {
        val email = emailInput.text.toString()
        val username = usernameInput.text.toString()
        val password = passwordInput.text.toString()

        // Implement your sign up logic here
        Toast.makeText(this, "Sign up clicked with: $email", Toast.LENGTH_SHORT).show()
    }
}