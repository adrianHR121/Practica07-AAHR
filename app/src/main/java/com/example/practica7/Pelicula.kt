package com.example.practica7

import java.io.Serializable

class Pelicula(
    var imagen: Int,
    var titulo: String,
    var genero: String,
    var calificacion: Double,
    var detalle: String
) : Serializable
{
}