package com.example.practica7

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VerImagen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_imagen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cimagen2 = findViewById<ImageView>(R.id.gimagen2)
        val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcion)

        // Obtener la película enviada
        val pelicula = intent.getSerializableExtra("peli") as? Pelicula
        if (pelicula != null) {
            cimagen2.setImageResource(pelicula.imagen)
            tvTitulo.text = pelicula.titulo
            tvDescripcion.text = pelicula.detalle
        } else {
            // En caso de error, mostrar valores predeterminados
            cimagen2.setImageResource(R.drawable.imagen3)
            tvTitulo.text = "Película no encontrada"
            tvDescripcion.text = "No hay información disponible"
        }
    }
}
