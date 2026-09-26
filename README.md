# JANJI
Saya Farah Diba Nur Malinda dengan NIM 2502083 mengerjakan Tugas Praktikum 2 dalam mata kuliah Desain dan Pemrograman 
Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin

# Deskripsi
Program ini merupakan implementasi dari konsep Multilevel inheritance pada Toko Jajanan Tradisional.
Terdapat 3 class, yaitu:
- Class Produk, berisi data umum, seperti id, nama dan harga
- Class ProdukMakanan, turunan dari class Produk, berisi atribut spesifik makanan seperti bahan utama, rasa, dan lama ketahanan.
- Class JajananTradisional, turunan dari class ProdukMakanan (menjadi hirarki paling bawah pada Multilevel Inheritance), yang menambahkan atribut khas daerah seperti asal daerah, cara penyajian, dan jenis jajanan.

Ketentuan:
- Memiliki 5 data awal default.
- Menerima input user untuk menambahkan data
- Menampilkan data class dalam 1 tabel.
- Pada php ditambahkan atribut gambar.

# DIAGRAM
<img width="395" height="734" alt="diagram2_ drawio" src="https://github.com/user-attachments/assets/1bbca46b-d04a-45c7-a560-2378c08fac3a" /> <br>
- Class Produk: Berfungsi sebagai induk utama (base class) untuk menampung atribut umum (Id, Nama, Harga) yang dimiliki oleh seluruh entitas produk agar tidak terjadi pengulangan kode (code redundancy).
- Class ProdukMakanan: Berfungsi sebagai spesialisasi tingkat pertama yang mewarisi data umum produk sekaligus menambahkan atribut khusus konsumsi (Bahan, Rasa, Lama_ketahanan).
- Class JajananTradisional: Berfungsi sebagai entitas objek paling spesifik yang mewarisi seluruh data produk dan makanan, serta menambahkan atribut khas daerah (Asal_daerah, Cara_penyajian, Jenis_jajanan).

# ATRIBUT DAN METHOD ATAU FUNGSI
- Class Produk (Base Class) <br>
  Atribut:
  - id_produk (String): Menyimpan kode unik identitas produk (contoh: JT001).
  - nama_produk (String): Menyimpan nama produk umum.
  - harga (Integer / Double): Menyimpan harga jual produk dalam satuan mata uang. <br>
  Method:
  - Setter (setIdProduk, setNamaProduk, setHarga): Mengatur atau mengubah nilai atribut id_produk, nama_produk, dan harga.
  - Getter (getIdProduk, getNamaProduk, getHarga): Mengambil/mengembalikan nilai atribut id_produk, nama_produk, dan harga.

- Class ProdukMakanan (class turunan dari Produk) <br>
  Atribut:
  - Mewarisi seluruh atribut dari Class Produk (id_produk, nama_produk, harga).
  - bahan (String): Menyimpan bahan utama pembuat makanan (contoh: Tepung Ketan).
  - rasa (String): Menyimpan cita rasa makanan (contoh: Manis Gurih).
  - lama_ketahanan (Integer): Menyimpan durasi daya tahan penyimpanan makanan dalam hitungan hari. <br>
  Method:
  - Setter (setBahan, setRasa, setLamaKetahanan): Mengatur atau mengubah nilai atribut bahan, rasa, dan lama_ketahanan.
  - Getter (getBahan, getRasa, getLamaKetahanan): Mengambil/mengembalikan nilai atribut bahan, rasa, dan lama_ketahanan.

- Class JajananTradisional (class turunan dari ProdukMakanan)
  Atribut:
  - Mewarisi seluruh atribut dari Class ProdukMakanan dan Produk (id_produk, nama_produk, harga, bahan, rasa, lama_ketahanan).
  - asal_daerah (String): Menyimpan daerah asal kebudayaan jajanan (contoh: Jawa Tengah).
  - cara_penyajian (String): Menyimpan instruksi atau tradisi penyajian makanan (contoh: Tabur Kelapa).
  - jenis_jajanan (String): Menyimpan kategori jajanan (contoh: Jajanan Pasar).
  - foto / gambar (String - Khusus PHP): Menyimpan nama file atau path dari foto produk yang diunggah.
  Method:
  - Setter (setAsalDaerah, setCaraPenyajian, setJenisJajanan, setFoto): Mengatur atau mengubah nilai atribut khas kebudayaan lokal dan foto produk.
  - Getter (getAsalDaerah, getCaraPenyajian, getJenisJajanan, getFoto): Mengambil/mengembalikan nilai atribut khas kebudayaan lokal dan foto produk.

# ALUR PROGRAM
- Program secara otomatis menginisialisasi 5 data awal/default saat pertama kali dijalankan.
- User dapat memilih menu utama untuk menampilkan seluruh daftar data atau menambahkan data jajanan baru.
- Sistem menampilkan seluruh data jajanan tradisional secara presisi menggunakan format tabel dinamis.
- User dapat menginputkan data baru melalui serangkaian validasi ketat untuk memastikan data valid.
- Khusus pada implementasi PHP, user dapat mengunggah file gambar/foto untuk mengisi atribut foto jajanan.

# DOKUMENTASI OUPUT
- Tambah data pada c++: <br>
  <img width="1124" height="291" alt="tambah data" src="https://github.com/user-attachments/assets/ba6e1fe6-1e32-4349-b94f-62dc42e64ce3" />

- Tampil data pada c++: <br>
  <img width="1131" height="321" alt="tampil data" src="https://github.com/user-attachments/assets/74071525-bd1f-4861-af53-cfc9b4b523ad" />

- Tambah data pada java: <br>
  <img width="561" height="291" alt="tambah data" src="https://github.com/user-attachments/assets/c7ac4362-f737-4a7c-a921-a26229693c93" />

- Tampil data pada java: <br>
  <img width="1062" height="324" alt="tampil data" src="https://github.com/user-attachments/assets/650a3d2d-6480-437a-8424-19a726c56c2d" />

- Tambah data pada python: <br>
  <img width="547" height="282" alt="tambah data" src="https://github.com/user-attachments/assets/f48a7b43-5f9d-4a18-b88d-978831a5d3aa" />

- Tampil data pada python: <br>
  <img width="1075" height="322" alt="tampil data" src="https://github.com/user-attachments/assets/138c5b4e-46ee-489e-a86b-cc0b8229cdfb" />

- Tambah data pada php: </br>
  <img width="839" height="268" alt="tambah data" src="https://github.com/user-attachments/assets/338e5b56-4343-4995-884a-8729ede42bde" />

- Tampil data pada php: </br>
  <img width="694" height="565" alt="tampil data" src="https://github.com/user-attachments/assets/60b1747e-6117-432c-b105-4cf3a7cf8f0d" />

# ERROR HANDLING
Pada Program ini terdapat error handling:
- Pesan error dan meminta inputan kembali jika ID Produk tidak boleh kosong.
  <img width="515" height="55" alt="error_id kosong" src="https://github.com/user-attachments/assets/7a60a4e7-7dae-46a0-b2e1-e5aa4d452e30" />

- Pesan error dan meminta inputan kembali jika ID Produk sudah digunakan.
  <img width="591" height="72" alt="error_id sudah digunakan" src="https://github.com/user-attachments/assets/5c044999-ba3c-49bf-8c35-d7633a224ac3" />

  <img width="1277" height="251" alt="menggunakan id yang sudah ada" src="https://github.com/user-attachments/assets/5c9f8524-fe41-4382-8ac2-a15b9af0a862" />

- Pesan error dan meminta inputan kembali jika Nama, Bahan, Rasa, Asal Daerah, Cara Penyajian, dan Jenis Jajanan diisi kosong.

  <img width="1260" height="442" alt="ketika mengisi 0" src="https://github.com/user-attachments/assets/8c7fd94a-132c-4355-9597-9d8ad4c1c95c" />
  
  <img width="522" height="63" alt="error_nama tidak boleh kosong" src="https://github.com/user-attachments/assets/bbbbdada-2ea3-4f14-9025-0e1389d373f4" /> 

  <img width="372" height="61" alt="bahan_kosong" src="https://github.com/user-attachments/assets/7259c53c-e8a6-4cde-9046-131ad340650d" /> 

  <img width="402" height="67" alt="asal_kosong" src="https://github.com/user-attachments/assets/d3a34db2-632c-4e2b-b98b-a7cbe8122e20" /> 

  <img width="379" height="64" alt="rasa_kosong" src="https://github.com/user-attachments/assets/c35fb0e1-e63e-4e6a-8732-868ff21f3f2b" />

  <img width="402" height="67" alt="asal_kosong" src="https://github.com/user-attachments/assets/8c7ca38a-5d6b-483f-84e6-4dc0224c07e2" /> 

  <img width="433" height="65" alt="penyajian_kosong" src="https://github.com/user-attachments/assets/c1bf29dc-562b-4a94-a9e5-5595e004306c" /> 

  <img width="409" height="71" alt="jenis_kosong" src="https://github.com/user-attachments/assets/47b56cbc-91e7-4dd1-80a3-5ec5b4fb5953" /> 

- Pesan error dan meminta inputan kembali jika Nama, Bahan, Rasa, Asal Daerah, Cara Penyajian, dan Jenis Jajanan diisi dengan angka bukan huruf.
  
  <img width="509" height="71" alt="error_nama tidak boleh angka" src="https://github.com/user-attachments/assets/d77dff2f-c956-4aae-b0d1-bd5030b9a6f9" /> 

  <img width="518" height="69" alt="rasa tidak boleh angka" src="https://github.com/user-attachments/assets/778b0bab-0936-43eb-bdc3-c8da0dfa547c" /> 

  <img width="509" height="57" alt="asal tidak boleh angka" src="https://github.com/user-attachments/assets/2bc66fe4-2ac1-4985-9510-674ff59c3319" /> 

  <img width="500" height="74" alt="bahan tidak boleh angka" src="https://github.com/user-attachments/assets/0a3ecaa3-e510-417a-83ac-22e11494f833" /> 

  <img width="518" height="69" alt="rasa tidak boleh angka" src="https://github.com/user-attachments/assets/d7e57b64-79c9-4cea-a223-cec8146ac164" /> 

  <img width="565" height="65" alt="jenis jajanan tidak boleh angka" src="https://github.com/user-attachments/assets/c621c4a4-f9bc-47c3-838a-4b2aa1ca1203" /> 

- Pesan error dan meminta inputan kembali jika Harga dan Lama Ketahanan diisi dengan huruf.
  <img width="437" height="67" alt="harga tidak boleh huruf" src="https://github.com/user-attachments/assets/e53068d8-a948-4483-b0e8-d57d3e13a094" />
  
  <img width="472" height="79" alt="lama ketahanan tidak boleh huruf" src="https://github.com/user-attachments/assets/d2d96770-99be-4c5e-991e-575928503820" />

- Pesan error dan meminta inputan kembali jika Harga dan Lama Ketahanan diisi dengan kurang atau sama dengan 0.
  
  <img width="543" height="65" alt="error_tidak boleh minus atau 0" src="https://github.com/user-attachments/assets/ed5efcc9-0568-4482-9eae-7b265d0c52c8" /> 
  <img width="580" height="67" alt="ketahanan tidak boleh minus atau 0" src="https://github.com/user-attachments/assets/c93196bb-5331-4b80-b9c2-b538063cb18f" /> 

- Pesan error dan meminta inputan kembali jika inputan pilihan menu tidak berupa angka.
  <img width="459" height="139" alt="tidak boleh input pilihan bukan angka" src="https://github.com/user-attachments/assets/00ddc3fb-f3d3-443d-8d35-26d409e4d113" />

- Pesan error dan meminta inputan kembali jika inputan pilihan menu tidak berada dalam rentang opsi yang tersedia (0-2).
  <img width="582" height="129" alt="tidak boleh input pilihan yang tidak ada" src="https://github.com/user-attachments/assets/7e0a2244-fe3e-4bfc-ae40-189e3ebc2a4e" />
