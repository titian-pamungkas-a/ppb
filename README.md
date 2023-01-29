# Uni Ampera APP

## Source Code Kotlin [DI SINI](https://github.com/titian-pamungkas-a/uniapp_kotlin)


![image](https://user-images.githubusercontent.com/77373958/215311850-b4cc5f0a-dd22-4038-a18d-66156fa00cae.png)
![image](https://user-images.githubusercontent.com/77373958/215311857-b27df8dc-b671-446e-b3f8-5a0bfab1b869.png)



Uni Ampera APP adalah aplikasi pemesanan makanan berbasis android yang ditujukan untuk pengguna yang ingin memesan makanan padang di daerah Gebang dan Keputih, Surabaya. Uni Ampera App memiliki fitur utama yaitu pengguna dapat memesan makanan padang yang tersedia pada aplikasi, kemudian dikirim oleh restoran rumah padang terdekat dari tempat pengguna. Adapun fitur lainnya yaitu pengguna dapat melihat menu apa saja yang tersedia, melihat FAQ, dan memberikan review yang nantinya dapat dilihat melalui database. ***Uni Ampera App merupakan mini proyek pribadi yang seluruhnya dibuat oleh penulis, Aplikasi ini tidak terhubung dengan restoran makanan manapun, melainkan hanya sebagai contoh pemesanan makanan oleh pengguna.***

## Technology

Uni Ampera APP dibuat menggunakan IDE Android Studio dan ditulis menggunakan bahasa pemrograman Java dan Kotlin, serta menggunakan Firebase firestore sebagai database dan menggunakan Firebase Authentication sebagai data authentication.

## Fitur

### Login dan Register


![image](https://user-images.githubusercontent.com/77373958/215311651-21620a57-a4cd-4c5c-a34b-0eee7d4479c1.png)
![image](https://user-images.githubusercontent.com/77373958/215311657-c57b3a0c-ae8f-473e-a6bc-64e25788e95e.png)



Ketika pertama kali membuka aplikasi, pengguna akan diminta untuk login terlebih dahulu. Jika pengguna tidak memiliki akun, maka pengguna dapat mendaftar terlebih dahulu melalui register. Setelah melakukan login/register, pengguna akan melihat activity menu dan dapat memilih hal apa yang ingin dilakukan.

### Menu


![image](https://user-images.githubusercontent.com/77373958/215311666-dd196840-0480-42fd-9edf-20240ee37cd3.png)



Menu activity merupakan halaman dimana pengguna dapat memilih aksi yang bisa mereka lakukan. Beberapa aksi yang bisa dilakukan adalah melihat daftar menu, memesan makanan, melihat FAQ, dan memberi review kepada restoran. Pengguna juga bisa melakukan log out pada laman ini.

### Order


![image](https://user-images.githubusercontent.com/77373958/215311680-269a713b-7196-414f-8741-e15adc2ba5ef.png)



Pengguna dapat memesan makanan melalui halaman order/pesan. Setiap makanan terdapat harga yang harus dibayarkan. Pengguna akan memilih makanan yang diinginkan dengan menambah jumlah setiap makanan (default 0). Total harga akan otomatis ditampilkan berdasarkan harga total makanan. Jika pengguna sudah yakin, mereka bisa membeli.

### Map


![image](https://user-images.githubusercontent.com/77373958/215311694-97efca61-bd77-4bdb-babd-4c64d736b66a.png)



Setelah membeli, pengguna akan melihat tampilan maps, yang berlokasi di sekitar tempat pembeli. Sistem akan memilihkan tempat restoran terdekat dari tempat pembeli secara otomatis. Dalam real case, akan ada logo driver yang menunjukkan posisi dimana driver berada. Namun, dalam project ini hanya ditampilkan lokasi pembeli dan lokasi restoran, serta ditampilkan restoran mana yang terdekat dan jaraknya.

### List Makanan


![image](https://user-images.githubusercontent.com/77373958/215311712-b5379f40-81fc-4c29-8988-896194ba7eab.png)
![image](https://user-images.githubusercontent.com/77373958/215311701-6cbf0f33-9ba4-4c4a-bba8-aad74d335d6f.png)



Pengguna dapat melihat detail dari setiap menu yang disediakan di halaman List Makanan. Pengguna dapat klik dari setiap jenis makanan untuk melihat detailnya.

### FAQ


![image](https://user-images.githubusercontent.com/77373958/215311684-760b9f82-2777-4198-9e28-f142843ca78e.png)



Jika user memiliki pertanyaan seputar resto atau aplikasi, bisa dilihat melalui halaman FAQ

### Review


![image](https://user-images.githubusercontent.com/77373958/215311721-6b188661-13b5-48bc-9f1b-8d72f3f6e0f6.png)



Pengguna dapat memberikan review mengenai penggunaan aplikasi terhadap restoran dengan cara memberika ulasan tertulis. Ulasan yang diberikan oleh pengguna akan disimpen di dalam database
