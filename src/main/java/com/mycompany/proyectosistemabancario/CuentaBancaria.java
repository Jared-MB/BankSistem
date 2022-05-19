package com.mycompany.proyectosistemabancario;

public class CuentaBancaria {
	// ATTRIBUTES
	private String clientID;
	private Double saldo;
	private Long numeroCuenta;
	// CONSTRUCTOR
	public CuentaBancaria(String clientID){
		this.clientID = clientID;
		this.saldo = 0.0;
		this.numeroCuenta = (long) (Math.random() * 1000000000);
	}
	public CuentaBancaria(String clientID, Double saldo, Long numeroCuenta) {
		this.clientID = clientID;
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
	}
	// METHODS
	public String getClientID() {
		return clientID;
	}
	// 
	public Long getNumeroCuenta() {
		return numeroCuenta;
	}
	// 
	public Double getSaldo() {
		return saldo;
	}
	//
	public void hacerDeposito(Long deposito) throws Exception {
		try {
			if (deposito > 0) {
				this.saldo += deposito;
				System.out.println("Deposito realizado correctamente");
			} else {
				throw new Exception("El deposito no puede ser negativo");
			}
		} 
		catch (Exception e) { System.out.println(e.getMessage()); }
	}
	//
	public Long hacerRetiro(Long retiro){
		if (retiro > 0) {
			if (retiro instanceof Long) {
				if (retiro <= this.saldo) {
					this.saldo -= retiro;
					return retiro;
				}
				else {
					System.out.println("Saldo insuficiente");
				}
			}
			else {
				System.out.println("El valor a retirar debe de ser un número entero");
			}
		}
		else if (retiro <= 0){
			System.out.println("Todos los retiros deben de ser mayores a 0");
		}
		return 0L;
	}
}
