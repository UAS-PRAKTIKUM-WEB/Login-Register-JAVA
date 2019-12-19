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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author fajriyan nur
 */
public class MASUK_USER extends javax.swing.JFrame {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL_DB = "jdbc:mysql://localhost/uap-java-web";
    static final String username_db = "root";
    static final String password_db = "";
    static String sql,us,aaa,idd;
    
   
    static Connection conn;
    static Statement stmt;
    public PreparedStatement ps;
    static ResultSet hasil,hasil2;
    public MASUK_USER() {
        initComponents();
        Koneksi_DB();
        tampildata();
        combo_jurusan();
        autoid();
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
    public void tampildata() {
        Object[] baris = {"ID","PENULIS", "TOPIK","ISI TOPIK","TERKAIT"};
        DefaultTableModel model = new DefaultTableModel(null, baris);
        jScrollPane1.setEnabled(true);
        jScrollPane1.setViewportView(TABEL_USER);
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
            TABEL_USER.setModel(model);
        } catch (Exception e) {

        }
    }
    private void combo_jurusan() {
        try {
            sql = "select * from kategori";
            hasil = stmt.executeQuery(sql);
            LIKE.addItem("-- Pilih --");
            while (hasil.next()) {
                LIKE.addItem(hasil.getString("suka"));
            }
            System.out.println(LIKE.getSelectedItem().toString());
        } catch (SQLException e) {
            System.out.println(e);
        }
    } 
    private void autoid(){
       try {
            sql="select * from posting order by id desc";
            stmt=(Statement) conn.createStatement();
            hasil=stmt.executeQuery(sql);
            if (hasil.next()) {
                String nofak = hasil.getString("id").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "00";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
               ID_ADMIN_AUTO.setText("P" + Nol + AN);
            } else {
               ID_ADMIN_AUTO.setText("P001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, "SALAH DI AUTO \n"+e);
        }
    }
    public void kirim()throws SQLException{
        try {
            if (ID_ADMIN_AUTO.getText().equals("") || NAMA_USER.getText().equals("")
                    || TOPIK_USER.getText().equals("")||ISI_USER.equals("")||LIKE.equals("-- Pilih --")) {
            JOptionPane.showMessageDialog(null, "KIRIM GAGAL || DATA ADA YANG KOSONG");
            }else{
              
               String sql2 = "insert into posting(id,nama ,topik, isi, tentang,post) values ('"+ID_ADMIN_AUTO.getText()+"','"+ NAMA_USER.getText() + "','" + TOPIK_USER.getText()+"','"+ISI_USER.getText()+
                       "','"+LIKE.getSelectedItem()+"',now()"+")";
                stmt.executeUpdate(sql2);
                autoid();
                tampildata();
                JOptionPane.showMessageDialog(null, "KIRIM BERHASIL");
                bersihkan();
            }
           } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "EROR NIH SAAT KIRIM \n"+e);
           }        
    }
    public void bersihkan(){
        autoid();
        NAMA_USER.setText(null);
        TOPIK_USER.setText(null);
        ISI_USER.setText(null);
        LIKE.setSelectedIndex(0);
        
    }
    public void closefrem (){
           super.dispose();
       }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        STATUS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL_USER = new javax.swing.JTable();
        ID_ADMIN_AUTO = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NAMA_USER = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        TOPIK_USER = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ISI_USER = new javax.swing.JTextField();
        KIRIM_USER = new javax.swing.JButton();
        LIKE = new javax.swing.JComboBox<>();
        ADMIN_USER = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        STATUS.setEditable(false);
        STATUS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        STATUS.setText("USER");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("TABEL USER");

        TABEL_USER.setModel(new javax.swing.table.DefaultTableModel(
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
        TABEL_USER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABEL_USERMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABEL_USER);

        ID_ADMIN_AUTO.setEditable(false);
        ID_ADMIN_AUTO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("APA YANG ANDA PIKIRKAN");

        jLabel3.setText("NAMA SINGKAT PENULIS");

        TOPIK_USER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOPIK_USERActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel2.setText("TOPIK");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel4.setText("ISI");

        KIRIM_USER.setBackground(new java.awt.Color(204, 204, 255));
        KIRIM_USER.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        KIRIM_USER.setText("KIRIM");
        KIRIM_USER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KIRIM_USERActionPerformed(evt);
            }
        });

        ADMIN_USER.setBackground(new java.awt.Color(51, 51, 51));
        ADMIN_USER.setForeground(new java.awt.Color(255, 255, 255));
        ADMIN_USER.setText("LOGIN");
        ADMIN_USER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMIN_USERActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(KIRIM_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ADMIN_USER))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NAMA_USER))
                    .addComponent(TOPIK_USER, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ISI_USER, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ID_ADMIN_AUTO, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                            .addComponent(jSeparator1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LIKE, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ADMIN_USER)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_ADMIN_AUTO, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NAMA_USER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TOPIK_USER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ISI_USER, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LIKE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(KIRIM_USER, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TABEL_USERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABEL_USERMouseClicked

    }//GEN-LAST:event_TABEL_USERMouseClicked

    private void TOPIK_USERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOPIK_USERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TOPIK_USERActionPerformed

    private void KIRIM_USERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KIRIM_USERActionPerformed
        try {
            kirim();
        } catch (SQLException ex) {
            Logger.getLogger(MASUK_USER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_KIRIM_USERActionPerformed

    private void ADMIN_USERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMIN_USERActionPerformed
        closefrem();
        LOGIN masuk2 = new LOGIN();
        masuk2.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_ADMIN_USERActionPerformed

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
            java.util.logging.Logger.getLogger(MASUK_USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MASUK_USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MASUK_USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MASUK_USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MASUK_USER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADMIN_USER;
    private javax.swing.JTextField ID_ADMIN_AUTO;
    private javax.swing.JTextField ISI_USER;
    private javax.swing.JButton KIRIM_USER;
    private javax.swing.JComboBox<String> LIKE;
    private javax.swing.JTextField NAMA_USER;
    private javax.swing.JTextField STATUS;
    private javax.swing.JTable TABEL_USER;
    private javax.swing.JTextField TOPIK_USER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
