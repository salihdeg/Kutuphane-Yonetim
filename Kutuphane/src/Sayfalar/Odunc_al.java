/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sayfalar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Salih Degirmenci
 */
public class Odunc_al extends javax.swing.JFrame {

    /**
     * Creates new form Odunc_al
     */
    public Odunc_al() {
        initComponents();
        this.setLocationRelativeTo(null);
        kitaplariGoster();
        jTextField_almaTarihi.setText(LocalDate.now().toString());
        LocalDate c1 = LocalDate.now();
        LocalDate c2 = LocalDate.parse("2020-01-08");
        Date d2 = java.sql.Date.valueOf(c2);
        Date d1 = java.sql.Date.valueOf(c1);
        long diff = d2.getTime() - d1.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        
        //JOptionPane.showMessageDialog(null,"Tarih farkı: "+diffDays);
    }
    public boolean kitapSecimKontrol(){
        String Kitap_Adi = jTextField_Kitap_Adi.getText();
        String Yazar_Adi = jTextField_Yazar_Adi.getText();
        String Yayin_Evi = jTextField_Yayin_Evi.getText();
        String Basim_Tarihi = jTextField_Basim_Tarihi.getText();
        JLabel mesaj = new JLabel("Kitap Seçimi Yapmadınız!");
        mesaj.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        if (Kitap_Adi.trim().equals("") || Yazar_Adi.trim().equals("") || Yayin_Evi.trim().equals("")
                || Basim_Tarihi.trim().equals("")) {
            JOptionPane.showMessageDialog(null,mesaj,"Eksik Bilgi!",2);
            return false;
        }else{
            return true;
        }
    }
    public boolean aliciSecimiKontrol(){
        JLabel mesaj = new JLabel("Alıcı Bilgileri Eksik");
        mesaj.setFont(new Font("Times New Roman", Font.BOLD, 18));
        String Ad_Soyad = jTextField_ad_soyad.getText();
        String Tlf_No = jTextField_tlfNo.getText();
        if(Ad_Soyad.trim().equals("") || Tlf_No.trim().equals("")){
            JOptionPane.showMessageDialog(null,mesaj,"Eksik Bilgi",2);
            return false;
        }else{
            return true;
        }
    }
    
    public boolean aldiMi(String adSoyad,String tlfNo,String Kitap_Adi){
        JLabel mesaj = new JLabel("Aynı Kitabı Aynı Kişi Bir Kez Alabilir!");
        mesaj.setFont(new Font("Times New Roman", Font.BOLD, 18));
        PreparedStatement st;
        ResultSet rs;
        boolean oduncVarMi=false;
        
        String query = "SELECT * FROM `tbl_odunc` WHERE `Ad_Soyad` = ? and `Tlf_No` = ? and `Kitap_Adi` = ?";
        
        try {
            st = (PreparedStatement) My_CNX.getConnection().prepareStatement(query);
            st.setString(1, adSoyad);
            st.setString(2, tlfNo);
            st.setString(3, Kitap_Adi);
            rs = st.executeQuery();
            if(rs.next()){
                oduncVarMi=true;
                JOptionPane.showMessageDialog(null,mesaj,"Tekrar Eden Kayıt!",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kitap_ekle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oduncVarMi;
    }
    
    
    public ArrayList<Kitaplar2> Kitaplari_Al(){
        ArrayList<Kitaplar2> kitapListesi = new ArrayList<>();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT `Kitap_Adi`, `Yazar_Adi`, `Yayin_Evi`, `Basim_Tarihi` FROM `tbl_kitaplar` WHERE `Durum` = 1";

        try {
            st = (PreparedStatement) My_CNX.getConnection().prepareStatement(query);
            rs= st.executeQuery(query);
            Kitaplar2 kitaplar2;
            //Gelen Tüm verileri almak için
            while (rs.next()) {
                kitaplar2 = new Kitaplar2(rs.getString("Kitap_Adi"),rs.getString("Yazar_Adi"),rs.getString("Yayin_Evi"),rs.getString("Basim_Tarihi"));
                kitapListesi.add(kitaplar2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kitap_Goruntule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kitapListesi;
    }
    public void kitaplariGoster(){
        ArrayList<Kitaplar2> liste = Kitaplari_Al();
        DefaultTableModel model = (DefaultTableModel) jTable_kitaplar.getModel();
        Object[] satir = new Object[4];
        for (int i = 0; i < liste.size(); i++) {
            satir[0] = liste.get(i).Kitap_Adi();
            satir[1] = liste.get(i).Yazar_Adi();
            satir[2] = liste.get(i).Yayin_Evi();
            satir[3] = liste.get(i).Basim_Tarihi();
            model.addRow(satir);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        HomePage_Icon = new javax.swing.JLabel();
        kapat = new javax.swing.JLabel();
        Kucult_icon = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Kitap_Adi = new javax.swing.JTextField();
        jTextField_Yazar_Adi = new javax.swing.JTextField();
        jTextField_Yayin_Evi = new javax.swing.JTextField();
        jTextField_Basim_Tarihi = new javax.swing.JTextField();
        jButton_tabloyuYenile = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_ad_soyad = new javax.swing.JTextField();
        jTextField_tlfNo = new javax.swing.JTextField();
        jTextField_almaTarihi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_kitaplar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 559));

        HomePage_Icon.setToolTipText("ANAMENU");
        HomePage_Icon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomePage_Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomePage_IconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomePage_IconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomePage_IconMouseExited(evt);
            }
        });

        kapat.setToolTipText("KAPAT");
        kapat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kapat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kapatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kapatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kapatMouseExited(evt);
            }
        });

        Kucult_icon.setToolTipText("Simge Durumuna");
        Kucult_icon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kucult_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kucult_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Kucult_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Kucult_iconMouseExited(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kıitap Ödünç Verme");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomePage_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247)
                .addComponent(Kucult_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomePage_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kucult_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        HomePage_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/homepage-icon.png")));
        kapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kapat.png")));
        Kucult_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kucult.png")));

        jPanel3.setPreferredSize(new java.awt.Dimension(1170, 450));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Kitap Adı:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Yazar Adı:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Yayın Evi:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Basım Tarihi:");

        jTextField_Kitap_Adi.setEditable(false);
        jTextField_Kitap_Adi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField_Kitap_Adi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Kitap_AdiActionPerformed(evt);
            }
        });

        jTextField_Yazar_Adi.setEditable(false);
        jTextField_Yazar_Adi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField_Yazar_Adi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Yazar_AdiActionPerformed(evt);
            }
        });

        jTextField_Yayin_Evi.setEditable(false);
        jTextField_Yayin_Evi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jTextField_Basim_Tarihi.setEditable(false);
        jTextField_Basim_Tarihi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField_Basim_Tarihi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Basim_TarihiActionPerformed(evt);
            }
        });

        jButton_tabloyuYenile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_tabloyuYenile.setText("Tabloyu Yenile");
        jButton_tabloyuYenile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_tabloyuYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tabloyuYenileActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Adı Soyadı:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Telefon No:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Aldığı Tarih:");

        jTextField_ad_soyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ad_soyadActionPerformed(evt);
            }
        });

        jTextField_tlfNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_tlfNoKeyTyped(evt);
            }
        });

        jTextField_almaTarihi.setEditable(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setText("Ödünç Ver");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tablodan İstediğiniz Kitabı Seçiniz");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(134, 134, 134))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Yazar_Adi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Yayin_Evi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Basim_Tarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Kitap_Adi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_ad_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_almaTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_tlfNo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton_tabloyuYenile)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_tabloyuYenile)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Kitap_Adi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Yazar_Adi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Yayin_Evi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Basim_Tarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_ad_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_tlfNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_almaTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable_kitaplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kitap Adı", "Yazar Adı", "Yayın Evi", "Basım Tarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_kitaplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_kitaplarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_kitaplar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomePage_IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomePage_IconMouseClicked
        Anasayfa form = new Anasayfa();
        form.setVisible(true);
        form.pack();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_HomePage_IconMouseClicked

    private void HomePage_IconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomePage_IconMouseEntered
        HomePage_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/homepage2-icon.png")));
    }//GEN-LAST:event_HomePage_IconMouseEntered

    private void HomePage_IconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomePage_IconMouseExited
        HomePage_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/homepage-icon.png")));
    }//GEN-LAST:event_HomePage_IconMouseExited

    private void kapatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kapatMouseClicked
        System.exit(0);
    }//GEN-LAST:event_kapatMouseClicked

    private void kapatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kapatMouseEntered
        kapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kapat2.png")));
    }//GEN-LAST:event_kapatMouseEntered

    private void kapatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kapatMouseExited
        kapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kapat.png")));
    }//GEN-LAST:event_kapatMouseExited

    private void Kucult_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kucult_iconMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_Kucult_iconMouseClicked

    private void Kucult_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kucult_iconMouseEntered
        Kucult_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kucult2.png")));
    }//GEN-LAST:event_Kucult_iconMouseEntered

    private void Kucult_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kucult_iconMouseExited
        Kucult_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kucult.png")));
    }//GEN-LAST:event_Kucult_iconMouseExited

    private void jTextField_Yazar_AdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Yazar_AdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Yazar_AdiActionPerformed

    private void jTextField_Kitap_AdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Kitap_AdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Kitap_AdiActionPerformed

    private void jButton_tabloyuYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tabloyuYenileActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable_kitaplar.getModel();
        model.setRowCount(0);
        kitaplariGoster();
        jTextField_Kitap_Adi.setText("");
        jTextField_Yazar_Adi.setText("");
        jTextField_Yayin_Evi.setText("");
        jTextField_Basim_Tarihi.setText("");
    }//GEN-LAST:event_jButton_tabloyuYenileActionPerformed

    private void jTable_kitaplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_kitaplarMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable_kitaplar.getModel();
        int seciliSatirIndex = jTable_kitaplar.getSelectedRow();
        jTextField_Kitap_Adi.setText(model.getValueAt(seciliSatirIndex,0).toString());
        jTextField_Yazar_Adi.setText(model.getValueAt(seciliSatirIndex,1).toString());
        jTextField_Yayin_Evi.setText(model.getValueAt(seciliSatirIndex,2).toString());
        jTextField_Basim_Tarihi.setText(model.getValueAt(seciliSatirIndex,3).toString());
    }//GEN-LAST:event_jTable_kitaplarMouseClicked

    private void jTextField_Basim_TarihiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Basim_TarihiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Basim_TarihiActionPerformed

    private void jTextField_ad_soyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ad_soyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ad_soyadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Kitap Bilgileri
        String Kitap_Adi = jTextField_Kitap_Adi.getText();
        String Yazar_Adi = jTextField_Yazar_Adi.getText();
        String Yayin_Evi = jTextField_Yayin_Evi.getText();
        String Basim_Tarihi = jTextField_Basim_Tarihi.getText();
        //Update için gerekli olan durum biti
        Integer Durum = 0;
        //Alıcı Bilgileri
        String Ad_Soyad = jTextField_ad_soyad.getText().trim();
        String Tlf_No = jTextField_tlfNo.getText();
        java.sql.Date Alma_Tarihi = java.sql.Date.valueOf(java.time.LocalDate.now());
        //Mesajlar (Boyutlandırılmış)
        JLabel mesaj = new JLabel("Ödünç Verildi!");
        mesaj.setFont(new Font("Times New Roman", Font.BOLD, 18));
        JLabel mesaj2 = new JLabel("Kitabı Geri Getirmek İçin 10 Gününüz Var! 10 Günden Sonra Gün Başına 5TL 15 Günden Sonra 5TL'nin Üstüne Her Günkü Ücretin %5'i Kadar Ceza Yansıtılır!");
        mesaj2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        JLabel mesaj3 = new JLabel("Kitaplar Tablosu Güncellendi!");
        mesaj.setFont(new Font("Times New Roman", Font.BOLD, 18));
        JLabel mesaj4 = new JLabel("Hata: Tablo Güncellenemedi!\nTRANSACTION BULUNAMADI!");
        mesaj4.setFont(new Font("Times New Roman", Font.BOLD, 18));
        JLabel mesaj5 = new JLabel("Hata: Bilgilerinizi Kontrol Edin");
        mesaj5.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        if(kitapSecimKontrol()){
            if(aliciSecimiKontrol()){
                if(!aldiMi(Ad_Soyad,Tlf_No,Kitap_Adi)){
                    PreparedStatement ps,us;
                    ResultSet rs;
                    String KaydetmeQuery = "INSERT INTO `tbl_odunc`(`Ad_Soyad`, `Tlf_No`, `Kitap_Adi`, `Alma_Tarihi`) VALUES (?,?,?,?)";
                    String UpdateQuery = "UPDATE `tbl_kitaplar` SET `Durum`= 0 WHERE `Kitap_Adi` = ?";
                    try {
                        ps=(PreparedStatement) My_CNX.getConnection().prepareStatement(KaydetmeQuery);
                        ps.setString(1, Ad_Soyad);
                        ps.setString(2, Tlf_No);
                        ps.setString(3, Kitap_Adi);
                        ps.setDate(4, Alma_Tarihi);
                        if(ps.executeUpdate() != 0){
                            JOptionPane.showMessageDialog(null,mesaj);
                            JOptionPane.showMessageDialog(null,mesaj2,"Zaman Uyarısı",2);
                            try {
                                us = (PreparedStatement) My_CNX.getConnection().prepareStatement(UpdateQuery);
                                us.setString(1,Kitap_Adi);
                                if(us.executeUpdate() != 0){
                                    JOptionPane.showMessageDialog(null,mesaj3);
                                    DefaultTableModel model = (DefaultTableModel) jTable_kitaplar.getModel();
                                    model.setRowCount(0);
                                    kitaplariGoster();
                                    jTextField_Kitap_Adi.setText("");
                                    jTextField_Yazar_Adi.setText("");
                                    jTextField_Yayin_Evi.setText("");
                                    jTextField_Basim_Tarihi.setText("");
                                }else{
                                    JOptionPane.showMessageDialog(null,mesaj4);
                                    DefaultTableModel model = (DefaultTableModel) jTable_kitaplar.getModel();
                                    model.setRowCount(0);
                                    kitaplariGoster();
                                    jTextField_Kitap_Adi.setText("");
                                    jTextField_Yazar_Adi.setText("");
                                    jTextField_Yayin_Evi.setText("");
                                    jTextField_Basim_Tarihi.setText("");
                                }
                            } catch (SQLException e) {
                                Logger.getLogger(Kitap_ekle.class.getName()).log(Level.SEVERE, null, e);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,mesaj5);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Kitap_ekle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_tlfNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_tlfNoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_tlfNoKeyTyped

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
            java.util.logging.Logger.getLogger(Odunc_al.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Odunc_al.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Odunc_al.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Odunc_al.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Odunc_al().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HomePage_Icon;
    private javax.swing.JLabel Kucult_icon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_tabloyuYenile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_kitaplar;
    private javax.swing.JTextField jTextField_Basim_Tarihi;
    private javax.swing.JTextField jTextField_Kitap_Adi;
    private javax.swing.JTextField jTextField_Yayin_Evi;
    private javax.swing.JTextField jTextField_Yazar_Adi;
    private javax.swing.JTextField jTextField_ad_soyad;
    private javax.swing.JTextField jTextField_almaTarihi;
    private javax.swing.JTextField jTextField_tlfNo;
    private javax.swing.JLabel kapat;
    // End of variables declaration//GEN-END:variables
}
