import java.util.ArrayList; // Mengimpor kelas ArrayList dari paket java.util untuk menyimpan data secara dinamis
import java.util.Scanner;   // Mengimpor kelas Scanner dari paket java.util untuk membaca input teks dari pengguna

public class Main { // Deklarasi kelas utama dengan nama Main
    // Menginisialisasi ArrayList global bertipe JajananTradisional untuk menampung seluruh data objek jajanan
    static ArrayList<JajananTradisional> dataJajanan = new ArrayList<>();
    // Menginisialisasi objek Scanner global untuk menangani proses pembacaan input dari konsol (System.in)
    static Scanner scanner = new Scanner(System.in);

    // Fungsi dengan kembalian boolean untuk mengecek keberadaan suatu ID produk di dalam dataJajanan
    public static boolean cekId(String id) {
        // Melakukan iterasi (perulangan) pada setiap objek JajananTradisional di dalam ArrayList dataJajanan
        for (JajananTradisional data : dataJajanan) {
            // Membandingkan apakah ID objek saat ini sama dengan ID yang dimasukkan pengguna (case-sensitive)
            if (data.getId().equals(id)) {
                return true; // Mengembalikan nilai true jika ditemukan ID yang cocok (ID terduplikasi)
            }
        }
        return false; // Mengembalikan nilai false jika seluruh loop selesai tanpa menemukan ID yang sama
    }

    //Fungsi untuk mengecek apakah sebuah teks mengandung minimal satu karakter huruf
    public static boolean mengandungHuruf(String str) {
        //Melakukan perulangan (loop) untuk memeriksa setiap karakter 'c' di dalam string 'str'
        for (char c : str.toCharArray()) {
            // Memeriksa apakah karakter saat ini merupakan huruf (A-Z atau a-z)
            if (Character.isLetter(c)) { 
                // Jika ditemukan setidaknya satu huruf, kembalikan true
                return true; 
            }
        }
        // Jika tidak ada huruf sama sekali (misal hanya angka/spasi), kembalikan false
        return false; 
    }

    // Method untuk menghitung dan menentukan lebar maksimum setiap kolom tabel berdasarkan teks terpanjang
    public static int[] hitungLebarKolom() {
        int wId = "ID".length();// Mengambil panjang karakter default dari header "ID"
        int wNama = "Nama".length(); // Mengambil panjang karakter default dari header "Nama"
        int wHarga = "Harga".length();// Mengambil panjang karakter default dari header "Harga"
        int wBahan = "Bahan".length(); // Mengambil panjang karakter default dari header "Bahan"
        int wRasa = "Rasa".length(); // Mengambil panjang karakter default dari header "Rasa"
        int wTahan = "Tahan (Hari)".length(); // Mengambil panjang karakter default dari header "Tahan (Hari)"
        int wAsal = "Asal Daerah".length(); // Mengambil panjang karakter default dari header "Asal Daerah"
        int wPenyajian = "Cara Penyajian".length(); // Mengambil panjang karakter default dari header "Cara Penyajian"
        int wJenis = "Jenis Jajanan".length(); // Mengambil panjang karakter default dari header "Jenis Jajanan"

        // Loop untuk mengecek setiap data jajanan dan memperbarui nilai lebar maksimum jika ada isi data yang lebih panjang
        for (JajananTradisional data : dataJajanan) {
            wId = Math.max(wId, data.getId().length()); // Membandingkan dan menyimpan panjang ID terpanjang
            wNama = Math.max(wNama, data.getNama().length()); // Membandingkan dan menyimpan panjang Nama terpanjang
            wHarga = Math.max(wHarga, String.valueOf(data.getHarga()).length()); // Mengonversi Harga ke String lalu mencari nilai terpanjang
            wBahan = Math.max(wBahan, data.getBahan().length()); // Membandingkan dan menyimpan panjang Bahan terpanjang
            wRasa = Math.max(wRasa, data.getRasa().length()); // Membandingkan dan menyimpan panjang Rasa terpanjang
            wTahan = Math.max(wTahan, String.valueOf(data.getLama_ketahanan()).length()); // Mengonversi Ketahanan ke String lalu mencari nilai terpanjang
            wAsal = Math.max(wAsal, data.getAsal().length()); // Membandingkan dan menyimpan panjang Asal Daerah terpanjang
            wPenyajian = Math.max(wPenyajian, data.getPenyajian().length()); // Membandingkan dan menyimpan panjang Cara Penyajian terpanjang
            wJenis = Math.max(wJenis, data.getJenis().length()); // Membandingkan dan menyimpan panjang Jenis Jajanan terpanjang
        }

        // Mengembalikan array integer berisi nilai lebar maksimum dari masing-masing kolom
        return new int[]{wId, wNama, wHarga, wBahan, wRasa, wTahan, wAsal, wPenyajian, wJenis};
    }

    // Fungsi bantu untuk membuat dan menggabungkan suatu karakter secara berulang menjadi sebuah String
    public static String repeatChar(char ch, int count) {
        StringBuilder sb = new StringBuilder(); // Membuat instance StringBuilder untuk efisiensi manipulasi String
        for (int i = 0; i < count; i++) {       // Melakukan loop sebanyak nilai parameter count
            sb.append(ch);  // Menambahkan karakter ch ke dalam objek StringBuilder
        }
        return sb.toString();                    // Mengonversi hasil penggabungan StringBuilder menjadi String dan mengembalikannya
    }

    // Method untuk menampilkan seluruh data dalam bentuk tabel terformat secara rapi dan presisi
    public static void tampilData() {
        int[] w = hitungLebarKolom(); // Memanggil method hitungLebarKolom untuk mendapatkan array ukuran tiap kolom
        int wId = w[0], wNama = w[1], wHarga = w[2], wBahan = w[3], wRasa = w[4]; // Menyimpan lebar kolom ID, Nama, Harga, Bahan, Rasa
        int wTahan = w[5], wAsal = w[6], wPenyajian = w[7], wJenis = w[8];        // Menyimpan lebar kolom Tahan, Asal, Penyajian, Jenis

        // Menyusun string garis pembatas tabel (+ dan -) sesuai ukuran masing-masing kolom ditambah padding space (+2)
        String garis = "+" + repeatChar('-', wId + 2)
                     + "+" + repeatChar('-', wNama + 2)
                     + "+" + repeatChar('-', wHarga + 2)
                     + "+" + repeatChar('-', wBahan + 2)
                     + "+" + repeatChar('-', wRasa + 2)
                     + "+" + repeatChar('-', wTahan + 2)
                     + "+" + repeatChar('-', wAsal + 2)
                     + "+" + repeatChar('-', wPenyajian + 2)
                     + "+" + repeatChar('-', wJenis + 2) + "+";

        String judul = "DATA JAJANAN TRADISIONAL"; // Menginisialisasi teks judul tabel
        int totalLebar = garis.length(); // Menghitung panjang total karakter dari garis pembatas tabel

        System.out.println("\n" + repeatChar('=', totalLebar)); // Mencetak baris baru dan garis pembatas utama berupa karakter '='

        // Menentukan posisi tengah (center alignment) untuk teks judul
        if (totalLebar > judul.length()) {
            int padLeft = (totalLebar - judul.length()) / 2;     //Menghitung jumlah spasi yang dibutuhkan di sebelah kiri judul
            System.out.println(repeatChar(' ', padLeft) + judul); // Mencetak spasi kiri dilanjutkan dengan teks judul
        } else {
            System.out.println(judul); // Mencetak judul langsung jika lebarnya melebihi totalLebar
        }

        System.out.println(repeatChar('=', totalLebar)); // Mencetak garis pembatas '=' di bawah judul

        System.out.println(garis); // Mencetak garis pembatas paling atas tabel

        // Mengatur format penulisan header kolom dengan rata kiri (%-ds) sesuai lebar dinamis masing-masing
        String formatHeader = String.format("| %%-%ds | %%-%ds | %%-%ds | %%-%ds | %%-%ds | %%-%ds | %%-%ds | %%-%ds | %%-%ds |%%n", wId, wNama, wHarga, wBahan, wRasa, wTahan, wAsal, wPenyajian, wJenis);
        // Mencetak baris header tabel dengan judul-judul kolom yang ditentukan
        System.out.printf(formatHeader, "ID", "Nama", "Harga", "Bahan", "Rasa", "Tahan (Hari)", "Asal Daerah", "Cara Penyajian", "Jenis Jajanan");

        System.out.println(garis); // Mencetak garis pembatas pemisah antara header dan isi data

        // Melakukan iterasi untuk mencetak seluruh baris data objek JajananTradisional yang ada di ArrayList
        for (JajananTradisional data : dataJajanan){
            // Mencetak isi bidang data sesuai format kolom yang telah disiapkan
            System.out.printf(formatHeader,data.getId(), data.getNama(), data.getHarga(), data.getBahan(), data.getRasa(), data.getLama_ketahanan(), data.getAsal(), data.getPenyajian(), data.getJenis());
        }
        System.out.println(garis); // Mencetak garis pembatas penutup paling bawah tabel
    }

    // Method prosedur untuk memandu dan menerima penambahan data jajanan baru dari pengguna
    public static void tambahData() {
        // Deklarasi variabel penampung bertipe String untuk input atribut jajanan
        String id_produk, nama_produk, bahan, rasa, asal_daerah, cara_penyajian, jenis_jajanan;
        // Deklarasi variabel penampung bertipe integer untuk harga dan durasi ketahanan
        int harga, lama_ketahanan;

        System.out.println("\n================ TAMBAH DATA JAJANAN TRADISIONAL ================"); // Tampilan header fitur tambah data

        System.out.print("Masukkan ID Produk          : "); // Menampilkan instruksi input ID Produk
        id_produk = scanner.nextLine().trim();           // Membaca input baris dari konsol dan menghapus spasi di awal/akhir

        // Validasi agar ID tidak boleh kosong dan tidak boleh bernilai duplikat di ArrayList
        while (id_produk.isEmpty() || cekId(id_produk)) {
            if (id_produk.isEmpty()) {
                System.out.println(" [!] Error Nih: Duhh ID Produk tidak boleh kosong!"); // Pesan peringatan jika input kosong
            } 
            else if (cekId(id_produk)) {
                System.out.println(" [!] Error Nih: Alamaak ID Produk sudah digunakan!"); // Pesan peringatan jika ID sudah terdaftar
            }
            System.out.print("Masukkan ID Produk Kembali         : "); // Meminta kembali masukan ID Produk yang valid
            id_produk = scanner.nextLine().trim();           // Membaca ulang masukan pengguna
        }

        System.out.print("Masukkan Nama Produk        : "); // Menampilkan instruksi input Nama Produk
        nama_produk = scanner.nextLine().trim();         // Membaca input nama produk
        // Validasi perulangan agar Nama Produk tidak boleh disi kosong
        while (nama_produk.isEmpty() || !mengandungHuruf(nama_produk)) {
            if(nama_produk.isEmpty()){ //jika nama kosong
                System.out.println(" [!] Error Nih: Duhh Nama Produk tidak boleh kosong!"); // Pesan peringatan jika input kosong
            }
            else{ //jika nama berupa angka
                System.out.println(" [!] Error Nih: Nama Produk harus huruf (tidak boleh angka)"); //pesan jika input angka
            }
            System.out.print("Masukkan Nama Produk Kembali        : "); // Meminta ulang masukan Nama Produk
            nama_produk = scanner.nextLine().trim(); // Membaca ulang input masukan
        }

        harga = 0; // Mengisi nilai awal variabel 'harga'
        System.out.print("Masukkan Harga              : "); // Menampilkan pesan instruksi agar pengguna memasukkan harga
        boolean validHarga = false; // Variabel penanda status keabsahan input harga

        while (!validHarga) { // Perulangan berjalan selama input belum valid
            if (!scanner.hasNextInt()) { // Memeriksa apakah input BUKAN berupa angka integer
                System.out.println(" [!] Error Nih: Harga harus berupa angka Yaa!"); // Menampilkan pesan peringatan jika tipe input salah
                scanner.next(); // Membaca dan membuang input non-angka dari buffer Scanner
            } 
            else { // Dijalankan jika input berupa angka
                harga = scanner.nextInt(); // Membaca nilai integer dari input
        
                if (harga <= 0) { // Memeriksa apakah nilai harga kurang dari atau sama dengan nol
                    System.out.println(" [!] Error Nih: Harga tidak boleh nol (0) dan minus Yaa!"); // Menampilkan pesan peringatan jika harga bernilai 0 atau negatif
                } 
                else { // Dijalankan jika harga bernilai valid (> 0)
                    scanner.nextLine(); // Membersihkan sisa karakter Enter (\n) dari buffer
                    validHarga = true; // Mengubah status menjadi true agar perulangan while berhenti
                }
            }
            if (!validHarga) { // Memeriksa apakah input masih belum valid
                System.out.print("Masukkan Harga Kembali      : "); // Menampilkan pesan permintaan input ulang
            }
        }

        System.out.print("Masukkan Bahan              : "); // Menampilkan instruksi input Bahan
        bahan = scanner.nextLine().trim();               // Membaca input bahan utama
        // Validasi agar input Bahan tidak boleh diisi kosong
        while (bahan.isEmpty() || !mengandungHuruf(bahan)) {
            if(bahan.isEmpty()){
                System.out.println(" [!] Error Nih: Bahan tidak boleh kosong!"); // Pesan peringatan jika input kosong
            }
            else{
                System.out.println(" [!] Error Nih: Nama Produk harus huruf (tidak boleh angka)"); //pesan jika input angka
            }
            System.out.print("Masukkan Bahan Kembali             : "); // Meminta ulang input bahan
            bahan = scanner.nextLine().trim(); // Membaca ulang masukan
        }

        System.out.print("Masukkan Rasa               : "); // Menampilkan instruksi input Rasa
        rasa = scanner.nextLine().trim();                // Membaca input rasa produk
        // Validasi agar input Rasa tidak boleh diisi kosong
        while (rasa.isEmpty() || !mengandungHuruf(rasa)) {
            if(rasa.isEmpty()){ //jika 
                System.out.println(" [!] Error Nih: Rasa tidak boleh kosong!"); // Pesan peringatan jika input kosong
            }
            else{
                System.out.println(" [!] Error Nih: Bahan harus huruf (tidak boleh angka)"); //pesan jika input angka
            }
            System.out.print("Masukkan Rasa Kembali              : "); // Meminta ulang input rasa
            rasa = scanner.nextLine().trim(); // Membaca ulang masukan
        }


        lama_ketahanan = 0; // Mengisi nilai awal variabel 'lama_ketahanan'
        System.out.print("Masukkan Lama Ketahanan     : "); // Menampilkan pesan instruksi agar pengguna memasukkan ketahanan

        boolean valid = false; // Variabel penanda status keabsahan input

        while (!valid) { // Perulangan berjalan selama input belum valid
            if (!scanner.hasNextInt()) { // Memeriksa apakah input BUKAN berupa angka integer
                System.out.println(" [!] Error Nih: Lama Ketahanan harus berupa angka Yaa!"); // Menampilkan pesan peringatan jika tipe input salah
                scanner.next(); // Membaca dan membuang input non-angka dari buffer Scanner
            } 
            else { // Dijalankan jika input berupa angka
                lama_ketahanan = scanner.nextInt(); // Membaca nilai integer dari input
        
                if (lama_ketahanan <= 0) { // Memeriksa apakah nilai kurang dari atau sama dengan nol
                    System.out.println(" [!] Error Nih: Lama Ketahanan tidak boleh nol (0) dan minus Yaa!"); // Menampilkan pesan peringatan jika nilai 0 atau negatif
                } 
                else { // Dijalankan jika nilai angka sudah valid (> 0)
                    scanner.nextLine(); // Membersihkan sisa karakter Enter (\n) dari buffer
                    valid = true; // Mengubah status menjadi true agar perulangan while berhenti
                }
            }
            if (!valid) { // Memeriksa apakah input masih belum valid
                System.out.print("Masukkan Lama Ketahanan Kembali      : "); // Menampilkan pesan permintaan input ulang
            }
        }

        System.out.print("Masukkan Asal Daerah        : "); // Menampilkan instruksi input Asal Daerah
        asal_daerah = scanner.nextLine().trim();         // Membaca input asal daerah
        // Validasi perulangan agar input Asal Daerah tidak diisi kosong
        while (asal_daerah.isEmpty() || !mengandungHuruf(asal_daerah)) {
            if(asal_daerah.isEmpty()){
                System.out.println(" [!] Error Nih: Asal Daerah tidak boleh kosong!"); // Pesan peringatan jika input kosong
            }
            else{
                System.out.println(" [!] Error Nih: Asala Daerah harus huruf (tidak boleh angka)"); //pesan jika input angka
            }
            System.out.print("Masukkan Asal Daerah Kembali        : "); // Meminta ulang input asal daerah
            asal_daerah = scanner.nextLine().trim(); // Membaca ulang masukan
        }

        System.out.print("Masukkan Cara Penyajian     : "); // Menampilkan instruksi input Cara Penyajian
        cara_penyajian = scanner.nextLine().trim();      // Membaca input cara penyajian
        // Validasi perulangan agar input Cara Penyajian tidak diisi kosong
        while (cara_penyajian.isEmpty() || !mengandungHuruf(cara_penyajian)) {
            if(cara_penyajian.isEmpty()){
                System.out.println(" [!] Error Nih: Cara Penyajian tidak boleh kosong!"); // Pesan peringatan jika input kosong
            }
            else{
                System.out.println(" [!] Error Nih: Cara Penyajian harus huruf (tidak boleh angka)"); //pesan jika input angka
            }
            System.out.print("Masukkan Cara Penyajian Kembali     : "); // Meminta ulang input cara penyajian
            cara_penyajian = scanner.nextLine().trim(); // Membaca ulang masukan
        }

        System.out.print("Masukkan Jenis Jajanan      : "); // Menampilkan instruksi input Jenis Jajanan
        jenis_jajanan = scanner.nextLine().trim(); // Membaca input jenis jajanan
        // Validasi perulangan agar input Jenis Jajanan tidak diisi kosong
        while (jenis_jajanan.isEmpty() || !mengandungHuruf(jenis_jajanan)) {
            if(jenis_jajanan.isEmpty()){
                System.out.println(" [!] Error: Jenis Jajanan tidak boleh kosong!"); // Pesan peringatan jika input kosong
            }
            else{
                System.out.println(" [!] Error Nih: Jenis Jajanan Penyajian harus huruf (tidak boleh angka)"); //pesan jika input angka
            }

            System.out.print("Masukkan Jenis Jajanan Kembali      : ");// Meminta ulang input jenis jajanan
            jenis_jajanan = scanner.nextLine().trim(); // Membaca ulang masukan
        }

        // Membuat/menginstansiasi objek baru dari kelas JajananTradisional berdasarkan variabel-variabel yang telah diinputkan
        JajananTradisional dataBaru = new JajananTradisional(id_produk, nama_produk, harga, bahan, rasa, lama_ketahanan, asal_daerah, cara_penyajian, jenis_jajanan);

        dataJajanan.add(dataBaru); // Memasukkan instance objek dataBaru ke dalam daftar ArrayList dataJajanan
        System.out.println("Uhuyy Data berhasil ditambahkan Bosss!"); // Menampilkan pesan pemberitahuan bahwa data berhasil disimpan
    }

    // Method khusus untuk menampilkan antarmuka pilihan menu utama program di layar
    public static void menuPilihan() {
        System.out.println("\n===== MENU JAJANAN TRADISIONAL ====="); // Mencetak judul/header menu utama
        System.out.println("1. Tampilkan Data"); // Mencetak pilihan menu 1 (Tampilkan Data)
        System.out.println("2. Tambah Data"); // Mencetak pilihan menu 2 (Tambah Data)
        System.out.println("0. Keluar"); // Mencetak pilihan menu 0 (Keluar)
        System.out.print("Pilih : "); // Mencetak teks petunjuk tempat pengguna memasukkan angka pilihan
    }

    // Main Method
    public static void main(String[] args) {
        // Memasukkan data awal (dummy data) ke-1 ke dalam list
        dataJajanan.add(new JajananTradisional("JT001", "Bika Ambon", 15000, "Tepung Tapioka", "Manis", 3, "Medan", "Polos", "Kue Basah"));
        // Memasukkan data awal (dummy data) ke-2 ke dalam list
        dataJajanan.add(new JajananTradisional("JT002", "Getuk Lindri", 4000, "Singkong", "Manis", 2, "Jawa Tengah", "Dengan Kelapa", "Jajanan Pasar"));
        // Memasukkan data awal (dummy data) ke-3 ke dalam list
        dataJajanan.add(new JajananTradisional("JT003", "Awug", 6000, "Tepung Beras", "Manis", 2, "Jawa Barat", "Dengan Kelapa", "Jajanan Tradisional"));
        // Memasukkan data awal (dummy data) ke-4 ke dalam list
        dataJajanan.add(new JajananTradisional("JT004", "Serabi Solo", 8000, "Tepung Beras", "Manis", 1, "Solo", "Polos", "Jajanan Pasar"));
        // Memasukkan data awal (dummy data) ke-5 ke dalam list
        dataJajanan.add(new JajananTradisional("JT005", "Barongko", 7000, "Pisang", "Manis", 2, "Sulawesi Selatan", "Polos", "Kue Basah"));

        int pilihan; // Deklarasi variabel integer untuk menampung pilihan menu dari pengguna

        // Loop perulangan tak terbatas (infinite loop) agar aplikasi terus berjalan hingga pengguna memilih menu keluar (0)
        while (true) {
            menuPilihan(); // Memanggil method menuPilihan() untuk mencetak daftar menu di layar
            String inputChoice = scanner.nextLine().trim(); // Membaca baris teks input pilihan dari pengguna

            try {
                pilihan = Integer.parseInt(inputChoice); // Mengubah tipe masukan String pilihan pengguna menjadi bentuk integer
            } catch (NumberFormatException e) {
                // Menangani kondisi apabila pengguna memasukkan karakter selain angka integer
                System.out.println("Pilihan Harus Berupa Angka (0-2) Yaa!\n"); // Menampilkan pesan error validasi pilihan
                continue; // Melompati sisa perintah di dalam loop dan kembali ke awal iterasi while
            }

            switch (pilihan) { // Memeriksa nilai variabel pilihan untuk menentukan blok kode yang akan dieksekusi
                case 1 -> tampilData(); // Jika pilihan bernilai 1, panggil method tampilData() untuk menampilkan tabel data
                case 2 -> tambahData(); // Memanggil method tambahData() untuk menerima input masukan jajanan baru dari pengguna
                case 0 -> { // Jika pilihan bernilai 0 
                    System.out.println("Terima Kasih Sudah Menggunakan Program Ini. Sampai Jumpa Lagi"); //Pesan penutup
                    return; // Hentikan eksekusi method main() secara penuh untuk keluar dari aplikasi
                }
                default -> System.out.println("Aduhh Pilihan Tidak Tersedia. Silakan Masukkan Angka 0 Sampai 2 Yaa\n"); // Tampilkan peringatan jika angka pilihan di luar 0, 1, atau 2
            }
        }
    }
}