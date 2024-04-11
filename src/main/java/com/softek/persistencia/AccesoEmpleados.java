package com.softek.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AccesoEmpleados {

    private Conexion conexion;
    private Scanner scanner;

    public AccesoEmpleados(Conexion conexion) {
        this.conexion = conexion;
        this.scanner = new Scanner(System.in);
    }


    public ResultSet obtenerEmpleados() throws Exception {
        System.out.println("Empleados : ");
        String consulta = "SELECT * FROM employees";
        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        ResultSet conectarresu = conec.executeQuery();
        return conectarresu;
    }


    public ResultSet obtenerEmpleadoPorId(int id) throws Exception {
        System.out.println("Empleado por id :");
        String consulta = "SELECT * FROM employees WHERE employee_id = ?";
        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        conec.setInt(1, id);
        return conec.executeQuery();
    }


    public void actualizarEmpleado(int id, String lastName, String firstName) throws Exception {
        String consulta = "UPDATE employees SET last_name = ?, first_name = ? WHERE employee_id = ?";
        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        conec.setString(1, lastName);
        conec.setString(2, firstName);
        conec.setInt(3, id);
        conec.executeUpdate();
        System.out.println("Empleado Actualizado");
    }

    public void crearEmpleado() throws Exception {
        System.out.println("Ingrese los datos del nuevo empleado:");

        System.out.println("Introduce el id : ");
        int id = scanner.nextInt();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();


        String consulta = "INSERT INTO employees (employee_id, last_name, first_name, title, title_of_courtesy, birth_date, hire_date, address, city, region, postal_code, country, home_phone, extension, photo, notes, reports_to, photo_path) VALUES (? ,?, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)";

        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);


        conec.setInt(1,id);
        conec.setString(2, apellido);
        conec.setString(3, nombre);

        conec.executeUpdate();
        System.out.println("Empleado creado XD");
    }



    public void eliminarEmpleadoPorId(int id) throws Exception {
        String consulta = "DELETE FROM employees WHERE employee_id = ?";
        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        conec.setInt(1, id);
        conec.executeUpdate();
    }




}
