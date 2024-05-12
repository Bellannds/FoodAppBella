package com.bella.foodapp.model

import com.bella.foodapp.R

data class Food (
    val id: Long,
    val image: Int,
    val title: String,
    val price: String,
    val description: String
)

val dummyFood = listOf(
    Food(
        1,
        R.drawable.asinan_bogor,
        "Asinan Bogor",
        "Rp 10.000",
        "Salad buah atau sayuran yang disajikan dengan saus bumbu kacang manis asam, berasal dari Bogor, Jawa Barat."),
    Food(
        2,
        R.drawable.ayam_betutu,
        "Ayam Betutu",
        "Rp 30.000",
        "Ayam yang dimasak dengan bumbu rempah khas Bali, kemudian dibungkus dan dipanggang."),
    Food(
        3,
        R.drawable.gudeng,
        "Gudeng",
        "Rp 22.000",
        "Masakan khas Yogyakarta dan Jawa Tengah yang terbuat dari nangka muda yang dimasak dengan santan dan bumbu rempah."),
    Food(
        4,
        R.drawable.karedok,
        "Karedok",
        "Rp 25.000",
        "Salad khas Sunda dari Jawa Barat yang terdiri dari sayuran mentah seperti kacang panjang, tauge, dan terong yang disajikan dengan saus bumbu kacang."),
    Food(5,
        R.drawable.kerak_telor_betawi,
        "Kerak Telor",
        "Rp 15.000",
        "Makanan tradisional dari Betawi, Jakarta, yang terbuat dari telur ayam, beras ketan, dan bumbu-bumbu khas yang dibakar di atas wajan."),
    Food(6,
        R.drawable.pecel,
        "Pecel",
        "Rp 15.000",
        "Salad sayuran yang disajikan dengan saus kacang khas Jawa Timur, seringkali disertai dengan krupuk."),
    Food(
        7,
        R.drawable.pempek_palembang,
        "Pempek",
        "Rp 10.000",
        "Makanan khas Palembang yang terbuat dari ikan yang dicampur dengan tepung tapioka, kemudian digoreng dan disajikan dengan cuko khas."),
    Food(
        8,
        R.drawable.rawon,
        "Rawon",
        "Rp 20.000",
        "Sup daging sapi berwarna hitam khas Jawa Timur dengan bumbu khas seperti kluwek yang memberikan rasa khas."),
    Food(
        9,
        R.drawable.rendang,
        "Rendang",
        "Rp 17.000",
        "Masakan daging sapi yang dimasak dalam santan dan rempah-rempah khas Minangkabau, Sumatra Barat, dengan cita rasa yang kaya dan pedas."),
    Food(
        10,
        R.drawable.rujak_cingur,
        "Rujak Cingur",
        "Rp 15.000",
        "Salad khas Surabaya yang terdiri dari irisan buah, sayuran, dan cingur (bagian hidung sapi) yang disajikan dengan saus kacang."),
)