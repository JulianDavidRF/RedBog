package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.security.PublicKey;

public class RegistroActivity extends AppCompatActivity {

    private TextInputEditText Nombre;
    private TextInputEditText Celular;
    private TextInputEditText Correo;
    private TextInputEditText Contraseña;
    private TextInputEditText ConfirmarContrasña;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Nombre = (TextInputEditText)findViewById(R.id.nombreInputR);
        Celular = (TextInputEditText)findViewById(R.id.celularInputR);
        Correo = (TextInputEditText)findViewById(R.id.correoInputR);
        Contraseña = (TextInputEditText)findViewById(R.id.contraseñaInputR);
        ConfirmarContrasña = (TextInputEditText)findViewById(R.id.con_contraseñaInputR);

    }

    public void registro(View view) {
        String nombre = Nombre.getText().toString();
        String celular = Celular.getText().toString();
        String correo = Correo.getText().toString();
        String contraseña = Contraseña.getText().toString();
        String confirmarContrasña = ConfirmarContrasña.getText().toString();

        boolean estado = true;
        if (nombre.isEmpty()) {
            Nombre.setError("Debes ingresar un nombre");
            estado = false;
        } else if (celular.isEmpty()) {
            Celular.setError("Debes ingresar un numero de ceular");
            estado = false;
        } else if (correo.isEmpty()) {
            Correo.setError("Debes ingresar un correo");
            estado = false;
        } else if (contraseña.isEmpty()) {
            Contraseña.setError("Debes ingresar una contraseña");
            estado = false;
        } else if (confirmarContrasña.isEmpty()) {
            ConfirmarContrasña.setError("Debes ingresar una contrasñea");
            estado = false;
        } else if (!contraseña.equals(confirmarContrasña)) {
            ConfirmarContrasña.setError("Las contraseñas no coindicen");
            estado = false;
        }

        if (estado) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

            Cursor fila = BaseDeDatos.rawQuery
                    ("select celular from usuario where celular =" + celular, null);
            if (fila.moveToFirst()) {
                Toast.makeText(this, "Existe un registro con este numero.", Toast.LENGTH_SHORT).show();
            } else {
                ContentValues registro = new ContentValues();
                registro.put("celular", celular);
                registro.put("nombre", nombre);
                registro.put("correo", correo);
                registro.put("contraseña", contraseña);

                BaseDeDatos.insert("usuario", null, registro);
                BaseDeDatos.close();
                Toast.makeText(this, "Usuario Registrado.", Toast.LENGTH_SHORT).show();

                Intent irLogin  =  new Intent(this,LoginActivity.class);
                startActivity(irLogin);
            }
        }
    }


    public void irLogin(View view){
        Intent irLogin  =  new Intent(this,LoginActivity.class);
        startActivity(irLogin);
    }
}