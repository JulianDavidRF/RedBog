package com.example.redbog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import dalvik.system.BaseDexClassLoader;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table usuario(celular int primary key,nombre text, correo text, contraseña text)");
        BaseDeDatos.execSQL("create table reporte(id integer primary key autoincrement, celular int ,tipo_reporte text, localidad text,comentario text, fecha text,hora text,nombre text, dateId int)");
    }



    /*
    Nombre;
    Celular;
    Correo;
    Contraseña;
    ConfirmarContrasña;
    */

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table usuario");
        sqLiteDatabase.execSQL("drop table reporte");

        onCreate(sqLiteDatabase);
    }
}