package com.example.josue.proyectox;

/**
 * Created by Josue on 11/26/2016.
 */

public enum Materia {
    CLAVE("clave"),
    NOMBRE("nombre"),
    DESCRIPCION("descripcion"),
    TIPO("tipo");




    Materia(String user){
        this.user=user;
    }
    String user;
}
