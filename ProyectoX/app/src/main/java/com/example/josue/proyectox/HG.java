package com.example.josue.proyectox;

/**
 * Created by Josue on 11/26/2016.
 */

public enum HG {
    ID_HORARIO("id_Horario"),
    CLAVE("clave"),
    DIA("dia"),
    HORA_IN("hora_in"),
    HORA_FIN("hora_fin");




    HG(String user){
        this.user=user;
    }
    String user;
}
