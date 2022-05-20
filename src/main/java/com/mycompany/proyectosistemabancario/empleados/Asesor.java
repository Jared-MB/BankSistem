package com.mycompany.proyectosistemabancario.empleados;

import com.mycompany.proyectosistemabancario.utils.FileUtils;
import javax.swing.JOptionPane;
import com.mycompany.proyectosistemabancario.Cliente;

import java.io.*;

public class Asesor extends Empleado {
    private Float sueldo;
    private String clientes[] = new String[10];
    //CONSTRUCTOR
    public Asesor (String nombre, String rfc, String telefono, String direccion,  Float sueldo){
        super(nombre, rfc, telefono, direccion);
        this.sueldo = sueldo;
    }
    public Asesor (String ID, String nombre, String rfc, String telefono, String direccion,  Float sueldo){
        super(ID, nombre, rfc, telefono, direccion);
        this.sueldo = sueldo;
    }
	// METHODS
    public Float getSueldo() {
        return sueldo;
    }
    //
    public void setSueldo(Float sueldo){
        try {
            if (sueldo != null){
                this.sueldo = sueldo;
            } 
            else {
                throw new Exception("El sueldo no es un valor aceptable");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //
    public void addClients(Cliente cliente) throws IOException{
        String cacheClients[] = new String[10];
        try {
            cacheClients = FileUtils.getAsesorClients();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally {
            try {
                for (int i = 0; i <= cacheClients.length; i++) {
                    if (cacheClients[i] == null) {
                        cacheClients[i] = cliente.getID();
                        JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
                        break;
                    }
                    if (i == 9 && cacheClients[9] != null) throw new Exception("El asesor ya tiene 10 clientes");
                }
                this.clientes = cacheClients;
                saveClients();
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    // 
    public void removeClient(String id) throws IOException {
        try {
            String cacheClients[] = FileUtils.getAsesorClients();
            int since = -1;
            for (int i = 0; i < cacheClients.length; i++){
                if (cacheClients[i] != null){
                    if (cacheClients[i].startsWith(id)){
                        cacheClients[i] = null;
                        since = i;
                        break;
                    }
                }
                else break;
            }
            if (since >= 0){
                for (int i = since; i < cacheClients.length - 1; i++){
                    cacheClients[i] = cacheClients[i + 1];
                    cacheClients[i + 1] = null;
                }
            }
            else throw new Exception("El cliente no existe");
            this.clientes = cacheClients;
            saveClients();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // 
    public void saveClients() throws IOException {
        try {
            FileWriter fw = new FileWriter("AsesorClientes.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Asesor");
            bw.newLine();
            bw.write(this.getRFC());
            bw.newLine();
            bw.write("Clientes");
            bw.newLine();
            for (int i = 0; i < this.clientes.length; i++){
                if (this.clientes[i] != null){
                    bw.write(this.clientes[i]);
                    bw.newLine();
                }
            }
            bw.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al guardar los datos");
        }
    }
}
