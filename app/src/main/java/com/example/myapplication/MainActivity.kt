package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private val colores = listOf("#FFFFFF", "#FFE0E0", "#E0F7FA", "#E8F5E9", "#FFF9C4")

    private val saludos = listOf(
        "¡Hola desde Kotlin! 🎉",
        "¿Qué tal? 😄",
        "Android Studio mola 📱",
        "¡Sigue así! 💪",
        "Kotlin > Java? 😏"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView = findViewById<TextView>(R.id.textView)
        val contadorText = findViewById<TextView>(R.id.contadorText)
        val button = findViewById<Button>(R.id.button)
        val root = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)

        button.setOnClickListener {
            contador++
            textView.text = saludos[contador % saludos.size]
            contadorText.text = "Clics: $contador"
            root.setBackgroundColor(Color.parseColor(colores[contador % colores.size]))
            Toast.makeText(this, "¡Click #$contador!", Toast.LENGTH_SHORT).show()
        }
    }
}