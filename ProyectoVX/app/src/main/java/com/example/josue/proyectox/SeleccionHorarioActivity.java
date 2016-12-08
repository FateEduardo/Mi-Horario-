package com.example.josue.proyectox;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SeleccionHorarioActivity extends AppCompatActivity {
    //private ArrayList<RelativeLayout> arrayList;
    private ArrayAdapter<RelativeLayout> adapter;
    private ArrayList<HashMap<String, String>> horariosList = new ArrayList<HashMap<String, String>>();
    private int num_materias;
    //horariosList = new ArrayList<>();
    private LinearLayout l1;
    private LinearLayout l2;
    private String colores[]= {"#2e8c80","#6c9c02","#eead0e","#538370","#acae85"};
    /*#2e8c80
    #6c9c02
    #eead0e
    #538370
            #acae85*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_horario);
        l1=(LinearLayout)findViewById(R.id.List1);
        l2=(LinearLayout)findViewById(R.id.List2);
        //*********************
        Intent intent = getIntent();
        String response = intent.getStringExtra("response");
        //****************
        JSONArray materias = null;
        //**************
        try {
            JSONObject jsonResponse = new JSONObject(response);
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
                //*****************
                System.out.println(name);
                System.out.println(tipo);
                System.out.println(hora_fin);
                System.out.println(hora_in);
                //************
                horariosList.add(map);
                //Intent intent = new Intent(MenuActivity.this,SeleccionHorarioActivity.class);
                //MenuActivity.this.startActivity(intent);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        addLeft(materias.length());
        addRight(materias.length());
    }

    public void addLeft(final int numberOfMatter){
        LayoutInflater inflater = LayoutInflater.from(this);
        int id = R.layout.left;
        int hora=7;
        StringBuilder str;
        for(int i=0;i<numberOfMatter;i++){
            RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(id, null, false);
            TextView txtI=(TextView) relativeLayout.findViewById(R.id.HoraInicio);
            txtI.setText(horariosList.get(i).get("hora_in"));
            l1.addView(relativeLayout);
            hora++;
            TextView txtF=(TextView) relativeLayout.findViewById(R.id.HoraFin);

            txtF.setText(horariosList.get(i).get("hora_fin"));
        }

    }

    public void addRight(final int numberOfMatter){
        LayoutInflater inflater = LayoutInflater.from(this);
        int id = R.layout.rigth;
        //************
       // StringBuilder str;
        for(int i=0,j=0;i<numberOfMatter;i++,j++){
            /*str=new StringBuilder();
            str.append("Matematicas");*/
            RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(id, null, false);
            Button txtI=(Button) relativeLayout.findViewById(R.id.button);

            if(j==colores.length) j=0;
            txtI.setBackgroundColor(Color.parseColor(colores[j]));
            //*********************************
            txtI.setText(horariosList.get(i).get("nombre"));
            //txtI.setTag(str);
            txtI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.out.println("Se preciono "+v.getTag());
                    System.out.println("Se preciono "+v.getId());
                    //System.out.println("Se preciono "+v.setVisibility(View.INVISIBLE););
                    v.setVisibility(View.INVISIBLE);

                }
            });
            l2.addView(relativeLayout);
        }

    }
}
