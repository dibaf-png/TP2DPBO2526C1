<?php
// Mengimpor definisi class JajananTradisional dari file eksternal
require_once 'JajananTradisional.php';

// Memulai atau melanjutkan session untuk menyimpan data sementara
session_start();

// Cek apakah data jajanan belum ada dalam session
if (!isset($_SESSION['dataJajanan'])) {
    // Inisialisasi array session dengan dummy data awal
    $_SESSION['dataJajanan'] = [
        new JajananTradisional("JT001", "Bika Ambon", 15000, "Tepung Tapioka", "Manis", 3, "Medan", "Polos", "Kue Basah", "foto/bika_ambon.webp"),
        new JajananTradisional("JT002", "Getuk Lindri", 4000, "Singkong", "Manis", 2, "Jawa Tengah", "Dengan Kelapa", "Jajanan Pasar", "foto/getuk_lindri.jpg"),
        new JajananTradisional("JT003", "Awug", 6000, "Tepung Beras", "Manis", 2, "Jawa Barat", "Dengan Kelapa", "Jajanan Tradisional", "foto/awug.jpg"),
        new JajananTradisional("JT004", "Serabi Solo", 8000, "Tepung Beras", "Manis", 1, "Solo", "Polos", "Jajanan Pasar", "foto/serabi_solo.jpg"),
        new JajananTradisional("JT005", "Barongko", 7000, "Pisang", "Manis", 2, "Sulawesi Selatan", "Polos", "Kue Basah", "foto/barongko.jpg")
    ];
}

// Mengambil pesan notifikasi dari session (jika ada)
$message = $_SESSION['message'] ?? '';
// Mengambil tipe notifikasi ('success' atau 'error')
$message_type = $_SESSION['message_type'] ?? '';

// Menghapus variabel pesan session agar tidak tampil berulang kali saat halaman di-refresh manual berikutnya
unset($_SESSION['message'], $_SESSION['message_type']);

// Fungsi validasi apakah ID produk sudah ada dalam daftar
function isIdExists($id, $list) {
    // Melakukan perulangan pada setiap objek jajanan dalam daftar
    foreach ($list as $item) {
        // Cek jika ID objek sama dengan ID yang diinputkan
        if ($item->getId() === $id) {
            return true; // Kembalikan true jika ID ditemukan
        }
    }
    return false; // Kembalikan false jika ID unik
}

// Fungsi validasi apakah string input mengandung minimal 1 karakter huruf
function mengandungHuruf($str) {
    // Regex menguji apakah ada minimal satu huruf a-z atau A-Z
    return preg_match('/[a-zA-Z]/', $str) === 1;
}

// MEMPROSES FORM TAMBAH DATA
if (isset($_POST['tambah'])) {
    // Mengambil dan membersihkan spasi di awal/akhir input ID Produk
    $id             = trim($_POST['id_produk']);
    // Mengambil dan membersihkan spasi di awal/akhir input Nama Produk
    $nama           = trim($_POST['nama_produk']);
    // Mengambil nilai input Harga
    $harga          = $_POST['harga'];
    // Mengambil dan membersihkan spasi di awal/akhir input Bahan Utama
    $bahan          = trim($_POST['bahan']);
    // Mengambil dan membersihkan spasi di awal/akhir input Rasa
    $rasa           = trim($_POST['rasa']);
    // Mengambil nilai input Lama Ketahanan
    $lama_ketahanan = $_POST['lama_ketahanan'];
    // Mengambil dan membersihkan spasi di awal/akhir input Asal Daerah
    $asal           = trim($_POST['asal_daerah']);
    // Mengambil dan membersihkan spasi di awal/akhir input Cara Penyajian
    $penyajian      = trim($_POST['cara_penyajian']);
    // Mengambil dan membersihkan spasi di awal/akhir input Jenis Jajanan
    $jenis          = trim($_POST['jenis_jajanan']);

    // VALIDASI INPUT
    // Cek apakah ada field teks yang kosong
    if (empty($id) || empty($nama) || empty($bahan) || empty($rasa) || empty($asal) || empty($penyajian) || empty($jenis)) {
        $_SESSION['message'] = "[!] Error: Semua field teks tidak boleh kosong!"; // Pesan error
        $_SESSION['message_type'] = 'error'; // Tipe error
    } 
    // Cek apakah ID sudah ada di daftar
    elseif (isIdExists($id, $_SESSION['dataJajanan'])) {
        $_SESSION['message'] = "[!] Error: ID Produk ($id) sudah digunakan!"; // Pesan error duplikasi ID
        $_SESSION['message_type'] = 'error'; // Tipe error
    } 
    // Cek apakah input teks tidak mengandung huruf (misal hanya angka murni)
    elseif (!mengandungHuruf($nama) || !mengandungHuruf($bahan) || !mengandungHuruf($rasa) || !mengandungHuruf($asal) || !mengandungHuruf($penyajian) || !mengandungHuruf($jenis)) {
        $_SESSION['message'] = "[!] Error: Input teks harus mengandung huruf (tidak boleh angka murni)!"; // Pesan error teks
        $_SESSION['message_type'] = 'error'; // Tipe error
    } 
    // Cek apakah harga dan lama ketahanan valid (harus angka positif > 0)
    elseif (!is_numeric($harga) || $harga <= 0 || !is_numeric($lama_ketahanan) || $lama_ketahanan <= 0) {
        $_SESSION['message'] = "[!] Error: Harga dan Lama Ketahanan harus berupa angka positif lebih dari 0!"; // Pesan error angka
        $_SESSION['message_type'] = 'error'; // Tipe error
    } 
    else {
        // PROSES UPLOAD GAMBAR (Dijalankan hanya jika semua validasi lolos)
        $gambar_path = ''; // Inisialisasi variabel path gambar
        if (!empty($_FILES['gambar']['name']) && $_FILES['gambar']['error'] == 0) {
            $target_dir = "./foto/"; // Direktori tujuan penyimpanan
            if (!file_exists($target_dir)) {
                mkdir($target_dir, 0777, true); // Buat folder jika belum ada
            }
            // Buat nama file unik menggunakan timestamp
            $target_file = $target_dir . time() . "_" . basename($_FILES['gambar']['name']);
            if (move_uploaded_file($_FILES['gambar']['tmp_name'], $target_file)) {
                $gambar_path = $target_file; // Simpan path jika berhasil diupload
            }
        }

        // MENAMBAHKAN DATA BARU KE ARRAY SESSION
        $dataBaru = new JajananTradisional($id, $nama, (int)$harga, $bahan, $rasa, (int)$lama_ketahanan, $asal, $penyajian, $jenis, $gambar_path);
        $_SESSION['dataJajanan'][] = $dataBaru;

        // Set pesan notifikasi sukses
        $_SESSION['message'] = "Data ($nama) berhasil ditambahkan!";
        $_SESSION['message_type'] = 'success';
    }

    // REDIRECT BERLAKU UNTUK SEMUA HASIL (SUKSES MAUPUN ERROR)
    // Melakukan redirect otomatis kembali ke halaman ini agar browser melakukan GET request bersih (PRG Pattern)
    header("Location: " . $_SERVER['PHP_SELF']);
    exit(); // Menghentikan eksekusi script setelah mengarahkan halaman
}
?>

<!DOCTYPE html> <!-- Deklarasi dokumen HTML5 -->
<html lang="id"> <!-- Bahasa utama halaman adalah Indonesia -->
<head>
    <meta charset="UTF-8"> <!-- Set encoding karakter UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Pengaturan responsif layar -->
    <title>Sistem Manajemen Jajanan Tradisional</title> <!-- Judul pada tab browser -->
    <!-- Mengimpor font Google Montserrat & Poppins -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600;700&family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <style>
        /* CSS Reset untuk perhitungan ukuran elemen */
        * { box-sizing: border-box; }
        /* Styling bagian body / latar belakang utama */
        body {
            font-family: 'Poppins', 'Montserrat', Arial, sans-serif; /* Mengatur font */
            margin: 0; /* Menghilangkan margin bawaan */
            padding: 30px 20px; /* Padding sekeliling halaman */
            min-height: 100vh; /* Tinggi minimum menyesuaikan layar */
            background: linear-gradient(135deg, #8B4513 0%, #3E2723 100%); /* Gradasi warna cokelat */
            display: flex; /* Menggunakan flexbox */
            justify-content: center; /* Posisikan konten di tengah secara horisontal */
            align-items: flex-start; /* Konten rata atas */
            color: #2d3748; /* Warna teks bawaan */
        }

        /* Container utama pembungkus aplikasi */
        .container {
            width: 100%; /* Lebar penuh relatif */
            max-width: 1300px; /* Lebar maksimum container */
            background: rgba(255, 255, 255, 0.98); /* Warna latar putih sedikit transparan */
            border-radius: 16px; /* Sudut membulat */
            box-shadow: 0 20px 40px rgba(0,0,0,0.3); /* Efek bayangan */
            padding: 35px; /* Padding bagian dalam container */
            backdrop-filter: blur(10px); /* Efek buram pada latar */
        }

        /* Styling Judul Utama */
        h1 {
            text-align: center; /* Teks rata tengah */
            color: #5D4037; /* Warna cokelat gelap */
            font-family: 'Montserrat', sans-serif; /* Jenis font judul */
            font-weight: 700; /* Ketebalan font */
            margin-bottom: 25px; /* Jarak bawah judul */
            text-transform: uppercase; /* Ubah huruf menjadi kapital */
            letter-spacing: 1px; /* Jarak antar huruf */
        }

        /* Styling kotak pesan error / sukses */
        .alert {
            padding: 15px 20px; /* Padding dalam kotak */
            border-radius: 10px; /* Sudut membulat */
            margin-bottom: 25px; /* Jarak bawah */
            font-weight: 500; /* Ketebalan teks */
        }
        /* Styling khusus pesan sukses */
        .alert.success { background: #E8F5E9; color: #2E7D32; border: 1px solid #A5D6A7; }
        /* Styling khusus pesan error */
        .alert.error { background: #FFEBEE; color: #C62828; border: 1px solid #EF9A9A; }

        /* Styling Kartu Form */
        .card {
            background: #FAFAFA; /* Warna latar kartu */
            border-radius: 12px; /* Sudut membulat */
            padding: 25px; /* Padding dalam kartu */
            border: 1px solid #E0E0E0; /* Garis tepi kartu */
            margin-bottom: 30px; /* Jarak bawah kartu */
        }

        /* Judul sub-bagian kartu */
        .card h2 {
            margin-top: 0; /* Hilangkan margin atas */
            color: #6D4C41; /* Warna teks sub-judul */
            font-size: 1.25rem; /* Ukuran teks */
            margin-bottom: 20px; /* Jarak bawah */
            border-bottom: 2px solid #D7CCC8; /* Garis bawah dekoratif */
            padding-bottom: 8px; /* Padding bawah */
        }

        /* Tata letak grid untuk field form */
        .form-grid {
            display: grid; /* Menggunakan CSS Grid */
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr)); /* Kolom responsif */
            gap: 15px; /* Jarak antar field */
        }

        /* Kelompok elemen input & label */
        .form-group {
            display: flex; /* Menggunakan flexbox vertikal */
            flex-direction: column; /* Menyusun label dan input secara vertikal */
        }

        /* Styling label form */
        .form-group label {
            font-size: 0.85rem; /* Ukuran teks label */
            font-weight: 600; /* Ketebalan font */
            margin-bottom: 6px; /* Jarak bawah label */
            color: #4E342E; /* Warna label */
        }

        /* Styling input teks dan angka */
        .form-group input {
            padding: 10px 14px; /* Padding dalam input */
            border: 1px solid #BCAAA4; /* Warna garis tepi input */
            border-radius: 8px; /* Sudut membulat */
            font-family: inherit; /* Mewarisi font utama */
            font-size: 0.9rem; /* Ukuran teks */
            transition: all 0.3s ease; /* Transisi halus saat fokus */
        }

        /* Styling saat input di-fokus / di-klik */
        .form-group input:focus {
            outline: none; /* Hilangkan outline default */
            border-color: #8D6E63; /* Ubah warna border */
            box-shadow: 0 0 0 3px rgba(141, 110, 99, 0.2); /* Efek glow */
        }

        /* Pembungkus tombol */
        .btn-group {
            margin-top: 20px; /* Jarak atas dari form */
            display: flex; /* Menggunakan flexbox */
            gap: 10px; /* Jarak antar tombol */
        }

        /* Styling dasar tombol */
        .btn {
            padding: 10px 20px; /* Padding dalam tombol */
            border: none; /* Hilangkan border */
            border-radius: 8px; /* Sudut membulat */
            font-weight: 600; /* Ketebalan font */
            cursor: pointer; /* Mengubah kursor jadi pointer */
            transition: background 0.3s ease; /* Efek transisi warna */
            font-size: 0.9rem; /* Ukuran font tombol */
        }

        /* Warna khusus tombol utama (Tambah) */
        .btn-primary { background: #6D4C41; color: #fff; }
        /* Efek hover tombol utama */
        .btn-primary:hover { background: #4E342E; }

        /* Container pembungkus tabel agar responsif */
        .table-container {
            overflow-x: auto; /* Mengizinkan scroll horisontal jika tabel lebar */
            border-radius: 10px; /* Sudut membulat */
            border: 1px solid #E0E0E0; /* Garis tepi */
        }

        /* Styling tabel data */
        table {
            width: 100%; /* Lebar tabel 100% */
            border-collapse: collapse; /* Menggabungkan border sel */
            background: #fff; /* Latar belakang putih */
            text-align: left; /* Teks rata kiri */
            font-size: 0.9rem; /* Ukuran font tabel */
        }

        /* Styling header & isi sel tabel */
        th, td {
            padding: 12px 15px; /* Padding dalam sel */
            border-bottom: 1px solid #E0E0E0; /* Garis pembatas bawah */
            white-space: nowrap; /* Mencegah teks terpotong ke baris baru */
        }

        /* Styling khusus header tabel */
        th {
            background: #5D4037; /* Warna latar header cokelat */
            color: #fff; /* Warna teks putih */
            font-weight: 600; /* Ketebalan teks */
        }

        /* Efek hover pada baris tabel */
        tr:hover { background: #F5F5F5; }

        /* Styling thumbnail gambar pada tabel */
        .img-thumb {
            width: 50px; /* Lebar gambar */
            height: 50px; /* Tinggi gambar */
            object-fit: cover; /* Menjaga rasio gambar */
            border-radius: 6px; /* Sudut membulat */
            border: 1px solid #DDD; /* Garis tepi gambar */
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Judul Halaman Utama -->
    <h1>DATA JAJANAN TRADISIONAL</h1>

    <!-- Memeriksa apakah ada pesan notifikasi untuk ditampilkan -->
    <?php if (!empty($message)): ?>
        <!-- Menampilkan pesan notifikasi dengan kelas CSS yang sesuai (success / error) -->
        <div class="alert <?= htmlspecialchars($message_type); ?>">
            <?= htmlspecialchars($message); ?> <!-- Menampilkan isi pesan -->
        </div>
    <?php endif; ?>

    <!-- FORM TAMBAH DATA -->
    <div class="card">
        <h2>Tambah Data Jajanan Tradisional</h2>
        <!-- Form mengirim data menggunakan method POST dan mengizinkan upload file (enctype) -->
        <form action="" method="POST" enctype="multipart/form-data">
            <div class="form-grid">
                <!-- Input untuk ID Produk -->
                <div class="form-group">
                    <label>ID Produk</label>
                    <input type="text" name="id_produk" required placeholder="Contoh: JT006">
                </div>
                <!-- Input untuk Nama Produk -->
                <div class="form-group">
                    <label>Nama Produk</label>
                    <input type="text" name="nama_produk" required placeholder="Contoh: Klepon">
                </div>
                <!-- Input untuk Harga -->
                <div class="form-group">
                    <label>Harga (Rp)</label>
                    <input type="number" name="harga" min="1" required placeholder="Contoh: 5000">
                </div>
                <!-- Input untuk Bahan Utama -->
                <div class="form-group">
                    <label>Bahan Utama</label>
                    <input type="text" name="bahan" required placeholder="Contoh: Tepung Ketan">
                </div>
                <!-- Input untuk Rasa -->
                <div class="form-group">
                    <label>Rasa</label>
                    <input type="text" name="rasa" required placeholder="Contoh: Manis Gurih">
                </div>
                <!-- Input untuk Lama Ketahanan -->
                <div class="form-group">
                    <label>Ketahanan (Hari)</label>
                    <input type="number" name="lama_ketahanan" min="1" required placeholder="Contoh: 2">
                </div>
                <!-- Input untuk Asal Daerah -->
                <div class="form-group">
                    <label>Asal Daerah</label>
                    <input type="text" name="asal_daerah" required placeholder="Contoh: Jawa Tengah">
                </div>
                <!-- Input untuk Cara Penyajian -->
                <div class="form-group">
                    <label>Cara Penyajian</label>
                    <input type="text" name="cara_penyajian" required placeholder="Contoh: Tabur Kelapa">
                </div>
                <!-- Input untuk Jenis Jajanan -->
                <div class="form-group">
                    <label>Jenis Jajanan</label>
                    <input type="text" name="jenis_jajanan" required placeholder="Contoh: Jajanan Pasar">
                </div>
                <!-- Input untuk File Gambar Jajanan -->
                <div class="form-group">
                    <label>Foto Jajanan</label>
                    <input type="file" name="gambar" accept="image/*">
                </div>
            </div>

            <!-- Tombol submit form -->
            <div class="btn-group">
                <button type="submit" name="tambah" class="btn btn-primary">Tambah Data</button>
            </div>
        </form>
    </div>

    <!-- TABEL TAMPILAN DATA (READ ONLY) -->
    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <!-- Header kolom tabel -->
                    <th>Gambar</th>
                    <th>ID</th>
                    <th>Nama</th>
                    <th>Harga</th>
                    <th>Bahan</th>
                    <th>Rasa</th>
                    <th>Tahan (Hari)</th>
                    <th>Asal Daerah</th>
                    <th>Cara Penyajian</th>
                    <th>Jenis Jajanan</th>
                </tr>
            </thead>
            <tbody>
                <!-- Cek jika data jajanan kosong -->
                <?php if (empty($_SESSION['dataJajanan'])): ?>
                    <tr>
                        <!-- Baris alternatif jika data belum ada -->
                        <td colspan="10" style="text-align: center; color: #757575;">Tidak ada data jajanan.</td>
                    </tr>
                <?php else: ?>
                    <!-- Melakukan perulangan untuk setiap objek jajanan dalam session -->
                    <?php foreach ($_SESSION['dataJajanan'] as $d): ?>
                        <tr>
                            <!-- Kolom Gambar -->
                            <td>
                                <!-- Cek apakah gambar ada dan filenya tersedia -->
                                <?php if (!empty($d->getGambar()) && file_exists($d->getGambar())): ?>
                                    <!-- Tampilkan elemen gambar thumbnail -->
                                    <img src="<?= htmlspecialchars($d->getGambar()); ?>" class="img-thumb" alt="Foto">
                                <?php else: ?>
                                    <!-- Teks alternatif jika gambar tidak diunggah -->
                                    <span style="color:#aaa; font-size: 0.8rem;">Tidak Ada</span>
                                <?php endif; ?>
                            </td>
                            <!-- Kolom ID -->
                            <td><strong><?= htmlspecialchars($d->getId()); ?></strong></td>
                            <!-- Kolom Nama -->
                            <td><?= htmlspecialchars($d->getNama()); ?></td>
                            <!-- Kolom Harga dengan format Rupiah -->
                            <td>Rp <?= number_format($d->getHarga(), 0, ',', '.'); ?></td>
                            <!-- Kolom Bahan -->
                            <td><?= htmlspecialchars($d->getBahan()); ?></td>
                            <!-- Kolom Rasa -->
                            <td><?= htmlspecialchars($d->getRasa()); ?></td>
                            <!-- Kolom Ketahanan -->
                            <td><?= htmlspecialchars(method_exists($d, 'getLamaKetahanan') ? $d->getLamaKetahanan() : $d->getLama_ketahanan()); ?> Hari</td>
                            <!-- Kolom Asal Daerah -->
                            <td><?= htmlspecialchars($d->getAsalDaerah()); ?></td>
                            <!-- Kolom Cara Penyajian -->
                            <td><?= htmlspecialchars($d->getCaraPenyajian()); ?></td>
                            <!-- Kolom Jenis Jajanan -->
                            <td><?= htmlspecialchars($d->getJenisJajanan()); ?></td>
                        </tr>
                    <?php endforeach; ?> <!-- Akhir dari perulangan foreach -->
                <?php endif; ?> <!-- Akhir dari percabangan if -->
            </tbody>
        </table>
    </div>
</div>

</body>
</html>