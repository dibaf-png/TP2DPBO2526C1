public class ProdukMakanan extends Produk {//membuat class ProdukMakanan yang mewarisi (extends) dari class Produk secara public
    //hak akses private hanya dapat diakses langsung dari dalam class
    private String bahan; //menyimpan bahan produk makanan
    private String rasa; //menyimpan rasa produk makanan
    private int lama_ketahanan; //menyimpan lama ketahanan produk makanan dalam hari/bulan

    // Constructor untuk membuat object ProdukMakanan
    //memanggil constructor parent class (super) dari Produk
    public ProdukMakanan(String id_produk, String nama_produk, int harga, String bahan, String rasa, int lama_ketahanan) {
        super(id_produk, nama_produk, harga); //memanggil constructor parent class Produk
        this.bahan = bahan; //mengisi atribut bahan dengan nilai dari parameter
        this.rasa = rasa; //mengisi atribut rasa dengan nilai dari parameter
        this.lama_ketahanan = lama_ketahanan; //mengisi atribut lama_ketahanan dengan nilai dari parameter
    }

    //setter untuk mengubah bahan
    public void setBahan(String bahan) {
        this.bahan = bahan; //mengubah nilai atribut bahan
    }

    //getter untuk mengambil bahan
    public String getBahan() {
        return bahan; //mengembalikan nilai atribut bahan
    }

    //setter untuk mengubah rasa
    public void setRasa(String rasa) {
        this.rasa = rasa; //mengubah nilai atribut rasa
    }

    //getter untuk mengambil rasa
    public String getRasa() {
        return rasa; //mengembalikan nilai atribut rasa
    }

    //setter untuk mengubah lama ketahanan
    public void setLama_ketahanan(int lama_ketahanan) {
        this.lama_ketahanan = lama_ketahanan; //mengubah nilai atribut lama_ketahanan
    }

    //getter untuk mengambil lama ketahanan
    public int getLama_ketahanan() {
        return lama_ketahanan; //mengembalikan nilai atribut lama_ketahanan
    }


    //method untuk menampilkan data produk makanan
    public void tampil() {
        super.tampil(); //menampilkan data dasar dari parent class Produk (ID, Nama, Harga, Stok)
        System.out.println("Bahan Produk Makanan  : " + bahan); //untuk menampilkan bahan produk makanan
        System.out.println("Rasa Produk Makanan   : " + rasa); //untuk menampilkan rasa produk makanan
        System.out.println("Lama Ketahanan        : " + lama_ketahanan); //untuk menampilkan lama ketahanan produk makanan
    }
}