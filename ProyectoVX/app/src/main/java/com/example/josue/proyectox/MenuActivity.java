package com.example.josue.proyectox;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.josue.proyectox.fragmentos_de_menu.OpHorariosFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //String response;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //**************************

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        //************************************
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String correo = intent.getStringExtra("correo");

        TextView tName = (TextView) findViewById(R.id.tx_name);
        TextView tCorreo = (TextView) findViewById(R.id.tx_correo);

        tName.setText(name);
        tCorreo.setText(correo);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        android.app.FragmentManager fragmentManager = getFragmentManager();
        int id = item.getItemId();
        if (id == R.id.nav_cuenta_layout) {
            //fragmentManager.beginTransaction().replace(R.id.content_menu, new OpHorariosFragment()).commit();

        } else if (id == R.id.nav_salones_layout) {
            //fragmentManager.beginTransaction().replace(R.id.content_menu, new FirstFragment()).commit();

        } else if (id == R.id.nav_maestros_layout) {
            //fragmentManager.beginTransaction().replace(R.id.content_menu, new SecondFragment()).commit();

        }else if (id == R.id.nav_horarios_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_menu, new OpHorariosFragment()).commit();
        }

        /*if (id == R.id.nav_cuenta_layout) {
            // Handle the camera action
        } else if (id == R.id.nav_salones_layout) {

        } else if (id == R.id.nav_maestros_layout) {

        } else if (id == R.id.nav_horarios_layout) {


            String dia = "1";
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<HashMap<String, String>> horariosList;
                        horariosList = new ArrayList<>();
                        JSONArray materias = null;
                        JSONObject jsonResponse = new JSONObject(response);

                        //
                        int success = jsonResponse.getInt("success");
                       //**************************
                        if(success==1){
                            materias = jsonResponse.getJSONArray("materias");
                            for (int i = 0; i < materias.length(); i++) {
                                JSONObject c = materias.getJSONObject(i);

                                // Storing each json item in variable
                                String name = c.getString("nombre");
                                String tipo = c.getString("tipo");
                                String hora_in = c.getString("hora_in");
                                String hora_fin = c.getString("hora_fin");
                                HashMap map = new HashMap();

                                // adding each child node to HashMap key => value
                                map.put("nombre",name);
                                map.put("tipo",tipo);
                                map.put("hora_in",hora_in);
                                map.put("hora_fin",hora_fin);
                                horariosList.add(map);
                                //Intent intent = new Intent(MenuActivity.this,SeleccionHorarioActivity.class);
                                 //MenuActivity.this.startActivity(intent);

                            }

                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                            builder.setMessage(jsonResponse.toString())
                                    .setNegativeButton("CON LA PECHERONA",null)
                                    .create()
                                    .show();

                       }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                            builder.setMessage("No se pudo viejon!")
                                    .setNegativeButton("Puro pa lante pariente",null)
                                    .create()
                                    .show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            HorariosRequest horarioRequest = new HorariosRequest(dia,responseListener);
            RequestQueue queue = Volley.newRequestQueue(MenuActivity.this);
            queue.add(horarioRequest);*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
