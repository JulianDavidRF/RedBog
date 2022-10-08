package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redbog.clases.ListAdapter;
import com.example.redbog.clases.Reporte;
import com.example.redbog.stack.StackRef;
import com.example.redbog.PrincipalActivity;

import java.util.ArrayList;
import java.util.List;

public class misReportesActivity extends AppCompatActivity implements RecyclerViewClickInterface{

    StackRef<Reporte> misReportesStack;
    List<Reporte> misReportesLista;
    String celular;
    Dialog dialog;
    int id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        celular = getIntent().getStringExtra("celular");
        setContentView(R.layout.activity_mis_reportes);
        dialog = new Dialog(this);
        misReportesStack = llenarStack();
        Toast.makeText(this, "empty stack" + misReportesStack.isEmpty(), Toast.LENGTH_SHORT).show();
        stackaLista(misReportesStack );
        init();
        llenarStack();

    }


    public StackRef<Reporte> llenarStack(){
        misReportesStack = new StackRef<>();
        Reporte reporte;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,7);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select * from reporte where celular ="+celular,null);
        while(fila.moveToNext()){
            Toast.makeText(this,"texto" +fila.getString(4),Toast.LENGTH_SHORT).show();
            //String nombre, String reporte, String fecha, String hora, String localidad, String tipologia
            reporte = new Reporte(fila.getString(7), fila.getString(4),fila.getString(5),fila.getString(6),fila.getString(3),fila.getString(2),fila.getInt(0));
            misReportesStack.push(reporte);
        }
        return misReportesStack;
    }

    public void stackaLista(StackRef<Reporte> stack){
        misReportesLista = new ArrayList<>();
        while(!stack.isEmpty()){
            misReportesLista.add(stack.pop());
        }

    }

    public void init() {
        ListAdapter listAdapter = new ListAdapter(misReportesLista, this,this);
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(listAdapter);
    }

    public void alertDialog(View view){
        openAlert();
    }




    private void openAlert() {

        dialog.setContentView(R.layout.activity_alert_message);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView close = dialog.findViewById(R.id.close_icon);
        dialog.show();
        TextView id = findViewById(R.id.ID);
        Toast.makeText(this,"id : " + id.getText().toString(),Toast.LENGTH_SHORT).show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }

        });


    }

    public void editarReporte(View view){
        Intent principal = new Intent(this,EditarReporte.class);
        principal.putExtra("celular",celular);
        startActivity(principal);
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "id" + misReportesLista.get(position).getId(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongItemClick(int position) {

    }
}