public class Produk { //membuat class namanya Produk
    //hak akses private hanya dapat diakses langsung dari dalam class
    private String id_produk; //untuk menyimpan Id unik produk
    private String nama_produk; //menyimpan nama produk
    private int harga; //menyimpan harga produk

    public Produk (String id_produk, String nama_produk, int harga) { //constructor untuk membuat object Produk
        this.id_produk = id_produk; //mengisi atribut ID dengan nilai dari parameter
        this.nama_produk = nama_produk; //mngisi atribut nama dengan nilai dari parameter
        this.harga = harga; //mngisi atribut harga dengan nilai dari parameter
    }
    //setter untuk mengubah id
    public void setId(String id_produk){
        this.id_produk = id_produk; //mengubah nilai id
    }
    //getter untuk mengambil id
    public String getId(){
        return id_produk; //mengembalikan nilai id
    }

    //setter untuk mengubah nama
    public void setNama (String nama_produk){
        this.nama_produk = nama_produk; //mengubah nilai nama produk
    }
    //getter untuk mengambil nama
    public String getNama(){
        return nama_produk; //mengembalikan nilai nama produk
    }

    //setter untuk mengubah harga
    public void setHarga(int harga){
        this.harga = harga; //mengubah nilai harga
    }
    //getter untuk mengambil harga
    public int getHarga(){
        return harga; //mengembalikan nilai harga
    }

    public void tampil() { //ini berfungsi untuk menampilkan data produk
        System.out.println ("Id Produk      : " + id_produk); //menampilkan id produk
        System.out.println ("Nama Produk    : " + nama_produk); //menampilkan nama produk
        System.out.println ("Harga Produk   : " + harga); //menampilkan harga dari produk
    }
    
}