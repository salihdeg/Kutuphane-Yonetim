-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 14 Oca 2021, 22:45:39
-- Sunucu sürümü: 10.4.11-MariaDB
-- PHP Sürümü: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kutuphane`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_kategori`
--

CREATE TABLE `tbl_kategori` (
  `Id` int(11) NOT NULL,
  `Kategori_Adi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tbl_kategori`
--

INSERT INTO `tbl_kategori` (`Id`, `Kategori_Adi`) VALUES
(1, 'Roman'),
(3, 'Şiir Kitabı'),
(4, 'Tarih Kitabı'),
(5, 'Hukuk Kitabı'),
(6, 'Felsefe Kitabı'),
(7, 'Dini Kitaplar'),
(8, 'Çocuk Kitapları'),
(9, 'Eğitici Kitaplar');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_kitaplar`
--

CREATE TABLE `tbl_kitaplar` (
  `Id` int(11) NOT NULL,
  `Kitap_Adi` varchar(100) NOT NULL,
  `Yazar_Adi` varchar(50) NOT NULL,
  `Yayin_Evi` varchar(50) NOT NULL,
  `Basim_Tarihi` varchar(10) NOT NULL,
  `ISBN` varchar(13) NOT NULL,
  `Kategori` varchar(50) NOT NULL,
  `Durum` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tbl_kitaplar`
--

INSERT INTO `tbl_kitaplar` (`Id`, `Kitap_Adi`, `Yazar_Adi`, `Yayin_Evi`, `Basim_Tarihi`, `ISBN`, `Kategori`, `Durum`) VALUES
(2, 'Martı Jonathan Livingston', 'Richard Bach', 'Epsilon Yayınevi', '01.10.2011', '9753310080', 'Roman', b'1'),
(3, 'Güzel Ve Etkili Konuşma Sanatı', 'Mehmet Doğru', 'Damla Yayınları', '01.10.2010', '9759753813112', 'Eğitici Kitaplar', b'1'),
(4, 'Suikastçının İnancı Assassin\'s Creed Yoldaşlık', 'Oliver Bowden', 'Epsilon Yayınevi', '01.11.2014', '9789944829052', 'Roman', b'1'),
(5, 'The Catcher in the Rye', 'Jerome David Salinger', 'Penguin Books', '01.01.2010', '9780241950432', 'Roman', b'1'),
(6, 'Sonsuz Nur', 'Onk. Dr. Haluk Nurbaki', 'Damla Yayınları', '01.01.1987', '9753810210', 'Dini Kitaplar', b'1'),
(7, 'BELLEK GÜÇLENDİRME TEKNİKLERİ', 'DONALD H. WEİSS', 'Rota Yayınları', '01.01.1993', '9757805327', 'Eğitici Kitaplar', b'1'),
(9, 'İnsan İsterse - Azmin Zaferi Öyküleri 4', 'Mümin Sekman', 'Alfa Yayıncılık', '01.11.2009', '9786051061726', 'Eğitici Kitaplar', b'1'),
(10, 'Hitler Oyuncağımı Çaldı', 'Judith Kerr', 'Akyüz Yayınları', '01.10.1988', '9799756304043', 'Roman', b'1'),
(11, 'Evrende Tesadüf Yoktur Yankı Vardır', 'Nusret Kaya', 'Destek Yayınları', '01.02.2012', '9786054607136', 'Eğitici Kitaplar', b'1'),
(12, 'Cumhuriyet Dönemi Öncesinde Türkler', 'Yılmaz Öztuna', 'Babıali Kültür Yayıncılığı', '01.08.2006', '9758486659', 'Tarih Kitabı', b'1'),
(13, 'Kişisel Verilerin Korunması Hukuku', 'A. Çiğdem Ayözger Öngün', 'Beta Yayınevi', '01.01.2019', '9786052421833', 'Hukuk Kitabı', b'1'),
(14, 'Henüz Vakit Varken Gülüm', 'Nazım Hikmet', 'Yapı Kredi Yayınları', '01.01.2008', '9789750814068', 'Şiir Kitabı', b'1'),
(15, 'Haritada Kaybolmak', 'Vladimir Tumanov', 'Günışığı Kitaplığı', '01.04.2006', '9789756227268', 'Roman', b'1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_odunc`
--

CREATE TABLE `tbl_odunc` (
  `Id` int(11) NOT NULL,
  `Ad_Soyad` varchar(100) NOT NULL,
  `Tlf_No` varchar(11) NOT NULL,
  `Kitap_Adi` varchar(100) NOT NULL,
  `Alma_Tarihi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `tbl_kitaplar`
--
ALTER TABLE `tbl_kitaplar`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `tbl_odunc`
--
ALTER TABLE `tbl_odunc`
  ADD PRIMARY KEY (`Id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_kitaplar`
--
ALTER TABLE `tbl_kitaplar`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_odunc`
--
ALTER TABLE `tbl_odunc`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
