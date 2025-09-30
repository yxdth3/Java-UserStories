package com.riwi.academia.domain;


import java.util.Objects;
import java.util.UUID;

public class Estudiante {
    private final String id;
    private String nombre;
    private int edad;

    private Estudiante(String id, String nombre, int edad) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
        if (edad < 16) throw new IllegalArgumentException("Edad mínima 16");
        this.id = Objects.requireNonNull(id);
        this.nombre = nombre;
        this.edad = edad;
    }
    
    
public static Estudiante fromCSV(String linea) throws IllegalArgumentException {
        
    String[] partes = linea.split(",");
        if (partes.length != 6) throw new IllegalArgumentException("Formato incorrecto de CSV");

        try {
            String id = partes[0].trim();
            String nombre = partes[1].trim();
            int edad = Integer.parseInt(partes[2].trim());

     

            return new Estudiante(id, nombre, edad);

        } catch (Exception e) {
            throw new IllegalArgumentException("Datos inválidos en CSV: " + e.getMessage());
        }
    }


    public static Estudiante crear(String nombre, int edad) {
        return new Estudiante(UUID.randomUUID().toString(), nombre, edad);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public void renombrar(String nuevo) {
        if (nuevo == null || nuevo.isBlank()) throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nuevo;
    }
    
}
    
    

    