package com.example.principal.tarea_03_g10;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Reg_Usuar extends AppCompatActivity {

    public EditText EditText1,EditText,EditText2,EditText3,EditText4,EditText5;
    public TextView textView;
    public Button save,load;
    public ArrayList ListaUsuarios= new ArrayList  ();
    public int auxiliar=0;

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaTutorial";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg__usuar);
        EditText= (EditText) findViewById(R.id.ing_usuario);
        EditText1= (EditText) findViewById(R.id.ing_clave);
        EditText2= (EditText) findViewById(R.id.nombre);
        EditText3= (EditText) findViewById(R.id.ing_apellido);
        EditText4= (EditText) findViewById(R.id.ing_email);
        EditText5= (EditText) findViewById(R.id.ing_celular);
        textView = (TextView) findViewById(R.id.textview);
        Toast.makeText(Reg_Usuar.this,"Versión 1.0.", Toast.LENGTH_SHORT).show();
        save = (Button) findViewById(R.id.save);
        load = (Button) findViewById(R.id.load);
        File dir = new File(path);
        dir.mkdirs();
    }
    public void load (View view)
    {
        String[] archivos = fileList();

        if (existe(archivos, "notas.txt"))
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                String [] datos=new String[4];
                while (linea != null) {
                   datos=linea.split(",");
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                EditText.setText(datos[0]);
                EditText1.setText(datos[1]);
                EditText2.setText(datos[2]);
                EditText3.setText(datos[3]);
                EditText4.setText(datos[4]);
            } catch (IOException e) {
            }


        /* File file = new File (path + "/savedFile.txt");
        String [] loadText = Load(file);
        String finalString = "";
        for (int i = 0; i < loadText.length; i++)
        {
            finalString += loadText[i] + System.getProperty("line.separator");
        }
        textView.setText(finalString);*/
    }

    public void save (View view )
    {

        File file = new File (path + "/savedFile.txt");
        String usser=EditText.getText().toString();
        String calve=EditText1.getText().toString();
        String name=EditText2.getText().toString();
        String lastname=EditText3.getText().toString();
        String email=EditText4.getText().toString();
        String celular=EditText5.getText().toString();
        auxiliar= auxiliar+1;

        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    "notas.txt", Activity.MODE_PRIVATE));
            String concatenado=usser+","+calve+","+name+","+lastname+","+email+","+celular;
            archivo.write(concatenado);
            archivo.flush();
            archivo.close();

        } catch (IOException e) {
            Toast t = Toast.makeText(this, "HUBI UN ERROR",
                    Toast.LENGTH_SHORT);
        }
        Toast t = Toast.makeText(this, "Los datos fueron grabados",
                Toast.LENGTH_SHORT);
        t.show();
        finish();

/*
        String []saveText = String.valueOf(EditText.getText()).split(System.getProperty("line.separator"));
        EditText.setText("");
        String nombre=String.valueOf(EditText.getText());
        String nnumero=String.valueOf(EditText4.getText());

        String [] saveText1 = String.valueOf(EditText1.getText()).split(System.getProperty("line.separator"));
        EditText1.setText("");

        String [] saveText2 = String.valueOf(EditText2.getText()).split(System.getProperty("line.separator"));
        EditText2.setText("");

        String [] saveText3 = String.valueOf(EditText3.getText()).split(System.getProperty("line.separator"));
        EditText3.setText("");

        String [] saveText4 = String.valueOf(EditText4.getText()).split(System.getProperty("line.separator"));
        EditText4.setText("");

        String [] saveText5 = String.valueOf(EditText5.getText()).split(System.getProperty("line.separator"));
        EditText5.setText("");




        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

        Save (file, saveText);
        Save (file, saveText1);
        Save (file, saveText2);
        Save (file, saveText3);
        Save (file, saveText4);
        Save (file, saveText5);*/







    }
    private boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }
    public void instansia(){
        usuario usuario1= new usuario();


    }


    //Método Guardar
    public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }
    public static String[] Load(File file)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
    }








    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //  Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        //  Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        //    Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //  Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }
}
