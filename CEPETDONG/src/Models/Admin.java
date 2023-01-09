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
public class Admin extends User{
    protected String resi;

    public Admin(String resi, String ID, String nama, int nohp) {
        super(ID, nama, nohp);
        this.resi = resi;
    }

    public String getResi() {
        return resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
    }
}
