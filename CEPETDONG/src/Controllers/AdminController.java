/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Admin;
import Views.AdminView;
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
public class AdminController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Admin> ADMIN;
    
    public AdminController() {
        ADMIN = new ArrayList<>();
        try{
            connect();
            String sql = "SELECT * FROM admin";
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
            String sql = "SELECT ADMIN.username FROM friends INNER JOIN ADMIN ON friends.id_user2=ADMIN.id WHERE friends.id_user1 = (SELECT id FROM ADMIN WHERE username = '" + user_now +"')";
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
            sql = "SELECT * FROM ADMIN WHERE username='"+friend+"'";
            rs = stmt.executeQuery(sql);
            rs.next();
            if(friend.equals(rs.getObject(2).toString())) friendSwitch = true; System.out.println("friendSwitch TRUE!");
            disconnect();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No such user in database!");
        }
        
        //cek if already friends
        try{
            sql = "SELECT * FROM friends WHERE id_user1 = (SELECT id FROM ADMIN WHERE username='" + user_now + "') AND id_user2 = (SELECT id FROM ADMIN WHERE username='" + friend + "')";
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
                    sql = "INSERT INTO friends VALUES ((SELECT id FROM ADMIN WHERE username='" + user_now + "'), (SELECT id FROM ADMIN WHERE username='" + friend + "'))";
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
    
    public void loginUserAdmin(String nama, String ID) {
        try {
            connect();
            String sql = "SELECT * FROM admin where nama='"+nama+"' and ID='"+ID+"';";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                AdminView landView = new AdminView(nama);
                landView.show();
            } else {
                JOptionPane.showMessageDialog(null, "username atau password salah");
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void registerUser(String resi, String ID, String nama, int nohp) {
        AdminController x = new AdminController();
        try {
            connect();
            if(x.findUser(ID) == false){
                stmt.executeUpdate("INSERT INTO Admin (resi, ID, nama, nohp) VALUES('"+resi+"', '"+ID+"', '"+nama+"', '"+nohp+"');");
            } else {
                //placeholder, change later
                System.out.println("ADMIN SUDAH TERDAFTAR");
            }
            disconnect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addUser(String resi, String ID, String nama, int nohp){
        Admin x = new Admin(resi,ID, nama, nohp);
        ADMIN.add(x);
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
    
    public void updateStatus(String namaPaket, int hargaPaket, String resiPaket) {
        try {
            connect();
            System.out.println(namaPaket + hargaPaket +  resiPaket);
            String sql = "UPDATE paket SET hargaPaket='"+hargaPaket+"' WHERE namaPaket ='"+namaPaket+"';";
            String sql1 = "UPDATE paket SET resiPaket='"+resiPaket+"' WHERE namaPaket ='"+namaPaket+"';";
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
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
