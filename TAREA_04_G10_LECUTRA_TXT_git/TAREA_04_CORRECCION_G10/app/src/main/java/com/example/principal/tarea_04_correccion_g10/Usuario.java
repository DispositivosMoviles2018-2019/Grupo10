package com.example.principal.tarea_04_correccion_g10;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Usuario extends AppCompatActivity {
    String usuario;
    String clave;
    String nombre;
    String apellido;
    String email;
    String celular;
    String genero;

    public Usuario(){ }
    public Usuario(String usuario,String clave,String nombre,String apellid,String email,String celular,String genero){
        this.usuario = usuario;
        this.clave =  clave;
        this.nombre =  nombre;
        this.apellido =  apellido;
        this.email = email;
        this.celular = celular;
        this.genero = genero;

    }
    //metodos get y set de usuario no necesitan convalidacion
    public String getUsuario(){
        return usuario;
    }
    public boolean setUsuario(String usuario, EditText editUser){

        if(usuario.isEmpty()){

            editUser.setError("Campo Vacio");
            editUser.requestFocus();
            return false;

        }else{
            this.usuario=usuario;
            return true;
        }

    }
    //metodos get y set de clave no neecsitan convalidacion
    public String getClave(){
        return clave;
    }
    public boolean setClave(String clave, EditText editClave){
        if(clave.isEmpty()){

            editClave.setError("Campo Vacio");
            editClave.requestFocus();
            return false;

        }else{
            this.clave=clave;
            return true;
        }
    }
    //metodos get y set de nombre no necesitan convalidacion
    public String getNombre(){
        return nombre;
    }
    public boolean setNombre(String nombre,EditText editNombre){
        if(nombre.isEmpty()){

            editNombre.setError("Campo Vacio");
            editNombre.requestFocus();
            return false;

        }else{
            this.nombre=nombre;
            return true;
        }
    }
    //metodos set y get de apellidpo no necesitan convalidacion
    public String getApellido(){
        return apellido;
    }
    public boolean setApellido(String apellido,EditText editApellido){
        if(apellido.isEmpty()){

            editApellido.setError("Campo Vacio");
            editApellido.requestFocus();
            return false;

        }else{
            this.apellido=apellido;
            return true;
        }
    }
    //metodo get y set de email si necesita cCONVALIDACION
    public String getEmail(){
        return email;
    }
    public Boolean setEmail(String email, EditText editEmail){

        String emailv="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailv) && email.length() > 0)
        {
           this.email=email;
            return true;
        }
        else
        {
            editEmail.setError("Correo invalido");
            editEmail.requestFocus();
            return false;
        }


    }

    //metodos get y set de celilar NECESITAN CONVALIDACION
    public String getCelular() {
        return celular;
    }
    public boolean setCelular (String celular, EditText editCelular){
        String entradaTeclado=editCelular.getText().toString();
        if(celular.isEmpty()){

            editCelular.setError("Campo Vacio");
            editCelular.requestFocus();
            return false;

        }else{


            if (celular.charAt(0) =='0'  &&  (celular.charAt(1) =='8' ||celular.charAt(1) =='9' )) {
                if (editCelular.length()==10) {
                    for (int i = 1; i < entradaTeclado.length(); i++) {

                        if (entradaTeclado.charAt(i) !='0'
                                &&entradaTeclado.charAt(i) !='1'
                                &&entradaTeclado.charAt(i) !='2'
                                &&entradaTeclado.charAt(i) !='3'
                                &&entradaTeclado.charAt(i) !='4'
                                &&entradaTeclado.charAt(i) !='5'
                                &&entradaTeclado.charAt(i) !='6'
                                &&entradaTeclado.charAt(i) !='7'
                                &&entradaTeclado.charAt(i) !='8'
                                &&entradaTeclado.charAt(i) !='9'

                                ) {
                            editCelular.setError("Incorrecto ingrese números 0-9");
                            return false;
                        }
                    }
                    //System.out.println("Correctamente 10 numero !!!!!!!!!!!!");
                    this.celular = celular;
                    return true;

                }else{
                    editCelular.setError("Ingrese 10 Digitos");
                    return false;

                }

            }else{
                editCelular.setError("ingrese 09-08 al inicio");
                return false;
            }

        }

    }

    //metodos set y get de genero
    public String getGenero(){
        return genero;
    }
    public boolean setGenero(String genero, RadioButton masculino, RadioButton femenino){

            if (masculino.isChecked() == true) {
                this.genero = "Masculino";
                return true;

            } else if (femenino.isChecked()==true) {
            this.genero = "Femenino";
             return true;
            }else {

                return false;
            }

    }




}
