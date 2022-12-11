package Conexion;
import java.sql.*;

public class Conexion {
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facepass_2.0","root","");
            System.out.println("Connected");
            return cn;
        }catch(SQLException e){
            System.out.println("Error en la conexión local " + e); 
        }
        return(null);
    }
}