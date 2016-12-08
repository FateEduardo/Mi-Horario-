package com.example.josue.proyectox;

/**
 * Created by Josue on 11/26/2016.
 */

public enum UserData {
    MATRICULA("matricula"),
    NAME("name"),
    APP("app"),
    APM("apm"),
    CORREO("correo"),
    CARREA("carrera"),
    SEMESTRE("semestre"),
    PASSWWORD("password") ;



    UserData(String user){
        this.user=user;
    }
    String user;
}
