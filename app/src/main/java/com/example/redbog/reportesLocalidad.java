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



public class reportesLocalidad extends AppCompatActivity {


    //Declaracion de variables-------------------------------------
    StackRef<Reporte> todosReportesStack;
    List<Reporte> todosReportesLista;


    String celular;
    Dialog dialog;
    Spinner filtroSpinner;
    TextView tv;
    ImageView im;
    String respuestaFiltro;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes_localidad);


        llenarLista();

        TablaHash myTabla = new TablaHash(22);

        ArrayList<Reporte>  Suba = new ArrayList<>();
        ArrayList<Reporte>  Usaquen = new ArrayList<>();
        ArrayList<Reporte> BarriosUnidos = new ArrayList<>();
        ArrayList<Reporte>  Chapinero = new ArrayList<>() ;
        ArrayList<Reporte>  SantaFe = new ArrayList<>();
        ArrayList<Reporte> LaCandelaria = new ArrayList<>();
        ArrayList<Reporte>  SanCristobal= new ArrayList<>() ;
        ArrayList<Reporte>  Usme = new ArrayList<>();
        ArrayList<Reporte>  SumaPaz = new ArrayList<>();
        ArrayList<Reporte>  CiudadBolivar = new ArrayList<>();
        ArrayList<Reporte>  Tunjuelito = new ArrayList<>();
        ArrayList<Reporte>  RafaelUribe = new ArrayList<>() ;
        ArrayList<Reporte>  AntonioNarinio= new ArrayList<>()  ;
        ArrayList<Reporte>  Kennedy= new ArrayList<>();
        ArrayList<Reporte> Bosa = new ArrayList<>();
        ArrayList<Reporte>  PuenteAranda= new ArrayList<>() ;
        ArrayList<Reporte>  Martires = new ArrayList<>();
        ArrayList<Reporte>  Teusaquillo= new ArrayList<>();
        ArrayList<Reporte> Fontibon = new ArrayList<>();
        ArrayList<Reporte> Engativa  = new ArrayList<>() ;



        Toast("size : " );
        Toast.makeText(this,"size : " ,Toast.LENGTH_SHORT).show();



        for(Reporte rep : todosReportesLista ){


            switch (rep.getTipologia()) {
                case "Suba":
                    Suba.add(rep);
                    break;
                case "Usaquen":
                    Usaquen.add(rep);
                    break;
                case "Barrios Unidos":
                    BarriosUnidos.add(rep);
                    break;
                case "Chapinero":
                    Chapinero.add(rep);

                    break;
                case "Santa Fe":
                    SantaFe.add(rep);
                    break;
                case "La Candelaria":
                    LaCandelaria.add(rep);
                    break;
                case "San Cristobal":
                    SanCristobal.add(rep);
                    break;
                case "Usme":
                    Usme.add(rep);
                    break;
                case "Sumapaz":
                    SumaPaz.add(rep);
                    break;
                case "Ciudad Bolivar":
                    CiudadBolivar.add(rep);
                    break;
                case "Tunjuelito":
                    Tunjuelito.add(rep);
                    break;
                case "Antonio Narinio":
                    AntonioNarinio.add(rep);
                    break;
                case "Kennedy":
                    Kennedy.add(rep);

                    break;
                case "Bosa":
                    Bosa.add(rep);
                    break;
                case "Puente Aranda":
                    PuenteAranda.add(rep);
                    break;
                case "Martires":
                    Martires.add(rep);
                    break;
                case "Teusaquillo":
                    Teusaquillo.add(rep);
                    break;
                case "Fontibon":
                    Fontibon.add(rep);
                    break;
                case "Engativa":
                    Engativa.add(rep);
                    break;
                case "Rafael Uribe":
                    RafaelUribe.add(rep);
                    break;

                default:
                    // code block
            }









        }



        Toast("size : " + Chapinero.size());

        myTabla.insertar("Suba",Suba);
        myTabla.insertar("Usaquen",Usaquen);
        myTabla.insertar("Barrios Unidos",BarriosUnidos);
        myTabla.insertar("Chapinero",Chapinero);
        myTabla.insertar("Santa Fe",SantaFe);
        myTabla.insertar("La Candelaria",LaCandelaria);
        myTabla.insertar("San Cristobal",SanCristobal);
        myTabla.insertar("Usme",Usme);
        myTabla.insertar("Sumapaz",SumaPaz);
        myTabla.insertar("Ciudad Bolivar",CiudadBolivar);
        myTabla.insertar("Tunjuelito",Tunjuelito);
        myTabla.insertar("Rafael Uribe",RafaelUribe);
        myTabla.insertar("Antonio Narinio",AntonioNarinio);
        myTabla.insertar("Kennedy",Kennedy);
        myTabla.insertar("Bosa",Bosa);
        myTabla.insertar("Puente Aranda",PuenteAranda);
        myTabla.insertar("Martires",Martires);
        myTabla.insertar("Teusaquillo",Teusaquillo);
        myTabla.insertar("Fontibon",Fontibon);
        myTabla.insertar("Engativa",Engativa);





        //Crecion de array para filtros-----------------------------------------------------
        setContentView(R.layout.activity_reportes_localidad);
        ArrayList<String> filtros= new ArrayList<>();
        filtros.add("Localidades");
        filtros.add("Usaquen");
        filtros.add("Suba");
        filtros.add("Barrios Unidos");
        filtros.add("Chapinero");
        filtros.add("Santa Fe");
        filtros.add("La Candelaria");
        filtros.add("San Cristobal");
        filtros.add("Usme");
        filtros.add("Sumapaz");
        filtros.add("Ciudad Bolivar");
        filtros.add("Tunjuelito");
        filtros.add("Rafael Uribe");
        filtros.add("Antonio Narinio");
        filtros.add("Kennedy");
        filtros.add("Bosa");
        filtros.add("Puente Aranda");
        filtros.add("Martires");
        filtros.add("Teusaquillo");
        filtros.add("Fontibon");
        filtros.add("Engativa");




        celular = getIntent().getStringExtra("celular");

        //El array se asigna a el drop-down adapter--------------------------------------------
        filtroSpinner = findViewById(R.id.spinner);
        tv = findViewById(R.id.textView);
        im = findViewById(R.id.imageView);
        ArrayAdapter<CharSequence> adapter =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, filtros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filtroSpinner.setAdapter(adapter);


        filtroSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                respuestaFiltro = adapterView.getItemAtPosition(i).toString();

                if(respuestaFiltro !="Localidades"){
                    tv.setVisibility(View.GONE);
                    im.setVisibility(View.GONE);
                }

                if(respuestaFiltro == "Usaquen"){

                    if(!((List)myTabla.leer("Usaquen")).isEmpty()){
                        init((List)myTabla.leer("Usaquen"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);
                    }


                }
                if(respuestaFiltro == "Suba"){
                    if(!((List)myTabla.leer("Suba")).isEmpty()){
                        init((List)myTabla.leer("Suba"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);
                    }

                }
                if(respuestaFiltro == "Barrios Unidos"){

                    if(!((List)myTabla.leer("Barrios Unidos")).isEmpty()){
                        init((List)myTabla.leer("Barrios Unidos"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);

                    }


                }
                if(respuestaFiltro == "Chapinero"){
                    if(!((List)myTabla.leer("Chapinero")).isEmpty()){
                        init((List)myTabla.leer("Chapinero"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);

                    }


                }
                if(respuestaFiltro == "Santa Fe"){
                    if(!((List)myTabla.leer("Santa Fe")).isEmpty()){
                        init((List)myTabla.leer("Santa Fe"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);

                    }


                }
                if(respuestaFiltro == "La Candelaria"){
                    if(!((List)myTabla.leer("La Candelaria")).isEmpty()){
                        init((List)myTabla.leer("La Candelaria"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);

                    }


                }
                if(respuestaFiltro == "San Cristobal"){
                    if(!((List)myTabla.leer("San Cristobal")).isEmpty()){
                        init((List)myTabla.leer("San Cristobal"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);

                    }


                }
                if(respuestaFiltro == "Usme"){
                    if(!((List)myTabla.leer("Usme")).isEmpty()){
                        init((List)myTabla.leer("Usme"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);

                    }


                }
                if(respuestaFiltro == "Sumapaz"){
                    if(!((List)myTabla.leer("Sumapaz")).isEmpty()){
                        init((List)myTabla.leer("Sumapaz"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);

                    }


                }
                if(respuestaFiltro == "Ciudad Bolivar"){
                    if(!((List)myTabla.leer("Ciudad Bolivar")).isEmpty()){
                        init((List)myTabla.leer("Ciudad Bolivar"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);

                    }


                }
                if(respuestaFiltro == "Tunjuelito"){
                    if(!((List)myTabla.leer("Tunjuelito")).isEmpty()){
                        init((List)myTabla.leer("Tunjuelito"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }



                }
                if(respuestaFiltro == "Rafael Uribe"){
                    if(!((List)myTabla.leer("Rafael Uribe")).isEmpty()){
                        init((List)myTabla.leer("Rafael Uribe"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }



                }
                if(respuestaFiltro == "Antonio Narinio"){
                    if(!((List)myTabla.leer("Antonio Narinio")).isEmpty()){
                        init((List)myTabla.leer("Antonio Narinio"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }
                if(respuestaFiltro == "Kennedy"){
                    if(!((List)myTabla.leer("Kennedy")).isEmpty()){
                        init((List)myTabla.leer("Kennedy"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }
                if(respuestaFiltro == "Bosa"){
                    if(!((List)myTabla.leer("Bosa")).isEmpty()){
                        init((List)myTabla.leer("Bosa"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }
                if(respuestaFiltro == "Puente Aranda"){
                    if(!((List)myTabla.leer("Puente Aranda")).isEmpty()){
                        init((List)myTabla.leer("Puente Aranda"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }
                if(respuestaFiltro == "Martires"){
                    if(!((List)myTabla.leer("Martires")).isEmpty()){
                        init((List)myTabla.leer("Martires"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }
                if(respuestaFiltro == "Teusaquillo"){
                    if(!((List)myTabla.leer("Teusaquillo")).isEmpty()){
                        init((List)myTabla.leer("Teusaquillo"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }
                if(respuestaFiltro == "Fontibon"){
                    if(!((List)myTabla.leer("Fontibon")).isEmpty()){
                        init((List)myTabla.leer("Fontibon"));
                    }else{
                        im.setImageResource(R.drawable.no_results);
                        tv.setText("No se encontaron resultados en esta busqueda");
                        im.setVisibility(View.VISIBLE);
                    }


                }

                if(respuestaFiltro == "Engativa"){
                    if(!((List)myTabla.leer("Engativa")).isEmpty()){
                        init((List)myTabla.leer("Engativa"));
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

    public void Toast(String n){
        Toast.makeText(this, "fecha inico " + n, Toast.LENGTH_SHORT).show();
    }

    public List<Reporte> llenarLista(){

        todosReportesLista = new ArrayList<Reporte>();

        Reporte reporte;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,9);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select * from reporte ",null);
        while(fila.moveToNext()){
            Toast.makeText(this,"texto" +fila.getString(4),Toast.LENGTH_SHORT).show();
            //String nombre, String reporte, String fecha, String hora, String localidad, String tipologia
            reporte = new Reporte(fila.getString(7), fila.getString(4),fila.getString(5),fila.getString(6),fila.getString(3),fila.getString(2),fila.getInt(0),fila.getInt(8));
            todosReportesLista.add(reporte);


        }

        return todosReportesLista ;

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