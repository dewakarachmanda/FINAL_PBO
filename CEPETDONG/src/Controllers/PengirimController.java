/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Pengirim;
import Views.PengirimView;
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
public class PengirimController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Pengirim> PENGIRIM;
    
    public PengirimController() {
        PENGIRIM = new ArrayList<>();
        try{
            connect();
            String sql = "SELECT * FROM Pengirim";
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
            String sql = "SELECT Pengirim.username FROM friends INNER JOIN ADMIN ON friends.id_user2=ADMIN.id WHERE friends.id_user1 = (SELECT id FROM ADMIN WHERE username = '" + user_now +"')";
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
            sql = "SELECT * FROM pengirim WHERE username='"+friend+"'";
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
    
    public void loginUserPengirim(String nama, String ID) {
        try {
            connect();
            String sql = "SELECT * FROM pengirim where nama='"+nama+"' and ID='"+ID+"';";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                PengirimView landView = new PengirimView(ID);
                landView.show();
                System.out.println("OIIII");
            } else {
                JOptionPane.showMessageDialog(null, "username atau password salah");
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void registerUserPengirim(String detailPaket, String detailResi, String ID, String nama, int nohp) {
        PengirimController x = new PengirimController();
        try {
            connect();
            if(x.findUser(ID) == false){
                stmt.executeUpdate("INSERT INTO pengirim (detailPaket, detailResi,ID,  nama, nohp) VALUES('"+detailPaket+"','"+detailResi+"',  '"+ID+"', '"+nama+"', '"+nohp+"');");
            } else {
                //placeholder, change later
                System.out.println("SENDER SUDAH TERDAFTAR");
            }
            disconnect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    public void addUser(String detailPaket, String detailResi, String ID, String nama, int nohp){
        Pengirim x = new Pengirim(detailPaket, detailResi,ID, nama, nohp);
        PENGIRIM.add(x);
    }
    
    public void connect(){
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pbo", 
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
    
    public void updateUser(String old,String username, String password) {
        try {
            connect();
            String sql = "UPDATE Admin SET username='"+username+"', password='"+password+"' WHERE username='"+old+"';";
            stmt.executeUpdate(sql);
            disconnect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean findUser(String ID){
        
        boolean cek = false;
        try{
            connect();
            rs = stmt.executeQuery("SELECT * FROM Admin WHERE ID='"+ID+"'");
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
