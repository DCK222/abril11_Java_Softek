package com.softek.presentacion;

import com.softek.persistencia.AccesoEmpleados;
import com.softek.persistencia.Conexion;
import com.softek.persistencia.EjericiosSteam;

import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws Exception {
        Conexion conexion = new Conexion();
        conexion.abrirConexion();

        AccesoEmpleados accesoEmpleados = new AccesoEmpleados(conexion);

        // Todos
        ResultSet todosLosEmpleados = accesoEmpleados.obtenerEmpleados();
        while (todosLosEmpleados.next()) {
            String nombre = todosLosEmpleados.getString("first_name");
            String apellido = todosLosEmpleados.getString("last_name");
            String titulo = todosLosEmpleados.getString("title");
            String fechaNacimiento = todosLosEmpleados.getString("birth_date");
            String fechaContratacion = todosLosEmpleados.getString("hire_date");
            String ciudad = todosLosEmpleados.getString("city");

            System.out.println(nombre + " " + apellido + ", " + titulo + ", Nacido el: " + fechaNacimiento + ", Contratado el: " + fechaContratacion + ", Ciudad: " + ciudad);
        }

        // POr id
        int id = 1;
        ResultSet empleadoPorId = accesoEmpleados.obtenerEmpleadoPorId(id);
        if (empleadoPorId.next()) {

            System.out.println(empleadoPorId.getString("first_name") + " " + empleadoPorId.getString("last_name"));
        }

        // Actualizar un empleado
        int idParaActualizar = 2;
       accesoEmpleados.actualizarEmpleado(idParaActualizar, "garcia", "Carlos");

       //Crear Empleado
        accesoEmpleados.crearEmpleado();


        // Eliminar un empleado por ID
       // int idParaEliminar = 5;
       // accesoEmpleados.eliminarEmpleadoPorId(idParaEliminar);

        


    }
}
