/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author goody
 */
public class Kurir extends User{
    private String idKurir;

    public Kurir(String idKurir, String ID, String nama, int nohp) {
        super(ID, nama, nohp);
        this.idKurir = idKurir;
    }

    public void setIdKurir(String idKurir) {
        this.idKurir = idKurir;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIdKurir() {
        return idKurir;
    }

    public String getID() {
        return ID;
    }
}
