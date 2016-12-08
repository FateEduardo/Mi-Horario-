package com.example.josue.proyectox;

/**
 * Created by Josue on 11/26/2016.
 */

public class User {
    private int matricula;
    private String name;
    private String app;
    private String apm;
    private String correo;
    private String carrera;
    private int semestre;
    private String password;

    public User(int matricula,String name,String app,String apm,String correo,String carrera,int semestre,String password){
        this.matricula=matricula;
        this.name=name;
        this.app=app;
        this.apm=apm;
        this.correo=correo;
        this.carrera=carrera;
        this.semestre=semestre;
        this.password=password;
    }

    public int setMatricula(){
        return matricula;
    }
    public String setName(){
        return name;
    }
    public String setApp(){
        return app;
    }

    public String setApm(){
        return apm;
    }

    public String setCorreo(){
        return correo;
    }
    public String setCarrera(){
        return carrera;
    }
    public int setSemestre(){
        return semestre;
    }
    public String setpassword(){
        return password;
    }
}
