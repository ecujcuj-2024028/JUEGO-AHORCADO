package controlador;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Palabra;

public class ControladorPalabra {

    public List<Palabra> listarPalabras() {
        System.out.println("Se entró a listar palabras");
        List<Palabra> lista = new ArrayList<>();
        String sql = "call sp_listar_palabras();";
        
        try {
            Conexion conexionInstance = Conexion.getInstancia();
            Connection con = conexionInstance.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                
                System.out.println("Consulta ejecutada, procesando resultados...");
                
                while (rs.next()) {
                    Palabra palabra = new Palabra(
                            rs.getInt("codigo_palabra"),
                            rs.getString("nombre"),
                            rs.getString("pista_1"),
                            rs.getString("pista_2"),
                            rs.getString("pista_3")
                    );
                    lista.add(palabra);
                }
            } catch (SQLException e) {
                System.err.println("ERROR al ejecutar la consulta:");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("ERROR inesperado:");
            e.printStackTrace();
        }
        
        return lista;
    }
}
