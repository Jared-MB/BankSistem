package com.mycompany.proyectosistemabancario.empleados;

import javax.swing.JOptionPane;

import com.mycompany.proyectosistemabancario.CuentaBancaria;

import java.time.LocalDate;
import java.util.UUID;

public class Empleado {
    // ATTRIBUTES
    private String nombre;
    private String rfc;
    private String ID;
    private String telefono;
    private String direccion;
    // CONSTRUCTOR
    public Empleado(String nombre, String rfc, String telefono, String direccion) {
        this.ID = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Empleado(String ID, String nombre, String rfc, String telefono, String direccion) {
        this.ID = ID;
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    // METHODS
    public String getID(){
        return this.ID;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    //
    public String getNombre() {
        return nombre;
    }
    // 
    public String getRFC() {
        return rfc;
    }
    public void addCuenta(){
        
    }
    // 
    //  
    public void setNombre(String nombre) {
        if (nombre != ""){
            this.nombre = nombre;
        } 
        else {
            JOptionPane.showMessageDialog(null, "El nombre no es un valor aceptable");
        }
    }
    // 
    public void setRfc(String rfc) {
        if (rfc != ""){
            this.rfc = rfc;
        } 
        else {
            JOptionPane.showMessageDialog(null, "El RFC no es un valor aceptable");
        }
    }
    // 
    public void getInfo() {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nRFC: " + rfc);
    }
}
