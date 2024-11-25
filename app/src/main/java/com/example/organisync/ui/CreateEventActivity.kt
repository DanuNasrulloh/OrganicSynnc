package com.example.organisync.ui

import android.app.DatePickerDialog
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.organisync.R
import com.google.android.datatransport.Event
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class CreateEventActivity : AppCompatActivity() {
    private lateinit var edtJudulEvent: TextInputEditText
    private lateinit var edtTanggalEvent: TextInputEditText
    private lateinit var edtDeskripsiEvent: TextInputEditText
    private lateinit var btnBuat: MaterialButton
    private lateinit var cardPhoto: androidx.cardview.widget.CardView
    private var selectedImageUri: Uri? = null

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            selectedImageUri = it
            // Here you can also set the image to an ImageView if you want to show the selected image
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        initializeViews()
        setupListeners()
    }

    private fun initializeViews() {
        edtJudulEvent = findViewById(R.id.edtJudulEvent)
        edtTanggalEvent = findViewById(R.id.edtTanggalEvent)
        edtDeskripsiEvent = findViewById(R.id.edtDeskripsiEvent)
        btnBuat = findViewById(R.id.btnBuat)
        cardPhoto = findViewById(R.id.cardPhoto)
    }

    private fun setupListeners() {
        // Setup Date Picker
        edtTanggalEvent.setOnClickListener {
            showDatePicker()
        }

        // Setup Image Picker
        cardPhoto.setOnClickListener {
            getContent.launch("image/*")
        }

        // Setup Create Button
        btnBuat.setOnClickListener {
            if (validateInputs()) {
                createEvent()
            }
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            edtTanggalEvent.setText(selectedDate)
        }, year, month, day).show()
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        if (edtJudulEvent.text.toString().trim().isEmpty()) {
            edtJudulEvent.error = "Judul event tidak boleh kosong"
            isValid = false
        }

        if (edtTanggalEvent.text.toString().trim().isEmpty()) {
            edtTanggalEvent.error = "Tanggal event tidak boleh kosong"
            isValid = false
        }

        if (edtDeskripsiEvent.text.toString().trim().isEmpty()) {
            edtDeskripsiEvent.error = "Deskripsi event tidak boleh kosong"
            isValid = false
        }

        if (selectedImageUri == null) {
            // Show error message for image
            // You might want to show a Toast or Snackbar here
            isValid = false
        }

        return isValid
    }

    private fun createEvent() {
        // Here you would typically:
        // 1. Create an Event object with all the data
        // 2. Save it to your database or send it to your server
        // 3. Show a success message
        // 4. Navigate back or to another screen

//        val eventData = Event(
//            judul = edtJudulEvent.text.toString(),
//            tanggal = edtTanggalEvent.text.toString(),
//            deskripsi = edtDeskripsiEvent.text.toString(),
//            photoUri = selectedImageUri.toString()
//        )

        // TODO: Save eventData to your database/server

        // For now, just finish the activity
        finish()
    }
}

// Data class to hold event information
//data class Event(
//    val judul: String,
//    val tanggal: String,
//    val deskripsi: String,
//    val photoUri: String
//)