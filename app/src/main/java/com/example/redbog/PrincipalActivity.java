package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    private Button button;
    String celular;
    String nombre;
    String id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        celular =  getIntent().getStringExtra("celular");
        nombre =  getIntent().getStringExtra("nombre");
        id =    getIntent().getStringExtra("id");


        setContentView(R.layout.activity_principal);

    }

    public void volver(View view){
        Intent irLogin  =  new Intent(this,LoginActivity.class);
        startActivity(irLogin);
    }

    /*public void openCrearReporte(){
        Intent crearReporte  =  new Intent(this,CrearReporteActivity.class);
        startActivity(crearReporte);

    }*/
    public void irAcrearReporte(View view){

        Intent principal = new Intent(this,CrearReporteActivity.class);
        principal.putExtra("celular",celular);
        principal.putExtra("nombre",nombre);
        startActivity(principal);


    }

    public void irAmisReportes(View view){

        Intent principal = new Intent(this, misReportesActivity.class);
        principal.putExtra("celular",celular);
        startActivity(principal);


    }

    public void irAreportes(View view){

        Intent principal = new Intent(this, TodosLosReportes.class);
        principal.putExtra("celular",celular);
        startActivity(principal);


    }
}