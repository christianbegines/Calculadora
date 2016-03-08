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
        Double f = new Double(x);
        Double f1 = new Double(y);
        Double r = new Double(f + f1);
        double res = r.doubleValue();

        return res;
    }

    public double Restar(String x, String y) {
        Double f = new Double(x);
        Double f1 = new Double(y);
        Double r = new Double(f - f1);
        double res = r.doubleValue();

        return res;

    }

    public double Dividir(String x, String y) {
        Double f = new Double(x);
        Double f1 = new Double(y);
        if (f1 == 0) {
            throw new ErrorValores("operando Y vale 0");
        }

        Double r = new Double(f / f1);
        double res = r.doubleValue();

        return res;
    }

    public double Multiplicar(String x, String y) {
        Double f = new Double(x);
        Double f1 = new Double(y);
        Double r = new Double(f * f1);
        double res = r.doubleValue();
        return res;
    }
    
    public double Exponencial(String x,String y){
        Double f = new Double(x);
        Double f1 = new Double(y);
        Double r = new Double(Math.pow(f,f1));
        double res=r.doubleValue();
        return res ;
        
        
    }
}
