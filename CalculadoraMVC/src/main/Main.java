/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controlador.ControladorCalculadora;
import modelo.ModeloCalculadora;
import vista.VistaCalculadora;

/**
 *
 * @author PC GAMING
 */
public class Main {
    public static void main(String[] args) {
        ModeloCalculadora modelo = new ModeloCalculadora();
        VistaCalculadora vista = new VistaCalculadora();
        ControladorCalculadora controlador = new ControladorCalculadora(modelo, vista);
        
        vista.setVisible(true);
    }
}