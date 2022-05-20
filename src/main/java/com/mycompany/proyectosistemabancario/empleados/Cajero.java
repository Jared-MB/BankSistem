package com.mycompany.proyectosistemabancario.empleados;

import javax.swing.JOptionPane;

public class Cajero extends Empleado {
    // ATTRIBUTES
    private Integer horas;
    private Float sueldo;
    // CONSTRUCTOR
    public Cajero(String nombre, String rfc, String telefono, String direccion, Float sueldo, Integer horas){
        super(nombre, rfc, telefono, direccion);
        this.horas = horas;
        this.sueldo = sueldo;
    }
    public Cajero(String ID,String nombre, String rfc, String telefono, String direccion, Float sueldo, Integer horas){
        super(ID,nombre, rfc, telefono, direccion);
        this.horas = horas;
        this.sueldo = sueldo;
    }
    // METHODS
    public Integer getHoras() {
        return horas;
    }
    //
    public Float getSueldo() {
        return sueldo;
    }
    //
    public void setHoras(Integer horas) {
        if (horas != null && horas > 0){
            this.horas = horas;
        } 
        else {
            JOptionPane.showMessageDialog(null, "Las horas no son un valor aceptable");
        }
    }
    //
    public void setSueldo(Float sueldo) {
        if (sueldo != null && sueldo > 0){
            this.sueldo = sueldo;
        } 
        else {
            JOptionPane.showMessageDialog(null, "El sueldo no es un valor aceptable");
        }
    }
}
