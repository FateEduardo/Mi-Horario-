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
    private static final String LOGIN_REQUEST_URL = "http://al331385.net23.net/Registro.php";//direccion del servidor de la base de datos
    private Map<String,String> params;

    public RegisterRequest(String matricula,String name, String apP,String apM, String correo, String carrera, String semestre,String password,  Response.Listener<String> listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("matricula",matricula);
        params.put("name",name);
        params.put("app",apP);
        params.put("apm",apM);
        params.put("correo",correo);
        params.put("carrera",carrera);
        params.put("semestre",semestre);
        params.put("password",password);

    }
    public Map<String, String> getParams() {
        return params;
    }
}
