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
    private JButton resta, porcentaje;
    private JButton division, factorial;
    private JButton multiplicar, potencia;
    private Container panelOperandos, panelOperaciones1, panelResultado, panelResultados, panelOperaciones2, panelArea;
    private JLabel o1, o2, r, operaciones;
    private JTextField operando1, operando2, resultado;
    CalculadoraInterna calculador;
    private JTextArea resultados;
    int contadorOperaciones=0;

    public Calculadora() {
        super("Calculadora");
        calculador = new CalculadoraInterna();
        setSize(700, 700);
        this.setLayout(new GridLayout(5, 1));

        this.panelOperandos = new JPanel();
        this.panelOperaciones1 = new JPanel();
        this.panelOperaciones2 = new JPanel();
        this.panelResultado = new JPanel();
        this.panelResultados = new JPanel();

        panelOperandos.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 20));
        panelOperaciones1.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 50));
        panelOperaciones2.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 50));
        panelResultado.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 20));
        panelResultados.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 30));

        this.add(panelOperandos);
        this.add(panelOperaciones1);
        this.add(panelOperaciones2);
        this.add(panelResultado);

        suma = new JButton("Suma");
        resta = new JButton("Resta");
        division = new JButton("Dividir");
        multiplicar = new JButton("Multiplicar");
        potencia = new JButton("Potencia");
        porcentaje = new JButton("Porcentaje");
        factorial = new JButton("Factorial");
        resultados = new JTextArea(10, 10);

        operando1 = new JTextField(7);
        operando2 = new JTextField(7);
        resultado = new JTextField(7);

        o1 = new JLabel("Operando 1");
        o2 = new JLabel("Operando 2");
        r = new JLabel("Resultado");
        operaciones = new JLabel("Operaciones");
        resultado.setEnabled(false);

        suma.addActionListener(new HacerOperaciones());
        resta.addActionListener(new HacerOperaciones());
        multiplicar.addActionListener(new HacerOperaciones());
        division.addActionListener(new HacerOperaciones());
        potencia.addActionListener(new HacerOperaciones());
        porcentaje.addActionListener(new HacerOperaciones());
        factorial.addActionListener(new HacerOperaciones());

        suma.setActionCommand("+");
        resta.setActionCommand("-");
        division.setActionCommand("/");
        multiplicar.setActionCommand("*");
        potencia.setActionCommand("^");
        porcentaje.setActionCommand("%");
        factorial.setActionCommand("!");

        panelOperandos.add(o1);
        panelOperandos.add(operando1);
        panelOperandos.add(o2);
        panelOperandos.add(operando2);
        panelOperaciones1.add(suma);
        panelOperaciones1.add(resta);
        panelOperaciones1.add(multiplicar);
        panelOperaciones1.add(division);
        panelOperaciones2.add(potencia);
        panelOperaciones2.add(porcentaje);
        panelOperaciones2.add(factorial);
        panelResultado.add(r);
        panelResultado.add(resultado);
        panelResultado.add(operaciones);
        panelResultado.add(resultados);

        setVisible(true);
        setResizable(false);

    }

    class HacerOperaciones implements ActionListener {
   
        String dato;
        @Override
        public void actionPerformed(ActionEvent e) {
            String tipoOperacion = (String) e.getActionCommand();
            String op1 = operando1.getText();
            String op2 = operando2.getText();
            double valor = 0;
            contadorOperaciones++;
            if (tipoOperacion.equals("+")) {
                valor = calculador.Sumar(op1, op2);
                
            }
            if (tipoOperacion.equals("-")) {
                valor = calculador.Restar(op1, op2);
            }
            if (tipoOperacion.equals("/")) {
                valor = calculador.Dividir(op1, op2);
            }
            if (tipoOperacion.equals("*")) {
                valor = calculador.Multiplicar(op1, op2);
            }
            if (tipoOperacion.equals("^")) {
                valor = calculador.Exponencial(op1, op2);
            }
            if (tipoOperacion.equals("%")) {
                valor = calculador.porcentaje(op1, op2);
            }
            if (tipoOperacion.equals("!")) {
                valor = calculador.factorial(op1);
            }
            operando1.setText(" ");
            operando2.setText(" ");
            dato="Op"+contadorOperaciones+": "+op1+tipoOperacion+op2+"="+valor+"\n";
            resultados.append(dato);
            resultado.setEnabled(true);
            resultado.setText(Double.toString(valor));
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Calculadora calc = new Calculadora();
    }

}
