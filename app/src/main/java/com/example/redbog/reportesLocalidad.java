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
        ArrayAdapter<CharSequence> adapter =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, filtros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filtroSpinner.setAdapter(adapter);


        filtroSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                respuestaFiltro = adapterView.getItemAtPosition(i).toString();

                if(respuestaFiltro == "Usaquen"){
                    init((List)myTabla.leer("Usaquen"));


                }
                if(respuestaFiltro == "Suba"){
                    init((List)myTabla.leer("Suba"));

                }
                if(respuestaFiltro == "Barrios Unidos"){
                    init((List)myTabla.leer("Barrios Unidos"));

                }
                if(respuestaFiltro == "Chapinero"){
                    init((List)myTabla.leer("Chapinero"));


                }
                if(respuestaFiltro == "Santa Fe"){
                    init((List)myTabla.leer("Santa Fe"));


                }
                if(respuestaFiltro == "La Candelaria"){
                    init((List)myTabla.leer("La Candelaria"));


                }
                if(respuestaFiltro == "San Cristobal"){
                    init((List)myTabla.leer("San Cristobal"));


                }
                if(respuestaFiltro == "Usme"){
                    init((List)myTabla.leer("Usme"));


                }
                if(respuestaFiltro == "Sumapaz"){
                    init((List)myTabla.leer("Sumapaz"));


                }
                if(respuestaFiltro == "Ciudad Bolivar"){
                    init((List)myTabla.leer("Ciudad Bolivar"));


                }
                if(respuestaFiltro == "Tunjuelito"){
                    init((List)myTabla.leer("Tunjuelito"));


                }
                if(respuestaFiltro == "Rafael Uribe"){
                    init((List)myTabla.leer("Rafael Uribe"));


                }
                if(respuestaFiltro == "Antonio Narinio"){
                    init((List)myTabla.leer("Antonio Narinio"));


                }
                if(respuestaFiltro == "Kennedy"){
                    init((List)myTabla.leer("Kennedy"));


                }
                if(respuestaFiltro == "Bosa"){
                    init((List)myTabla.leer("Bosa"));


                }
                if(respuestaFiltro == "Puente Aranda"){
                    init((List)myTabla.leer("Puente Aranda"));


                }
                if(respuestaFiltro == "Martires"){
                    init((List)myTabla.leer("Martires"));


                }
                if(respuestaFiltro == "Teusaquillo"){
                    init((List)myTabla.leer("Teusaquillo"));


                }
                if(respuestaFiltro == "Fontibon"){
                    init((List)myTabla.leer("Fontibon"));


                }

                if(respuestaFiltro == "Engativa"){
                    init((List)myTabla.leer("Engativa"));


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









}