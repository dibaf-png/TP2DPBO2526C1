#include <iostream> //library untuk operasi input/output
#include <string> //library untuk tipe data string
#include "ProdukMakanan.cpp"//mengimpor file produkMakanan

using namespace std; //ini agar tidak perlu menulis std:: pada string dan cout

class JajananTradisional : public ProdukMakanan{ //membuat class namanya JajananTradisional yang mewarisi class ProdukMakanan secara public.

    private: //hak akses private hanya dapat diakses langsung dari dalam class
        string asal_daerah; //menyimpan asal_daerah
        string cara_penyajian; //menyimpan cara_penyajian
        string jenis_jajanan; //menyimpan jenis jajanan

    public: //hak akses public dapat digunakan dari luar class

        //constructor untuk membuat object ProdukMakanan
        //emanggil constructor parent class Produk untuk mengisi empat atribut yang diwariskan
        JajananTradisional(string id_produk, string nama_produk, int harga, string bahan, string rasa, int lama_ketahanan, string asal_daerah, string cara_penyajian, string jenis_jajanan) : ProdukMakanan(id_produk, nama_produk, harga, bahan, rasa, lama_ketahanan) { 
            this->asal_daerah = asal_daerah; //mengisi atribut asal_daerah dengan nilai dari parameter
            this->cara_penyajian = cara_penyajian; //mengisi atribut cara_penyajian dengan nilai dari parameter
            this->jenis_jajanan = jenis_jajanan; //mengisi atribut jenis jajanandengan nilai dari parameter
        }
    //setter untuk mengubah asal_daerah
    void setAsala(string asal_daerah){
        this ->asal_daerah = asal_daerah; //mengubah nilai asal_daerah
    }
    //getter untuk mengambil asal daerah
    string getAsal() const{
        return asal_daerah; //mengembalikan nilai asal daerah
    }

    //setter untuk mengubah cara penyajian
    void setPenyajian (string cara_penyajian){
        this -> cara_penyajian = cara_penyajian; //mengubah nilai cara_penyajian
    }
    //getter untuk mengambil cara_penyajian
    string getPenyajian() const{
        return cara_penyajian; //mengembalikan nilai cara penyajian
    }

    //setter untuk mengubah jenis jajanan
    void setJenis(string jenis_jajanan){
        this ->jenis_jajanan = jenis_jajanan;
    }
    //getter untuk mengambil jenis jajanan 
    string getJenis() const {
        return jenis_jajanan; //mengembalikan nilai jenis jajanan
    }

    void tampil() const { //ini berfungsi untuk menampilkan data produk
        ProdukMakanan::tampil(); // memanggil method tampil dari parent class ProdukMakanan
        cout << "Asal Daerah Jajanan  : " << asal_daerah << endl; //menampilkan asal daerah dari jajanan tradisional
        cout << "Cara Penyajian Jajanan   : " << cara_penyajian << endl; //menampilkan cara penyajian jajanan tradisional
        cout << "Jenis Jajanan     : " << jenis_jajanan << endl; //menampilkan jenis jajanan tradisional
    }
    ~JajananTradisional(){ //destructor 
        
    }
};
