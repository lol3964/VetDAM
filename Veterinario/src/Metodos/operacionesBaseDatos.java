/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pruebaaccesobasedatos.Conexion;

/**
 *
 * @author Daniel
 */
public class operacionesBaseDatos {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        añadirPersona("49132925A", "Ismael", "calle doctor", "692701170", "isma@gmail.com", "", "1234", false);
        añadirPersona("11111111A", "Laura", "calle antioquia", "666555444", "laur@gmail.com", "doctora", "1234", true);
        añadirAnimal(1, "yanko", "mestizo", 30.5, "2015-05-26", "49132925A");
        añadirCita(1, 1, "11111111A", "Revision", "2017/05/29", "13:30", false);

    }

    public static void añadirAnimal(int id, String nombre, String raza, double peso, String fecha_nacimiento, String dueño) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "INSERT INTO animal (idAnimal,nombre,raza,peso,fecha_nacimiento,dueño) VALUES"
                + "(" + id + ",'" + nombre + "','" + raza + "','" + peso + "','" + fecha_nacimiento + "','" + dueño + "');";

        System.out.println(query);

        Integer result = sentencia.executeUpdate(query);
    }

    public static void añadirPersona(String dni, String nombre, String direccion, String telefono, String email, String especialidad, String contraseña, boolean admin) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "INSERT INTO persona (dni,nombre,direccion,telefono,email,especialidad,contraseña,admin) VALUES"
                + "('" + dni + "','" + nombre + "','" + direccion + "','" + telefono + "','" + email + "','" + especialidad + "','" + contraseña + "'," + admin + ");";

        System.out.println(query);

        Integer result = sentencia.executeUpdate(query);
    }

    public static void añadirCita(int consulta, int idAnimal, String veterinario, String servicio, String fecha_cita, String hora_cita, boolean atendida) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "INSERT INTO citas (consulta,idAnimal,veterinario,servicio,fecha_cita,hora_cita,atendida) VALUES"
                + "(" + consulta + "," + idAnimal + ",'" + veterinario + "','" + servicio + "','" + fecha_cita + "','" + hora_cita + "'," + atendida + ");";

        System.out.println(query);

        Integer result = sentencia.executeUpdate(query);
        query = "UPDATE horarios SET ocupada=1 WHERE fecha_cita=" + "'" + fecha_cita + "'" + " AND " + " hora_cita=" + "'" + hora_cita + "'" + " and " + " consulta=" + 1;
        System.out.println(query);
        sentencia.executeUpdate(query);
    }

    public static void eliminarAnimal(int idAnimal) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "DELETE FROM animal WHERE idAnimal=" + idAnimal;
        System.out.println(query);
        sentencia.executeUpdate(query);
    }

    public static void modificarPersona(String dni, String nombre, String direccion, String telefono, String email, String especialidad, String contraseña, boolean admin) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "UPDATE FROM personas SET nombre=" + "'" + nombre + "'" + " ,direccion=" + "'" + direccion + "'" + " ,telefono=" + "'" + telefono + "'" + " ,email=" + "'" + email + "'" + " ,especialidad=" + "'" + especialidad + "'" + " ,contraseña" + " ,admin=" + admin + "WHERE dni=" + "'" + dni + "'";
        System.out.println(query);
        sentencia.executeUpdate(query);

    }

    public static void verHistorialTotal(JTable tabla) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"Animal", "Veterinario", "Tema", "Fecha", "Descripcion"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        String query = "SELECT idAnimal,veterianrio,tema,fecha,descripcion FROM anotacionesMedicas";
        ResultSet r = sentencia.executeQuery(query);
        while (r.next()) {
            fila[0] = r.getString("idAnimal");
            fila[1] = r.getString("veterianrio");
            fila[2] = r.getString("tema");
            fila[3] = r.getString("fecha");
            fila[4] = r.getString("descripcion");
            dtm.addRow(fila);
        }
        tabla.setModel(dtm);
    }

    public static void verHistorialAnimal(int idAnimal, JTable tabla) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"Animal", "Veterinario", "Tema", "Fecha", "Descripcion"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        String query = "SELECT idAnimal,veterianrio,tema,fecha,descripcion FROM anotacionesMedicas WHERE idAnimal=" + "'" + idAnimal + "'";
        ResultSet r = sentencia.executeQuery(query);
        while (r.next()) {
            fila[0] = r.getString("idAnimal");
            fila[1] = r.getString("veterianrio");
            fila[2] = r.getString("tema");
            fila[3] = r.getString("fecha");
            fila[4] = r.getString("descripcion");
            dtm.addRow(fila);
        }
        tabla.setModel(dtm);
    }
}
