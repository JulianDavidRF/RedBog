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
import android.util.Log;
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

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

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
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,9);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select * from reporte where celular ="+celular,null);
        while(fila.moveToNext()){
            //Toast.makeText(this,"texto" +fila.getString(4),Toast.LENGTH_SHORT).show();
            //String nombre, String reporte, String fecha, String hora, String localidad, String tipologia
            reporte = new Reporte(fila.getString(7), fila.getString(4),fila.getString(5),fila.getString(6),fila.getString(3),fila.getString(2),fila.getInt(0),fila.getInt(8));
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

    /*public void alertDialog(View view){
        openAlert();
    }*/











    @Override
    public void onItemClickEliminar(int position) {
        Toast.makeText(this, "id eliminar" + misReportesLista.get(position).getId(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "el reporte : " + misReportesLista.get(position).getReporte(), Toast.LENGTH_SHORT).show();
        this.id = misReportesLista.get(position).getId();

    }


    public void onItemClickEditar(int position) {

        //Toast.makeText(this, "el reporte : " + misReportesLista.get(position).getReporte(), Toast.LENGTH_SHORT).show();
        this.id = misReportesLista.get(position).getId();
        String reporte = misReportesLista.get(position).getReporte();
        String fecha = misReportesLista.get(position).getFecha();
        String hora = misReportesLista.get(position).getHora();
        String nombre = misReportesLista.get(position).getNombre();


        Intent editar = new Intent(this, EditarReporte.class);

        editar.putExtra("id",String.valueOf(id));
        editar.putExtra("reporte", reporte);
        editar.putExtra("fecha", fecha);
        editar.putExtra("hora",hora);
        editar.putExtra("celular",celular);
        editar.putExtra("nombre",nombre);
        startActivity(editar);



    }


    /*private void openAlert() {

        dialog.setContentView(R.layout.activity_alert_message);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView close = dialog.findViewById(R.id.close_icon);
        dialog.show();
        Toast.makeText(this,"id : " + id,Toast.LENGTH_SHORT).show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }

        });


    }*/





    public boolean delete(int elid ){
        boolean correct = false;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,9);
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


    // Cuando le daba a la basura el id que aparecia no era el correcto debido a que se le estaba poniando un onclick a la basura
    //Ese onclick hacia un override al onclick que mostraba el id, y por ende ya no lo tomaba
    //Para solucionar esto, se le creo un onclick a la basura dentro del adapter
    public void Borrar(View view) {
        int position = this.id;

        //Toast.makeText(this, "SI ENTROOO" + misReportesLista.get(position).getId(), Toast.LENGTH_SHORT).show();
        //position = misReportesLista.get(position).getId();
        Toast.makeText(this, "el id : " + position, Toast.LENGTH_SHORT).show();
        boolean funcionepls = delete(position);
        if(funcionepls ){
            Toast.makeText(this, "El reporte ha sido elminado somos unos tesoooos", Toast.LENGTH_SHORT).show();
            Intent principal = new Intent(this, misReportesActivity.class);
            principal.putExtra("celular",celular);
            startActivity(principal);
        }else{
            Toast.makeText(this, "si sale me mato ", Toast.LENGTH_SHORT).show();
        }

    }
    public void editarReporte(View view){
        int position = this.id;
        //position = misReportesLista.get(this.id).getId();
        //String sPosition  = String.valueOf(position);


        Toast.makeText(this, "id de editar : " + position, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "el reporte : " + misReportesLista.get(position).getReporte(), Toast.LENGTH_SHORT).show();


        //String reporte = misReportesLista.get(position).getReporte();

        Intent principal = new Intent(this,EditarReporte.class);
        principal.putExtra("celular",celular);
        //principal.putExtra("id", sPosition);*/

        //principal.putExtra("reporte",reporte);
        //principal.putExtra("localidad",misReportesLista.get(position).getLocalidad());
        //principal.putExtra("tipologia",misReportesLista.get(position).getTipologia());
        startActivity(principal);

    }

    public void volver(View view){
        Intent principal = new Intent(this,PrincipalActivity.class);
        principal.putExtra("celular",celular);
        startActivity(principal);

    }
    public void irPrincipal(View view){
        Intent registro = new Intent(this,PrincipalActivity.class);
        registro.putExtra("celular", celular);
        startActivity(registro);
    }






}