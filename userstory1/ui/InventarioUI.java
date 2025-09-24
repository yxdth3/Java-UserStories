/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userstory1.ui;

import com.mycompany.userstory1.domain.Producto;

/*Aquí se maneja toda la interfaz del usuario*/

import javax.swing.*;
import java.util.ArrayList;

public class InventarioUI {

    private ArrayList<Producto> productos = new ArrayList<>();
    private double totalCompras = 0;

    public void iniciar() {
        boolean continuar = true;
        String menu = """
                1. Agregar producto
                2. Ver inventario
                3. Comprar producto
                4. Mostrar estadísticas (precio mínimo y máximo)
                5. Buscar producto por nombre
                6. Salir con ticket final
                """;

        /*Este ciclo while mantiene la vista del menu hasta que el usuario elija la opcion "salir" */
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(menu);
            if (opcion == null) break;
            try {
                switch (Integer.parseInt(opcion)) {
                    case 1 -> agregarProducto();
                    case 2 -> listarInventario();
                    case 3 -> comprarProducto();
                    case 4 -> mostrarEstadisticas();
                    case 5 -> buscarProducto();
                    case 6 -> {
                        JOptionPane.showMessageDialog(null, "Total de compras: $" + totalCompras);
                        continuar = false;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
            /*Este catch valida que el usuario solo pueda ingresar opciones válidas/existentes */
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.");
            }
        }
    }
á
    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        if (nombre == null || nombre.isBlank()) return;
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(null, "El producto ya existe.");
                return;
            }
        }
        try {
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Stock inicial:"));
            productos.add(new Producto(nombre, precio, cantidad));
            JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }

    private void listarInventario() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inventario vacío.");
            return;
        }
        StringBuilder sb = new StringBuilder("Inventario:\n");
        for (Producto p : productos) {
            sb.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void comprarProducto() {
        String nombre = JOptionPane.showInputDialog("Producto a comprar:");
        if (nombre == null) return;
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                try {
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a comprar:"));
                    if (cantidad <= 0 || cantidad > p.getStock()) {
                        JOptionPane.showMessageDialog(null, "Stock insuficiente.");
                        return;
                    }
                    p.setStock(p.getStock() - cantidad);
                    double total = p.getPrecio() * cantidad;
                    totalCompras += total;
                    JOptionPane.showMessageDialog(null, "Compra realizada. Total: $" + total);
                    return;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
    }

    private void mostrarEstadisticas() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }
        Producto min = productos.get(0), max = productos.get(0);
        for (Producto p : productos) {
            if (p.getPrecio() < min.getPrecio()) min = p;
            if (p.getPrecio() > max.getPrecio()) max = p;
        }
        JOptionPane.showMessageDialog(null, 
                "Más barato: " + min + "\nMás caro: " + max);
    }

    private void buscarProducto() {
        String busqueda = JOptionPane.showInputDialog("Buscar producto por nombre:");
        if (busqueda == null || busqueda.isBlank()) return;
        StringBuilder sb = new StringBuilder("Resultados:\n");
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                sb.append(p).append("\n");
            }
        }
        if (sb.toString().equals("Resultados:\n")) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
        } else {
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}