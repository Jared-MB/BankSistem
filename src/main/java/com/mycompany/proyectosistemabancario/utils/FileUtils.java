package com.mycompany.proyectosistemabancario.utils;

import java.io.*;

import javax.swing.JOptionPane;

public class FileUtils {
	public static String[] getAsesorClients() throws IOException{
        FileReader file = new FileReader("AsesorClientes.txt");
        BufferedReader br = new BufferedReader(file);
        String line;
        boolean finish = false;
        String cacheClients[] = new String[10];
        while (!finish){
            line = br.readLine();
            if (line == null) finish = true;
            else {
                if (line.startsWith("Asesor")){
                    line = br.readLine();
                    line = br.readLine();
                    for (int index = 0; index <= 9; index++){
                        line = br.readLine();
                        if (line != null){
                            if (line.startsWith("Asesor")){
                                finish = true;
                                break;
                            }
                            else {
                                cacheClients[index] = line;
                            }
                        }
                    }
                }
            }
        }
        file.close();
        br.close();
		return cacheClients;
    }
    public static String[] getEmployees(String sucursalID) throws IOException {

        String[] employees  = new String[10];

        FileReader fr = new FileReader("SucursalEmployees.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String Sucursal = "";
        boolean finish = false;
        String line;
        
        while (!finish){
            line = br.readLine();
            if (line == null){
                finish = true;
            }
            else if (line.startsWith("Sucursal")){
                line = br.readLine();
                Sucursal = line;
            }
            else if (line.startsWith("Empleados")){

                boolean read = true;
                int index = 0;
                
                do {
                    line = br.readLine();
                    if (line == null || line.startsWith("Sucursal")){
                        read = false;
                        finish = true;
                    }
                    else {
                        employees[index] = line;
                        index++;
                    }
                } while (read);
            }
        }
        br.close();
        return employees;
    }
    public static void saveEmployees(String[] employees, String sucursal, String gerente) throws IOException {
        try {
            FileWriter writer = new FileWriter("SucursalEmployees.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Sucursal");
            bw.newLine();
            bw.write(sucursal);
            bw.newLine();
            bw.write("Gerente");
            bw.newLine();
            bw.write(gerente);
            bw.newLine();
            bw.write("Empleados");
            bw.newLine();
            for (int i = 0; i <= employees.length; i++){
                if (employees[i] != null){
                    bw.write(employees[i]);
                    bw.newLine();
                }
                else {
                    break;
                }
            }
            bw.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error: El archivo no se ha podido guardar");
        }
    }
}

