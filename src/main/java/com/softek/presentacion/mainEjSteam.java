package com.softek.presentacion;

import com.softek.persistencia.Conexion;
import com.softek.persistencia.EjericiosSteam;

import java.sql.ResultSet;

public class mainEjSteam {
    public static void main(String[] args) throws Exception {

        Conexion conexion = new Conexion();
        conexion.abrirConexion();
        EjericiosSteam ejericiosSteam = new EjericiosSteam();
        ejericiosSteam.ConecEjercicios(conexion);

        ResultSet rsProductosN = ejericiosSteam.obtenerProductosN();
        imprimirResultSet(rsProductosN);

        ResultSet rsProductosOrdenados = ejericiosSteam.obtenerProductosOrdenados();
        imprimirResultSet(rsProductosOrdenados);

        ResultSet productoMaxPrecio = ejericiosSteam.obtenermax();
        imprimirResultSet(productoMaxPrecio);

        ResultSet mediapro = ejericiosSteam.obtenerAvg();
        imprimirResultSet(mediapro);

        ResultSet distintasCiudades = ejericiosSteam.distintasciudades();
        imprimirResultSet(distintasCiudades);

    }

    // Método para imprimir los resultados de un ResultSet
    public static void imprimirResultSet(ResultSet rs) throws Exception {
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
    }



    }

