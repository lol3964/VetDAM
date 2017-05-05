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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pruebaaccesobasedatos.Conexion;

/**
 *
 * @author Ismael
 */
public class operacionesBaseDatos {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        

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
    
       public static void eliminarPersona(String dni) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "DELETE FROM persona WHERE dni=" + "'" + dni + "'";
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

     public static DefaultTableModel verHistorialTotal() throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"Animal", "Veterinario", "Tema", "Fecha", "Descripcion"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        String query = "SELECT idAnimal,veterinario,tema,fecha_anotacion,descripcion FROM anotacionesMedicas";
        ResultSet r = sentencia.executeQuery(query);
        System.out.println(r.toString());
        while (r.next()) {
            fila[0] = r.getString("idAnimal");
            fila[1] = r.getString("veterinario");
            fila[2] = r.getString("tema");
            fila[3] = r.getString("fecha_anotacion");
            fila[4] = r.getString("descripcion");
            dtm.addRow(fila);
        }

        return dtm;
    }

    public static DefaultTableModel verHistorialAnimal(int idAnimal) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"Animal", "Veterinario", "Tema", "Fecha", "Descripcion"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        String query = "SELECT idAnimal,veterinario,tema,fecha_anotacion,descripcion FROM anotacionesMedicas WHERE idAnimal=" + "'" + idAnimal + "'";
        ResultSet r = sentencia.executeQuery(query);
        while (r.next()) {
            fila[0] = r.getString("idAnimal");
            fila[1] = r.getString("veterinario");
            fila[2] = r.getString("tema");
            fila[3] = r.getString("fecha_anotacion");
            fila[4] = r.getString("descripcion");
            dtm.addRow(fila);
        }
        return dtm;
    }
    
    public static DefaultTableModel listarClientes() throws SQLException, ClassNotFoundException{
    Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"DNI", "Nombre", "Direccion", "Telefono", "Email"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        String query = "SELECT * FROM persona where especialidad ="+"'"+ null+"'";
        ResultSet r = sentencia.executeQuery(query);
        System.out.println(r.toString());
        while (r.next()) {
            fila[0] = r.getString("dni");
            fila[1] = r.getString("nombre");
            fila[2] = r.getString("direccion");
            fila[3] = r.getString("telefono");
            fila[4] = r.getString("email");
            dtm.addRow(fila);
        }

        return dtm;
    }
    
      public static DefaultTableModel buscarCliente(String dni ) throws SQLException, ClassNotFoundException{
    Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"DNI", "Nombre", "Direccion", "Telefono", "Email"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        String query = "SELECT * FROM persona where especialidad ="+"'"+ null+"'"+" and dni="+"'"+dni+"'";
        ResultSet r = sentencia.executeQuery(query);
        System.out.println(r.toString());
        while (r.next()) {
            fila[0] = r.getString("dni");
            fila[1] = r.getString("nombre");
            fila[2] = r.getString("direccion");
            fila[3] = r.getString("telefono");
            fila[4] = r.getString("email");
            dtm.addRow(fila);
        }

        return dtm;
    }
      
       public static DefaultTableModel listarVeterinario() throws SQLException, ClassNotFoundException{
    Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"DNI", "Nombre", "Direccion", "Telefono", "Email","Especialidad"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[6];
        String query = "SELECT * FROM persona where especialidad <>"+"'"+ null+"'";
        ResultSet r = sentencia.executeQuery(query);
        System.out.println(r.toString());
        while (r.next()) {
            fila[0] = r.getString("dni");
            fila[1] = r.getString("nombre");
            fila[2] = r.getString("direccion");
            fila[3] = r.getString("telefono");
            fila[4] = r.getString("email");
            fila[5] = r.getString("especialidad");
            dtm.addRow(fila);
        }

        return dtm;
    }
    
    public static DefaultTableModel buscarVeterinario(String dni) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"DNI", "Nombre", "Direccion", "Telefono", "Email", "Especialidad"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        String query = "SELECT * FROM persona where especialidad <>" + "'" + null + "'" + " and dni=" + "'" + dni + "'";
        ResultSet r = sentencia.executeQuery(query);
        System.out.println(r.toString());
        while (r.next()) {
            fila[0] = r.getString("dni");
            fila[1] = r.getString("nombre");
            fila[2] = r.getString("direccion");
            fila[3] = r.getString("telefono");
            fila[4] = r.getString("email");
            fila[5] = r.getString("especialidad");
            dtm.addRow(fila);
        }

        return dtm;
    }
    
    public static DefaultTableModel buscarVeterinarioEspecialidad(String especialidad) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"DNI", "Nombre", "Direccion", "Telefono", "Email", "Especialidad"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        String query = "SELECT * FROM persona where especialidad =" + "'" + especialidad + "'";
        ResultSet r = sentencia.executeQuery(query);
        System.out.println(r.toString());
        while (r.next()) {
            fila[0] = r.getString("dni");
            fila[1] = r.getString("nombre");
            fila[2] = r.getString("direccion");
            fila[3] = r.getString("telefono");
            fila[4] = r.getString("email");
            fila[5] = r.getString("especialidad");
            dtm.addRow(fila);
        }

        return dtm;
    }

    //Métodos realizados por Manuel Lorenzo
    public static void eliminarCita(int idAnimal, int idConsulta, String fecha, String hora) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "DELETE FROM citas WHERE consulta=" + idConsulta + " AND hora_cita='" + hora + "'" + " AND fecha_cita='" + fecha
                + "'" + " AND idAnimal=" + idAnimal;
        System.out.println(query);
        sentencia.executeUpdate(query);
    }

    public static void marcarCitaAtendida(int idAnimal, int idConsulta, String fecha, String hora) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "UPDATE citas SET atendida=true WHERE consulta=" + idConsulta + " AND hora_cita='" + hora + "'" + " AND fecha_cita='" + fecha
                + "'" + " AND idAnimal=" + idAnimal;
        System.out.println(query);
        sentencia.executeUpdate(query);
    }

    public static void listarTodasCitas(JTable tabla) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String titulos[] = {"Consulta", "Animal", "Veterinario", "Servicio", "Fecha", "Hora", "Estado"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        String fila[] = new String[7];
        String query = "SELECT * FROM citas";
        ResultSet r = sentencia.executeQuery(query);
        while (r.next()) {
            fila[0] = r.getString("consulta");
            fila[1] = r.getString("idAnimal");
            fila[2] = r.getString("veterinario");
            fila[3] = r.getString("servicio");
            fila[4] = r.getString("fecha_cita");
            fila[5] = r.getString("hora_cita");
            if (r.getString("atendida").equals("1")) {
                fila[6] = "Atendida";
            } else {
                fila[6] = "Sin atender";
            }
            dtm.addRow(fila);
        }
        tabla.setModel(dtm);
    }

    public static void añadirAnotación(int idAnimal, String veterinario, String descripción, String tema, String fecha) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "INSERT INTO anotacionesMedicas (idAnimal,veterinario,descripcion,tema,fecha_anotacion) VALUES"
                + "(" + idAnimal + ",'" + veterinario + "','" + descripción + "','" + tema + "','" + fecha + "'" + ");";

        System.out.println(query);

        Integer result = sentencia.executeUpdate(query);
    }

    public static void modificarMascota(int idAnimal, String nombre, String raza, float peso, String fecha, String dueño) throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = "UPDATE animal SET nombre=" + "'" + nombre + "'" + " ,raza=" + "'" + raza + "'" + " ,peso=" + peso + " ,fecha_nacimiento=" + "'" + fecha
                + "'" + " ,dueño=" + "'" + dueño + "'" + " WHERE idAnimal=" + idAnimal;
        System.out.println(query);
        sentencia.executeUpdate(query);

    }
    
    
    //METODOS REALIZADOS POR SERGIO--EN REVISION
    //METODO ELIMINAR PERSONA
    public void eliminarPersona(String dni) throws ClassNotFoundException, SQLException{
		Connection c = Conexion.obtener();
		Statement sentencia = c.createStatement();
		String query = "DELETE FROM persona WHERE dni=" + dni;
		System.out.println(query);
		sentencia.executeUpdate(query);
	}
    
    //METODO MODIFICAR CITAS
     public void modificarCitas(int consulta, int idAnimal,String fecha_cita, String hora_cita) throws SQLException, ClassNotFoundException{
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = " UPDATE citas set consulta=" + "'" + consulta + "'" + ",fecha_cita=" + "'" + fecha_cita + "'" + ",hora_cita=" + "'" + hora_cita + "'" + " WHERE idAnimal=" +idAnimal;
        System.out.println(query);
        sentencia.executeUpdate(query);
    } 
    
    //METODO BUSQUEDA DEL HISTORIAL
    //HE REALIZADO TRES METODOS, UNO PARA TEMA, OTRO PARA FECHA Y UNO QUE ENGLOBA LOS DOS
    
    //BUSCAR POR TEMA
    public void buscarhistorial(String tema) throws SQLException, ClassNotFoundException{
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = " SELECT * FROM anotacionesMedicas WHERE tema=" + "'" + tema + "'";
        System.out.println(query);
        sentencia.executeQuery(query);
    }
    
    //BUSCAR POR FECHA
     public void buscarhistorial(String fecha) throws SQLException, ClassNotFoundException{
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = " SELECT * FROM anotacionesMedicas WHERE fecha_anotacion=" + "'" + fecha + "'";
        System.out.println(query);
        sentencia.executeQuery(query);
    }
    
    //AMBOS
    public void buscarhistorial(String fecha, String tema) throws SQLException, ClassNotFoundException{
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
        String query = " SELECT * FROM anotacionesMedicas WHERE fecha_anotacion=" + "'" + fecha + "'" +" AND" + " tema=" +"'" + tema + "'";
        System.out.println(query);
        sentencia.executeQuery(query);
    }
    
    
    
}
