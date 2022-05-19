package com.mycompany.proyectosistemabancario.empleados;

import com.mycompany.proyectosistemabancario.Sucursal;
import javax.swing.JOptionPane;

public class Gerente extends Empleado {

    // ATTRIBUTES
    public Double sueldo;
    
    // CONSTRUCTOR
    public Gerente (String name, String rfc, String NSS, Double sueldo){
        super(name, rfc, NSS);
        this.sueldo = sueldo;
    }
    // METHODS
    public void hireEmployee(String type, Sucursal sucursal){

        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del " + type);
        String rfc = JOptionPane.showInputDialog(null, "Ingrese el RFC del " + type);
        String NSS = JOptionPane.showInputDialog(null, "Ingrese el NSS del " + type);
        Float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el sueldo del " + type));
        if (type == "Cajero" || type == "cajero"){
            Integer horas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese las horas del " + type));

            while ((horas == null || horas <= 0) || (sueldo == null || sueldo <= 0)){
                if (horas == null || horas <= 0){
                    JOptionPane.showMessageDialog(null, "Las horas no son un valor aceptable");
                    horas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese las horas del " + type));
                }
    
                if (sueldo == null || sueldo <= 0){
                    JOptionPane.showMessageDialog(null, "El sueldo no es un valor aceptable");
                    sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el sueldo del " + type));
                }
            }

            Cajero newCajero = new Cajero(nombre, rfc, sueldo, NSS, horas);
            System.out.println("Se ha contratado a un nuevo cajero, " + newCajero.getNombre());
            // sucursal.addEmployee(newCajero);
        }
        else if (type == "Asesor"){
            Asesor newAsesor = new Asesor(nombre, rfc, sueldo, NSS);
            System.out.println("Se ha contratado a un nuevo asesor, " + newAsesor.getNombre());
            // sucursal.addEmployee(newAsesor);
        }
        else {
            JOptionPane.showMessageDialog(null, "El tipo de empleado no es aceptable");
        }
    }
}
