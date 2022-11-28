package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.util.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redbog.AVL.AVLTree;
import com.example.redbog.clases.ListAdapter2;
import com.example.redbog.clases.Reporte;
import com.example.redbog.stack.StackRef;
import com.example.redbog.queue.Cola;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import com.example.redbog.Hash.*;



public class filtro_tipologia extends AppCompatActivity {


    //Declaracion de variables-------------------------------------
    StackRef<Reporte> todosReportesStack;
    List<Reporte> todosReportesLista;

    TextView tv;
    ImageView im;
    String celular;
    Dialog dialog;
    Spinner filtroSpinner;
    String respuestaFiltro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_tipologia);


        llenarLista();

        TablaHash myTabla = new TablaHash(22);

        ArrayList<Reporte> robo = new ArrayList<>();
        ArrayList<Reporte> estafa = new ArrayList<>();
        ArrayList<Reporte> agresion = new ArrayList<>();
        ArrayList<Reporte> asalto = new ArrayList<>();
        ArrayList<Reporte> riñas = new ArrayList<>();



        Toast("size : ");
        Toast.makeText(this, "size : ", Toast.LENGTH_SHORT).show();


        for (Reporte rep : todosReportesLista) {


            switch (rep.getLocalidad()) {
                case "Robo":
                    robo.add(rep);
                    break;
                case "Estafa":
                    estafa.add(rep);
                    break;
                case "Agresión":
                    agresion.add(rep);
                    break;
                case "Asalto":
                    asalto.add(rep);

                    break;
                case "Riñas":
                    riñas.add(rep);
                    break;

                default:
                    // code block
            }


        }


        //Toast("size : " + Chapinero.size());

        myTabla.insertar("Robo", robo);
        myTabla.insertar("Estafa", estafa);
        myTabla.insertar("Agresión", agresion);
        myTabla.insertar("Asalto", asalto);
        myTabla.insertar("Riñas", riñas);



        //Crecion de array para filtros-----------------------------------------------------
        setContentView(R.layout.activity_filtro_tipologia);
        ArrayList<String> filtros = new ArrayList<>();

        filtros.add("Acto ilicito");
        filtros.add("Robo");
        filtros.add("Estafa");
        filtros.add("Agresión");
        filtros.add("Asalto");
        filtros.add("Riñas");



        celular = getIntent().getStringExtra("celular");

        //El array se asigna a el drop-down adapter--------------------------------------------
        filtroSpinner = findViewById(R.id.spinner);
        tv = findViewById(R.id.textView);
        im = findViewById(R.id.imageView);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, filtros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filtroSpinner.setAdapter(adapter);


        filtroSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                respuestaFiltro = adapterView.getItemAtPosition(i).toString();

                if(respuestaFiltro !="Acto ilicito"){
                    tv.setVisibility(View.GONE);
                    im.setVisibility(View.GONE);
                }

                if (respuestaFiltro == "Robo") {
                    if(!((List)myTabla.leer("Robo")).isEmpty()){
                        init((List)myTabla.leer("Robo"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }

                }
                if (respuestaFiltro == "Agresión") {
                    if(!((List)myTabla.leer("Agresión")).isEmpty()){
                        init((List)myTabla.leer("Agresión"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }

                }
                if (respuestaFiltro == "Estafa") {
                    if(!((List)myTabla.leer("Estafa")).isEmpty()){
                        init((List)myTabla.leer("Estafa"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }

                }
                if (respuestaFiltro == "Asalto") {
                    if(!((List)myTabla.leer("Asalto")).isEmpty()){
                        init((List)myTabla.leer("Asalto"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }
                if (respuestaFiltro == "Riñas") {
                    if(!((List)myTabla.leer("Riñas")).isEmpty()){
                        init((List)myTabla.leer("Riñas"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }



            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


    }

    public void Toast(String n) {
        Toast.makeText(this, "fecha inico " + n, Toast.LENGTH_SHORT).show();
    }

    public List<Reporte> llenarLista() {

        todosReportesLista = new ArrayList<Reporte>();

        Reporte reporte;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 9);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select * from reporte ", null);
        while (fila.moveToNext()) {
            Toast.makeText(this, "texto" + fila.getString(4), Toast.LENGTH_SHORT).show();
            //String nombre, String reporte, String fecha, String hora, String localidad, String tipologia
            reporte = new Reporte(fila.getString(7), fila.getString(4), fila.getString(5), fila.getString(6), fila.getString(3), fila.getString(2), fila.getInt(0), fila.getInt(8));
            todosReportesLista.add(reporte);


        }

        return todosReportesLista;

    }

    public void init(List reportes) {
        ListAdapter2 listAdapter2 = new ListAdapter2(reportes, this);
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(listAdapter2);
    }
    public void irTodosReportes(View view){
        Intent registro = new Intent(this,TodosLosReportes.class);
        registro.putExtra("celular", celular);
        startActivity(registro);
    }
}





