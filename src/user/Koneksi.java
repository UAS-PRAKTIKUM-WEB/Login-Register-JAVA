package user;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
 
public class Koneksi {
   static Connection con;
   static Statement stm;
   public static void main(String[] args) {
    //tes();
}
   private static java.sql.Connection koneksi = null;
    public static java.sql.Connection tes(){
        try {
            MysqlDataSource data = new MysqlDataSource();
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/uap-java-web", "root", "");
            stm = con.createStatement();
            koneksi = data.getConnection();
            System.out.println("KONEKSI BERHASIL");
        } catch (Exception e) {
            System.out.println("KONEKSI GAGAL");
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return koneksi;
    }
}
