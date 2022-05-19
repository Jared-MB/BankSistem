package com.mycompany.proyectosistemabancario.empleados;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.UUID;

public class Empleado {
    // ATTRIBUTES
    private String nombre;
    private String rfc;
    private String NSS;
    private LocalDate fechaContratacion;
    private String ID;
    // CONSTRUCTOR
    public Empleado(String nombre, String rfc, String NSS) {
        this.ID = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.rfc = rfc;
        this.NSS = NSS;
        this.fechaContratacion = LocalDate.now();
    }
    // METHODS
    public String getID(){
        return this.ID;
    }
    //
    public String getNombre() {
        return nombre;
    }
    // 
    public String getNSS(){
        return NSS;
    }
    // 
    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }
    // 
    public String getRFC() {
        return rfc;
    }
    // 
    public void setNSS(String NSS) {
        if (NSS != ""){
            this.NSS = NSS;
        } 
        else {
            JOptionPane.showMessageDialog(null, "El NSS no es un valor aceptable");
        }
    }
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
