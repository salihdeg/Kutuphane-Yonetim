/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sayfalar;

/**
 *
 * @author Salih Degirmenci
 */
class Oduncler {
    String Ad_Soyad,Kitap_Adi;
    java.sql.Date Alma_Tarihi;
    public Oduncler(String Ad_Soyad,String Kitap_Adi,java.sql.Date Alma_Tarihi){
        this.Kitap_Adi = Kitap_Adi;
        this.Ad_Soyad = Ad_Soyad;
        this.Alma_Tarihi = Alma_Tarihi;
    }

    public String Kitap_Adi(){
        return Kitap_Adi;
    }
    public String Ad_Soyad(){
        return Ad_Soyad;
    }
    public java.sql.Date Alma_Tarihi(){
        return Alma_Tarihi;
    }
}
