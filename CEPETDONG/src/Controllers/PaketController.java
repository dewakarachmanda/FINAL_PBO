/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Paket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author goody
 */
public class PaketController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    public ArrayList<Paket> PAKET;
    
    public PaketController(){
        PAKET = new ArrayList<>();
        try{
            connect();
            String sql = "SELECT * FROM paket";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Paket paket = new Paket(
                rs.getString("namaPaket"),
                rs.getString("idPaket"),
                rs.getInt("beratPaket"),
                rs.getInt("kuantitas"),
                rs.getInt("hargaPaket"),
                rs.getString("resiPaket"),
                rs.getString("alamatTujuan"),
                rs.getString("statusPengiriman")
                );
                PAKET.add(paket);
            }           


            disconnect();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    public void connect(){
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cepetdong", 
                    "root",
                    "");
            this.stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect(){
        try{
            conn.close();
            stmt.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean findPaket(String namaPaket){
        
        boolean cek = false;
        try{
            connect();
            rs = stmt.executeQuery("SELECT * FROM paket WHERE namaPaket='"+namaPaket+"'");
            while(rs.next()){
                cek = true;
            }
            disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        return cek;
    }
    
    public Paket searchPaket(String namaPaket){
            int i = 0;
            while(!PAKET.get(i).getNamaPaket().equals(namaPaket) && i < PAKET.size()){
                i++;
            }
 
        return PAKET.get(i);
    }

    public void addPaket(String namaPaket, String idPaket, int beratPaket, int kuantitas, int hargaPaket, String resiPaket, String alamatTujuan, String statusPengiriman) {
        PaketController x = new PaketController();
        try {
            connect();
            if(x.findPaket(namaPaket) == false){
                stmt.executeUpdate("INSERT INTO paket (namaPaket, idPaket, beratPaket, kuantitas, hargaPaket, resiPaket, alamatTujuan, statusPengiriman) "
                        + "VALUES('"+namaPaket+"', '"+idPaket+"', '"+beratPaket+"', '"+kuantitas+"', '"+hargaPaket+"', '"+resiPaket+"', '"+alamatTujuan+"', '"+statusPengiriman+"');");
            } else {
                //placeholder, change later
                System.out.println("PAKET SUDAH TERDAFTAR");
            }
            disconnect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
