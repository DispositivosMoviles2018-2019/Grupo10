package com.example.principal.tarea_04_correccion_g10;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Mostrar extends AppCompatActivity {
    TextView text;
    ListView lista;
    String todo = "";
    List<String> listado = new ArrayList<String>();
    String linea;
    String datos[];
    Context context = this;
    private ArrayList<String> ingrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        ingrear=new ArrayList<String>();
        //  text = (TextView) findViewById(R.id.ver);
        //lista donde se va a gaurdar mis datos
        lista = (ListView) findViewById(R.id.listita);
        //lecutra con preferencias compartidas
        SharedPreferences sharpref = getSharedPreferences("ArchivoSP",Context.MODE_PRIVATE);
        // Toast.makeText(getApplicationContext(),sharpref.getString("usuario",""),Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();
        String usuario = sharpref.getString("usuario",null);
        String nombre = sharpref.getString("nombre",null);
        String apellido = sharpref.getString("apellido",null);
        String celular = sharpref.getString("celular",null);
        String email = sharpref.getString("email",null);
        String genero = sharpref.getString("genero",null);
        //Type type = new TypeToken<ArrayList<Usuario>>() {}.getType();
        // ingrear  = gson.fromJson(json,type);



        // String user = sharpref.getString("usuario","error al guardar");
        ingrear.add(usuario+nombre+apellido+celular+email+genero);
        //  datos = listado.toArray(new String[listado.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ingrear);
        lista.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.activity_menu,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcionmenu){
        int id=opcionmenu.getItemId();
        if(id==R.id.regresar){
            Intent i = new Intent(Mostrar.this, Main.class);  //Para ir a una vista específica
            startActivity(i);
        }

        if(id==R.id.salir){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(opcionmenu);
    }
}
