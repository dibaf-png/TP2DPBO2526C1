<?php
require_once 'Produk.php'; //mengimpor file class Produk

class ProdukMakanan extends Produk { // Membuat class ProdukMakanan yang mewarisi class Produk

    private string $bahan; // Menyimpan bahan produk makanan
    private string $rasa; // Menyimpan rasa produk makanan
    private string $lama_ketahanan; // Menyimpan lama ketahanan produk makanan

    // Constructor untuk membuat object ProdukMakanan
    public function __construct(string $id_produk, string $nama_produk, int $harga, string $bahan, string $rasa, string $lama_ketahanan) {
        parent::__construct($id_produk, $nama_produk, $harga); // Memanggil constructor parent class Produk
        $this->bahan = $bahan; // Mengisi atribut bahan dengan nilai dari parameter
        $this->rasa = $rasa; // Mengisi atribut rasa dengan nilai dari parameter
        $this->lama_ketahanan = $lama_ketahanan; // Mengisi atribut lama_ketahanan dengan nilai dari parameter
            
    }

    //setter untuk mengubah bahan
    public function setBahan($bahan) {
        $this->bahan = $bahan; // Mengubah nilai atribut bahan
    }

    //getter untuk mengambil bahan
    public function getBahan() {
        return $this->bahan; // Mengembalikan nilai atribut bahan
    }

    //setter untuk mengubah rasa
    public function setRasa($rasa) {
        $this->rasa = $rasa; // Mengubah nilai atribut rasa
    }

    //getter untuk mengambil rasa
    public function getRasa() {
        return $this->rasa; // Mengembalikan nilai atribut rasa
    }

    //setter untuk mengubah lama ketahanan
    public function setLama_ketahanan($lama_ketahanan) {
        $this->lama_ketahanan = $lama_ketahanan; // Mengubah nilai atribut lama_ketahanan
    }

    //getter untuk mengambil lama ketahanan
    public function getLama_ketahanan() {
        return $this->lama_ketahanan; // Mengembalikan nilai atribut lama_ketahanan
    }

}

?>