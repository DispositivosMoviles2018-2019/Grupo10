package com.example.principal.tarea_04_correccion_g10;

import android.content.Context;
import android.content.Intent;
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

        try
         {
             OutputStreamWriter fout=
                            new OutputStreamWriter(
                                openFileOutput("prueba_int.txt", Context.MODE_APPEND));

        //     Toast.makeText(getApplicationContext(), fout.toString(), Toast.LENGTH_SHORT).show();//fout.write("Texto de prueba.");
                fout.close();
            }
         catch (Exception ex)
         {
                 Log.e("Ficheros", "Error al escribir fichero a memoria interna");
         }


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

/*
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.activity_menu,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcionmenu){
        int id=opcionmenu.getItemId();

        if(id==R.id.salir){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(opcionmenu);
    }
*/
}
