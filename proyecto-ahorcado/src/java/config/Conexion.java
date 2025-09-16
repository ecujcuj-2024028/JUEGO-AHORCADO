package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static Conexion instancia;
    private Connection conexion;
    
    private Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            String url=("jdbc:mysql://localhost:3306/DB_ahorcado?useSSL=false&sallowPublicKeyRetrieval=true");
            String user="quintom";
            String password ="admin";
            conexion = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException error) {
            StackTraceElement elemento = error.getStackTrace()[0];
            System.out.println("Error en :" + elemento.getClassName()+"linea "+elemento.getLineNumber());
            System.out.println("Mensaje: "+ error.getMessage());
        } catch (SQLException error) {
            StackTraceElement[] elemento = error.getStackTrace();
            System.out.println("Error en: " + elemento[0].getClassName() + " línea " + elemento[0].getLineNumber());
            System.out.println("Mensaje: " + error.getMessage());
        }
    }

    public static synchronized Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/DB_ahorcado?useSSL=false&allowPublicKeyRetrieval=true";
                String user = "quintom";
                String password = "admin";
                conexion = DriverManager.getConnection(url, user, password);
                
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
        }
        return conexion;
    }
    
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
}
