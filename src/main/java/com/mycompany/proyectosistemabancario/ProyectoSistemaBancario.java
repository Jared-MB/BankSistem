/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectosistemabancario;

import com.mycompany.proyectosistemabancario.empleados.Asesor;
import com.mycompany.proyectosistemabancario.empleados.Cajero;
import com.mycompany.proyectosistemabancario.empleados.Empleado;
import com.mycompany.proyectosistemabancario.empleados.Gerente;
import com.mycompany.proyectosistemabancario.utils.ClientUtils;
import com.mycompany.proyectosistemabancario.utils.CuentaUtils;
import com.mycompany.proyectosistemabancario.utils.EmployeesUtils;
import com.mycompany.proyectosistemabancario.Main;
/**
 *
 * @author amuno
 */
public class ProyectoSistemaBancario {

    public static void main(String[] args) throws Exception{
		new Main().setVisible(true);
                //Empleado empleado1 = new Empleado("John", "4JD02A", "204MD2M");
		//Gerente gerente1 = new Gerente("John", "4JD02A", "204MD2", 15000.00 );
		//Sucursal sucursal1 = new Sucursal("Sur 3", gerente1.getID(), new String[10]);
		//sucursal1.addEmployee(empleado1.getID());
		// Cliente cliente1 = new Cliente("Pedro", "Calle 1", (long)987654321, "email@emial.com", "2DS344");
		// // Cliente cliente2 = new Cliente("Jose", "Calle 3", (long)693454321, "email@email2.com", "394DDSD");
		// Asesor asesor1 = new Asesor("John", "S9D9",(float) 10000, "ABC1AAS23");
		// asesor1.addClients(cliente1);

		// asesor1.addClients(cliente2);
		// asesor1.saveClients();
		// asesor1.removeClient("d8c44824-bcb5-43d0-b704-46c8f98b0864");

		// Cliente cliente = new Cliente("Jonh Doe", "Calle Poniente 2", (long)728234432, "email@al", "SKDMLWSDLD");
		// ClientUtils.SaveClient(cliente);
		// Cliente[] clients = ClientUtils.GetClients();
		// try {
		// 	clients[1].removeCuentaBancaria(clients[1].getCuentas()[0].getNumeroCuenta());
		// }
		// catch (IllegalArgumentException e) {
		// 	System.out.println(e.getMessage());
		// }
		// catch (Exception e) {
		// 	System.out.println(e.getMessage());
		// }
		// Cliente cliente = new Cliente("Pedro", "Calle 2", (long)923654321, "email2", "KSMDSD");
		// CuentaBancaria cuenta = new CuentaBancaria(cliente.getID());
		// cliente.addCuentaBancaria(cuenta);
		// CuentaUtils.SaveCuenta(cuenta);
		// ClientUtils.SaveClient(cliente);
		// Cliente cliente = ClientUtils.GetClientByID("186605b3-65e2-4aed-a643-8f8283dad1e5");
		// System.out.println(cliente.getNombre());
		// * UPDATE CLIENT
		// Cliente cliente = new Cliente("f7bc27bd-be34-4712-a6f8-5ed3638e39bc", "Angel Jared", "Sur 1",(long) 98876554, "angel@gmail.com", "UN3OFA");
		// ClientUtils.UpdateClient(cliente);

		// * REMOVE CLIENT
		// ClientUtils.RemoveClient("186605b3-65e2-4aed-a643-8f8283dad1e5");

		// * ADD EMPLOYEE
		// ? CAJERO
		// Cajero cajero = new Cajero("Doe", "AAP20AD", "2342344123", "Sur 2",(float) 6000.00, 8 );
		// EmployeesUtils.SaveEmployee(cajero);
		// ? GERENTE
		// Gerente gerente = new Gerente("John", "FEW3434", "23246752234", "Sur 4", 16000.00 );
		// EmployeesUtils.SaveEmployee(gerente);
		// ? ASESOR
		// Asesor asesor = new Asesor("Juan", "SDK2323", "214332342", "Oriente 15", (float) 10000);
		// EmployeesUtils.SaveEmployee(asesor);

		// * REMOVE EMPLOYEE
		// EmployeesUtils.RemoveEmployee("6b8d3c35-6a50-4500-8a52-8d6f55381a0d");

		// * GET EMPLOYEE
		// Empleado empleado = EmployeesUtils.GetEmployeeByID("6b8d3c35-6a50-4500-8a52-8d6f55381a0d");
		// System.out.println(empleado.getNombre());

		// * UPDATE EMPLOYEE
		// Empleado empleado = new Asesor("79bbf1d4-8597-432a-ad8b-5d708496b46c", "Juan", "SDK2323", "214332342", "Norte 1",(float) 10000.0);
		// EmployeesUtils.UpdateEmployee(empleado);
	}
}
