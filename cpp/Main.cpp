#include <iostream> //library untuk operasi input/output (cout, cin, endl)
#include <vector>  //library untuk menyediakan kontainer dinamis vector
#include <iomanip> //library untuk format tampilan I/O tabel (setw, left)
#include <string>  //library untuk manipulasi tipe data string (to_string, length)
#include <algorithm>//library untuk menggunakan fungsi algoritma umum (std::max)
#include <cctype> // library untuk menggunakan isdigit() dan isalpha()
#include "JajananTradisional.cpp" // Mengimpor definisi dan implementasi class JajananTradisional

using namespace std; //menggunakan namespace std agar tidak perlu menuliskan std:: berulang kali

vector<JajananTradisional> dataJajanan; //vector global ini itu untuk menyimpan kumpulan objek data jajanan

//ini fungsi untuk mengecek apakah ID produk sudah ada di dalam vector dataJajanan atau belum
bool cekId(const string &id){
    //looping setiap objek JajananTradisional di dalam vector menggunakan range-based for loop
    for (const auto &data : dataJajanan){
        //lakukan pengecekan apakah ID pada objek saat ini sama dengan ID yang diinputkan
        if (data.getId() == id){
            return true; //akan true jika ditemukan ID yang sama (duplikat)
        }
    }
    return false; //akan false jika ID belum terdaftar
}

// Fungsi untuk mengecek apakah sebuah string mengandung minimal 1 huruf (mencegah input yang murni berupa angka atau simbol saja)
bool mengandungHuruf(const string &str) {
    for (char c : str){ // Melakukan perulangan (loop) untuk memeriksa setiap karakter 'c' di dalam string 'str'
        if (isalpha(c)){
            return true; // Mengembalikan true jika ditemukan minimal satu karakter yang berupa huruf (A-Z atau a-z)
        }
    }                              
    return false;// Mengembalikan false jika tidak ada satu pun huruf yang ditemukan dalam string
}

//method khusus untuk menghitung lebar maksimum murni tiap kolom berdasarkan header dan isi data
void hitungLebarKolom(size_t &wId, size_t &wNama, size_t &wHarga, size_t &wBahan, size_t &wRasa, size_t &wTahan, size_t &wAsal, size_t &wPenyajian, size_t &wJenis){
    wId = string("ID").length();  //panjang dari teks "ID"
    wNama = string("Nama").length(); //panjang dari teks "Nama"
    wHarga = string("Harga").length(); //panjang dari teks "Harga"
    wBahan = string("Bahan").length(); //panjang dari teks "Bahan"
    wRasa = string("Rasa").length();  //panjang dari teks "Rasa"
    wTahan = string("Tahan (Hari)").length(); //panjang dari teks "Tahan (Hari)"
    wAsal = string("Asal Daerah").length(); //panjang dari teks "Asal Daerah"
    wPenyajian = string("Cara Penyajian").length();//panjang dari teks "Cara Penyajian"
    wJenis = string("Jenis Jajanan").length(); //panjang dari teks "Jenis Jajanan"

    for (const auto &d : dataJajanan){//looping untuk mencari string atau angka terpanjang dari seluruh isi data yang ada
        wId = max(wId, d.getId().length()); //mengambil data terpanjang untuk kolom ID
        wNama = max(wNama, d.getNama().length());  //mengambil data terpanjang untuk kolom Nama
        wHarga = max(wHarga, to_string(d.getHarga()).length()); //mengubah Harga ke string lalu mengambil data terpanjang
        wBahan = max(wBahan, d.getBahan().length()); // Mengambil data terpanjang untuk kolom Bahan
        wRasa = max(wRasa, d.getRasa().length()); // Mengambil data terpanjang untuk kolom Rasa
        wTahan = max(wTahan, to_string(d.getLama_ketahanan()).length()); //mengubah Ketahanan ke string lalu mengambil data terpanjang
        wAsal = max(wAsal, d.getAsal().length()); // Mengambil data terpanjang untuk kolom Asal
        wPenyajian = max(wPenyajian, d.getPenyajian().length()); // Mengambil data terpanjang untuk kolom Cara Penyajian
        wJenis = max(wJenis, d.getJenis().length()); // Mengambil data terpanjang untuk kolom Jenis Jajanan
    }
}

//ini untuk menampilkan data dengan garis pembatas dinamis & presisi
void tampilData(){
    //deklarasi variabel penampung lebar tiap kolom
    size_t wId, wNama, wHarga, wBahan, wRasa, wTahan, wAsal, wPenyajian, wJenis;

    //memanggil method hitung lebar isi teks terpanjang untuk setiap kolom
    hitungLebarKolom(wId, wNama, wHarga, wBahan, wRasa, wTahan, wAsal, wPenyajian, wJenis);

    //ini untuk garis pembatas, kenapa ada + 2 itu karena ada 1 spasi kiri dan 1 spasi kanan sebagai padding
    string garis = "+" + string(wId + 2, '-') 
                 + "+" + string(wNama + 2, '-') 
                 + "+" + string(wHarga + 2, '-') 
                 + "+" + string(wBahan + 2, '-') 
                 + "+" + string(wRasa + 2, '-') 
                 + "+" + string(wTahan + 2, '-') 
                 + "+" + string(wAsal + 2, '-') 
                 + "+" + string(wPenyajian + 2, '-') 
                 + "+" + string(wJenis + 2, '-') + "+";

    string judul = "DATA JAJANAN TRADISIONAL"; //deklarasi string judul utama
    // Menghitung panjang total seluruh karakter garis pembatas tabel
    size_t totalLebar = garis.length(); 

    // Mencetak baris kosong dan garis pembatas sama dengan atas
    cout << "\n" << string(totalLebar, '=') << endl;
    
    // Logika penataan teks judul di tengah (center alignment)
    if (totalLebar > judul.length()) {
        size_t padLeft = (totalLebar - judul.length()) / 2; // Menhitung spasi padding di sisi kiri
        cout << string(padLeft, ' ') << judul << endl;      // Mencetak spasi padding lalu mencetak judul
    } else {
        cout << judul << endl;                             // Jika judul lebih panjang, cetak tanpa padding
    }

    // Mencetak garis pembatas sama dengan bawah
    cout << string(totalLebar, '=') << endl;

    //Garis Pembatas Atas Tabel
    cout << garis << endl;

    //format dan cetak Header Kolom dengan rata kiri
    cout << left
         << "| " << setw(wId) << "ID" << " "
         << "| " << setw(wNama) << "Nama" << " "
         << "| " << setw(wHarga) << "Harga" << " "
         << "| " << setw(wBahan) << "Bahan" << " "
         << "| " << setw(wRasa) << "Rasa" << " "
         << "| " << setw(wTahan) << "Tahan (Hari)" << " "
         << "| " << setw(wAsal) << "Asal Daerah" << " "
         << "| " << setw(wPenyajian) << "Cara Penyajian" << " "
         << "| " << setw(wJenis) << "Jenis Jajanan" << " |"
         << endl;

    //garis Pembatas Tengah Pemisah Header dan Data
    cout << garis << endl;

    //looping untuk mencetak (|) pada setiap baris data ata
    for (const auto &data : dataJajanan)
    {
        cout << "| " << setw(wId) << data.getId() << " "
             << "| " << setw(wNama) << data.getNama() << " "
             << "| " << setw(wHarga) << data.getHarga() << " "
             << "| " << setw(wBahan) << data.getBahan() << " "
             << "| " << setw(wRasa) << data.getRasa() << " "
             << "| " << setw(wTahan) << data.getLama_ketahanan() << " "
             << "| " << setw(wAsal) << data.getAsal() << " "
             << "| " << setw(wPenyajian) << data.getPenyajian() << " "
             << "| " << setw(wJenis) << data.getJenis() << " |"
             << endl;
    }

    //garis Pembatas Bawah Penutup Tabel
    cout << garis << endl;
}

// Fungsi Prosedur Tambah Data
void tambahData(){
    // Deklarasi variabel lokal untuk menampung input string
    string id_produk, nama_produk, bahan, rasa, asal_daerah, cara_penyajian, jenis_jajanan;
    // Deklarasi variabel lokal untuk menampung input integer
    int harga = 0, lama_ketahanan = 0;

    // Cetak header visual penambahan data
    cout << "\n================ TAMBAH DATA JAJANAN TRADISIONAL ================\n";

    // Meminta input ID Produk
    cout << "Masukkan ID Produk          : ";
    getline(cin, id_produk); // Membaca input satu baris teks

    // Validasi perulangan jika ID kosong atau sudah terdaftar
    while (id_produk.empty() || cekId(id_produk)){
        if (id_produk.empty()){
            cout << " [!] Error Nih: Duhh ID Produk tidak boleh kosong!\n"; // Pesan jika input ID diisi kosong
        }
        else if (cekId(id_produk)){
            cout << " [!] Error Nih: Alamaak ID Produk sudah digunakan!\n"; // Pesan jika ID sudah ada
        }
        cout << "Masukkan ID Produk Kembali         : ";
        getline(cin, id_produk); // Meminta input ID kembali
    }

    // Meminta input Nama Produk
    cout << "Masukkan Nama Produk        : ";
    getline(cin, nama_produk);
    // Validasi agar Nama Produk tidak boleh kosong
    while (nama_produk.empty() || !mengandungHuruf(nama_produk)){
        if(nama_produk.empty()) { 
            cout << " [!] Error Nih: Duhh Nama Produk tidak boleh kosong!\n"; //pesan jika Nama diisi kosong
        }
        else {
            cout << " [!] Error Nih: Nama Produk harus huruf (tidak boleh angka)\n"; //pesan jika Nama diisi oleh angka
        }
        cout << "Masukkan Nama Produk Kembali        : "; //akan meminta input kembali
        getline(cin, nama_produk);
    }

    // Meminta input Harga Produk
    cout << "Masukkan Harga              : ";
    cin >> harga;  // Membaca nilai integer harga awal
    // Validasi agar input berupa angka, nilainya tidak negatif dan tidak kosong atau langusng enter 
    while (cin.fail() || harga <= 0) {
        //jika input diisi huruf
        if (cin.fail()) { 
            cout << " [!] Error Nih: Harga harus berupa angka Yaa!" << endl; //pesan error jika diisi huruf
        } 
        //jika input berupa angka, tetapi nilainya negatif
        else if (harga <= 0) { 
            cout << " [!] Error Nih: Harga tidak boleh nol (0) dan minus Yaa!" << endl; //pesan error
        }

        cin.clear();            // Memulihkan status cin ke kondisi normal
        cin.ignore(1000, '\n'); // Membersihkan buffer input hingga Enter

        cout << "Masukkan Harga Kembali      : "; 
        cin >> harga;                           
    }
    cin.ignore(1000, '\n'); // Membersihkan karakter Enter ('\n') dari buffer setelah input harga valid

    // Meminta input Bahan Utama
    cout << "Masukkan Bahan              : ";
    getline(cin, bahan);
    // Validasi agar Bahan tidak boleh kosong
    while (bahan.empty() || !mengandungHuruf(bahan)){
        if(bahan.empty()){
            cout << " [!] Error Nih: Bahan tidak boleh kosong!\n"; //pesan jika Bahan diisi kosong
        }
        else{
            cout << " [!] Error Nih: Bahan harus huruf (tidak boleh angka)\n"; //pesan error jika diisi angka
        }
        cout << "Masukkan Bahan Kembali              : "; //akan meminta inputan kembali
        getline(cin, bahan);
    }

    // Meminta input Rasa Produk
    cout << "Masukkan Rasa               : ";
    getline(cin, rasa);
    // Validasi agar Rasa tidak boleh kosong
    while (rasa.empty() || !mengandungHuruf(rasa)){
        if(rasa.empty()){
            cout << " [!] Error Nih: Rasa tidak boleh kosong!\n"; //pesan jika Rasa diisi kosong
        }
        else{
            cout << " [!] Error Nih: Rasa harus huruf (tidak boleh angka)\n"; //pesan error jika diisi angka
        }
        cout << "Masukkan Rasa Kembali               : "; //akan meminta inputan kembali
        getline(cin, rasa);
    }

    cout << "Masukkan Lama Ketahanan     : "; // Menampilkan instruksi input lama ketahanan
    cin >> lama_ketahanan; // Membaca nilai integer ketahanan awal

    // Validasi agar input berupa angka, nilainya tidak negatif, dan tidak kosong (langsung tekan Enter)
    while (cin.fail() || lama_ketahanan <= 0) {
        
        //jika input gagal dibaca sebagai tipe data integer (misal: huruf/simbol)
        if (cin.fail()) { 
            cout << " [!] Error Nih: Lama Ketahanan harus berupa angka Yaa!" << endl;
        } 
        //jika input berupa angka, tetapi nilainya negatif
        else if (lama_ketahanan <= 0) { 
            cout << " [!] Error Nih: Lama Ketahanan tidak boleh nol (0) dan minus Yaa!" << endl;
        }

        cin.clear();            // Memulihkan status cin ke kondisi normal
        cin.ignore(1000, '\n'); // Membersihkan buffer input hingga Enter

        cout << "Masukkan Lama Ketahanan Kembali      : "; 
        cin >> lama_ketahanan;                           
    }
    cin.ignore(1000, '\n'); // Membersihkan karakter Enter ('\n') dari buffer setelah input harga valid

    // Meminta input Asal Daerah
    cout << "Masukkan Asal Daerah        : ";
    getline(cin, asal_daerah);
    // Validasi agar Asal Daerah tidak boleh kosong
    while (asal_daerah.empty() || !mengandungHuruf(asal_daerah)){
        if(asal_daerah.empty()){
            cout << " [!] Error Nih: Asal Daerah tidak boleh kosong!\n"; //pesan jika Asal daerah diisi kosong
        }
        else{
            cout << " [!] Error Nih: Asal Daerah harus huruf (tidak boleh angka)\n"; //pesan error jika diisi angka
        }
        cout << "Masukkan Asal Daerah Kembali       : "; //akan meminta inputan kembali
        getline(cin, asal_daerah);
    }

    // Meminta input Cara Penyajian
    cout << "Masukkan Cara Penyajian     : ";
    getline(cin, cara_penyajian);
    // Validasi agar Cara Penyajian tidak boleh kosong dan harus berupa huruf
    while (cara_penyajian.empty() || !mengandungHuruf(cara_penyajian)){
        if(cara_penyajian.empty()){
            cout << " [!] Error Nih: Cara Penyajian tidak boleh kosong!\n"; //pesan jika Cara penyajian diisi kosong 
        }
        else{
            cout << " [!] Error Nih: Cara Penyajian harus huruf (tidak boleh angka)\n"; //pesan error jika diisi angka
        }
        cout << "Masukkan Cara Penyajian Kembali     : "; //akan meminta inputan kembali
        getline(cin, cara_penyajian);
    }

    // Meminta input Jenis Jajanan
    cout << "Masukkan Jenis Jajanan      : ";
    getline(cin, jenis_jajanan);
    // Validasi agar Jenis Jajanan tidak boleh kosong dan harus huruf
    while (jenis_jajanan.empty() || !mengandungHuruf(jenis_jajanan)){
        if(jenis_jajanan.empty()){
            cout << " [!] Error: Jenis Jajanan tidak boleh kosong!\n"; //pesan jika Jenis jajanan diisi kosong
        }
        else{
            cout << " [!] Error Nih: Jenis Jajanan harus huruf (tidak boleh angka)\n"; //pesan error jika diisi angka
        }
        cout << "Masukkan Jenis Jajanan Kembali     : "; //akan meminta inputan kembali
        getline(cin, jenis_jajanan);
    }

    // Instansiasi atau pembuatan objek baru JajananTradisional dengan argumen yang sudah disiapkan
    JajananTradisional dataBaru(id_produk, nama_produk, harga, bahan, rasa, lama_ketahanan, asal_daerah, cara_penyajian, jenis_jajanan);

    // Memasukkan objek baru ke dalam vector global dataJajanan
    dataJajanan.push_back(dataBaru);
    // Tampilkan pesan konfirmasi sukses
    cout << "Uhuyy Data berhasil ditambahkan Bosss!\n";
}

// Fungsi untuk mencetak Tampilan Menu Utama
void menuPilihan() {
    cout << "\n===== MENU JAJANAN TRADISIONAL =====" << endl; // Teks header menu
    cout << "1. Tampilkan Data" << endl; // Opsi 1 untukk menampilkan data
    cout << "2. Tambah Data" << endl; // Opsi 2 untuk menambhakan data
    cout << "0. Keluar" << endl; // Opsi 0 untuk keluar dari program
    cout << "Pilih : "; //input pilihan
}

// Main Function
int main() {
   // Inisialisasi data awal (dummy data) menggunakan constructor class
   JajananTradisional j1("JT001", "Bika Ambon", 15000, "Tepung Tapioka", "Manis", 3, "Medan", "Polos", "Kue Basah");
   JajananTradisional j2("JT002", "Getuk Lindri", 4000, "Singkong", "Manis", 2, "Jawa Tengah", "Dengan Kelapa", "Jajanan Pasar");
   JajananTradisional j3("JT003", "Awug", 6000, "Tepung Beras", "Manis", 2, "Jawa Barat", "Dengan Kelapa", "Jajanan Tradisional");
   JajananTradisional j4("JT004", "Serabi Solo", 8000, "Tepung Beras", "Manis", 1, "Solo", "Polos", "Jajanan Pasar");
   JajananTradisional j5("JT005", "Barongko", 7000, "Pisang", "Manis", 2, "Sulawesi Selatan", "Polos", "Kue Basah");

   // Memasukkan seluruh data awal ke dalam vector global
   dataJajanan.push_back(j1);
   dataJajanan.push_back(j2);
   dataJajanan.push_back(j3);
   dataJajanan.push_back(j4);
   dataJajanan.push_back(j5);

   int pilihan; // Variabel penampung nomor pilihan menu pengguna

   // Perulangan tak terbatas (looping) agar menu muncul terus sampai dipilah keluar
   while (true) {
       menuPilihan(); // Memanggil fungsi untuk menampilkan daftar menu
       cin >> pilihan; // Menerima input pilihan menu dari pengguna

       // Pengecekan jika input gagal/bukan berupa angka
       if (cin.fail()) {
           cin.clear();              // Menghapus status error pada cin
           cin.ignore(1000, '\n');   // Mengabaikan karakter sampah di dalam buffer
           cout << "Pilihan Harus Berupa Angka (0-2) Yaa!\n" << endl; // Tampilkan pesan error
           continue; // Kembali ke awal perulangan loop
       }

       cin.ignore(1000, '\n'); // Membersihkan karakter newline sisa input angka

       //switch untuk mengeksekusi opsi pilihan menu
       switch (pilihan) {
           case 1:
               tampilData(); // Eksekusi fungsi tampilData jika memilih 1
               break;
           case 2:
               tambahData(); // Eksekusi fungsi tambahData jika memilih 2
               break;
           case 0:
               // Pesan saat keluar dari program
               cout << "Terima Kasih Sudah Menggunakan Program Ini. Sampai Jumpa Lagi" << endl;
               return 0; // Menghentikan eksekusi program main()
           default:
               // Pesan warning jika input angka di luar opsi (bukan 0, 1, atau 2)
               cout << "Aduhh Pilihan Tidak Tersedia. Silakan Masukkan Angka 0 Sampai 2 Yaa\n" << endl;
               break;
       }
   }
   return 0;
}