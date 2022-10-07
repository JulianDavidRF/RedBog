package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.redbog.clases.ListAdapter;
import com.example.redbog.clases.Reporte;
import com.example.redbog.stack.StackRef;

import java.util.ArrayList;
import java.util.List;

public class misReportesActivity extends AppCompatActivity {

    StackRef<Reporte> misReportesStack;
    List<Reporte> misReportesLista;
    String celular;
    Dialog dialog;


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
        ListAdapter listAdapter = new ListAdapter(misReportesLista, this);
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(listAdapter);
    }











}