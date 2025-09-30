/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riwi.academia.service;

import com.riwi.academia.db.EstudianteDAO;
import com.riwi.academia.domain.Estudiante;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author javierariza
 */
public class EstudianteService {
    
    
    
    
    public void guardarEstudiante() throws Exception{
        
  
            
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre");
        Integer edad= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
        
        
       Estudiante estudiante= Estudiante.crear(nombre, edad);
       EstudianteDAO.guardarEstudiante(estudiante);
       
       
       
        System.out.println("com.riwi.academia.service.EstudianteService.guardarEstudiante()"+estudiante.toString());

          
           
        
    }
    
}
