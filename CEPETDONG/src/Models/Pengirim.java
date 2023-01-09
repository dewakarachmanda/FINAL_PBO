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
public class Pengirim extends User{
    private String detailPaket;
    private String detailResi;
    
    public Pengirim(String ID, String nama, int nohp) {
        super(ID, nama, nohp);
    }

    public Pengirim(String detailPaket, String detailResi, String ID, String nama, int nohp) {
        super(ID, nama, nohp);
        this.detailPaket = detailPaket;
        this.detailResi = detailResi;
    }

    public String getDetailPaket() {
        return detailPaket;
    }

    public void setDetailPaket(String detailPaket) {
        this.detailPaket = detailPaket;
    }

    public String getDetailResi() {
        return detailResi;
    }

    public void setDetailResi(String detailResi) {
        this.detailResi = detailResi;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
