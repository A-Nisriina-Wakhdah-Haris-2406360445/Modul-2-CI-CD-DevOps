<details>
<Summary><b>Refleksi 1</b></Summary>
Berikut ini adalah clean code principles yang telah saya gunakan dalam mengimplementasikan dua fitur baru menggunakan
Spring Boot, yaitu:

1. Meaningful names: Dalam membuat kode untuk mengimplementasikan kedua fitur tersebut saya menggunakan prinsip meaningful
names. Tujuannya adalah agar saya tidak lupa mengenai fungsi variabel yang telah saya buat, misalnya variabel product pada
method deleteById yang fungsinya untuk menyimpan suatu produk
2. Function: Saya juga membuat function untuk mengimplementasikan setiap fitur yang ada.gti Tujuannya adalah agar kode untuk
suatu fitur tidak bercampur dengan kode fitur lain dan agar dapat dipakai berulang kali. Selain itu, dalam membuat function
saya menggunakan nama yang menggambarkan perilaku function tersebut, seperti function update yang fungsinya untuk mengedit(update)
product yang telah dibuat
3. Comment: Saya menambahkan beberapa komen yang menjelaskan secara singkat mengenai apa yang dilakukan oleh suatu function
agar orang lain yang membaca kode saya mengerti tujuan suatu function dibuat

Saya juga menerapkan secure coding practice berupa input data validation. Validasi inii diterapkan pada file createProduct.html
dan editProduct.html dengan menambahkan atribut required pada field productName dan productQuantity agar field tersebut
tidak bisa kosong. Pada createProduct.html saya menambahkan ketentuan min="1" input productQuantity, karena saat user
membuat prduct baru, jumlah stok minimalnya yang diizinkan adalah 1 dan tidak bisa nol. Selain itu, pada editProduct.html saya menambahkan ketentuan
min="0" pada input field productQuantity karena stok barang yang telah terdaftar di dalam list produk bisa saja habis (bernilai nol).
</details>
