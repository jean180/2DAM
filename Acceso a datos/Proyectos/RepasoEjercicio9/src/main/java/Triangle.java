/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean_
 */
public class Triangle {

    Punt A, B, C;

    public Triangle(Punt A, Punt B, Punt C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public Punt getA() {
        return A;
    }

    public Punt getB() {
        return B;
    }

    public Punt getC() {
        return C;
    }

    public void setA(Punt A) {
        this.A = A;
    }

    public void setB(Punt B) {
        this.B = B;
    }

    public void setC(Punt C) {
        this.C = C;
    }

    @Override
    public String toString() {
        return A.toString() + "," + B.toString() + "," + C.toString();
    }

}
