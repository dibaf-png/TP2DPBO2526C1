#include <iostream> //library untuk operasi input/output
#include <string> //library untuk tipe data string

using namespace std; //ini agar tidak perlu menulis std:: pada string dan cout

class Produk { //membuat class namanya Produk

    private: //hak akses private hanya dapat diakses langsung dari dalam class
        string id_produk; //mnyimpan Id unik produk
        string nama_produk; //menyimpan nama produk
        int harga; //menyimpan harga produk

    public: //hak akses public dapat digunakan dari luar class

        Produk(string id_produk, string nama_produk, int harga) { //constructor untuk membuat object Produk
            this->id_produk = id_produk; //mengisi atribut ID dengan nilai dari parameter
            this->nama_produk = nama_produk; //mngisi atribut nama dengan nilai dari parameter
            this->harga = harga; //mngisi atribut harga dengan nilai dari parameter
        }
    //setter untuk mengubah id
    void setId(string id_produk){
        this ->id_produk = id_produk; //mengubah nilai id
    }
    //getter untuk mengambil id
    string getId() const{
        return id_produk; //mengembalikan nilai id
    }

    //setter untuk mengubah nama
    void setNama (string nama_produk){
        this -> nama_produk = nama_produk; //mengubah nilai nama produk
    }
    //getter untuk mengambil nama
    string getNama() const{
        return nama_produk; //mengembalikan nilai nama produk
    }

    //setter untuk mengubah harga
    void setHarga(int harga){
        this-> harga = harga; //mengubah nilai harga
    }
    //getter untuk mengambil harga
    int getHarga() const{
        return harga; //mengembalikan nilai harga
    }


    void tampil() const { //ini berfungsi untuk menampilkan data produk
        cout << "Id Produk      : " << id_produk << endl; //menampilkan id produk
        cout << "Nama Produk    : " << nama_produk << endl; //menampilkan nama produk
        cout << "Harga Produk   : " << harga << endl; //menampilkan harga dari produk
    }
    ~Produk(){ //destructor 
        
    }
};
