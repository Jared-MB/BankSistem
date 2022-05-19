package com.mycompany.proyectosistemabancario;

import java.io.*;
import java.util.UUID;

import javax.swing.JOptionPane;

import com.mycompany.proyectosistemabancario.utils.CuentaUtils;

public class Cliente {
	// ATTRIBUTES
	private String ID;
	private String nombre;
	private String direccion;
	private Long telefono;
	private String email;
	private String RFC;
	private CuentaBancaria cuentas[];
	// CONSTRUCTOR
	public Cliente(String nombre, String direccion, Long telefono, String email, String RFC) {
		this.ID =  UUID.randomUUID().toString();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.RFC = RFC;
		this.cuentas = new CuentaBancaria[5];
	}
	public Cliente(String ID, String nombre, String direccion, Long telefono, String email, String RFC) {
		this.ID = ID;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.RFC = RFC;
		this.cuentas = new CuentaBancaria[5];
	}
	public Cliente(String ID, String nombre, String direccion, Long telefono, String email, String RFC, CuentaBancaria[] cuentas) {
		this.ID = ID;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.RFC = RFC;
		this.cuentas = cuentas;
	}
	// METHODS
	public String getID() {
		return ID;
	}
	// 
	public String getNombre() {
		return nombre;
	}
	// 
	public String getDireccion() {
		return direccion;
	}
	// 
	public Long getTelefono() {
		return telefono;
	}
	// 
	public String getEmail() {
		return email;
	}
	// 
	public String getRFC() {
		return RFC;
	}
	// 
	public CuentaBancaria[] getCuentas() {
		return cuentas;
	}
	// 
	public void setEmail(String email) {
		if (email != "" || email != null) this.email = email; 
		else JOptionPane.showMessageDialog(null, "El email no es un valor aceptable"); 
	}
	// 
	public void setTelefono(Long telefono){
		if (Long.toString(telefono).length() < 9) JOptionPane.showMessageDialog(null, "El telefono no es un valor aceptable"); 
		else this.telefono = telefono; 
	}
	// 
	public void setDireccion(String direccion){
		if (direccion != "" || direccion != null) this.direccion = direccion;
		else JOptionPane.showMessageDialog(null, "La direccion no es un valor aceptable"); 
	}
	// 
	public void addCuentaBancaria() throws Exception {
		CuentaBancaria[] cuentas = CuentaUtils.GetCuentasClient(this.ID);
		this.cuentas = cuentas;
		if (this.cuentas[4] == null){
			CuentaBancaria cuenta = new CuentaBancaria(this.ID);
			CuentaUtils.SaveCuenta(cuenta);
		}
		else throw new Exception("No se pueden agregar mas cuentas");
	}
	public void removeCuentaBancaria(Long numeroCuenta) throws IOException {
		CuentaUtils.RemoveCuenta(numeroCuenta);
	}
}
