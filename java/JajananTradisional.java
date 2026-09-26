// Membuat class JajananTradisional yang mewarisi (extends) dari class ProdukMakanan
public class JajananTradisional extends ProdukMakanan {

    private String asal_daerah;    // Menyimpan asal daerah jajanan tradisional (hak akses private)
    private String cara_penyajian; // Menyimpan cara penyajian jajanan tradisional (hak akses private)
    private String jenis_jajanan;  // Menyimpan jenis jajanan tradisional (hak akses private)

    // Constructor untuk membuat object JajananTradisional
    // Memanggil constructor parent class (super) dari ProdukMakanan
    public JajananTradisional(String id_produk, String nama_produk, int harga, String bahan, String rasa, int lama_ketahanan, String asal_daerah, String cara_penyajian, String jenis_jajanan) {
        super(id_produk, nama_produk, harga, bahan, rasa, lama_ketahanan); //memanggil constructor ProdukMakanan
        this.asal_daerah = asal_daerah; //mengisi atribut asal_daerah dengan nilai dari parameter
        this.cara_penyajian = cara_penyajian; //mengisi atribut cara_penyajian dengan nilai dari parameter
        this.jenis_jajanan = jenis_jajanan;//mengisi atribut jenis_jajanan dengan nilai dari parameter
    }

    //setter untuk mengubah asal daerah
    public void setAsal(String asal_daerah) {
        this.asal_daerah = asal_daerah; //mengubah nilai atribut asal_daerah
    }

    //getter untuk mengambil asal daerah
    public String getAsal() {
        return asal_daerah; //mengembalikan nilai atribut asal_daerah
    }

    //setter untuk mengubah cara penyajian
    public void setPenyajian(String cara_penyajian) {
        this.cara_penyajian = cara_penyajian; //mengubah nilai atribut cara_penyajian
    }

    //getter untuk mengambil cara penyajian
    public String getPenyajian() {
        return cara_penyajian; //mengembalikan nilai atribut cara_penyajian
    }

    //setter untuk mengubah jenis jajanan
    public void setJenis(String jenis_jajanan) {
        this.jenis_jajanan = jenis_jajanan; //mengubah nilai atribut jenis_jajanan
    }

    //getter untuk mengambil jenis jajanan
    public String getJenis() {
        return jenis_jajanan; //mengembalikan nilai atribut jenis_jajanan
    }

    //untuk menampilkan seluruh data jajanan tradisional
    public void tampil() {
        super.tampil(); //menampilkan data dari parent class ProdukMakanan dan juga class Produk
        System.out.println("Asal Daerah Jajanan    : " + asal_daerah);    //menampilkan asal daerah jajanan
        System.out.println("Cara Penyajian Jajanan : " + cara_penyajian); //menampilkan cara penyajian jajanan
        System.out.println("Jenis Jajanan          : " + jenis_jajanan);   //menampilkan jenis jajanan
    }
}