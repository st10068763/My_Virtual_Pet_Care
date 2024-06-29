package com.example.virtualpet

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PetActivityPage : AppCompatActivity() {

    // Declaring the variables for the levels
    private var hungerLevel: Int = 10 // Initial hunger level
    private var cleanLevel: Int = 10 // Initial clean level
    private var playLevel: Int = 10 // Initial play level

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pet_page)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Declaring the buttons and image view
        val imageView: ImageView = findViewById(R.id.imageView2)
        val btnFood: Button = findViewById(R.id.btnFood)
        val btnClean: Button = findViewById(R.id.btnClean)
        val btnPlay: Button = findViewById(R.id.btnPlay)

        // Declaring the views for the texts
        val editTextHungerLevel: EditText = findViewById(R.id.editTextHungerLevel)
        val editTextCleanLevel: EditText = findViewById(R.id.editTextCleanLevel)
        val editTextPlayLevel: EditText = findViewById(R.id.editTextHappyLevel)

        // Set initial levels
        editTextHungerLevel.setText(hungerLevel.toString())
        editTextCleanLevel.setText(cleanLevel.toString())
        editTextPlayLevel.setText(playLevel.toString())

        // Food button click listener
        btnFood.setOnClickListener {
            imageView.setImageResource(R.drawable.pluto_eating)
            if (hungerLevel < 10) hungerLevel += 1
            if (cleanLevel > 0) cleanLevel -= 1
            if (playLevel > 0) playLevel -= 1
            updateLevels(editTextHungerLevel, editTextCleanLevel, editTextPlayLevel)
        }

        // Clean button click listener
        btnClean.setOnClickListener {
            imageView.setImageResource(R.drawable.pluto_showering)
            if (cleanLevel < 10) cleanLevel += 1
            if (hungerLevel > 0) hungerLevel -= 1
            if (playLevel > 0) playLevel -= 1
            updateLevels(editTextHungerLevel, editTextCleanLevel, editTextPlayLevel)
        }

        // Play button click listener
        btnPlay.setOnClickListener {
            imageView.setImageResource(R.drawable.pluto_playing)
            if (playLevel < 10) playLevel += 1
            if (hungerLevel > 0) hungerLevel -= 1
            if (cleanLevel > 0) cleanLevel -= 1
            updateLevels(editTextHungerLevel, editTextCleanLevel, editTextPlayLevel)
        }
    }

    // Function to update the EditText fields with the current levels
    private fun updateLevels(
        editTextHungerLevel: EditText,
        editTextCleanLevel: EditText,
        editTextPlayLevel: EditText
    ) {
        editTextHungerLevel.setText(hungerLevel.toString())
        editTextCleanLevel.setText(cleanLevel.toString())
        editTextPlayLevel.setText(playLevel.toString())
    }
}
