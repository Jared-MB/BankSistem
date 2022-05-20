package com.mycompany.proyectosistemabancario.empleados;

import com.mycompany.proyectosistemabancario.Sucursal;
import javax.swing.JOptionPane;

public class Gerente extends Empleado {

    // ATTRIBUTES
    public Float sueldo;
    
    // CONSTRUCTOR
    public Gerente (String ID,String name, String rfc, String telefono, String direccion, Float sueldo){
        super(ID, name, rfc, telefono, direccion);
        this.sueldo = sueldo;
    }
    public Gerente (String name, String rfc, String telefono, String direccion, Float sueldo){
        super(name, rfc, telefono, direccion);
        this.sueldo = sueldo;
    }
    // METHODS
    public Float getSueldo() {
        return sueldo;
    }
}
