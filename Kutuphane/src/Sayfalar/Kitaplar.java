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
class Kitaplar {
    String Kitap_Adi,Yazar_Adi,Yayin_Evi,Basim_Tarihi,ISBN,Kategori;
    public Kitaplar(String Kitap_Adi,String Yazar_Adi,String Yayin_Evi,String Basim_Tarihi,String ISBN,String Kategori){
        this.Kitap_Adi = Kitap_Adi;
        this.Yazar_Adi = Yazar_Adi;
        this.Yayin_Evi = Yayin_Evi;
        this.Basim_Tarihi = Basim_Tarihi;
        this.ISBN = ISBN;
        this.Kategori = Kategori;
    }
    
    public String Kitap_Adi(){
        return Kitap_Adi;
    }
    public String Yazar_Adi(){
        return Yazar_Adi;
    }
    public String Yayin_Evi(){
        return Yayin_Evi;
    }
    public String Basim_Tarihi(){
        return Basim_Tarihi;
    }
    public String ISBN(){
        return ISBN;
    }
    public String Kategori(){
        return Kategori;
    }
    
}
