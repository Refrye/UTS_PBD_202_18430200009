/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobaaccess;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class FormBarang extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelBarang = new DefaultTableModel();

    /**
     * Creates new form FormBarang
     */
    public FormBarang() {
        initComponents();
        tblBarang.setModel(modelBarang);
        modelBarang.addColumn("Id_barang");
        modelBarang.addColumn("Nama_Barang");
        modelBarang.addColumn("Satuan");
        modelBarang.addColumn("Stok");
        modelBarang.addColumn("Tgl_Exp");
        modelBarang.addColumn("Harga_Beli");
        modelBarang.addColumn("Harga_Jual");
        modelBarang.addColumn("Id_Kategori");
        modelBarang.addColumn("Status");

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\Semester 6\\Pembrograman Basis Data (Kojul)\\Penjualan.accdb");

            pst = conn.prepareStatement("select * from barang");
            rs = pst.executeQuery();
            modelBarang.setRowCount(0);
            while (rs.next()) {
                Object[] data = new Object[9];
                data[0] = rs.getString("Id_Barang");
                data[1] = rs.getString("Nama_Barang");
                data[2] = rs.getString("Satuan");
                data[3] = rs.getString("Stok");
                data[4] = rs.getDate("Tgl_Exp");
                data[5] = rs.getDouble("Harga_Beli");
                data[6] = rs.getDouble("Harga_Jual");
                data[7] = rs.getString("Id_Kategori");
                data[8] = rs.getString("Status");

                modelBarang.addRow(data);
            }
            pst.close();

            pst = conn.prepareStatement("select * from Kategori");
            rs = pst.executeQuery();
            while (rs.next()) {
                cbKategori_barang.addItem(rs.getString(2));
            }
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfId_Barang = new javax.swing.JTextField();
        tfNama_Barang = new javax.swing.JTextField();
        cbSatuan = new javax.swing.JComboBox<>();
        spStok = new javax.swing.JSpinner();
        tfHarga_Beli = new java.awt.TextField();
        tfHarga_Jual = new java.awt.TextField();
        btnSimpan = new java.awt.Button();
        btnUbah = new java.awt.Button();
        btndelete = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        tfTgl_Exp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rbHotItem = new javax.swing.JRadioButton();
        rbBiasa = new javax.swing.JRadioButton();
        cbKategori_barang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id_Barang");

        jLabel2.setText("Nama_barang");

        jLabel3.setText("Satuan");

        jLabel4.setText("Stok");

        jLabel5.setText("Harga_Beli");

        jLabel6.setText("Harga_Jual");

        jLabel7.setText("Kategori_barang");

        tfId_Barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfId_BarangActionPerformed(evt);
            }
        });

        tfNama_Barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNama_BarangActionPerformed(evt);
            }
        });

        cbSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pcs", "Dus" }));
        cbSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSatuanActionPerformed(evt);
            }
        });

        tfHarga_Beli.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tfHarga_BeliInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        tfHarga_Beli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfHarga_BeliFocusGained(evt);
            }
        });
        tfHarga_Beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHarga_BeliActionPerformed(evt);
            }
        });
        tfHarga_Beli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfHarga_BeliKeyTyped(evt);
            }
        });

        tfHarga_Jual.setEditable(false);
        tfHarga_Jual.setEnabled(false);
        tfHarga_Jual.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tfHarga_JualInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        tfHarga_Jual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfHarga_JualFocusGained(evt);
            }
        });
        tfHarga_Jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHarga_JualActionPerformed(evt);
            }
        });
        tfHarga_Jual.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfHarga_JualPropertyChange(evt);
            }
        });
        tfHarga_Jual.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                tfHarga_JualTextValueChanged(evt);
            }
        });
        tfHarga_Jual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfHarga_JualKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfHarga_JualKeyTyped(evt);
            }
        });

        btnSimpan.setActionCommand("Simpan");
        btnSimpan.setLabel("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setLabel("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btndelete.setLabel("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBarang);

        jLabel8.setText("Tgl_Exp");

        jLabel10.setText("Status");

        buttonGroup1.add(rbHotItem);
        rbHotItem.setText("Hot Item");
        rbHotItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbHotItemMouseClicked(evt);
            }
        });
        rbHotItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbHotItemKeyPressed(evt);
            }
        });

        buttonGroup1.add(rbBiasa);
        rbBiasa.setText("Biasa");
        rbBiasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbBiasaMouseClicked(evt);
            }
        });

        cbKategori_barang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKategori_barangItemStateChanged(evt);
            }
        });
        cbKategori_barang.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cbKategori_barangInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        cbKategori_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbKategori_barangKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNama_Barang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfId_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(cbSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHarga_Beli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfHarga_Jual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spStok)
                            .addComponent(tfTgl_Exp)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbKategori_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbHotItem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbBiasa)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNama_Barang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(tfTgl_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tfHarga_Beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfHarga_Jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbKategori_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rbHotItem)
                    .addComponent(rbBiasa))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfId_BarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfId_BarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfId_BarangActionPerformed

    private void tfNama_BarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNama_BarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNama_BarangActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:

        String idKategori = "";
        try {
            st = conn.createStatement();

            String namaKategori;
            namaKategori = (String) cbKategori_barang.getSelectedItem();
            String sql = "select * from Kategori where Nama_Kategori='" + namaKategori.toString() + "'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                idKategori = rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null, "gagal");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            String status;
            if (rbHotItem.isSelected()) {
                status = "Hot Item";
            } else {
                status = "Biasa";
            }

            pst = conn.prepareStatement("insert into barang(Id_Barang,Nama_Barang,Satuan,Stok,Tgl_Exp,Harga_Beli,Harga_Jual,Id_Kategori,Status) values (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tfId_Barang.getText());
            pst.setString(2, tfNama_Barang.getText());
            pst.setString(3, cbSatuan.getSelectedItem().toString());
            pst.setInt(4, Integer.parseInt(spStok.getValue().toString()));
            pst.setDate(5, java.sql.Date.valueOf(tfTgl_Exp.getText().replace("/", "-")));
            pst.setDouble(6, Double.parseDouble(tfHarga_Beli.getText()));
            pst.setDouble(7, Double.parseDouble(tfHarga_Jual.getText()));
            pst.setString(8, idKategori);
            pst.setString(9, status);

            int jum = pst.executeUpdate();
            if (jum > 0) {
                JOptionPane.showMessageDialog(null, "Tersimpan");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
            pst.close();

            reset();
            pst = conn.prepareStatement("select * from barang");
            rs = pst.executeQuery();
            modelBarang.setRowCount(0);
            while (rs.next()) {
                Object[] data = new Object[9];
                data[0] = rs.getString("Id_Barang");
                data[1] = rs.getString("Nama_Barang");
                data[2] = rs.getString("Satuan");
                data[3] = rs.getString("Stok");
                data[4] = rs.getDate("Tgl_Exp");
                data[5] = rs.getDouble("Harga_Beli");
                data[6] = rs.getDouble("Harga_Jual");
                data[7] = rs.getString("Id_Kategori");
                data[8] = rs.getString("Status");
                modelBarang.addRow(data);
            }
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        String idKategori = "";
        try {
            st = conn.createStatement();

            String namaKategori;
            namaKategori = (String) cbKategori_barang.getSelectedItem();
            String sql = "select * from Kategori where Nama_Kategori='" + namaKategori.toString() + "'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                idKategori = rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null, "gagal");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            String status;
            if (rbHotItem.isSelected()) {
                status = "Hot Item";
            } else {
                status = "Biasa";
            }
            pst = conn.prepareStatement("update barang set Nama_Barang=?,Satuan=?,Stok=?,Tgl_Exp=?,Harga_Beli=?,Harga_Jual=?,Id_Kategori=?, Status=? where Id_Barang=?");
            pst.setString(9, tfId_Barang.getText());
            pst.setString(1, tfNama_Barang.getText());
            pst.setString(2, cbSatuan.getSelectedItem().toString());
            pst.setInt(3, Integer.parseInt(spStok.getValue().toString()));
            pst.setDate(4, java.sql.Date.valueOf(tfTgl_Exp.getText().replace("/", "-")));
            pst.setDouble(5, Double.parseDouble(tfHarga_Beli.getText()));
            pst.setDouble(6, Double.parseDouble(tfHarga_Jual.getText()));
            pst.setString(7, idKategori);
            pst.setString(8, status);

            int jum = pst.executeUpdate();
            if (jum > 0) {
                JOptionPane.showMessageDialog(null, "Terubah");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
            pst.close();

            reset();

            pst = conn.prepareStatement("select * from barang");
            rs = pst.executeQuery();
            modelBarang.setRowCount(0);
            while (rs.next()) {
                Object[] data = new Object[9];
                data[0] = rs.getString("Id_Barang");
                data[1] = rs.getString("Nama_Barang");
                data[2] = rs.getString("Satuan");
                data[3] = rs.getString("Stok");
                data[4] = rs.getDate("Tgl_Exp");
                data[5] = rs.getDouble("Harga_Beli");
                data[6] = rs.getDouble("Harga_Jual");
                data[7] = rs.getString("Id_Kategori");
                data[8] = rs.getString("Status");
                modelBarang.addRow(data);
            }
            pst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        // TODO add your handling code here:
        int baris = tblBarang.getSelectedRow();
        tfId_Barang.setText(tblBarang.getModel().getValueAt(baris, 0).toString());
        tfNama_Barang.setText(tblBarang.getModel().getValueAt(baris, 1).toString());
        cbSatuan.setSelectedItem(tblBarang.getModel().getValueAt(baris, 2).toString());
        spStok.setValue(Integer.parseInt((String) tblBarang.getValueAt(baris, 3)));
        tfTgl_Exp.setText(tblBarang.getModel().getValueAt(baris, 4).toString());
        tfHarga_Beli.setText(tblBarang.getModel().getValueAt(baris, 5).toString());
        tfHarga_Jual.setText(tblBarang.getModel().getValueAt(baris, 6).toString());
        cbKategori_barang.setSelectedItem(tblBarang.getModel().getValueAt(baris, 7).toString());
        if (tblBarang.getModel().getValueAt(baris, 8).toString().equals("Hot Item")) {
            rbHotItem.setSelected(true);
        } else {
            rbBiasa.setSelected(true);
        }
        tfId_Barang.grabFocus();
// yang radio button belum
    }//GEN-LAST:event_tblBarangMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        try {

            pst = conn.prepareStatement("delete barang where Id_Barang=?");
            pst.setString(1, tfId_Barang.getText());

            int jum = pst.executeUpdate();
            if (jum > 0) {
                JOptionPane.showMessageDialog(null, "Terhapus");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
            pst.close();

            reset();

            pst = conn.prepareStatement("select * from barang");
            rs = pst.executeQuery();
            modelBarang.setRowCount(0);
            while (rs.next()) {
                Object[] data = new Object[9];
                data[0] = rs.getString("Id_Barang");
                data[1] = rs.getString("Nama_Barang");
                data[2] = rs.getString("Satuan");
                data[3] = rs.getString("Stok");
                data[4] = rs.getDate("Tgl_Exp");
                data[5] = rs.getDouble("Harga_Beli");
                data[6] = rs.getDouble("Harga_Jual");
                data[7] = rs.getString("Id_Kategori");
                data[8] = rs.getString("Status");
                modelBarang.addRow(data);
            }
            pst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tfHarga_BeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHarga_BeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHarga_BeliActionPerformed

    private void tfHarga_JualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHarga_JualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHarga_JualActionPerformed

    private void tfHarga_JualInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tfHarga_JualInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHarga_JualInputMethodTextChanged

    private void tfHarga_BeliInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tfHarga_BeliInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHarga_BeliInputMethodTextChanged

    private void tfHarga_JualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfHarga_JualFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHarga_JualFocusGained

    private void tfHarga_BeliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfHarga_BeliFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHarga_BeliFocusGained

    private void tfHarga_JualTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_tfHarga_JualTextValueChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHarga_JualTextValueChanged

    private void tfHarga_JualPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfHarga_JualPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHarga_JualPropertyChange

    private void tfHarga_JualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHarga_JualKeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_tfHarga_JualKeyReleased

    private void tfHarga_JualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHarga_JualKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHarga_JualKeyTyped

    private void tfHarga_BeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHarga_BeliKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHarga_BeliKeyTyped

    private void rbHotItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbHotItemKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_rbHotItemKeyPressed

    private void rbHotItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbHotItemMouseClicked
        // TODO add your handling code here:
        double totalHargaJual = 0;
        totalHargaJual = Double.parseDouble(tfHarga_Beli.getText()) + (Double.parseDouble(tfHarga_Beli.getText()) * 0.2);
        tfHarga_Jual.setText(String.valueOf(totalHargaJual));
    }//GEN-LAST:event_rbHotItemMouseClicked

    private void rbBiasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbBiasaMouseClicked
        // TODO add your handling code here:
        double totalHargaJual = 0;
        totalHargaJual = Double.parseDouble(tfHarga_Beli.getText()) + (Double.parseDouble(tfHarga_Beli.getText()) * 0.15);
        tfHarga_Jual.setText(String.valueOf(totalHargaJual));
    }//GEN-LAST:event_rbBiasaMouseClicked

    private void cbSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSatuanActionPerformed

    private void cbKategori_barangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKategori_barangItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbKategori_barangItemStateChanged

    private void cbKategori_barangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbKategori_barangKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cbKategori_barangKeyReleased

    private void cbKategori_barangInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cbKategori_barangInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbKategori_barangInputMethodTextChanged

    private void reset() {
        tfId_Barang.setText("");
        tfNama_Barang.setText("");
        cbSatuan.setSelectedIndex(0);
        spStok.setValue(0);
        tfTgl_Exp.setText("");
        tfHarga_Beli.setText("");
        tfHarga_Jual.setText("");
        cbKategori_barang.setSelectedIndex(0);

        //yang radio button belum
        tfId_Barang.grabFocus();
    }

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
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnSimpan;
    private java.awt.Button btnUbah;
    private java.awt.Button btndelete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbKategori_barang;
    private javax.swing.JComboBox<String> cbSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbBiasa;
    private javax.swing.JRadioButton rbHotItem;
    private javax.swing.JSpinner spStok;
    private javax.swing.JTable tblBarang;
    private java.awt.TextField tfHarga_Beli;
    private java.awt.TextField tfHarga_Jual;
    private javax.swing.JTextField tfId_Barang;
    private javax.swing.JTextField tfNama_Barang;
    private javax.swing.JTextField tfTgl_Exp;
    // End of variables declaration//GEN-END:variables
}
