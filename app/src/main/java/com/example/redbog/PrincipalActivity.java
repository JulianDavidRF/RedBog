package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        button = findViewById(R.id.crear_reporte);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCrearReporte();
            }
        });
    }

    public void volver(View view){
        Intent irLogin  =  new Intent(this,LoginActivity.class);
        startActivity(irLogin);
    }

    public void openCrearReporte(){
        Intent crearReporte  =  new Intent(this,CrearReporteActivity.class);
        startActivity(crearReporte);

    }
}