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
public class User {
    protected String ID;
    private String nama;
    private int nohp;

    public User(String ID, String nama, int nohp) {
        this.ID = ID;
        this.nama = nama;
        this.nohp = nohp;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNohp() {
        return nohp;
    }

    public void setNohp(int nohp) {
        this.nohp = nohp;
    }
}
