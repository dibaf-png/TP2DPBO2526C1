<?php
require_once 'ProdukMakanan.php'; //mengimpor file class ProdukMakanan

class JajananTradisional extends ProdukMakanan { //membuat class JajananTradisional yang mewarisi class ProdukMakanan

    private $asal_daerah; //menyimpan asal daerah jajanan tradisional 
    private $cara_penyajian; //menyimpan cara penyajian jajanan tradisional 
    private $jenis_jajanan; //menyimpan jenis jajanan tradisional 
    private $gambar; //menyimpan nama/path file foto produk 

    //constructor untuk membuat object JajananTradisional
    public function __construct(string $id_produk, string $nama_produk, int $harga, string $bahan, string $rasa, string $lama_ketahanan, string $asal_daerah, string $cara_penyajian, string $jenis_jajanan, string $gambar) {
        parent::__construct($id_produk, $nama_produk, $harga, $bahan, $rasa, $lama_ketahanan); //memanggil constructor ProdukMakanan
        $this->asal_daerah = $asal_daerah;       // Mengisi atribut asal daerah dengan nilai dari parameter
        $this->cara_penyajian = $cara_penyajian; // Mengisi atribut cara penyajian dengan nilai dari parameter
        $this->jenis_jajanan = $jenis_jajanan;   // Mengisi atribut jenis jajanan dengan nilai dari parameter
        $this->gambar = $gambar;       // Mengisi atribut gambar dengan nilai dari parameter
    }

    //setter untuk mengubah asal daerah
    public function setAsalDaerah($asal_daerah) {
        $this->asal_daerah = $asal_daerah; // Mengubah nilai atribut asal_daerah
    }

    // Getter untuk mengambil asal daerah
    public function getAsalDaerah() {
        return $this->asal_daerah; // Mengembalikan nilai atribut asal_daerah
    }

    //setter untuk mengubah cara penyajian
    public function setCaraPenyajian($cara_penyajian) {
        $this->cara_penyajian = $cara_penyajian; // Mengubah nilai atribut cara_penyajian
    }

    // Getter untuk mengambil cara penyajian
    public function getCaraPenyajian() {
        return $this->cara_penyajian; // Mengembalikan nilai atribut cara_penyajian
    }

    //setter untuk mengubah jenis jajanan
    public function setJenisJajanan($jenis_jajanan) {
        $this->jenis_jajanan = $jenis_jajanan; // Mengubah nilai atribut jenis_jajanan
    }

    // Getter untuk mengambil jenis jajanan
    public function getJenisJajanan() {
        return $this->jenis_jajanan; // Mengembalikan nilai atribut jenis_jajanan
    }

    //setter untuk mengubah foto produk
    public function setGambar($gambar) {
        $this->gambar = $gambar; // Mengubah nilai atribut gambar
    }

    // Getter untuk mengambil foto produk
    public function getGambar() {
        return $this->gambar; // Mengembalikan nilai atribut gambar
    }
}

?>