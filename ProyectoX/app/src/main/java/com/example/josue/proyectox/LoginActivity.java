package com.example.josue.proyectox;

import android.animation.Animator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {
    boolean click = false;
    FloatingActionMenu floatingActionMenu;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                          //  User user = new User(,jsonResponse.getString("name"));
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){


                                //int age = jsonResponse.getInt("age");

                                Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
                                intent.putExtra("name",jsonResponse.getString(UserData.NAME.name()));
                                intent.putExtra("username",username);
                                intent.putExtra("correo",jsonResponse.getString(UserData.CORREO.name()));
                                //intent.putExtra("age",age);

                                LoginActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
                //loginRequest = null;

            }
        });
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);



        //flotingActionMenu menu_fab = (flotingActionMenu)findViewById(R.id.floatingActionMenu);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    click = !click;
                    Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(),
                            android.R.interpolator.fast_out_slow_in);

                    view.animate()
                            .rotation(click ? 45f : 0)
                            .setInterpolator(interpolador)
                            .start();
                }
                //Toast.makeText(getBaseContext(),getResources().getString(R.string.mensaje),
                //Toast.LENGTH_SHORT).show();
                //Snackbar.make(view,getResources().getString(R.string.mensaje),Snackbar.LENGTH_SHORT).show();
                Snackbar.make(view,getResources().getString(R.string.link_alumnos),Snackbar.LENGTH_LONG)

                        .setAction(getResources().getString(R.string.link_facultad),new View.OnClickListener(){

                            public void onClick(View view){

                                Uri uriUrl = Uri.parse("http://fiad.ens.uabc.mx/");
                                //Especificamos la accion a realizar con el ACTION_VIEW
                                //para que elija lo mas razonable
                                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(intent);
                                Log.i("SNACKBAR","Clic en snackbar");
                            }

                        }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
                //@Override

            }
        });*/
        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        //floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);
        //***************************************************
        floatingActionMenu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                bLogin.setVisibility(View.INVISIBLE);

            }
        });
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bLogin.setVisibility(View.INVISIBLE);
                Uri uriUrl = Uri.parse("http://fiad.ens.uabc.mx/");
                //************************************
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("http://alumnos.uabc.mx/web/alumnos/");
                //************************************
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
    }
}
