package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText Celular;
    private TextInputEditText Contraseña;
    String nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Celular = (TextInputEditText)findViewById(R.id.celularInput);
        Contraseña = (TextInputEditText)findViewById(R.id.contraseñaInput);

    }
    public void loginVerificacion(View view){
        String celular = Celular.getText().toString();
        String contraseña = Contraseña.getText().toString();

        boolean estado = true;
        if(celular.isEmpty()){
            Celular.setError("Ingrese un celular");
            estado = false;
        } else if(contraseña.isEmpty()){
            Contraseña.setError("Ingrese una contraseña");
            estado = false;
        }

        if(estado){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,7);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

            Cursor fila = BaseDeDatos.rawQuery
                    ("select * from usuario where celular ="+celular,null);

            if(fila.moveToFirst()){
                if(fila.getString(3).equals(contraseña)){
                    nombre = fila.getString(1);
                    Toast.makeText(this, "Bienvenido " +  nombre, Toast.LENGTH_SHORT).show();



                    Intent principal = new Intent(this,PrincipalActivity.class);
                    principal.putExtra("celular",celular);
                    principal.putExtra("nombre",nombre);
                    startActivity(principal);


                } else {
                    Toast.makeText(this, "Contraseña Errada.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Usuario NO registrado.", Toast.LENGTH_SHORT).show();
            }
        }


    }
    public void registrarUsuario(View view){
        Intent registro = new Intent(this,RegistroActivity.class);
        startActivity(registro);
    }
}