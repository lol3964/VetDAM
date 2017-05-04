/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inserthorarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pruebaaccesobasedatos.Conexion;

/**
 *
 * @author Daniel
 */
public class claseIngresarFechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        insertarDatos();
         // borrarDatos();
    }
    
    private static void borrarDatos() throws SQLException, ClassNotFoundException{
         Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();
       String query = "DELETE FROM horarios WHERE 1";
       sentencia.executeUpdate(query);
    }

    private static void insertarDatos() throws SQLException, ClassNotFoundException {
        Connection c = Conexion.obtener();
        Statement sentencia = c.createStatement();

        String[] listaHoras = {"9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30",
            "14:30", "15:00", "15:30", "16:00"};
        String[] listaHorasFestivos = {"9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00"};
        ArrayList<String> listaFestivos = new ArrayList<String>();
        listaFestivos.add("2017-04-26");
        listaFestivos.add("2017-02-28");
        listaFestivos.add("2017-05-01");
        listaFestivos.add("2018-04-26");

        Integer year;
        int contadorFestivos = 0;
        int contadorNormales = 0;
        String query = "INSERT INTO horarios (consulta,fecha_cita,hora_cita) VALUES";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (LocalDate.now().isLeapYear()) {
            year = 366;
        } else {
            year = 365;
        }
        for (int j = 1; j <= 2; j++) {
            for (int i = 0; i <= year; i++) {
                String day = LocalDate.now().plusDays(i).format(df);
                if (listaFestivos.contains(day)) {
                    //System.out.println("FESTIVO: " + day);
                    contadorFestivos = 0;
                    for (String hour : listaHorasFestivos) {
                        contadorFestivos++;
                        //TODO Concatenar los datos a un String con la query para el insert
                        if (i != year) {
                            query = query.concat("(" + j + ",'" + day + "','" + hour + "'),\n");
                        } else {
                            if (contadorFestivos == listaHorasFestivos.length && j == 2) {
                                query = query.concat("(" + j + ",'" + day + "','" + hour + "')\n");
                            } else {
                                query = query.concat("(" + j + ",'" + day + "','" + hour + "'),\n");
                            }
                        }
                        //System.out.println("Insertamos hora para día festivo: " + hour);
                    }
                } else {
                    //System.out.println("NO FESTIVO: " + day);
                    contadorNormales = 0;
                    for (String hour : listaHoras) {
                        contadorNormales++;
                        //TODO Concatenar los datos a un String con la query para el insert
                        //System.out.println("Insertamos hora para día normal: " + hour);
                        if (i != year) {
                            query = query.concat("(" + j + ",'" + day + "','" + hour + "'),\n");
                        } else {
                            if (contadorNormales == listaHoras.length && j == 2) {
                                query = query.concat("(" + j + ",'" + day + "','" + hour + "')\n");
                            } else {
                                query = query.concat("(" + j + ",'" + day + "','" + hour + "'),\n");
                            }
                        }

                    }
                }
            }
        }
        query = query.concat(";");

        System.out.println(query);

        Integer result = sentencia.executeUpdate(query);

        //TODO Realizar query concatenada contra la BD
        //System.out.println("El año tiene " + year + " días");
        System.out.println(result);
    }
}
