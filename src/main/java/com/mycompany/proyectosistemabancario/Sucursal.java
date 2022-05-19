package com.mycompany.proyectosistemabancario;

import java.io.*;
import java.util.UUID;

import javax.swing.JOptionPane;

import com.mycompany.proyectosistemabancario.empleados.Empleado;
import com.mycompany.proyectosistemabancario.utils.FileUtils;
import com.mycompany.proyectosistemabancario.empleados.Gerente;

public class Sucursal {
	private String ID;
	private String direccion;
	private String gerente;
	private String empleados[];
	// CONSTRUCTOR
	public Sucursal(String direccion, String gerente, String[] empleados) {
		this.ID = UUID.randomUUID().toString();
		this.direccion = direccion;
		this.gerente = gerente;
		this.empleados = new String[10];
	}
	public Sucursal(String ID, String direccion, String gerente, String[] empleados) {
		this.ID = ID;
		this.direccion = direccion;
		this.gerente = gerente;
		this.empleados = new String[10];
	}
	// 
	public void addEmployee(String empleado) throws IOException {
		try {
			String[] cacheEmployees = FileUtils.getEmployees(this.ID);

			for (int i = 0; i <= 10; i++){
				if (cacheEmployees[i] == null){
					cacheEmployees[i] = empleado;
					break;
				}
			}
			
			this.empleados = cacheEmployees;

			FileUtils.saveEmployees(this.empleados, this.ID, this.gerente);

			JOptionPane.showMessageDialog(null, "Empleado guardado correctamente");
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Error al guardar los datos");
		}
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getID() {
		return ID;
	}
}
