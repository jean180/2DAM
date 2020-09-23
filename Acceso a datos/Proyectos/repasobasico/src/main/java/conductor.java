/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeaagu
 */
public class conductor {
    int tipo;
    double tasa;
    public conductor(int tipo, double tasa){
        this.tipo = tipo;
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
