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
public class Paket {
    private String namaPaket;
    private String idPaket;
    private int beratPaket;
    private int kuantitas;
    private int hargaPaket;
    private String resiPaket;
    private String alamatTujuan;
    private String statusPengiriman;

    public Paket(String namaPaket, String idPaket, int beratPaket, int kuantitas, int hargaPaket, String resiPaket, String alamatTujuan, String statusPengiriman) {
        this.namaPaket = namaPaket;
        this.idPaket = idPaket;
        this.beratPaket = beratPaket;
        this.kuantitas = kuantitas;
        this.hargaPaket = hargaPaket;
        this.resiPaket = resiPaket;
        this.alamatTujuan = alamatTujuan;
        this.statusPengiriman = statusPengiriman;
        
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    public String getIdPaket() {
        return idPaket;
    }

    public void setIdPaket(String idPaket) {
        this.idPaket = idPaket;
    }

    public int getBeratPaket() {
        return beratPaket;
    }

    public void setBeratPaket(int beratPaket) {
        this.beratPaket = beratPaket;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public int getHargaPaket() {
        return hargaPaket;
    }

    public void setHargaPaket(int hargaPaket) {
        this.hargaPaket = hargaPaket;
    }

    public String getResiPaket() {
        return resiPaket;
    }

    public void setResiPaket(String resiPaket) {
        this.resiPaket = resiPaket;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }

    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }

    public String isStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }
}
