package DAO;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

//     Connection conectar = null;
//     
//     String bd = "postgres";
//     String password = "Marce1995";
//     String ip = "localhost";
//     String usuario = "postgres";
//     String puerto = "5432";
//     
//     String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Marce1995";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);

//     public Connection establecerConexion(){
//          
//         try {
//             Class.forName("org.postgresql.Driver");
//             conectar = DriverManager.getConnection(cadena, usuario, password); 
//             JOptionPane.showMessageDialog(null, "Conexión Exitosa");
//         } catch (SQLException e) {
//             JOptionPane.showMessageDialog(null, "Error");
//         }
//         return conectar;
    }
    }
