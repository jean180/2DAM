/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean_
 */
public class CuentaCorriente {

    Titular titular1, titular2;
    String numero;
    double saldo;

    public CuentaCorriente(Titular titular1, String numero, double saldo) {
        this.titular1 = titular1;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Titular getTitular1() {
        return titular1;
    }

    public void setTitular1(Titular titular1) {
        this.titular1 = titular1;
    }

    public Titular getTitular2() {
        return titular2;
    }

    public void setTitular2(Titular titular2) {
        this.titular2 = titular2;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
