/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosistemabancario.utils;

import java.io.*;

import com.mycompany.proyectosistemabancario.Cliente;
import com.mycompany.proyectosistemabancario.CuentaBancaria;

/**
 *
 * @author amuno
 */
public class ClientUtils {
	public static void UpdateClient(Cliente clienteParam) throws IOException{
		Cliente[] clients = GetClients();
		FileWriter fw = new FileWriter("Clientes.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < clients.length; i++){
			if (clients[i] != null){
				if (clients[i].getID().equals(clienteParam.getID())){
					clients[i] = clienteParam;
					break;
				}
			}
		}
		for(int i = 0; i < clients.length; i++){
			if (clients[i] != null){
				bw.write("Cliente");
				bw.newLine();
				bw.write(clients[i].getID());
				bw.newLine();
				bw.write(clients[i].getNombre());
				bw.newLine();
				bw.write(clients[i].getDireccion());
				bw.newLine();
				bw.write(clients[i].getTelefono().toString());
				bw.newLine();
				bw.write(clients[i].getEmail());
				bw.newLine();
				bw.write(clients[i].getRFC());
				bw.newLine();
			}
		}
		bw.close();
	}
	public static Cliente GetClientByID(String ID) throws IOException {
		Cliente cliente = null;
		FileReader fr = new FileReader("Clientes.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		boolean finish = false;
		while (!finish) {
			line = br.readLine();
			if (line == null) {
				finish = true;
			} else if (line.startsWith(ID)) {
				line = br.readLine();
				String nombre = line;
				line = br.readLine();
				String direccion = line;
				line = br.readLine();
				String telefono = line;
				line = br.readLine();
				String email = line;
				line = br.readLine();
				String RFC = line;
                                CuentaBancaria[] cuentas = CuentaUtils.GetCuentasClient(ID);
				cliente = new Cliente(ID, nombre, direccion, Long.parseLong(telefono), email, RFC, cuentas);
				finish = true;
			}
		}
		br.close();
		return cliente;
	}
	public static Cliente[] GetClients() throws IOException {
		Cliente[] clients = new Cliente[10];
		FileReader fr = new FileReader("Clientes.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		boolean finish = false;
		int index = 0;
		String ID = "";
		String name = "";
		String direccion = "";
		Long telefono = 0L;
		String email = "";
		String RFC = "";
		while(!finish){
			line = br.readLine();
			if(line == null){
				finish = true;
			}
			else if(line.startsWith("Cliente")){
				line = br.readLine();
				ID = line;
				line = br.readLine();
				name = line;
				line = br.readLine();
				direccion = line;
				line = br.readLine();
				telefono = Long.parseLong(line);
				line = br.readLine();
				email = line;
				line = br.readLine();
				RFC = line;
				CuentaBancaria[] cuentaCache = CuentaUtils.GetCuentasClient(ID);
				clients[index] = new Cliente(ID, name, direccion, telefono, email, RFC, cuentaCache);
				index++;
			}
		}
		br.close();
		return clients;
	}
	public static void RemoveClient(String ID) throws IOException {
		Cliente[] cacheClients = GetClients();
		FileWriter fw = new FileWriter("Clientes.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		CuentaBancaria[] cuentas = CuentaUtils.GetCuentasClient(ID);
		for (int i = 0; i < cuentas.length; i++){
			if (cuentas[i] != null){
				CuentaUtils.RemoveCuenta(cuentas[i].getNumeroCuenta());
			}
		}
		for(int i = 0; i < cacheClients.length; i++){
			if (cacheClients[i] != null){
				if(!cacheClients[i].getID().equals(ID)){
					bw.write("Cliente");
					bw.newLine();
					bw.write(cacheClients[i].getID());
					bw.newLine();
					bw.write(cacheClients[i].getNombre());
					bw.newLine();
					bw.write(cacheClients[i].getDireccion());
					bw.newLine();
					bw.write(cacheClients[i].getTelefono().toString());
					bw.newLine();
					bw.write(cacheClients[i].getEmail());
					bw.newLine();
					bw.write(cacheClients[i].getRFC());
					bw.newLine();
				}
			}
		}
		bw.close();
	}
	public static void SaveClient(Cliente cliente, String File) throws IOException {
		Cliente[] cacheClients = GetClients();
		FileWriter file = new FileWriter(File);
		BufferedWriter bw = new BufferedWriter(file);
		boolean finish = false;
		int index = 0;
		while(!finish){
			if (cacheClients[index] != null){
				bw.write("Cliente");
				bw.newLine();
				bw.write(cacheClients[index].getID());
				bw.newLine();
				bw.write(cacheClients[index].getNombre());
				bw.newLine();
				bw.write(cacheClients[index].getDireccion());
				bw.newLine();
				bw.write(cacheClients[index].getTelefono().toString());
				bw.newLine();
				bw.write(cacheClients[index].getEmail());
				bw.newLine();
				bw.write(cacheClients[index].getRFC());
				bw.newLine();
			}
			else {
				bw.write("Cliente");
				bw.newLine();
				bw.write(cliente.getID());
				bw.newLine();
				bw.write(cliente.getNombre());
				bw.newLine();
				bw.write(cliente.getDireccion());
				bw.newLine();
				bw.write(cliente.getTelefono().toString());
				bw.newLine();
				bw.write(cliente.getEmail());
				bw.newLine();
				bw.write(cliente.getRFC());
				bw.newLine();
				finish = true;
			}
			index++;
		}
		bw.close();
	}
}
