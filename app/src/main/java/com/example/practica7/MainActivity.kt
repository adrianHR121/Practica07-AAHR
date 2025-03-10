package com.example.practica7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniRpelis()
    }

    public fun iniRpelis() {
        val rvpelis = findViewById<RecyclerView>(R.id.gpelis)
        rvpelis.layoutManager = LinearLayoutManager(this)
        rvpelis.adapter = Adaptador(generaDatosPeli(), this)

    }

    private fun generaDatosPeli():ArrayList<Pelicula> {
        var lista = ArrayList<Pelicula>()

        lista.add(Pelicula(R.drawable.imagen1, "Tutilo 1", "Genero 1", 1.5, "Detalle 1"))
        lista.add(Pelicula(R.drawable.imagen2, "Tutilo 2", "Genero 2", 2.5, "Detalle 2"))
        lista.add(Pelicula(R.drawable.imagen3, "Tutilo 3", "Genero 3", 3.5, "Detalle 3"))
        lista.add(Pelicula(R.drawable.imagen4, "Tutilo 4", "Genero 4", 4.5, "Detalle 4"))
        lista.add(Pelicula(R.drawable.imagen5, "Tutilo 5", "Genero 5", 5.5, "Detalle 5"))

        return lista
    }
}