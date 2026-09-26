#include <iostream> //library untuk operasi input/output
#include <string> //library untuk tipe data string

#include "Produk.cpp" //mengimpor file Produk

using namespace std; //ini agar tidak perlu menulis std:: pada string dan cout

class ProdukMakanan : public Produk{ //membuat class namanya ProdukMakanan yang mewarisi class Produk secara public
    private: //hak akses private hanya dapat diakses langsung dari dalam class
        string bahan; //menyimpan bahan produk makanan
        string rasa; //menyimpan rasa produk makanan
        int lama_ketahanan; //menyimpan lama ketahanan produk makanan 

    public: //hak akses public dapat digunakan dari luar class

        //constructor untuk membuat object ProdukMakanan
        //memanggil constructor parent class Produk
        ProdukMakanan(string id_produk, string nama_produk, int harga, string bahan, string rasa, int lama_ketahanan) : Produk(id_produk, nama_produk, harga) { 
            this->bahan = bahan; //mengisi atribut bahan dengan nilai dari parameter
            this->rasa = rasa; //mengisi atribut rasa dengan nilai dari parameter
            this->lama_ketahanan = lama_ketahanan; //mengisi atribut lama ketahanan dengan nilai dari parameter
        }
    //setter untuk mengubah bahan
    void setBahan(string bahan){
        this ->bahan = bahan; //mengubah nilai bahan
    }
    //getter untuk mengambil bahan
    string getBahan() const{
        return bahan; //mengembalikan nilai bahan
    }

    //setter untuk mengubah rasa
    void setRasa (string rasa){
        this -> rasa = rasa; //mengubah nilai rasa
    }
    //getter untuk mengambil rasa
    string getRasa() const{
        return rasa; //mengembalikan nilai rasa produk
    }

    //setter untuk mengubah lama ketahanan
    void setLama_ketahanan(int lama_ketahanan){
        this ->lama_ketahanan = lama_ketahanan;
    }
    //getter untuk mengambil tingkat ketahanan 
    int getLama_ketahanan()const{
        return lama_ketahanan; //mengembalikan nilai tingkat ketahanan
    }

    void tampil() const { //ini berfungsi untuk menampilkan data produk
        Produk::tampil(); //memanggil method tampil dari parent class Produk
        cout << "Bahan Produk Makanan : " << bahan << endl; //menampilkan bahan yang digunakan oleh produk makanan
        cout << "Rasa Produk Makanan  : " << rasa << endl; //menampilkan rasa di produk makanan
        cout << "Lama Ketahanan       : " << lama_ketahanan << endl; //menampilkan berapa lama ketahanan produk makanan
    }
    ~ProdukMakanan(){ //destructor 
        
    }
};
