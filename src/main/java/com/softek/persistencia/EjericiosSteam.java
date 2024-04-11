package com.softek.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EjericiosSteam {
    private Conexion conexion;
    private Scanner scanner;

    public void ConecEjercicios(Conexion conexion) {
        this.conexion = conexion;
        this.scanner = new Scanner(System.in);
    }

    public ResultSet obtenerProductosN() throws Exception {
        System.out.println("Productos de categoria N : ");
        String consulta = "SELECT product_name FROM products WHERE product_name LIKE 'N%'";

        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        ResultSet conectaresul = conec.executeQuery();

        return conectaresul;

    }

    public ResultSet obtenerProductosOrdenados() throws Exception {
        System.out.println("----------------------------------------------------");
        System.out.println("Productos ordenados: ");
        String consulta = "SELECT product_name FROM products ORDER BY product_name ASC";

        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        ResultSet conectaresul = conec.executeQuery();
        return conectaresul;
    }

    public ResultSet obtenermax() throws Exception{
        System.out.println("---------------------------------------------------------------");
        System.out.println("PRODUCTO PRECIO MAX : ");
        String consulta = "SELECT product_name, unit_price FROM products WHERE unit_price = (SELECT MAX(unit_price) FROM products)";
        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        ResultSet conectaresul = conec.executeQuery();
        return conectaresul;
    }

    public ResultSet obtenerAvg() throws Exception{
        System.out.println("---------------------------------------------------------------");
        System.out.println("MEDIA DE LOS PRODUCTOS : ");
        String consulta = "SELECT  avg(unit_price) FROM products ";
        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        ResultSet conectaresul = conec.executeQuery();
        return conectaresul;
    }

    public ResultSet distintasciudades() throws Exception{
        System.out.println("---------------------------------------------------------------");
        System.out.println("MEDIA DE LOS PRODUCTOS : ");
        String consulta = "SELECT DISTINCT city FROM employees";
        PreparedStatement conec = conexion.getConexion().prepareStatement(consulta);
        ResultSet conectaresul = conec.executeQuery();
        return conectaresul;
    }






}
