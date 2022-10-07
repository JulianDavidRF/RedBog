package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.redbog.clases.ListAdapter;
import com.example.redbog.clases.ListAdapter2;
import com.example.redbog.clases.Reporte;
import com.example.redbog.stack.StackRef;
import com.example.redbog.queue.Cola;
import com.example.redbog.queue.Node;

import java.util.ArrayList;
import java.util.List;


public class TodosLosReportes extends AppCompatActivity {


    StackRef<Reporte> misReportesStack;
    Cola<Reporte> misReportesCola;
    List<Reporte> misReportesLista;
    String celular;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        celular = getIntent().getStringExtra("celular");
        setContentView(R.layout.activity_todos_los_reportes);
        dialog = new Dialog(this);
        //misReportesStack = llenarStack();
        misReportesCola = llenarCola();
        Toast.makeText(this, "empty queue" + misReportesCola.empty(), Toast.LENGTH_SHORT).show();
        stackaLista(misReportesCola);
        init();
        llenarStack();

    }


    public StackRef<Reporte> llenarStack(){
        misReportesStack = new StackRef<>();
        Reporte reporte;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,7);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select * from reporte ",null);
        while(fila.moveToNext()){
            Toast.makeText(this,"texto" +fila.getString(4),Toast.LENGTH_SHORT).show();
            //String nombre, String reporte, String fecha, String hora, String localidad, String tipologia
            reporte = new Reporte(fila.getString(7), fila.getString(4),fila.getString(5),fila.getString(6),fila.getString(3),fila.getString(2),fila.getInt(0));
            misReportesStack.push(reporte);
        }
        return misReportesStack;
    }
    public Cola<Reporte> llenarCola(){
        misReportesCola = new Cola<Reporte>();
        Reporte reporte;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,7);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select * from reporte ",null);
        while(fila.moveToNext()){
            Toast.makeText(this,"texto" +fila.getString(4),Toast.LENGTH_SHORT).show();
            //String nombre, String reporte, String fecha, String hora, String localidad, String tipologia
            reporte = new Reporte(fila.getString(7), fila.getString(4),fila.getString(5),fila.getString(6),fila.getString(3),fila.getString(2),fila.getInt(0));
            misReportesCola.enqueue(reporte);
        }

        return misReportesCola;

    }
    public void stackaLista(StackRef<Reporte> stack){
        misReportesLista = new ArrayList<>();
        while(!stack.isEmpty()){
            misReportesLista.add(stack.pop());
        }

    }
    public void stackaLista(Cola<Reporte> cola){
        misReportesLista = new ArrayList<>();
        while(!cola.empty()){
            misReportesLista.add(cola.dequeue());
        }

    }

    public void init() {
        ListAdapter2 listAdapter2 = new ListAdapter2(misReportesLista, this);
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(listAdapter2);
    }

}