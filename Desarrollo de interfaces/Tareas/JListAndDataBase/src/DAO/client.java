/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author jeaagu
 */
public class client {

    private String id;
    private String notes;

    public client() {
        this.id = "";
        this.notes = "";
    }

    public String getId() {
        return id;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    

}
