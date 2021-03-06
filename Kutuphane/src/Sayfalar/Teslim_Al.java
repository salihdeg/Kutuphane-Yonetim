package Sayfalar;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
public class Teslim_Al extends javax.swing.JFrame {

    /**
     * Creates new form Teslim_Al
     */
    public Teslim_Al() {
        initComponents();
        this.setLocationRelativeTo(null);
        ShowOdunc();
    }
    
    public void cezaVarMi(long gunFarki){
        JLabel mesaj = new JLabel("Emanetinizi Zamanında Getirdiğiniz İçin Teşekkür Ederiz!");
        mesaj.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        double ucret = 0;
        if(gunFarki<=10){
            JOptionPane.showMessageDialog(null,mesaj,"Teşekkür Mesajı",1,new javax.swing.ImageIcon(getClass().getResource("/Resimler/smile-img.png")));
        }
        if(gunFarki>10){
            for (long i = 11; i <= gunFarki; i++) {
                if(i>15){
                    ucret+=5+(ucret*0.05);
                }else ucret+=5; 
            }
            JLabel mesaj2 = new JLabel("Geçikme Sebebiyle "+new DecimalFormat("##.##").format(ucret)+"TL Ceza Aldınız!");
            mesaj2.setFont(new Font("Times New Roman", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,mesaj2, "GEÇİKME CEZASI", 0, new javax.swing.ImageIcon(getClass().getResource("/Resimler/angry-img.png")));
        }
    }
    
    public boolean kitapSectiMi(){
        String Kitap_Adi = jTextField_Kitap_Adi.getText();
        String ad_soyad = jTextField_ad_soyad.getText();
        String almaTarihi = jTextField_almaTarihi.getText();
        JLabel mesaj = new JLabel("Lütfen Tablodan Kitap Seçiniz!");
        mesaj.setFont(new Font("Times New Roman", Font.BOLD, 18));
        if(Kitap_Adi.equals("") || ad_soyad.equals("") || almaTarihi.equals("")){
            JOptionPane.showMessageDialog(null,mesaj,"Seçim Yapılmamış",2);
            return false;
        }else{
            return true;
        }
    }
    public boolean VerdiMi(String adSoyad,String Kitap_Adi){
        JLabel mesaj = new JLabel("Kitabı Zaten Teslim Ettiniz");
        mesaj.setFont(new Font("Times New Roman", Font.BOLD, 18));
        PreparedStatement st;
        ResultSet rs;
        boolean oduncVarMi=false;
        
        String query = "SELECT * FROM `tbl_kitaplar` WHERE `Kitap_Adi` = ? and `Durum` = 1";
        
        try {
            st = (PreparedStatement) My_CNX.getConnection().prepareStatement(query);
            st.setString(1, Kitap_Adi);
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
    public ArrayList<Oduncler> GetOdunc(){
        ArrayList<Oduncler> oduncListesi = new ArrayList<>();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT `Ad_Soyad`, `Kitap_Adi`, `Alma_Tarihi` FROM `tbl_odunc`";

        try {
            st = (PreparedStatement) My_CNX.getConnection().prepareStatement(query);
            rs= st.executeQuery(query);
            Oduncler oduncler2;
            //Gelen Tüm verileri almak için
            while (rs.next()) {
                oduncler2 = new Oduncler(rs.getString("Ad_Soyad"),rs.getString("Kitap_Adi"),rs.getDate("Alma_Tarihi"));
                oduncListesi.add(oduncler2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kitap_Goruntule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oduncListesi;
    }
    public void ShowOdunc(){
        ArrayList<Oduncler> liste = GetOdunc();
        DefaultTableModel model = (DefaultTableModel) jTable_oduncler.getModel();
        Object[] satir = new Object[3];
        for (int i = 0; i < liste.size(); i++) {
            satir[0] = liste.get(i).Ad_Soyad();
            satir[1] = liste.get(i).Kitap_Adi();
            satir[2] = liste.get(i).Alma_Tarihi();
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
        jPanel3 = new javax.swing.JPanel();
        HomePage_Icon = new javax.swing.JLabel();
        kapat = new javax.swing.JLabel();
        Kucult_icon = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_oduncler = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton_Yenile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Kitap_Adi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_ad_soyad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_almaTarihi = new javax.swing.JTextField();
        jButton_teslimAl = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));

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
        jLabel8.setText("Kıitap Teslim Alma");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomePage_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230)
                .addComponent(Kucult_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomePage_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kucult_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        HomePage_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/homepage-icon.png")));
        kapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kapat.png")));
        Kucult_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/kucult.png")));

        jTable_oduncler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ad Soyad", "Kitap Adı", "Alma Tarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_oduncler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_odunclerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_oduncler);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Teslim Almak İstediğiniz Kitabı Seçin");
        jLabel1.setToolTipText("");
        jLabel1.setAutoscrolls(true);

        jButton_Yenile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Yenile.setText("Tabloyu Yenile");
        jButton_Yenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_YenileActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Kitap Adı:");

        jTextField_Kitap_Adi.setEditable(false);
        jTextField_Kitap_Adi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField_Kitap_Adi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Kitap_AdiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Adı Soyadı:");

        jTextField_ad_soyad.setEditable(false);
        jTextField_ad_soyad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField_ad_soyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ad_soyadActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Aldığı Tarih:");

        jTextField_almaTarihi.setEditable(false);
        jTextField_almaTarihi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton_teslimAl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_teslimAl.setText("Teslim Al");
        jButton_teslimAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_teslimAlActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ve Teslim Al Butonuna Tıklayın");
        jLabel3.setToolTipText("");
        jLabel3.setAutoscrolls(true);
        jLabel3.setMaximumSize(new java.awt.Dimension(291, 22));
        jLabel3.setMinimumSize(new java.awt.Dimension(291, 22));
        jLabel3.setPreferredSize(new java.awt.Dimension(291, 22));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton_Yenile))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton_teslimAl)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField_Kitap_Adi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_ad_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_almaTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Yenile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_ad_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_Kitap_Adi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_almaTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addComponent(jButton_teslimAl)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton_YenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_YenileActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable_oduncler.getModel();
        model.setRowCount(0);
        jTextField_Kitap_Adi.setText("");
        jTextField_ad_soyad.setText("");
        jTextField_almaTarihi.setText("");
        ShowOdunc();
    }//GEN-LAST:event_jButton_YenileActionPerformed

    private void jTextField_Kitap_AdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Kitap_AdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Kitap_AdiActionPerformed

    private void jTextField_ad_soyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ad_soyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ad_soyadActionPerformed

    private void jButton_teslimAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_teslimAlActionPerformed
        //Kitap Bilgileri
        String Ad_Soyad = jTextField_Kitap_Adi.getText();
        String Kitap_Adi = jTextField_Kitap_Adi.getText();
        //Mesajlar İçin Boyutladırma
        JLabel mesajTeslim = new JLabel("Teslim Alındı!");
        JLabel mesajUpdate = new JLabel("Kitaplar Tablosu Güncellendi!");
        JLabel mesajUpdateError = new JLabel("Hata: Tablo Güncellenemedi!\nTRANSACTION BULUNAMADI!");
        JLabel mesajErrorCheckFields = new JLabel("Hata: Bilgilerinizi Kontrol Edin");
        //Fonts For Messages
        mesajTeslim.setFont(new Font("Times New Roman", Font.BOLD, 18));
        mesajUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
        mesajUpdateError.setFont(new Font("Times New Roman", Font.BOLD, 18));
        mesajErrorCheckFields.setFont(new Font("Times New Roman", Font.BOLD, 18));
        if(kitapSectiMi()){
            java.sql.Date Alma_Tarihi = java.sql.Date.valueOf(jTextField_almaTarihi.getText());
            //Teslim İçin gerekli tanımlamalar
            Date d1 = java.sql.Date.valueOf(LocalDate.now());
            long fark = d1.getTime() - Alma_Tarihi.getTime();
            long gunFarki = fark / (24 * 60 * 60 * 1000);
                if(!VerdiMi(Ad_Soyad,Kitap_Adi)){
                    PreparedStatement ps,us;
                    String DeleteQuery = "DELETE FROM `tbl_odunc` WHERE `Kitap_Adi` = ?";
                    String UpdateQuery = "UPDATE `tbl_kitaplar` SET `Durum`= 1 WHERE `Kitap_Adi` = ?";

                    try {
                        ps=(PreparedStatement) My_CNX.getConnection().prepareStatement(DeleteQuery);
                        ps.setString(1, Kitap_Adi);
                        if(ps.executeUpdate() != 0){
                            JOptionPane.showMessageDialog(null,mesajTeslim);
                            cezaVarMi(gunFarki);
                            try {
                                us = (PreparedStatement) My_CNX.getConnection().prepareStatement(UpdateQuery);
                                us.setString(1,Kitap_Adi);
                                if(us.executeUpdate() != 0){
                                    JOptionPane.showMessageDialog(null,mesajUpdate);
                                }else{
                                    JOptionPane.showMessageDialog(null, mesajUpdateError);
                                }
                            } catch (SQLException e) {
                                Logger.getLogger(Kitap_ekle.class.getName()).log(Level.SEVERE, null, e);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,mesajErrorCheckFields,"Bilgilerde Sıkıntı Var",1);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Kitap_ekle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
        DefaultTableModel model = (DefaultTableModel) jTable_oduncler.getModel();
        model.setRowCount(0);
        jTextField_Kitap_Adi.setText("");
        jTextField_ad_soyad.setText("");
        jTextField_almaTarihi.setText("");
        ShowOdunc();
    }//GEN-LAST:event_jButton_teslimAlActionPerformed

    private void jTable_odunclerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_odunclerMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable_oduncler.getModel();
        int seciliSatirIndex = jTable_oduncler.getSelectedRow();
        jTextField_ad_soyad.setText(model.getValueAt(seciliSatirIndex,0).toString());
        jTextField_Kitap_Adi.setText(model.getValueAt(seciliSatirIndex,1).toString());
        jTextField_almaTarihi.setText(model.getValueAt(seciliSatirIndex,2).toString());
    }//GEN-LAST:event_jTable_odunclerMouseClicked

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
            java.util.logging.Logger.getLogger(Teslim_Al.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teslim_Al.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teslim_Al.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teslim_Al.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teslim_Al().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HomePage_Icon;
    private javax.swing.JLabel Kucult_icon;
    private javax.swing.JButton jButton_Yenile;
    private javax.swing.JButton jButton_teslimAl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_oduncler;
    private javax.swing.JTextField jTextField_Kitap_Adi;
    private javax.swing.JTextField jTextField_ad_soyad;
    private javax.swing.JTextField jTextField_almaTarihi;
    private javax.swing.JLabel kapat;
    // End of variables declaration//GEN-END:variables
}
