package com.mycompany.proyectosistemabancario.utils;

import com.mycompany.proyectosistemabancario.CuentaBancaria;

import java.io.*;	

public class CuentaUtils {
	public static CuentaBancaria[] GetCuentas() throws IOException{
		CuentaBancaria[] cacheCuentas = new CuentaBancaria[50];
		FileReader fr = new FileReader("Cuentas.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		boolean finish = false;
		int index = 0;
		String ID = "";
		String cuenta = "";
		String saldo = "";
		while(!finish){
			line = br.readLine();
			if(line == null){
				finish = true;
			}
			else if(line.startsWith("Cuenta")){
				line = br.readLine();
				ID = line;
				line = br.readLine();
				cuenta = line;
				line = br.readLine();
				saldo = line;
				cacheCuentas[index] = new CuentaBancaria(ID, Double.parseDouble(saldo), Long.parseLong(cuenta));
				index++;
			}
		}
		br.close();
		return cacheCuentas;
	}	
	public static CuentaBancaria[] GetCuentasClient(String ID) throws IOException {
		CuentaBancaria[] cacheCuentas = new CuentaBancaria[5];
		FileReader fr = new FileReader("Cuentas.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		boolean finish = false;
		int index = 0;
		Double saldo = 0D;
		Long numeroCuenta = 0L;
		while(!finish){
			line = br.readLine();
			if(line == null){
				finish = true;
			}
			else if(line.startsWith(ID)){
				line = br.readLine();
				numeroCuenta = Long.parseLong(line);
				line = br.readLine();
				saldo = Double.parseDouble(line);
				cacheCuentas[index] = new CuentaBancaria(ID, saldo, numeroCuenta);
				index++;
			}
		}
		br.close();
		return cacheCuentas;
	}
	public static void SaveCuenta(CuentaBancaria cuenta) throws IOException {
		CuentaBancaria[] cacheCuentas = GetCuentas();
		FileWriter fw = new FileWriter("Cuentas.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i < cacheCuentas.length; i++){
			if(cacheCuentas[i] != null){
				bw.write("Cuenta");
				bw.newLine();
				bw.write(cacheCuentas[i].getClientID());
				bw.newLine();
				bw.write(cacheCuentas[i].getNumeroCuenta().toString());
				bw.newLine();
				bw.write(cacheCuentas[i].getSaldo().toString());
				bw.newLine();
			}
			else break;
		}
		bw.write("Cuenta");
		bw.newLine();
		bw.write(cuenta.getClientID());
		bw.newLine();
		bw.write(cuenta.getNumeroCuenta().toString());
		bw.newLine();
		bw.write(cuenta.getSaldo().toString());
		bw.close();
	}
	public static void RemoveCuenta(Long numeroCuenta) throws IOException {
		if (!(numeroCuenta instanceof Long)) throw new IllegalArgumentException("El numero de cuenta no es valido");
		CuentaBancaria[] cacheCuentas = GetCuentas();
		int since = 0;
		for (int i = 0; i < cacheCuentas.length; i++) {
			if(cacheCuentas[i] != null){
				if(cacheCuentas[i].getNumeroCuenta().equals(numeroCuenta)){
					cacheCuentas[i] = null;
					since = i;
					break;
				}
			}
			else break;
		}
		do {
			if (since == cacheCuentas.length - 1) cacheCuentas[since] = null;
			else cacheCuentas[since] = cacheCuentas[since + 1];
			since++;
		} while (cacheCuentas[since] != null);

		FileWriter fw = new FileWriter("Cuentas.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i < cacheCuentas.length; i++){
			if(cacheCuentas[i] != null){
				bw.write("Cuenta");
				bw.newLine();
				bw.write(cacheCuentas[i].getClientID());
				bw.newLine();
				bw.write(cacheCuentas[i].getNumeroCuenta().toString());
				bw.newLine();
				bw.write(cacheCuentas[i].getSaldo().toString());
				bw.newLine();
			}
			else break;
		}
		bw.close();
	}
}
