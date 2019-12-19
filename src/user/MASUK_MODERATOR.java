/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static user.MASUK_USER.JDBC_DRIVER;

/**
 *
 * @author fajriyan nur
 */
public class MASUK_MODERATOR extends javax.swing.JFrame {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL_DB = "jdbc:mysql://localhost/uap-java-web";
    static final String username_db = "root";
    static final String password_db = "";
    static String sql,us,aaa,idd;
    
   
    static Connection conn;
    static Statement stmt;
    public PreparedStatement ps;
    static ResultSet hasil,hasil2;
    
    public MASUK_MODERATOR() {
        initComponents();
        Koneksi_DB();
        tampildata();
        tampildata2();
    }
    
    static void Koneksi_DB(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(URL_DB,username_db,password_db);
            stmt = (Statement) conn.createStatement();
            //System.out.println("--- KONEKSI BERHASIL ---");
        } catch (Exception e) {
            System.out.println("--- KONEKSI GAGAL ---\n"+e);
        }
    }
    private void tampildata() {
        Object[] baris = {"ID","PENULIS", "TOPIK","ISI TOPIK","TERKAIT"};
        DefaultTableModel model = new DefaultTableModel(null, baris);
        jScrollPane1.setEnabled(true);
        jScrollPane1.setViewportView(TABEL_MODERATOR);
        try {
            sql = "select * from posting";
            hasil = stmt.executeQuery(sql);
            while(hasil.next()){
                String[] data = {
                    hasil.getString("id"),
                    hasil.getString("nama"),
                    hasil.getString("topik"),
                    hasil.getString("isi"),
                    hasil.getString("tentang")};
                model.addRow(data);
            }
            TABEL_MODERATOR.setModel(model);
        } catch (Exception e) {

        }
    }
     public void closefrem (){
           super.dispose();
       }
      private void tampildata2() {
        Object[] baris2 = {"ID","NAMA", "EMAIL","PASSWORD", "JENIS KELAMIN","KATEGORI","BIO"};
        DefaultTableModel model = new DefaultTableModel(null, baris2);
        jScrollPane2.setEnabled(true);
        jScrollPane2.setViewportView(TABEL1);
        try {
            sql = "select * from user";
            hasil = stmt.executeQuery(sql);
            while(hasil.next()){
                String[] data = {
                    hasil.getString("id"),
                    hasil.getString("nama"),
                    hasil.getString("email"),
                    hasil.getString("password"),
                    hasil.getString("jk"),
                    hasil.getString("suka"),
                    hasil.getString("bio")};
                model.addRow(data);
            }
            TABEL1.setModel(model);
        } catch (SQLException e) {

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        STATUS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL_MODERATOR = new javax.swing.JTable();
        ADMIN_USER = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABEL1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        STATUS.setEditable(false);
        STATUS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        STATUS.setText("MODERATOR");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("TABEL MODERATOR");

        TABEL_MODERATOR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TABEL_MODERATOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABEL_MODERATORMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABEL_MODERATOR);

        ADMIN_USER.setBackground(new java.awt.Color(51, 51, 51));
        ADMIN_USER.setForeground(new java.awt.Color(255, 255, 255));
        ADMIN_USER.setText("LOGIN");
        ADMIN_USER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMIN_USERActionPerformed(evt);
            }
        });

        TABEL1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TABEL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABEL1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TABEL1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ADMIN_USER))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ADMIN_USER))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TABEL_MODERATORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABEL_MODERATORMouseClicked

    }//GEN-LAST:event_TABEL_MODERATORMouseClicked

    private void ADMIN_USERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMIN_USERActionPerformed
        closefrem();
        LOGIN masuk2 = new LOGIN();
        masuk2.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_ADMIN_USERActionPerformed

    private void TABEL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABEL1MouseClicked
      
    }//GEN-LAST:event_TABEL1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MASUK_MODERATOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MASUK_MODERATOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MASUK_MODERATOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MASUK_MODERATOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MASUK_MODERATOR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADMIN_USER;
    private javax.swing.JTextField STATUS;
    private javax.swing.JTable TABEL1;
    private javax.swing.JTable TABEL_MODERATOR;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}