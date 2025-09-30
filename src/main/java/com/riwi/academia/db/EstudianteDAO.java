
package com.riwi.academia.db;
import com.riwi.academia.domain.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EstudianteDAO {
    public static void guardarEstudiante (Estudiante estudiante) throws Exception{
    
        String sql="INSERT INTO estudiante (nombre, edad) VALUES (?,?)";
        
        try (Connection conn= ConnectionDB.getConexion();
        
        PreparedStatement ps= conn.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS)){
        ps.setString(1, estudiante.getNombre());
        ps.setInt(2, estudiante.getEdad());
        
        ps.executeUpdate();
        
        }
    }
    
    public static void eliminarEstudiante (Estudiante estudiante) throws Exception{
    
        String sql="DELETE FROM academia WHERE estudiante (nombre, edad) VALUES (?,?)";
        
        try (Connection conn= ConnectionDB.getConexion();
        
        PreparedStatement ps= conn.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS)){
        ps.setString(1, estudiante.getNombre());
        ps.setInt(2, estudiante.getEdad());
        
        ps.executeUpdate();
        
        }
    }
}
