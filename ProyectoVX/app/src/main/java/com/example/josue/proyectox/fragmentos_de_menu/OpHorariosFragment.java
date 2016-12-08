package com.example.josue.proyectox.fragmentos_de_menu;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.josue.proyectox.HorariosRequest;
import com.example.josue.proyectox.R;
import com.example.josue.proyectox.SeleccionHorarioActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import dalvik.annotation.TestTarget;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpHorariosFragment extends Fragment {
        View miVista;
        String response;

        @Nullable
        @Override


        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            miVista = inflater.inflate(R.layout.fragment_op_horarios, container,false);
            //nt mandar_request= 0;
            final Button bt_lunes = (Button)miVista.findViewById(R.id.bt_lunes);
            final Button bt_martes = (Button)miVista.findViewById(R.id.bt_martes);
            final Button bt_miercoles = (Button)miVista.findViewById(R.id.bt_miercoles);
            final Button bt_jueves = (Button)miVista.findViewById(R.id.bt_jueves);
            final Button bt_viernes = (Button)miVista.findViewById(R.id.bt_viernes);
            //************************

            bt_lunes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),SeleccionHorarioActivity.class);
                    //intent.putExtra("response",response);
                    System.out.println(response);
                    //getActivity().startActivity(intent);
                    request("1",intent);


                }
            });
            //*********
            bt_martes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),SeleccionHorarioActivity.class);
                    System.out.println(response);
                    request("2",intent);
                }
            });
            //********
            bt_miercoles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getActivity(),SeleccionHorarioActivity.class);
                    System.out.println(response);
                    request("3",intent);
                }
            });
            //************
            bt_jueves.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),SeleccionHorarioActivity.class);
                    System.out.println(response);
                    request("4",intent);
                }
            });
            //*************
            bt_viernes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),SeleccionHorarioActivity.class);
                    System.out.println(response);
                    request("5",intent);
                }
            });

            return miVista;

        }
    void request(String dia_semana, final Intent intent) {
        //String variable;
        //getActivity().

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response_base) {
                response = response_base;
                try {
                    //**************************
                    if(response!=null){

                        /*AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage(response)
                                .setNegativeButton("CON LA PECHERONA",null)
                                .create()
                                .show();
                        //Intent intent = new Intent(getActivity(),SeleccionHorarioActivity.class);*/
                        intent.putExtra("response",response);
                        System.out.println(response);
                        response=null;
                        getActivity().startActivity(intent);

                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("No se pudo viejon!")
                                .setNegativeButton("Puro pa lante pariente",null)
                                .create()
                                .show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        };
        HorariosRequest horarioRequest = new HorariosRequest(dia_semana,responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(horarioRequest);
    }
}

