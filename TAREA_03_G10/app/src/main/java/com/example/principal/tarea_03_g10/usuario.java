package com.example.principal.tarea_03_g10;

public class usuario {
    String usuario;
    String nombre;
    String contrasena;
    String celular;
    String apellido;
    String email;
    public  usuario(){}

    public  usuario(String usuario,String contrasena,String nombre ,String celular,String apellido, String email){
    this.usuario = usuario;
    this.nombre= nombre;
    this.contrasena = contrasena;
    this.celular = celular;
    this.apellido = apellido;
    this.email =  email;
    }
}
