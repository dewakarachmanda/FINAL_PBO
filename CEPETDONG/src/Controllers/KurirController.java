/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Kurir;
import Views.KurirView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author goody
 */
public class KurirController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Kurir> KURIR;
    
    public KurirController() {
        KURIR = new ArrayList<>();
        try{
            connect();
            String sql = "SELECT * FROM kurir";
            rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                addUser(rs.getString("username"), rs.getString("password"), 
//                        rs.getInt("id"));
//            }
            disconnect();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> findFriends(String user_now){
        ArrayList<String> friends = new ArrayList<>();
        try{
            connect();
            String sql = "SELECT KURIR.username FROM friends INNER JOIN KURIR ON friends.id_user2=KURIR.id WHERE friends.id_user1 = (SELECT id FROM KURIR WHERE username = '" + user_now +"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                friends.add(rs.getString("username"));
            }
            disconnect();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return friends;
    }
    
    public void addFriend(String user_now, String friend){
        boolean friendSwitch = false;
        String sql;
        
        //cek friend exists
        try{
            connect();
            sql = "SELECT * FROM KURIR WHERE username='"+friend+"'";
            rs = stmt.executeQuery(sql);
            rs.next();
            if(friend.equals(rs.getObject(2).toString())) friendSwitch = true; System.out.println("friendSwitch TRUE!");
            disconnect();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No such user in database!");
        }
        
        //cek if already friends
        try{
            sql = "SELECT * FROM friends WHERE id_user1 = (SELECT id FROM KURIR WHERE username='" + user_now + "') AND id_user2 = (SELECT id FROM KURIR WHERE username='" + friend + "')";
            connect();
            rs = stmt.executeQuery(sql);
            int i = 0;
            while(rs.next()) i++;
            disconnect();
            if(i>0){
                friendSwitch = false;
            }
            
            if(friendSwitch){
                try{
                    sql = "INSERT INTO friends VALUES ((SELECT id FROM KURIR WHERE username='" + user_now + "'), (SELECT id FROM KURIR WHERE username='" + friend + "'))";
                    connect();
                    stmt.executeUpdate(sql);
                    disconnect();
                    JOptionPane.showMessageDialog(null, "friend added succesfully!!");
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error adding friend!");
                }
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loginUserKurir(String nama, String ID) {
        try {
            connect();
            
            String sql = "SELECT * FROM kurir where nama='"+nama+"' and ID='"+ID+"';";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                KurirView landView = new KurirView(nama);
                landView.show();
            } else {
                JOptionPane.showMessageDialog(null, "nama atau id salah");
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void registerUser(String idKurir, String ID, String nama, int nohp) {
        KurirController x = new KurirController();
        try {
            connect();
            if(x.findUser(idKurir) == false){
                stmt.executeUpdate("INSERT INTO kurir (idKurir, ID, nama, nohp) VALUES('"+idKurir+"', '"+ID+"', '"+nama+"', '"+nohp+"');");
            } else {
                //placeholder, change later
                System.out.println("KURIR SUDAH TERDAFTAR");
            }
            disconnect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addUser(String idKurir, String ID, String nama, int nohp){
        Kurir x = new Kurir(idKurir, ID, nama, nohp);
        KURIR.add(x);
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
    
    public void updateStatus(String namaPaket, String statusPengiriman) {
        try {
            connect();
            String sql = "UPDATE paket SET statusPengiriman='"+statusPengiriman+"' WHERE namaPaket ='"+namaPaket+"';";
            stmt.executeUpdate(sql);
            disconnect();
        } catch (Exception e){
            System.out.println("eror cok sqlnya");
            e.printStackTrace();
        }
    }
    
    public boolean findUser(String idKurir){
        
        boolean cek = false;
        try{
            connect();
            rs = stmt.executeQuery("SELECT * FROM kurir WHERE idKurir='"+idKurir+"'");
            while(rs.next()){
                cek = true;
            }
            disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        return cek;
    }
}
