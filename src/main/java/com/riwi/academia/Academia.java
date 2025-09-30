/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.riwi.academia;

import com.riwi.academia.service.EstudianteService;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author javierariza
 */
public class Academia {
        

    public static void main(String[] args) throws Exception {
        
        System.out.println("Hello World!");
        
        EstudianteService estudianteService=new EstudianteService();
        
        estudianteService.guardarEstudiante();
        
               
        
    }
}



