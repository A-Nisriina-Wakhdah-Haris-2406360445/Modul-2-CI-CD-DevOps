Nama: Nisriina Wakhdah Haris<br>
NPM: 2406360445<br>
Kelas: ProLan - A<br>

<details>
<Summary><b>Refleksi 1</b></Summary>
Berikut ini adalah clean code principles yang telah saya gunakan dalam mengimplementasikan dua fitur baru menggunakan
Spring Boot, yaitu:

1. Meaningful names: Dalam membuat kode untuk mengimplementasikan kedua fitur tersebut saya menggunakan prinsip meaningful
names. Tujuannya adalah agar saya tidak lupa mengenai fungsi variabel yang telah saya buat, misalnya variabel product pada
method deleteById yang fungsinya untuk menyimpan suatu produk
2. Function: Saya juga membuat function untuk mengimplementasikan setiap fitur yang ada. Tujuannya adalah agar kode untuk
suatu fitur tidak bercampur dengan kode fitur lain dan agar dapat dipakai berulang kali. Selain itu, dalam membuat function
saya menggunakan nama yang menggambarkan perilaku function tersebut, seperti function update yang fungsinya untuk mengedit (update)
product yang telah dibuat
3. Comment: Saya menambahkan beberapa komen yang menjelaskan secara singkat mengenai apa yang dilakukan oleh suatu function
agar orang lain yang membaca kode saya mengerti tujuan suatu function dibuat

Saya juga menerapkan secure coding practice berupa input data validation. Validasi inii diterapkan pada file createProduct.html
dan editProduct.html dengan menambahkan atribut required pada field productName dan productQuantity agar field tersebut
tidak bisa kosong. Pada createProduct.html saya menambahkan ketentuan min="1" input productQuantity, karena saat user
membuat prduct baru, jumlah stok minimalnya yang diizinkan adalah 1 dan tidak bisa nol. Selain itu, pada editProduct.html saya menambahkan ketentuan
min="0" pada input field productQuantity karena stok barang yang telah terdaftar di dalam list produk bisa saja habis (bernilai nol) 
dan saya menambahkan anotasi validasi seperti @NotBlank dan @Min pada model untuk menambahkan validasi input di sisi backend
</details>

<details>
<Summary><b>Refleksi 2</b></Summary>

1. Setelah membuat unit test, saya merasa bahwa unit test itu sangat penting dalam membuat suatu program, karena dengan adanya unit test
kita dapat mengetahui apakah program yang kita buat dapat berjalan dengan baik tanpa error dan tidak cukup apabila jika hanya menjalankan kodenya saja tanpa
menguji setiap function. Dalam suatu class, jumlah unit test yang perlu dibuat tidak dapat ditentukan secara pasti, karena tergantung pada behavior dari function yang telah kita buat. 
Hal ini dikarenakan, setiap function dapat memiliki lebih dari satu unit test untuk menguji positive case dan negative case. Unit test dapat dianggap cukup ketika 
seluruh behavior dari program telah diuji, termasuk positive dan negative case. Salah satu indikator yang dapat digunakan adalah code coverage, namun faktor yang paling 
penting adalah unit test akan gagal apabila behavior dari program salah. Apabila suatu unit test menghasilkan 100% code coverage, tidak menjamin bahwa kode 
tersebut bebas dari bug dan error. Hal ini dikarenakan, code coverage hanya menunjukkan bawa seluruh kode telah dijalankan oleh unit test, namun tidak menjamin bahwa 
semua behavior telah diuji dengan benar, contohnya adalah ketika terdapat bug yang berasal dari desain suatu file html, saat unit test dijalankan code coveragenya tetap 100% 
namun pada paraktiknya tetap terdapat bug. Oleh karena itu, code coverage tidak bisa dijadikan sebagai jaminan bahwa program bbebas dari bug dan error, hanya saja dapat 
meningkatkan kepercayaan bahwa program dapat bekerja sesuai dengan yang diharapkan.
<br>
2. Pembuatan functional test suite baru yang memiliki setup procedures dan variabel yang sama dengan functional test sebelumnya dapat menurunkan 
kualitas dan kebersihan kode. Hal ini disebabkan karena adanya duplikasi kode yang melanggar prinsip DRY (Don't Repeat Yourself)
sehingga dapat menimbulkan masalah, seperti meningkatkan risiko inkonsistensi kode dan apabila terdapat perubahan, maka perubahan tersebut harus dilakukan di banyak tempat. 
Selain itu, masalah lain yang dapat muncul adalah kesulitan dalam pemeliharanan kode ketika jumlah test bertambah karena terdapat duplikasi kode(menurukan maintanability kode) 
serta dapat membuat seorang programmer kesulitan dalam membaca dan memahami kode karena terdapat kode yang sama dan berulang (menurunkan readability kode).
Solusi yang dapat dilakukan untuk menghindari permasalahan tersebut adalah memisahakan antara kode setup dengan kode pengujian beharivor yang spesifik,
seperti membuat base functional test class yang berisi setup umum agar test suite lain bisa mewarisi (inherit) dari base class tersebut dan mengimplementasikan
kode pengujian sesuai dengan behavior yang akan diuuji, dengan begitu kode menjadi lebih bersih, mudah dirawat, rapih dan terstruktur

