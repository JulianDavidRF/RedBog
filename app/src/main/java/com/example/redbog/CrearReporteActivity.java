package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class CrearReporteActivity extends AppCompatActivity {
    Spinner spinner;
    Spinner spinner3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_reporte);
        spinner = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,R.array.localidades, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 =  ArrayAdapter.createFromResource(this,R.array.tipologia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner3.setAdapter(adapter3);



    }






}