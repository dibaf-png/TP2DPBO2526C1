<?php
class Produk { //membuat class bernama Produk
    private string $id_produk; //menyimpan ID unik produk
    private string $nama_produk; //menyimpan nama produk 
    private int $harga; //menyimpan harga produk 

    // Constructor untuk membuat object Produk
    public function __construct(string $id_produk, string $nama_produk, int $harga) {
        $this->id_produk = $id_produk; //mengisi atribut ID dengan nilai dari parameter
        $this->nama_produk = $nama_produk; //mengisi atribut nama dengan nilai dari parameter
        $this->harga = $harga; //mengisi atribut harga dengan nilai dari parameter
    }

    //setter untuk mengubah ID produk
    public function setId($id_produk) {
        $this->id_produk = $id_produk; //mengubah nilai id_produk
    }

    //getter untuk mengambil ID produk
    public function getId() {
        return $this->id_produk; //mengembalikan nilai id_produk
    }

    //setter untuk mengubah nama produk
    public function setNama($nama_produk) {
        $this->nama_produk = $nama_produk; //mengubah nilai nama_produk
    }

    //getter untuk mengambil nama produk
    public function getNama() {
        return $this->nama_produk; //mengembalikan nilai nama_produk
    }

    //setter untukmengubah harga produk
    public function setHarga($harga) {
        $this->harga = $harga; //mengubah nilai harga
    }

    //getter untuk mengambil harga produk
    public function getHarga() {
        return $this->harga; //mengembalikan nilai harga
    }
}
?>