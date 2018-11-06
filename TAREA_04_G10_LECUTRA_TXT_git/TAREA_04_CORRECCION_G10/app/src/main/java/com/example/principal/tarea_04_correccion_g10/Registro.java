package com.example.principal.tarea_04_correccion_g10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class Registro extends AppCompatActivity {
    public EditText editUsuario,editClave,editNombre,editApellido,editCelular,editEmail;
    public RadioButton masculino, femenino;
    String usuario,clave,nombre ,apellido,celular,email,genero;
   // Boolean validaEmail=false;

    RadioGroup radiogrupo;
    Usuario nuevo = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        editUsuario = (EditText) findViewById(R.id.ing_usuario);
        editClave =  (EditText) findViewById(R.id.ing_clave);
        editCelular =(EditText) findViewById(R.id.ing_celular);
        editNombre = (EditText) findViewById(R.id.ing_nombre);
        editApellido=(EditText) findViewById(R.id.ing_apellido);
        editEmail =(EditText) findViewById(R.id.ing_email);
        masculino = (RadioButton) findViewById(R.id.radio_m);
        femenino = (RadioButton) findViewById(R.id.radio_f);

        radiogrupo = findViewById(R.id.radioGroup2);


        usuario="";
        clave="";
        celular="";
        nombre="";
        apellido="";
        email="";
        genero = "";

    }


    public void checkButton(View view){
        int radioId=radiogrupo.getCheckedRadioButtonId();
        radiogrupo=findViewById(radioId);

    }
    public void guardar(View view){

        usuario = editUsuario.getText().toString();
        clave =  editClave.getText().toString();
        nombre = editNombre.getText().toString();
        apellido= editApellido.getText().toString();
        email = editEmail.getText().toString();
        celular = editCelular.getText().toString();
        masculino = (RadioButton) findViewById(R.id.radio_m);
        femenino = (RadioButton) findViewById(R.id.radio_f);


        //validacion
        nuevo.setUsuario(usuario,editUsuario);
        nuevo.setClave(clave,editClave);
        nuevo.setNombre(nombre,editNombre);
        nuevo.setApellido(apellido,editApellido);
        nuevo.setCelular(celular,editCelular);
        nuevo.setEmail(email,editEmail);
        nuevo.setGenero(genero,masculino,femenino);




    if ( nuevo.setEmail(email,editEmail)==true&&
            nuevo.setUsuario(usuario,editUsuario)==true&&
            nuevo.setClave(clave,editClave)==true&&
            nuevo.setNombre(nombre,editNombre)==true&&
            nuevo.setApellido(apellido,editApellido)==true &&
            nuevo.setCelular(celular,editCelular)==true &&
            nuevo.setGenero(genero,masculino,femenino)
            ){
        try {
         OutputStreamWriter fout =
                new OutputStreamWriter(
                        openFileOutput("prueba_int.txt", Context.MODE_APPEND));

         fout.write("\n" + nuevo.getUsuario());
         fout.write(" " + nuevo.getClave());
         fout.write(" " + nuevo.getNombre());
         fout.write(" " + nuevo.getApellido());
         fout.write(" " + nuevo.getEmail());
         fout.write(" " + nuevo.getCelular());
         fout.write(" " + nuevo.getGenero());


        //  Toast.makeText(getApplicationContext(), fout.toString(), Toast.LENGTH_SHORT).show();//fout.write("Texto de prueba.");
         fout.close();
        } catch (Exception ex) {
          Log.e("Ficheros", "Error al escribir fichero a memoria interna");
         }
       Intent entrar = new Intent(this, Main.class);
        startActivity(entrar);
     }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.activity_menu,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcionmenu){
        int id=opcionmenu.getItemId();
        if(id==R.id.regresar){
            Intent i = new Intent(Registro.this, Main.class);  //Para ir a una vista específica
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
