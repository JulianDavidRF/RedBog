package com.example.redbog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redbog.clases.Reporte;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.textfield.TextInputEditText;

public class PrincipalActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    private Button button;
    private Marker AntonioNariño;
    private Marker BarriosUnidos;
    private Marker Bosa;
    private Marker Chapinero;
    private Marker CiudadBolivar;
    private Marker Engativa;
    private Marker Fontibon;
    private Marker Kennedy;
    private Marker LaCandelaria;
    private Marker LosMartires;
    private Marker PuenteAranda;
    private Marker RafaelUribe;
    private Marker SanCristobal;
    private Marker SantaFe;
    private Marker Suba;
    private Marker Sumapaz;
    private Marker Teusaquillo;
    private Marker Tunjuelito;
    private Marker Usaquen;
    private Marker Usme;


    String celular;
    String nombre;
    String id;
    TextView prueba;
    GoogleMap mMap;
    private TextView Localidad;
    private TextView Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        celular = getIntent().getStringExtra("celular");
        nombre = getIntent().getStringExtra("nombre");
        id = getIntent().getStringExtra("id");


        setContentView(R.layout.activity_principal);
        Localidad = findViewById(R.id.localidadID);
        Total = findViewById(R.id.totalID);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void volver(View view) {
        Intent irLogin = new Intent(this, LoginActivity.class);
        startActivity(irLogin);
    }

    public void irAcrearReporte(View view) {

        Intent principal = new Intent(this, CrearReporteActivity.class);
        principal.putExtra("celular", celular);
        principal.putExtra("nombre", nombre);
        startActivity(principal);


    }

    public void irAmisReportes(View view) {

        Intent principal = new Intent(this, misReportesActivity.class);
        principal.putExtra("celular", celular);
        startActivity(principal);


    }

    public void irAreportes(View view) {

        Intent principal = new Intent(this, TodosLosReportes.class);
        principal.putExtra("celular", celular);
        startActivity(principal);

    }
    public void refreshMark(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,9);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("SELECT tipo_reporte, COUNT(*) FROM reporte GROUP BY tipo_reporte",null);
        while(fila.moveToNext()){
            String reporte = fila.getString(0);

            if(reporte.equals("Kennedy")){
                LatLng kennedy = new LatLng(4.61775,-74.1330333);
                Kennedy =  mMap.addMarker(new MarkerOptions()
                        .position(kennedy)
                        .title("Kennedy")
                );
            } else if (reporte.equals("Barrios Unidos")){
                LatLng barriosUnidos = new LatLng(4.6742472,-74.0840734);
                BarriosUnidos = mMap.addMarker(new MarkerOptions()
                        .position(barriosUnidos)
                        .title("Barrios Unidos")
                );
            } else if (reporte.equals("Bosa")){
                LatLng bosa = new LatLng(4.6105536,-74.186971);
                BarriosUnidos = mMap.addMarker(new MarkerOptions()
                        .position(bosa)
                        .title("Bosa")
                );
            } else if (reporte.equals("Chapinero")) {
                LatLng chapinero = new LatLng(4.6417747,-74.0668848);
                Chapinero = mMap.addMarker(new MarkerOptions()
                        .position(chapinero)
                        .title("Chapinero")
                );
            } else if (reporte.equals("Ciudad Bolivar")){
                LatLng ciudadBolivar = new LatLng(4.5661836,-74.1456881);
                Chapinero = mMap.addMarker(new MarkerOptions()
                        .position(ciudadBolivar)
                        .title("Ciudad Bolivar")
                );
            } else if (reporte.equals("Engativa")){
                LatLng engativa = new LatLng(4.6872862,-74.1003977);
                Engativa = mMap.addMarker(new MarkerOptions()
                        .position(engativa)
                        .title("Engativa")
                );
            } else if (reporte.equals("Fontibon")){
                LatLng fontibon = new LatLng(4.6744502,-74.1454514);
                Fontibon = mMap.addMarker(new MarkerOptions()
                        .position(fontibon)
                        .title("Fontibon")
                );
            } else if(reporte.equals("La Candelaria")){
                LatLng laCandelaria = new LatLng(4.6000182,-74.0740183);
                LaCandelaria = mMap.addMarker(new MarkerOptions()
                        .position(laCandelaria)
                        .title("La Candelaria")
                );
            } else if(reporte.equals("Los Martires")){
                LatLng losMartires = new LatLng(4.6000449,-74.0805844);
                LosMartires = mMap.addMarker(new MarkerOptions()
                        .position(losMartires)
                        .title("Los Martires")
                );
            } else if(reporte.equals("Antonio Nariño")){
                LatLng antonioNariño = new LatLng(4.5856977,-74.1031734);
                AntonioNariño = mMap.addMarker(new MarkerOptions()
                        .position(antonioNariño)
                        .title("Antonio Nariño")
                );
            } else if(reporte.equals("Puente Aranda")){
                LatLng puenteAranda = new LatLng(4.6059207,-74.1054769);
                PuenteAranda = mMap.addMarker(new MarkerOptions()
                        .position(puenteAranda)
                        .title("Puente Aranda")
                );
            } else if (reporte.equals("Rafael Uribe")){
                LatLng rafaelUribe = new LatLng(4.6035997,-74.1195076);
                RafaelUribe = mMap.addMarker(new MarkerOptions()
                        .position(rafaelUribe)
                        .title("Rafael Uribe")
                );
            } else if (reporte.equals("San Cristobal")){
                LatLng sanCristobal = new LatLng(4.5699275,-74.0886342);
                SanCristobal = mMap.addMarker(new MarkerOptions()
                        .position(sanCristobal)
                        .title("San Cristobal")
                );
            } else if (reporte.equals("Santa Fe")){
                LatLng santaFe = new LatLng(4.6065386,-74.0723336);
                SantaFe = mMap.addMarker(new MarkerOptions()
                        .position(santaFe)
                        .title("Santa Fe")
                );
            } else if (reporte.equals("Suba")){
                LatLng suba = new LatLng(4.7406549,-74.0864261);
                Suba = mMap.addMarker(new MarkerOptions()
                        .position(suba)
                        .title("Suba")
                );
            } else if (reporte.equals("Teusaquillo")){
                LatLng teusaquillo = new LatLng(4.6269736,-74.0746371);
                Teusaquillo = mMap.addMarker(new MarkerOptions()
                        .position(teusaquillo)
                        .title("Teusaquillo")
                );
            } else if (reporte.equals("Tunjuelito")){
                LatLng tunjuelito = new LatLng(4.5719123,-74.1311582);
                Tunjuelito = mMap.addMarker(new MarkerOptions()
                        .position(tunjuelito)
                        .title("Tunjuelito")
                );
            } else if (reporte.equals("Usaquen")){
                LatLng usaquen = new LatLng(4.6952123,-74.0336469);
                Usaquen = mMap.addMarker(new MarkerOptions()
                        .position(usaquen)
                        .title("Usaquen")
                );
            } else if (reporte.equals("Usme")){
                LatLng usme = new LatLng(4.4711747,-74.1276399);
                Usme = mMap.addMarker(new MarkerOptions()
                        .position(usme)
                        .title("Usme")
                );
            }
        }
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        refreshMark();
        LatLng unal = new LatLng(4.6359897,-74.081975);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(unal,11));
        mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);


    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,9);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();
        String zona = marker.getTitle();
        Cursor fila = BaseDeDatos.rawQuery("SELECT tipo_reporte, COUNT(*) FROM reporte WHERE tipo_reporte = '"+zona+"' GROUP BY tipo_reporte" ,null);
        while(fila.moveToNext()){
            Localidad.setText("Localidad: "+fila.getString(0));
            Total.setText("Total actos delictivos: "+fila.getString(1));
        }
        return false;
    }
}