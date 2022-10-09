package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditarReporte extends AppCompatActivity {

    Spinner spinnerLocalidad;
    Spinner spinnerTipologia;
    String localidad;
    public String tipologia;
    String celular;
    String nombre;
    //SimpleDateFormat simpleDateFormat;
    //String currentDate;
    //String currentTime;
    //Calendar calendar;
    EditText mensajeInput;
    int id;
    String reporte;
    String fecha;
    String hora;


    EditText reporteTxt;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        id = Integer.valueOf(getIntent().getStringExtra("id"));
        fecha = getIntent().getStringExtra("fecha");
        hora =  getIntent().getStringExtra("hora");
        celular = getIntent().getStringExtra("celular");
        nombre = getIntent().getStringExtra("nombre");


        Toast.makeText(this,"ESTE ES EL REPORTE ->" + id, Toast.LENGTH_LONG).show();

        setContentView(R.layout.activity_editar_reporte);
        spinnerLocalidad = findViewById(R.id.spinner2);
        spinnerTipologia = findViewById(R.id.spinner3);
        mensajeInput =   findViewById(R.id.mensaje_reporte);

        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,R.array.localidades, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 =  ArrayAdapter.createFromResource(this,R.array.tipologia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

    public void editar(View view) {


        /*delete(id);
        Toast.makeText(this, mensajeInput.getText().toString(), Toast.LENGTH_SHORT).show();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 7);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        ContentValues c_reporte = new ContentValues();
        Toast.makeText(this,"celular " + celular,Toast.LENGTH_LONG).show();
        c_reporte.put("celular", this.celular);
        c_reporte.put("tipo_reporte", this.tipologia);
        c_reporte.put("localidad", this.localidad);
        c_reporte.put("comentario", mensajeInput.getText().toString());
        c_reporte.put("fecha", this.fecha);
        c_reporte.put("hora", this.hora);
        c_reporte.put("nombre", this.nombre);

        long id = BaseDeDatos.insert("reporte", null, c_reporte);
        BaseDeDatos.close();
        Toast.makeText(this, "el id es: " + id, Toast.LENGTH_SHORT).show();*/




        Toast.makeText(this, mensajeInput.getText().toString(), Toast.LENGTH_SHORT).show();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 7);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        /*ContentValues c_reporte = new ContentValues();
        c_reporte.put("celular", this.celular);
        c_reporte.put("tipo_reporte", this.tipologia);
        c_reporte.put("localidad", this.localidad);
        c_reporte.put("comentario", mensajeInput.getText().toString());
        c_reporte.put("fecha", this.fecha);
        c_reporte.put("hora", this.hora);
        c_reporte.put("nombre", this.nombre);
        long id_r = BaseDeDatos.insert("reporte", null, c_reporte);*/

        BaseDeDatos.execSQL("update  reporte  set celular = '"+this.celular+"', tipo_reporte = '"+this.tipologia+"',  " +
                "localidad = '"+this.localidad+"', comentario =  '"+mensajeInput.getText().toString()+"'," +
                "nombre='"+this.nombre+"' where id ='"+this.id+"' ");
        BaseDeDatos.close();
        Toast.makeText(this, "Reporte editado con exito" , Toast.LENGTH_SHORT).show();




    }
    public boolean delete(int elid ){
        boolean correct = false;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,7);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        try{
            BaseDeDatos.execSQL("delete from reporte where id = " + elid );
            correct = true;
        }catch(Exception ex){
            ex.toString();
            correct = false;
        }finally{
            BaseDeDatos.close();
        }

        return correct;

    }



}