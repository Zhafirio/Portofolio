/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipkkp.laporan;

import Koneksi.koneksi;
import aplikasipkkp.Main;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author defam
 */
public class LaporanPeserta extends javax.swing.JFrame {
    private DefaultTableModel DftTblModel_LaporanPeserta;
    private String SQL;

    /**
     * Creates new form LaporanPeserta
     */
    public LaporanPeserta() {
        initComponents();
        
        tampilData();
        
        setResizable(false);
    }
    
    public void tampilData(){
        DftTblModel_LaporanPeserta = new DefaultTableModel();
        DftTblModel_LaporanPeserta.addColumn("NIK");
        DftTblModel_LaporanPeserta.addColumn("Nama");
        DftTblModel_LaporanPeserta.addColumn("Kabupaten/Kota");
        DftTblModel_LaporanPeserta.addColumn("Seleksi Administrasi");
        DftTblModel_LaporanPeserta.addColumn("Laporan Nilai");
        DftTblModel_LaporanPeserta.addColumn("Rangking");
        tblLaporanPeserta.setModel(DftTblModel_LaporanPeserta);
         Connection conn = koneksi.getConnection();
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "SELECT nik, peserta.nama, kota, seleksi, bobot, rangking FROM peserta INNER JOIN penilaian ON peserta.nama = penilaian.nama";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_LaporanPeserta.addRow(new Object[]{
                    res.getString("nik"),
                    res.getString("nama"),
                    res.getString("kota"),
                    res.getString("seleksi"),
                    res.getString("bobot"),
                    res.getString("rangking")
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariData(String key){
        try{
            DftTblModel_LaporanPeserta = new DefaultTableModel();
            DftTblModel_LaporanPeserta.addColumn("NIK");
            DftTblModel_LaporanPeserta.addColumn("Nama");
            DftTblModel_LaporanPeserta.addColumn("Kabupaten/Kota");
            DftTblModel_LaporanPeserta.addColumn("Seleksi Administrasi");
            DftTblModel_LaporanPeserta.addColumn("Laporan Nilai");
            DftTblModel_LaporanPeserta.addColumn("Rangking");
            tblLaporanPeserta.setModel(DftTblModel_LaporanPeserta);
            
            Connection conn = koneksi.getConnection();
            java.sql.Statement stmt = conn.createStatement();
            DftTblModel_LaporanPeserta.getDataVector().removeAllElements();
            
            SQL = "SELECT nik, peserta.nama, kota, seleksi, bobot, rangking FROM peserta INNER JOIN penilaian ON peserta.nama = penilaian.nama WHERE peserta.nama LIKE '%"+key+"%'";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
 
            while(res.next()){
                DftTblModel_LaporanPeserta.addRow(new Object[]{
                    res.getString("nik"),
                    res.getString("nama"),
                    res.getString("kota"),
                    res.getString("seleksi"),
                    res.getString("bobot"),
                    res.getString("rangking")
                });
            }                
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporanPeserta = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Laporan Peserta");

        tblLaporanPeserta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLaporanPeserta);

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel2.setText("Cari Nama");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        setSize(new java.awt.Dimension(710, 456));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new Main().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        String key=txtCari.getText();
        System.out.println(key);  
        
        if(key!=""){
            cariData(key);
        }else{
            tampilData();
        }
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLaporanPeserta;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
