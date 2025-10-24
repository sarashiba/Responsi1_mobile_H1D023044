# Responsi 1 Pemrograman Mobile (H1D023044)

Aplikasi Android tentang klub sepak bola Villarreal CF tugas Responsi 1 Praktikum Pemrograman Mobile

**Nama:** Sarah Shiba Huwaidah<br>
**NIM:** H1D023044<br>
**Shift Baru:** C <br>
**Shift Asal:** A

## Video Demo
https://github.com/user-attachments/assets/b4231a33-821d-4157-9475-01ad794027be

## Penjelasan Alur Data

Aplikasi ini mengambil data detail tim Villarreal CF dari API publik football-data.org menggunakan library Retrofit dan Coroutines di `MainActivity`. Data yang didapat (objek `TeamResponse`) disimpan dalam sebuah variabel.

* Saat tombol **"Club History"** diklik, aplikasi membuka `HistoryActivity` yang menampilkan teks sejarah statis dengan efek CollapsingToolbar.
* Saat tombol **"Head Coach"** diklik, data pelatih (`coach`) dari variabel `teamData` dikirimkan melalui `Intent` ke `CoachActivity` untuk ditampilkan.
* Saat tombol **"Team Squad"** diklik, daftar pemain (`squad`) dari variabel `teamData` dikirimkan melalui `Intent` ke `SquadActivity`. `SquadActivity` kemudian menggunakan `RecyclerView` dan `SquadAdapter` untuk menampilkan daftar pemain. 
`SquadAdapter` juga bertanggung jawab untuk mengatur warna latar belakang kartu pemain sesuai posisi dan menangani klik pada item pemain untuk menampilkan detailnya dalam `PlayerDetailFragment` (Bottom Sheet).
