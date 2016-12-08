package com.example.josue.proyectox;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etMatricula = (EditText) findViewById(R.id.etMatricula);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etApp = (EditText) findViewById(R.id.etApp);
        final EditText etApm = (EditText) findViewById(R.id.etApm);
        final EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        final EditText etCarrera = (EditText) findViewById(R.id.etCarrera);
        final EditText etSemestre = (EditText) findViewById(R.id.etSemestre);
        final EditText etPassword = (EditText) findViewById(R.id.etPass);
        //********************
        final Button btRegistrar = (Button) findViewById(R.id.btRegistrar);
        //*********************
        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*LayoutInflater layoutInflater;
                View popupView;
                final PopupWindow popupWindow;
                layoutInflater =(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                popupView = layoutInflater.inflate(R.layout.popup, null);
                popupWindow = new PopupWindow(popupView,RadioGroup.LayoutParams.WRAP_CONTENT,
                        RadioGroup.LayoutParams.WRAP_CONTENT);

                final Button boton_cerrar = (Button)popupView.findViewById(R.id.id_cerrar);
                boton_cerrar.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }});
                //popupWindow.showAsDropDown(btRegistrar,0,0);
                popupWindow.showAsDropDown(btRegistrar,0, -200);*/
                //popupWindow.showAtLocation(btRegistrar, Gravity.BOTTOM, 0, anchor.getHeight());
                Intent intent = new Intent(RegisterActivity.this,TerminosActivity.class);
                intent.putExtra("matricula",etMatricula.getText().toString());
                intent.putExtra("name",etName.getText().toString());
                intent.putExtra("app",etApp.getText().toString());
                intent.putExtra("apm",etApm.getText().toString());
                intent.putExtra("correo",etCorreo.getText().toString());
                intent.putExtra("carrera",etCarrera.getText().toString());
                intent.putExtra("semestre",etSemestre.getText().toString());
                intent.putExtra("password",etPassword.getText().toString());
                //intent.putExtra("matricula",etMatricula.getText().toString());
                //intent.putExtra(username,jsonResponse.getString("matricula"));
               // intent.putExtra("correo",jsonResponse.getString("correo"));
                //intent.putExtra("age",age);

                RegisterActivity.this.startActivity(intent);
                //Intent intent = new Intent(LoginActivity.this,MenuActivity.class);

                /*final String matricula = etMatricula.getText().toString();
                final String name = etName.getText().toString();
                final String app = etApp.getText().toString();
                final String apm = etApm.getText().toString();
                final String correo = etCorreo.getText().toString();
                final String carrera = etCarrera.getText().toString();
                final String semestre = etSemestre.getText().toString();
                final String password = etPassword.getText().toString();*/
                /*Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            //
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
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
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);*/
            }
        });
        //****************************

       /* params.put("matricula",matricula);
        params.put("name",name);
        params.put("app",apP);
        params.put("apm",apM);
        params.put("correo",correo);
        params.put("carrera",carrera);
        params.put("semestre",semestre);
        params.put("password",password);*/

    }
    private boolean valida_num_lim(int num,int lim_in, int lim_sp){
        if (num>lim_in && num<=lim_sp){
            return true;
        }
        return false;
    }
    private boolean val_cadena(String cadena){

        return false;
    }
    //private boolean valida_string
}
