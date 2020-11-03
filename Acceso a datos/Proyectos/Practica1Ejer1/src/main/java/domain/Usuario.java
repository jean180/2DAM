/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jean_
 */
public class Usuario {

    private int id_usuario;
    private String usuario, password;

    public Usuario() {
    }

    public Usuario(int id_Usuario) {
        this.id_usuario = id_Usuario;
    }

    public Usuario(String Usuario, String Password) {
        this.usuario = Usuario;
        this.password = Password;
    }

    public Usuario(int id_Usuario, String Usuario, String Password) {
        this.id_usuario = id_Usuario;
        this.usuario = Usuario;
        this.password = Password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", password=" + password + '}';
    }

}
