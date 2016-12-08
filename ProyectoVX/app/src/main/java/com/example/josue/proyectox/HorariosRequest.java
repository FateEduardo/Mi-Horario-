package com.example.josue.proyectox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Josue on 12/3/2016.
 */

public class HorariosRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://al331385.net23.net/ConsultaHorarioGeneral.php";//"http://al331385.net23.net/.php";//direccion del servidor de la base de datos
    private Map<String,String> params;

    public HorariosRequest(String dia,Response.Listener<String> listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("dia",dia);//numeros entre 0 y 999999, y debe ser entero
    }
    public Map<String, String> getParams() {
        return params;
    }
}