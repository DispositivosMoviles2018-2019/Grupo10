package com.example.principal.tarea_04_correccion_g10;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharprefs =  getSharedPreferences("ArchivoSP", Context.MODE_PRIVATE);


    }
    public void ingresar(View view) {

        String usuario =((EditText)findViewById(R.id.usuario)).getText().toString();
        String contraseña =((EditText)findViewById(R.id.contrasena)).getText().toString();

if (usuario.equals("uce")&&contraseña.equals("123")){

    Intent ingresar = new Intent(this, Mostrar.class);
    startActivity(ingresar);

}

    }
    public void registrar(View view) {

        Intent registrar = new Intent(this, Registro.class);
        startActivity(registrar);

    }

}
