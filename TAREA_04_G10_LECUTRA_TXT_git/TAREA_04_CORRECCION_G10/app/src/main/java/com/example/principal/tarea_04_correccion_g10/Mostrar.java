package com.example.principal.tarea_04_correccion_g10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
      //  text = (TextView) findViewById(R.id.ver);
        //lista donde se va a gaurdar mis datos
        lista = (ListView) findViewById(R.id.listita);
        //escritura del ficher se actiuva con un boton

       /* try
        {
            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            openFileOutput("prueba_int.txt", Context.MODE_APPEND));

            fout.write("uno otro;");
            //  fout.append("\n");
            fout.write("\n"+"dos otro;");
            // fout.append("\n");
            fout.write("\n"+"tres otro;");
            //  fout.append("\n");
            fout.write("\n"+"cuatro otro;");
            fout.write("\n"+"cinco otro;");

          //  Toast.makeText(getApplicationContext(), fout.toString(), Toast.LENGTH_SHORT).show();//fout.write("Texto de prueba.");
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }*/
//lectura de fichero siempre tiene q estar activa
        try
        {

            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    openFileInput("prueba_int.txt")));

           while ((linea= fin.readLine())!=null){
               listado.add(linea);

          }
           // String mostrar = fin.readLine();


           //
           //Toast.makeText(this, "salio",Toast.LENGTH_SHORT).show();


            fin.close();



        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }
        datos = listado.toArray(new String[listado.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        lista.setAdapter(adapter);

     //   Toast.makeText(this,listado.size(),Toast.LENGTH_SHORT).show();
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
