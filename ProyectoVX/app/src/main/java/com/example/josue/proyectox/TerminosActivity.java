package com.example.josue.proyectox;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class TerminosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos);
        final Button btAceptar = (Button)findViewById(R.id.id_aceptar);
        final Button btCancelar = (Button)findViewById(R.id.id_cerrar);
        final CheckBox cBox = (CheckBox)findViewById(R.id.checkBox1);
        btAceptar.setVisibility(View.INVISIBLE);
        cBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                switch (v.getId()){
                    case R.id.checkBox1:
                        if(checked){
                            btAceptar.setVisibility(View.VISIBLE);
                        }else{
                            btAceptar.setVisibility(View.INVISIBLE);
                        }

                }
            }
        });
        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String matricula = intent.getStringExtra("matricula");
                String name = intent.getStringExtra("name");
                String app = intent.getStringExtra("app");
                String apm = intent.getStringExtra("apm");
                String correo = intent.getStringExtra("correo");
                String carrera = intent.getStringExtra("carrera");
                String semestre = intent.getStringExtra("semestre");
                String password = intent.getStringExtra("password");
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            //
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                Intent intent = new Intent(TerminosActivity.this,LoginActivity.class);
                                TerminosActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(TerminosActivity.this);
                                builder.setMessage("Register failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(matricula,name,app,apm,correo,carrera,semestre,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(TerminosActivity.this);
                queue.add(registerRequest);

            }
        });
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(TerminosActivity.this,RegisterActivity.class);
                TerminosActivity.this.startActivity(intent);*/
                finish();
            }
        });
    }
}
