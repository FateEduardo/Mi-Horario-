package com.example.josue.proyectox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Josue on 11/26/2016.
 */

public class RegisterRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://al331385.net23.net/Registro2.php";//direccion del servidor de la base de datos
    private Map<String,String> params;

    public RegisterRequest(String matricula,String name, String apP,String apM, String correo, String carrera, String semestre,String password,  Response.Listener<String> listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("matricula",matricula);//numeros entre 0 y 999999, y debe ser entero
        params.put("name",name);//pueden tener un espacio, sin numeros
        params.put("app",apP);//sin espacios, sin numeros
        params.put("apm",apM);//sin espacios, sin numeros
        params.put("correo",correo);//sin espacios, sin numeros
        params.put("carrera",carrera);//1 espacio, sin numeros
        params.put("semestre",semestre);//solo numeros entre 1 y 14
        params.put("password",password);//sin espacios
    }
    public Map<String, String> getParams() {
        return params;
    }
}
