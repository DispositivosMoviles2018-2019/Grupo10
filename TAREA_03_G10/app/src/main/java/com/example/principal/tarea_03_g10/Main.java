package com.example.principal.tarea_03_g10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    public void Entrar(View view){
       // Button botonEntrar =(Button) findViewById(R.id.botonEntrar);
        String usuario = ((EditText) findViewById(R.id.usuario)).getText().toString();
        String contrasena = ((EditText) findViewById(R.id.contrasena)).getText().toString();
        if(usuario.equals("michael")&&contrasena.equals("sarmiento")){

            Intent entrar = new Intent(this,usuario1.class);
            startActivity(entrar);
        }
        else{
            //mostramos el mensaje erroneo
        //    Toast.makeText(getApplicationContext(),"Usuario invalido", Toast.LENGTH_SHORT).show();
        }
        if(usuario.equals("juan")&&contrasena.equals("cuaycal")){

            Intent entrar = new Intent(this,usuario2.class);
            startActivity(entrar);
        }

        if(usuario.equals("karla")&&contrasena.equals("jaramillo")){

            Intent entrar = new Intent(this,usuario3.class);
            startActivity(entrar);
        }

        if(usuario.equals("gisela")&&contrasena.equals("sangoquiza")){

            Intent entrar = new Intent(this,usuario4.class);
            startActivity(entrar);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
     //   Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
      //  Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
     //   // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
    //    Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
     //   Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }


}
