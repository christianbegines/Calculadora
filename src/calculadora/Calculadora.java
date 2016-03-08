/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author daw1
 */
public class Calculadora extends JFrame {

    private JButton suma;
    private JButton resta,porcentaje;
    private JButton division,factorial;
    private JButton multiplicar,potencia;
    private Container panelOperandos, panelOperaciones, panelResultado,panelResultados;
    private JLabel o1, o2, r;
    private JTextField operando1, operando2, resultado;
    private int i=0;
    CalculadoraInterna calculador;
    public Calculadora() {
        super("Calculadora");
        calculador= new CalculadoraInterna();       
        setSize(600, 300);
        this.setLayout(new GridLayout(3, 1));
        
        this.panelOperandos = new JPanel();
        this.panelOperaciones = new JPanel();
        this.panelResultado = new JPanel();
        this.panelResultado= new JPanel();

        panelOperandos.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 20));
        panelOperaciones.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 50));
        panelResultado.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 50));
        //panelResultados.setLayout(new FlowLayout(FlowLayout.LEFT,60,50));

        this.add(panelOperandos);
        this.add(panelOperaciones);
        this.add(panelResultado);
       
        suma = new JButton("Suma");
        resta = new JButton("Resta");
        division = new JButton("Dividir");
        multiplicar = new JButton("Multiplicar");
        operando1 = new JTextField(7);
        operando2 = new JTextField(7);
        resultado = new JTextField(7);

        o1 = new JLabel("Operando 1");
        o2 = new JLabel("Operando 2");
        r = new JLabel("Resultado");
        resultado.setEnabled(false);
        
        suma.addActionListener(new HacerOperaciones());
        resta.addActionListener(new HacerOperaciones());
        multiplicar.addActionListener(new HacerOperaciones());
        division.addActionListener(new HacerOperaciones());
        
        
        suma.setActionCommand("S");
        resta.setActionCommand("R");
        division.setActionCommand("D");
        multiplicar.setActionCommand("M");

        panelOperandos.add(o1);
        panelOperandos.add(operando1);
        panelOperandos.add(o2);
        panelOperandos.add(operando2);
        panelOperaciones.add(suma);
        panelOperaciones.add(resta);
        panelOperaciones.add(multiplicar);
        panelOperaciones.add(division);

        panelResultado.add(r);
        panelResultado.add(resultado);

        setVisible(true);

    }

    class HacerOperaciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                                           
            String s = (String) e.getActionCommand();
            String op1=operando1.getText();
            String op2= operando2.getText();
            double valor =0;
            if (s.equals("S")) {
                valor=calculador.Sumar(op1,op2);
            }
            if (s.equals("R")) {
                valor=calculador.Restar(op1,op2);
            }
            if (s.equals("D")) {
                valor=calculador.Dividir(op1,op2);
            }
            if (s.equals("M")) {
               valor=calculador.Multiplicar(op1, op2);
            }
            resultado.setEnabled(true);
            resultado.setText(Double.toString(valor));
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Calculadora calc = new Calculadora();
    }

}
