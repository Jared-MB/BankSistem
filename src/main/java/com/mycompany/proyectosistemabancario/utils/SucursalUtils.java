package com.mycompany.proyectosistemabancario.utils;


import com.mycompany.proyectosistemabancario.CuentaBancaria;
import com.mycompany.proyectosistemabancario.empleados.Asesor;
import com.mycompany.proyectosistemabancario.empleados.Cajero;
import com.mycompany.proyectosistemabancario.empleados.Empleado;
import com.mycompany.proyectosistemabancario.empleados.Gerente;
import com.mycompany.proyectosistemabancario.utils.EmployeesUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amuno
 */
public class SucursalUtils {
    public static Integer getTotalEmployees(){
        try {
            Empleado[] empleados = EmployeesUtils.GetEmployees();
            Integer counter = 0;
            for (Empleado empleado : empleados) {
                if (empleado != null) {
                    counter++;
                }
                else break;
            }
            return counter;
        } catch (IOException ex) {
            Logger.getLogger(SucursalUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static void PayEmployees() throws Exception{
        try {
            Empleado[] empleados = EmployeesUtils.GetEmployees();
            Long total = 0L;
            for (Empleado empleado : empleados){
                if (empleado != null){
                    CuentaBancaria[] cuentas = CuentaUtils.GetCuentasClient(empleado.getID());
                    CuentaBancaria cuenta = cuentas[0];
                    if (empleado instanceof Asesor asesor){
                        cuenta.hacerDeposito(Long.parseLong(asesor.getSueldo().toString().split("\\.")[0]));
                        total += Long.parseLong(asesor.getSueldo().toString().split("\\.")[0]);
                    }
                    else if(empleado instanceof Cajero cajero){
                        cuenta.hacerDeposito(Long.parseLong(cajero.getSueldo().toString().split("\\.")[0]));
                        total += Long.parseLong(cajero.getSueldo().toString().split("\\.")[0]);
                    }
                    else if (empleado instanceof Gerente gerente){
                        cuenta.hacerDeposito(Long.parseLong(gerente.getSueldo().toString().split("\\.")[0]));
                        total += Long.parseLong(gerente.getSueldo().toString().split("\\.")[0]);
                    }
                    CuentaUtils.UpdateCuenta(cuenta);
                }
                else break;
            }
            JOptionPane.showMessageDialog(null, "Se ha pagado un total de $" + total);
        } catch (IOException ex) {
            Logger.getLogger(SucursalUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
