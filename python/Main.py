import sys  # Import pustaka sistem (dapat digunakan untuk manipulasi input/output atau penghentian program)
from JajananTradisional import JajananTradisional # Mengimpor class JajananTradisional dari berkas JajananTradisional.py

dataJajanan = [] # Deklarasi list global untuk menampung seluruh objek data jajanan tradisional

# Fungsi untuk memeriksa keberadaan ID produk di dalam list dataJajanan
def cekId(id_produk) -> bool:
    # Melakukan iterasi untuk setiap objek JajananTradisional yang ada di dalam list dataJajanan
    for data in dataJajanan:
        # Memeriksa apakah ID produk pada objek saat ini cocok dengan ID yang dicari
        if data.get_id() == id_produk:
            return True  # Mengembalikan nilai True jika ID sudah terdaftar (duplikat)
    return False  # Mengembalikan nilai False jika ID tidak ditemukan dalam list


# Fungsi untuk memeriksa apakah sebuah string mengandung minimal satu karakter huruf
def mengandungHuruf(s) -> bool:
    return any(c.isalpha() for c in s)  # Mengembalikan True jika ada minimal 1 huruf (A-Z, a-z), False jika angka/simbol murni


# Fungsi untuk menghitung lebar maksimum setiap kolom berdasarkan panjang header dan isi data
def hitungLebarKolom():
    wId = len("ID")  # Menghitung panjang karakter awal untuk header "ID"
    wNama = len("Nama")  # Menghitung panjang karakter awal untuk header "Nama"
    wHarga = len("Harga")  # Menghitung panjang karakter awal untuk header "Harga"
    wBahan = len("Bahan")  # Menghitung panjang karakter awal untuk header "Bahan"
    wRasa = len("Rasa")  # Menghitung panjang karakter awal untuk header "Rasa"
    wTahan = len("Tahan (Hari)")  # Menghitung panjang karakter awal untuk header "Tahan (Hari)"
    wAsal = len("Asal Daerah")  # Menghitung panjang karakter awal untuk header "Asal Daerah"
    wPenyajian = len("Cara Penyajian")  # Menghitung panjang karakter awal untuk header "Cara Penyajian"
    wJenis = len("Jenis Jajanan")  # Menghitung panjang karakter awal untuk header "Jenis Jajanan"

    # Melakukan iterasi pada setiap objek data untuk menyesuaikan lebar kolom dengan isi data terpanjang
    for d in dataJajanan:
        wId = max(wId, len(d.get_id()))  # Membandingkan dan mengambil nilai panjang terbanyak antara header ID atau isi data ID
        wNama = max(wNama, len(d.get_nama()))  # Membandingkan dan mengambil nilai panjang terbanyak untuk kolom Nama
        wHarga = max(wHarga, len(str(d.get_harga())))  # Mengonversi harga ke string lalu mencari panjang terbanyak untuk kolom Harga
        wBahan = max(wBahan, len(d.get_bahan()))  # Membandingkan dan mengambil nilai panjang terbanyak untuk kolom Bahan
        wRasa = max(wRasa, len(d.get_rasa()))  # Membandingkan dan mengambil nilai panjang terbanyak untuk kolom Rasa
        wTahan = max(wTahan, len(str(d.get_lama_ketahanan())))  # Mengonversi ketahanan ke string lalu mencari panjang terbanyak untuk kolom Ketahanan
        wAsal = max(wAsal, len(d.get_asal_daerah()))  # Membandingkan dan mengambil nilai panjang terbanyak untuk kolom Asal Daerah
        wPenyajian = max(wPenyajian, len(d.get_cara_penyajian()))  # Membandingkan dan mengambil nilai panjang terbanyak untuk kolom Cara Penyajian
        wJenis = max(wJenis, len(d.get_jenis_jajanan()))  # Membandingkan dan mengambil nilai panjang terbanyak untuk kolom Jenis Jajanan

    # Mengembalikan nilai lebar maksimum dari seluruh kolom secara berurutan
    return wId, wNama, wHarga, wBahan, wRasa, wTahan, wAsal, wPenyajian, wJenis


# Fungsi untuk menampilkan seluruh data jajanan ke dalam bentuk tabel yang rapi dan presisi
def tampilData():
    # Memanggil fungsi hitungLebarKolom() dan menguraikan hasilnya ke dalam masing-masing variabel lebar
    (wId, wNama, wHarga, wBahan, wRasa, wTahan, wAsal, wPenyajian, wJenis) = hitungLebarKolom()

    # Menyusun format string garis pembatas tabel (+2 ditambahkan sebagai spasi padding di kiri dan kanan)
    garis = ("+" + "-" * (wId + 2) + "+" + "-" * (wNama + 2) + "+" + "-" * (wHarga + 2) + "+" + "-" * (wBahan + 2) + "+" + "-" * (wRasa + 2) + "+" + "-" * (wTahan + 2) + "+" + "-" * (wAsal + 2) + "+" + "-" * (wPenyajian + 2) + "+" + "-" * (wJenis + 2) + "+")

    judul = "DATA JAJANAN TRADISIONAL"  # Menentukan string teks judul utama tabel
    totalLebar = (len(garis))  # Menghitung lebar total dari seluruh karakter pembatas tabel

    # Mencetak baris baru dan pembatas atas berupa karakter "=" sebanyak total lebar tabel
    print("\n" + "=" * totalLebar)

    # Memeriksa apakah total lebar tabel cukup untuk menempatkan judul di tengah
    if totalLebar > len(judul):
        padLeft = (totalLebar - len(judul)) // 2  # Menhitung jumlah spasi yang dibutuhkan untuk posisi tengah (center)
        print(" " * padLeft + judul)  # Mencetak spasi padding di kiri diikuti dengan teks judul
    else:
        print(judul)  # Mencetak judul langsung jika total lebar tabel lebih kecil dari panjang judul

    # Mencetak garis pembatas bawah judul berupa karakter "="
    print("=" * totalLebar)

    # Mencetak garis pembatas atas sebelum bagian header tabel
    print(garis)

    # Memformat dan menyusun teks header kolom dengan alignment rata kiri berdasarkan lebar kolom
    header = (
        f"| {'ID':<{wId}} "
        f"| {'Nama':<{wNama}} "
        f"| {'Harga':<{wHarga}} "
        f"| {'Bahan':<{wBahan}} "
        f"| {'Rasa':<{wRasa}} "
        f"| {'Tahan (Hari)':<{wTahan}} "
        f"| {'Asal Daerah':<{wAsal}} "
        f"| {'Cara Penyajian':<{wPenyajian}} "
        f"| {'Jenis Jajanan':<{wJenis}} |"
    )
    print(header)  # Mencetak baris header tabel

    # Mencetak garis pembatas tengah pemisah antara header dan isi data
    print(garis)

    # Melakukan iterasi pada list dataJajanan untuk mencetak seluruh baris data
    for data in dataJajanan:
        # Memformat isi data dari objek ke dalam susunan kolom tabel dengan rata kiri
        baris = (
            f"| {data.get_id():<{wId}} "
            f"| {data.get_nama():<{wNama}} "
            f"| {data.get_harga():<{wHarga}} "
            f"| {data.get_bahan():<{wBahan}} "
            f"| {data.get_rasa():<{wRasa}} "
            f"| {data.get_lama_ketahanan():<{wTahan}} "
            f"| {data.get_asal_daerah():<{wAsal}} "
            f"| {data.get_cara_penyajian():<{wPenyajian}} "
            f"| {data.get_jenis_jajanan():<{wJenis}} |"
        )
        print(baris)  # Mencetak satu baris data ke layar

    # Mencetak garis pembatas bawah sebagai penutup tabel
    print(garis)


# Fungsi untuk menangani prosedur penambahan data jajanan baru dari input pengguna
def tambahData():
    # Mencetak header visual untuk modul tambah data
    print("\n================ TAMBAH DATA JAJANAN TRADISIONAL ================")

    #Validasi ID Produk (tidak boleh kosong dan tidak boleh terdaftar/duplikat)
    id_produk = input("Masukkan ID Produk          : ").strip()
    while not id_produk or cekId(id_produk):
        if not id_produk:
            print(" [!] Error Nih: Duhh ID Produk tidak boleh kosong!")  # Menampilkan pesan error jika ID tidak diisi
        elif cekId(id_produk):
            print(" [!] Error Nih: Alamaak ID Produk sudah digunakan!")  # Menampilkan pesan error jika ID sudah ada
        id_produk = input("Masukkan ID Produk Kembali         : ").strip()  # Meminta ulang input ID Produk dengan format prompt penyesuaian

    # Validasi Nama Produk (tidak boleh kosong dan harus mengandung huruf)
    nama_produk = input("Masukkan Nama Produk        : ").strip()
    while not nama_produk or not mengandungHuruf(nama_produk):
        if not nama_produk:
            print(" [!] Error Nih: Duhh Nama Produk tidak boleh kosong!")  # Menampilkan pesan error jika nama kosong
        else:
            print(" [!] Error Nih: Nama Produk harus huruf (tidak boleh angka)")  # Menampilkan pesan error jika murni angka/simbol
        nama_produk = input("Masukkan Nama Produk Kembali        : ").strip()  # Meminta ulang input Nama Produk dengan prompt penyesuaian

    # Validasi Harga (harus berupa angka integer dan nilainya harus > 0)
    harga_input = input("Masukkan Harga              : ").strip()
    harga = -1  # Inisialisasi variabel harga
    valid = False  # Variabel penanda (flag) status validasi

    while not valid:  # Perulangan berjalan selama status belum valid
        try:
            harga = int(harga_input)  # Mencoba konversi input string ke integer
            if harga <= 0:
                print(" [!] Error Nih: Harga tidak boleh nol (0) dan minus Yaa!")  # Menampilkan pesan error jika <= 0
            else:
                valid = (True)  # Mengubah status menjadi True agar perulangan berhenti
        except ValueError:
            print(" [!] Error Nih: Harga harus berupa angka Yaa!")  # Menampilkan pesan error jika bukan angka

        if not valid:  # Jika status masih belum valid, minta input ulang
            harga_input = input("Masukkan Harga Kembali      : ").strip()

    #Validasi Bahan (tidak boleh kosong dan harus mengandung huruf)
    bahan = input("Masukkan Bahan              : ").strip()
    while not bahan or not mengandungHuruf(bahan):
        if not bahan:
            print(" [!] Error Nih: Bahan tidak boleh kosong!")  # Menampilkan pesan error jika bahan kosong
        else:
            print(" [!] Error Nih: Bahan harus huruf (tidak boleh angka)")  # Menampilkan pesan error jika murni angka/simbol
        bahan = input("Masukkan Bahan Kembali              : ").strip()  # Meminta ulang input bahan dari pengguna

    # Validasi Rasa (tidak boleh kosong dan harus mengandung huruf)
    rasa = input("Masukkan Rasa               : ").strip()
    while not rasa or not mengandungHuruf(rasa):
        if not rasa:
            print(" [!] Error Nih: Rasa tidak boleh kosong!")  # Menampilkan pesan error jika rasa kosong
        else:
            print(" [!] Error Nih: Rasa harus huruf (tidak boleh angka)")  # Menampilkan pesan error jika murni angka/simbol
        rasa = input("Masukkan Rasa Kembali               : ").strip()  # Meminta ulang input rasa dari pengguna

    # 6. Validasi Lama Ketahanan (harus berupa angka integer dan nilainya harus > 0)
    ketahanan_input = input("Masukkan Lama Ketahanan     : ").strip()  # Membaca input awal lama ketahanan dari pengguna
    lama_ketahanan = -1  # Inisialisasi variabel lama_ketahanan dengan nilai awal tidak valid
    valid_ketahanan = False  # Variabel penanda (flag) status validasi untuk lama ketahanan

    while not valid_ketahanan:  # Perulangan berjalan selama status validasi belum True
        try:
            lama_ketahanan = int(ketahanan_input)  # Mencoba konversi input string ke bentuk integer
            if lama_ketahanan <= 0:
                print(" [!] Error Nih: Lama Ketahanan tidak boleh nol (0) dan minus Yaa!")  # Menampilkan pesan error jika bernilai 0 atau negatif
            else:
                valid_ketahanan = True  # Mengubah status menjadi True agar perulangan berhenti secara alami
        except ValueError:
            print(" [!] Error Nih: Lama Ketahanan harus berupa angka Yaa!")  # Menampilkan pesan error jika input mengandung karakter non-angka

        if not valid_ketahanan:  # Pengecekan kondisi jika status validasi masih bernilai False
            ketahanan_input = input("Masukkan Lama Ketahanan Kembali      : ").strip()  # Meminta ulang input lama ketahanan dari pengguna

    # 7. Validasi Asal Daerah (tidak boleh kosong dan harus mengandung huruf)
    asal_daerah = input("Masukkan Asal Daerah        : ").strip()
    while not asal_daerah or not mengandungHuruf(asal_daerah):
        if not asal_daerah:
            print(
                " [!] Error Nih: Asal Daerah tidak boleh kosong!"
            )  # Menampilkan pesan error jika asal daerah kosong
        else:
            print(
                " [!] Error Nih: Asal Daerah harus huruf (tidak boleh angka)"
            )  # Menampilkan pesan error jika murni angka/simbol
        asal_daerah = input(
            "Masukkan Asal Daerah Kembali       : "
        ).strip()  # Meminta ulang input asal daerah dari pengguna

    # 8. Validasi Cara Penyajian (tidak boleh kosong dan harus mengandung huruf)
    cara_penyajian = input("Masukkan Cara Penyajian     : ").strip()
    while not cara_penyajian or not mengandungHuruf(cara_penyajian):
        if not cara_penyajian:
            print(
                " [!] Error Nih: Cara Penyajian tidak boleh kosong!"
            )  # Menampilkan pesan error jika cara penyajian kosong
        else:
            print(
                " [!] Error Nih: Cara Penyajian harus huruf (tidak boleh angka)"
            )  # Menampilkan pesan error jika murni angka/simbol
        cara_penyajian = input(
            "Masukkan Cara Penyajian Kembali     : "
        ).strip()  # Meminta ulang input cara penyajian dari pengguna

    # 9. Validasi Jenis Jajanan (tidak boleh kosong dan harus mengandung huruf)
    jenis_jajanan = input("Masukkan Jenis Jajanan      : ").strip()
    while not jenis_jajanan or not mengandungHuruf(jenis_jajanan):
        if not jenis_jajanan:
            print(
                " [!] Error: Jenis Jajanan tidak boleh kosong!"
            )  # Menampilkan pesan error jika jenis jajanan kosong
        else:
            print(
                " [!] Error Nih: Jenis Jajanan harus huruf (tidak boleh angka)"
            )  # Menampilkan pesan error jika murni angka/simbol
        jenis_jajanan = input(
            "Masukkan Jenis Jajanan Kembali     : "
        ).strip()  # Meminta ulang input jenis jajanan dari pengguna

    # Menginstansiasi objek baru dari class JajananTradisional menggunakan data masukan pengguna
    dataBaru = JajananTradisional(
        id_produk,
        nama_produk,
        harga,
        bahan,
        rasa,
        lama_ketahanan,
        asal_daerah,
        cara_penyajian,
        jenis_jajanan,
    )

    # Menambahkan objek data baru tersebut ke dalam list global dataJajanan
    dataJajanan.append(dataBaru)
    # Menampilkan pemberitahuan bahwa data telah sukses disimpan
    print("Uhuyy Data berhasil ditambahkan Bosss!")


# Fungsi untuk menampilkan pilihan menu utama aplikasi ke layar
def menuPilihan():
    print(
        "\n===== MENU JAJANAN TRADISIONAL ====="
    )  # Menampilkan baris judul menu utama
    print("1. Tampilkan Data")  # Menampilkan pilihan opsi 1 untuk lihat data
    print("2. Tambah Data")  # Menampilkan pilihan opsi 2 untuk tambah data
    print("0. Keluar")  # Menampilkan pilihan opsi 0 untuk menghentikan program


# Fungsi utama (main) yang mengatur alur eksekusi aplikasi
def main():
    # Membuat objek dummy pertama untuk data awal
    j1 = JajananTradisional(
        "JT001",
        "Bika Ambon",
        15000,
        "Tepung Tapioka",
        "Manis",
        3,
        "Medan",
        "Polos",
        "Kue Basah",
    )
    # Membuat objek dummy kedua untuk data awal
    j2 = JajananTradisional(
        "JT002",
        "Getuk Lindri",
        4000,
        "Singkong",
        "Manis",
        2,
        "Jawa Tengah",
        "Dengan Kelapa",
        "Jajanan Pasar",
    )
    # Membuat objek dummy ketiga untuk data awal
    j3 = JajananTradisional(
        "JT003",
        "Awug",
        6000,
        "Tepung Beras",
        "Manis",
        2,
        "Jawa Barat",
        "Dengan Kelapa",
        "Jajanan Tradisional",
    )
    # Membuat objek dummy keempat untuk data awal
    j4 = JajananTradisional(
        "JT004",
        "Serabi Solo",
        8000,
        "Tepung Beras",
        "Manis",
        1,
        "Solo",
        "Polos",
        "Jajanan Pasar",
    )
    # Membuat objek dummy kelima untuk data awal
    j5 = JajananTradisional(
        "JT005",
        "Barongko",
        7000,
        "Pisang",
        "Manis",
        2,
        "Sulawesi Selatan",
        "Polos",
        "Kue Basah",
    )

    # Memasukkan seluruh sampel objek dummy ke dalam list global dataJajanan secara sekaligus
    dataJajanan.extend([j1, j2, j3, j4, j5])

    # Perulangan utama program yang berjalan terus-menerus sampai dihentikan oleh pengguna
    while True:
        menuPilihan()  # Memanggil fungsi untuk menampilkan daftar opsi menu utama
        try:
            pilihan = int(
                input("Pilih : ")
            )  # Menerima pilihan opsi dari pengguna dan mengonversinya ke integer
        except ValueError:
            # Mengatasi error jika pengguna menginput karakter yang bukan angka
            print(
                "Pilihan Harus Berupa Angka (0-2) Yaa!\n"
            )  # Menampilkan pesan peringatan
            continue  # Mengulangi perulangan ke awal menu pilihan

        # Evaluasi kondisi berdasarkan opsi angka yang dipilih pengguna
        if pilihan == 1:
            tampilData()  # Memanggil fungsi tampilData() jika opsi yang dipilih adalah 1
        elif pilihan == 2:
            tambahData()  # Memanggil fungsi tambahData() jika opsi yang dipilih adalah 2
        elif pilihan == 0:
            # Menampilkan pesan penutup sebelum keluar dari program
            print(
                "Terima Kasih Sudah Menggunakan Program Ini. Sampai Jumpa Lagi"
            )
            # Menghentikan eksekusi skrip python secara keseluruhan
            sys.exit()
        else:
            # Menampilkan pesan peringatan jika opsi angka di luar rentang yang valid (0, 1, 2)
            print(
                "Aduhh Pilihan Tidak Tersedia. Silakan Masukkan Angka 0 Sampai 2 Yaa\n"
            )


# Titik awal eksekusi program utama ketika berkas dioperasikan langsung
if __name__ == "__main__":
    main()  # Memanggil fungsi main() untuk memulai seluruh alur eksekusi aplikasi