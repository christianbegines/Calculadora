/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author daw1
 */
public class CalculadoraInterna {

    public CalculadoraInterna() {
    }

    public double Sumar(String x, String y) {
        double res;
        Double f = new Double(x);
        Double f1 = new Double(y);
        Double r = (f + f1);

        return r;
    }

    public double Restar(String x, String y) {
        Double f = new Double(x);
        Double f1 = new Double(y);
        Double r = (f - f1);

        return r;

    }

    public double Dividir(String x, String y) {
        Double f = new Double(x);
        Double f1 = new Double(y);
        if (f1 == 0) {
            throw new ErrorValores("operando Y vale 0");
        }
        Double r = (f / f1);

        return r;
    }

    public double Multiplicar(String x, String y) {
        Double f = new Double(x);
        Double f1 = new Double(y);
        Double r = (f * f1);

        return r;
    }

    public double Exponencial(String x, String y) {
        Double f = new Double(x);
        Double f1 = new Double(y);
        Double r = (Math.pow(f, f1));

        return r;

    }

    public double factorial(String x) {
        double factorial = 1;
        Double f = new Double(x);
        while (f != 0) {
            factorial = factorial * f;
            f--;
        }
        return factorial;

    }

    public double porcentaje(String x, String y) {
        double f = new Double(x);
        double f1 = new Double(y);
        Double r = ((f * f1) / 100);

        return r;

    }
}
