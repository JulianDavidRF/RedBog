package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.redbog.ListaE.List;
import com.google.android.gms.maps.model.Marker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;

public class CrearReporteActivity extends AppCompatActivity{
    Spinner spinnerLocalidad;
    Spinner spinnerTipologia;
    String localidad;
    public String tipologia;
    String celular;
    String nombre;
    SimpleDateFormat simpleDateFormat;
   // String currentDate;
    String currentTime;
    Calendar calendar;
    EditText mensajeInput;
    String[] dateIdArray;
    String dateId;
    String[] anhoArray;
    String anhoId;
    String diaId;
    long milisegundosId;

    List<String> localidadLista;
    List<String> tipologiaLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        localidadLista = new List<>();
        tipologiaLista = new List<>();
        localidadLista.add("Localidad de los hechos");
        localidadLista.add("Antonio Nariño");
        localidadLista.add("Barrios Unidos");
        localidadLista.add("Chapinero");
        localidadLista.add("Ciudad Bolivar");
        localidadLista.add("Fontibon");
        localidadLista.add("Engativa");
        localidadLista.add("Kennedy");
        localidadLista.add("La Candelaria");
        localidadLista.add("Los Martires");
        localidadLista.add("Puente Aranda");
        localidadLista.add("Rafael Uribe");
        localidadLista.add("San Cristobal");
        localidadLista.add("Santa Fe");
        localidadLista.add("Suba");
        localidadLista.add("Sumapaz");
        localidadLista.add("Teusaquillo");
        localidadLista.add("Tunjuelito");
        localidadLista.add("Usaquen");
        localidadLista.add("Usme");

        tipologiaLista.add("Tipo de acto ilicito");
        tipologiaLista.add("Robo");
        tipologiaLista.add("Estafa");
        tipologiaLista.add("Agresión");
        tipologiaLista.add("Asalto");
        tipologiaLista.add("Riñas");

        ArrayList<String> localidadArray= new ArrayList<>();
        for(int i =0; i<= localidadLista.getC();i++){
            localidadArray.add(localidadLista.index(i));
        }

        ArrayList<String> tipologiaArray= new ArrayList<>();
        for(int i =0; i<= tipologiaLista.getC();i++){
            tipologiaArray.add(tipologiaLista.index(i));
        }

        celular =  getIntent().getStringExtra("celular");
        nombre =  getIntent().getStringExtra("nombre");

        Toast.makeText(this, celular, Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_crear_reporte);
        spinnerLocalidad = findViewById(R.id.spinner2);
        spinnerTipologia = findViewById(R.id.spinner3);
        mensajeInput =   findViewById(R.id.mensaje_reporte);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        currentTime = simpleDateFormat.format(calendar.getTime());
        ArrayAdapter<CharSequence> adapter =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, tipologiaArray);
        ArrayAdapter<CharSequence> adapter3 =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, localidadArray);
        spinnerLocalidad.setAdapter(adapter);
        spinnerTipologia.setAdapter(adapter3);
        spinnerLocalidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                localidad = adapterView.getItemAtPosition(i).toString();
                /*Toast.makeText(CrearReporteActivity.this,localidad,Toast.LENGTH_LONG).show();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerTipologia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tipologia = adapterView.getItemAtPosition(i).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    public void irPrincipal(View view){
        Intent registro = new Intent(this,PrincipalActivity.class);
        registro.putExtra("celular", celular);
        startActivity(registro);
    }

    public String getTodaysDate(){
        return new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date());
    }

    public void reporte(View view) {

        //Toast.makeText(this, mensajeInput.getText().toString(), Toast.LENGTH_SHORT).show();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 9);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        ContentValues c_reporte = new ContentValues();

        c_reporte.put("celular", this.celular);
        c_reporte.put("tipo_reporte", this.tipologia);
        c_reporte.put("localidad", this.localidad);
        c_reporte.put("comentario", mensajeInput.getText().toString());
        c_reporte.put("fecha", getTodaysDate());
        c_reporte.put("hora", this.currentTime);
        c_reporte.put("nombre", this.nombre);
        dateIdArray = getTodaysDate().split("/");
        dateId = "";
        for(int i =0; i< dateIdArray.length;i++){
            dateId+= dateIdArray[i];
        }
        c_reporte.put("dateId", dateId);
        //anhoArray = this.currentDate.split(" ");
        //anhoId = anhoArray[2];
        //diaId= anhoArray[0];
        //milisegundosId= calendar.getTimeInMillis();

        long id = BaseDeDatos.insert("reporte", null, c_reporte);
        BaseDeDatos.close();
        //Toast.makeText(this, "el id es: " + id, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Creado con exito", Toast.LENGTH_SHORT).show();



//20221029
  //      año + dia + milisegundos
    }



}