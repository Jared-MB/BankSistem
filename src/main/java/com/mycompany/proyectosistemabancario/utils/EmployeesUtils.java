package com.mycompany.proyectosistemabancario.utils;

import java.io.*;

import com.mycompany.proyectosistemabancario.CuentaBancaria;
import com.mycompany.proyectosistemabancario.empleados.Asesor;
import com.mycompany.proyectosistemabancario.empleados.Cajero;
import com.mycompany.proyectosistemabancario.empleados.Empleado;
import com.mycompany.proyectosistemabancario.empleados.Gerente;

public class EmployeesUtils {
	public static void UpdateEmployee(Empleado empleadoParam) throws IOException {
		Empleado[] employees = GetEmployees();
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getID().equals(empleadoParam.getID())) {
				employees[i] = empleadoParam;
				break;
			}
		}
		File file = new File("Empleados.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < employees.length; i++){
			if (employees[i] != null){
				bw.write("Empleado");
				bw.newLine();
				bw.write(employees[i].getID());
				bw.newLine();
				bw.write(employees[i].getNombre());
				bw.newLine();
				bw.write(employees[i].getRFC());
				bw.newLine();
				bw.write(employees[i].getTelefono());
				bw.newLine();
				bw.write(employees[i].getDireccion());
				bw.newLine();
				if (employees[i] instanceof Cajero){
					bw.write("Cajero");
					bw.newLine();
					bw.write(((Cajero)employees[i]).getHoras().toString());
					bw.newLine();
					bw.write(((Cajero) employees[i]).getSueldo().toString());
					bw.newLine();
				}
				else if (employees[i] instanceof Asesor){
					bw.write("Asesor");
					bw.newLine();
					bw.write(((Asesor) employees[i]).getSueldo().toString());
					bw.newLine();
				}
				else if (employees[i] instanceof Gerente){
					bw.write("Gerente");
					bw.newLine();
					bw.write(((Gerente) employees[i]).getSueldo().toString());
					bw.newLine();
				}
			}
			else break;
		}
		bw.close();
	}
	public static Empleado[] GetEmployees() throws IOException {
		Empleado[] employees = new Empleado[50];
		File file = new File("Empleados.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		boolean finish = false;
		int index = 0;
		while (!finish){
			linea = br.readLine();
			if (linea == null) finish = true;
			else if (linea.startsWith("Empleado")){
				linea = br.readLine();
				String ID = linea;
				linea = br.readLine();
				String nombre = linea;
				linea = br.readLine();
				String rfc = linea;
				linea = br.readLine();
				String telefono = linea;
				linea = br.readLine();
				String direccion = linea;
				linea = br.readLine();
				String type = linea;
				linea = br.readLine();
				if (type.startsWith("Cajero")){
					String horas = linea;
					linea = br.readLine();
					String sueldo = linea;
					employees[index] = new Cajero(ID,nombre, rfc, telefono, direccion, Float.parseFloat(sueldo), Integer.parseInt(horas));
				}
				else if (type.startsWith("Asesor")){
					String sueldo = linea;
					employees[index] = new Asesor(ID,nombre, rfc, telefono, direccion, Float.parseFloat(sueldo));
				}
				else if (type.startsWith("Gerente")){
					String sueldo = linea;
					employees[index] = new Gerente(ID,nombre, rfc, telefono, direccion, Float.parseFloat(sueldo));
				}
				index++;
			}
		}
		br.close();
		return employees;
	}
	public static Empleado GetEmployeeByID(String ID){
		Empleado[] employees = null;
		try {
			employees = EmployeesUtils.GetEmployees();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Empleado employee : employees){
			if (employee.getID().equals(ID)){
				return employee;
			}
		}
		return null;
	}
	public static void RemoveEmployee(String ID) throws IOException{
		Empleado[] cacheEmployees = GetEmployees();

		int since = 0;
		for (int i = 0; i < cacheEmployees.length; i++) {
			if(cacheEmployees[i] != null){
				if(cacheEmployees[i].getID().equals(ID)){
					CuentaBancaria[] cuentas = CuentaUtils.GetCuentasClient(ID);
					for (CuentaBancaria cuenta : cuentas){
						CuentaUtils.RemoveCuenta(cuenta.getNumeroCuenta());
					}
					cacheEmployees[i] = null;
					since = i;
					break;
				}
			}
			else break;
		}
		do {
			if (since == cacheEmployees.length - 1) cacheEmployees[since] = null;
			else cacheEmployees[since] = cacheEmployees[since + 1];
			since++;
		} while (cacheEmployees[since] != null);

		File file = new File("Empleados.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < cacheEmployees.length; i++){
			if (cacheEmployees[i] != null){
				bw.write("Empleado");
				bw.newLine();
				bw.write(cacheEmployees[i].getID());
				bw.newLine();
				bw.write(cacheEmployees[i].getNombre());
				bw.newLine();
				bw.write(cacheEmployees[i].getRFC());
				bw.newLine();
				bw.write(cacheEmployees[i].getTelefono());
				bw.newLine();
				bw.write(cacheEmployees[i].getDireccion());
				bw.newLine();
				if (cacheEmployees[i] instanceof Cajero){
					bw.write("Cajero");
					bw.newLine();
					bw.write(((Cajero)cacheEmployees[i]).getHoras().toString());
					bw.newLine();
					bw.write(((Cajero) cacheEmployees[i]).getSueldo().toString());
					bw.newLine();
				}
				else if (cacheEmployees[i] instanceof Asesor){
					bw.write("Asesor");
					bw.newLine();
					bw.write(((Asesor) cacheEmployees[i]).getSueldo().toString());
					bw.newLine();
				}
				else if (cacheEmployees[i] instanceof Gerente){
					bw.write("Gerente");
					bw.newLine();
					bw.write(((Gerente) cacheEmployees[i]).getSueldo().toString());
					bw.newLine();
				}
			}
			else break;
		}
		bw.close();

	}
	public static void SaveEmployee(Empleado empleado) throws IOException {
		Empleado[] cacheEmployees = GetEmployees();
		FileWriter fw = new FileWriter("Empleados.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < cacheEmployees.length; i++){
			if (cacheEmployees[i] != null){
				bw.write("Empleado");
				bw.newLine();
				bw.write(cacheEmployees[i].getID());
				bw.newLine();
				bw.write(cacheEmployees[i].getNombre());
				bw.newLine();
				bw.write(cacheEmployees[i].getRFC());
				bw.newLine();
				bw.write(cacheEmployees[i].getTelefono());
				bw.newLine();
				bw.write(cacheEmployees[i].getDireccion());
				bw.newLine();
				if (cacheEmployees[i] instanceof Cajero){
					bw.write("Cajero");
					bw.newLine();
					bw.write(((Cajero)cacheEmployees[i]).getHoras().toString());
					bw.newLine();
					bw.write(((Cajero) cacheEmployees[i]).getSueldo().toString());
					bw.newLine();
				}
				else if (cacheEmployees[i] instanceof Asesor){
					bw.write("Asesor");
					bw.newLine();
					bw.write(((Asesor) cacheEmployees[i]).getSueldo().toString());
					bw.newLine();
				}
				else if (cacheEmployees[i] instanceof Gerente){
					bw.write("Gerente");
					bw.newLine();
					bw.write(((Gerente) cacheEmployees[i]).getSueldo().toString());
					bw.newLine();
				}
			}
			else {
				bw.write("Empleado");
				bw.newLine();
				bw.write(empleado.getID());
				bw.newLine();
				bw.write(empleado.getNombre());
				bw.newLine();
				bw.write(empleado.getRFC());
				bw.newLine();
				bw.write(empleado.getTelefono());
				bw.newLine();
				bw.write(empleado.getDireccion());
				bw.newLine();
				if (empleado instanceof Cajero){
					bw.write("Cajero");
					bw.newLine();
					bw.write(((Cajero)empleado).getHoras().toString());
					bw.newLine();
					bw.write(((Cajero) empleado).getSueldo().toString());
					bw.newLine();
				}
				else if (empleado instanceof Asesor){
					bw.write("Asesor");
					bw.newLine();
					bw.write(((Asesor) empleado).getSueldo().toString());
					bw.newLine();
				}
				else if (empleado instanceof Gerente){
					bw.write("Gerente");
					bw.newLine();
					bw.write(((Gerente) empleado).getSueldo().toString());
					bw.newLine();
				}
				break;
			}
		}
		bw.close();
	}
}
