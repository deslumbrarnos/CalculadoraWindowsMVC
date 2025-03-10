/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloCalculadora;
import vista.VistaCalculadora;

/**
 *
 * @author PC GAMING
 */
public class ControladorCalculadora {
    
    private ModeloCalculadora modelo;
    private VistaCalculadora vista;
    
    public ControladorCalculadora(ModeloCalculadora modelo, VistaCalculadora vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        // Agregamos listeners a los botoncitos
        this.vista.btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                sumar();
            }
        });
        
        this.vista.btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                restar();
            }
        });
    }
    
    private void sumar() {
        int num1 = Integer.parseInt(vista.txtNumero1.getText());
        int num2 = Integer.parseInt(vista.txtNumero2.getText());
        int resultado = modelo.sumar(num1, num2);
        vista.txtResultado.setText("Resultado: " + resultado);
    }
    
    private void restar() {
        int num1 = Integer.parseInt(vista.txtNumero1.getText());
        int num2 = Integer.parseInt(vista.txtNumero2.getText());
        int resultado = modelo.restar(num1, num2);
        vista.txtResultado.setText("Resultado: " + resultado);
    }
}
