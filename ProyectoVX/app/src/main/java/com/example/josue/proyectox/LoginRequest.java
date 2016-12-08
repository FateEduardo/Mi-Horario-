package com.example.josue.proyectox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Josue on 11/9/2016.
 */

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://al331385.net23.net/Login.php" ;//direccion del servidor de la base de datos
    private Map<String,String> params;

    public LoginRequest(String matricula, String password, Response.Listener<String> listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("matricula",matricula);
        params.put("password",password);

    }




    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
