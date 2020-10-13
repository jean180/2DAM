/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean_
 */
public class Alumne {

    public String nom, Cognoms, DNI, notaLetra;
    public int notaNum;

    public Alumne(String nom, String Cognoms, String DNI, int notaNum, String notaLetra) {
        this.nom = nom;
        this.Cognoms = Cognoms;
        this.DNI = DNI;
        this.notaNum = notaNum;
    }

    public String getNom() {
        return nom;
    }

    public String getCognoms() {
        return Cognoms;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNotaLetra() {
        return notaLetra;
    }

    public int getNotaNum() {
        return notaNum;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognoms(String Cognoms) {
        this.Cognoms = Cognoms;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNotaLetra(String notaLetra) {
        this.notaLetra = notaLetra;
    }

    public void setNotaNum(int notaNum) {
        this.notaNum = notaNum;
    }

}
