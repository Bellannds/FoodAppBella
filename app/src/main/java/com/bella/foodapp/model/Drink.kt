package com.bella.foodapp.model

import com.bella.foodapp.R

data class Drink (
    val id: Long,
    val image: Int,
    val title: String,
    val price: String,
    val description: String
)

val dummyDrink = listOf(
    Drink(
        1,
        R.drawable.teh_tarik,
        "Teh Tarik",
        "Rp 15.000",
        "Minuman teh khas Malaysia dan Indonesia yang dicampur dengan susu kental manis. Namanya berasal dari proses menuangkan teh dari satu wadah ke wadah lain dengan gerakan tarikan yang menghasilkan buih di atasnya."),
    Drink(
        2,
        R.drawable.teh_talua,
        "Teh Talua",
        "Rp 10.000",
        "Minuman tradisional dari daerah Sumatra Barat yang terbuat dari campuran teh dengan telur ayam dan jeruk nipis. Biasanya diminum hangat."),
    Drink(
        3,
        R.drawable.selendang_mayang,
        "Selendang Mayang",
        "Rp 12.000",
        "Minuman asli Betawi yang terbuat dari campuran air kelapa, gula merah, dan daun pandan. Dinamakan demikian karena penyajiannya menggunakan dua gelas yang dihubungkan dengan sehelai selendang."),
    Drink(
        4,
        R.drawable.es_pisang_ijo,
        "Es Pisang Ijo",
        "Rp 17.000",
        "Makanan khas dari daerah Makassar, Sulawesi Selatan, terdiri dari pisang yang dibungkus dengan adonan tepung berwarna hijau dari daun suji, kemudian disajikan dengan siraman santan dan sirup gula merah."),
    Drink(5,
        R.drawable.wedang_ronde,
        "Wedang Ronde",
        "Rp 10.000",
        " Minuman hangat yang terbuat dari jahe, gula merah, dan tepung ketan yang dibentuk bulat-bulat kecil. Biasanya disajikan dengan potongan kelapa."),
    Drink(6,
        R.drawable.wedang_jahe,
        "Wedang Jahe",
        "Rp 7.000",
        "Minuman tradisional dari Jahe yang biasanya disajikan hangat. Jahe diparut dan direbus bersama air, kemudian ditambahkan gula merah atau madu."),
    Drink(
        7,
        R.drawable.es_doger,
        "Es Doger",
        "Rp 17.000",
        "Minuman dingin yang terbuat dari campuran es serut, kelapa muda, tape ketan hitam, alpukat, dan campuran bahan lainnya seperti agar-agar, santan, dan sirup merah."),
    Drink(
        8,
        R.drawable.stmj,
        "STMJ",
        "Rp 14.000",
        "Singkatan dari Susu Telur Madu Jahe, minuman yang terbuat dari campuran susu, telur, madu, dan jahe. Biasanya dikonsumsi hangat sebagai penambah energi."),
    Drink(
        9,
        R.drawable.wedang_uwuh,
        "Wedang Uwuh",
        "Rp 10.000",
        "Minuman tradisional Jawa Tengah yang terbuat dari campuran rempah-rempah seperti kayu manis, cengkeh, jahe, dan lain-lain. Biasanya diminum hangat."),
    Drink(
        10,
        R.drawable.cendol,
        "Cendol",
        "Rp 15.000",
        "Minuman dingin yang terbuat dari campuran tepung beras, air kelapa, dan gula merah, disajikan dengan es serut dan santan. Biasanya ditambahkan potongan nangka atau biji selasih untuk tambahan tekstur dan rasa."),
)

val dummyDrink2 = listOf(
    Drink(
        1,
        R.drawable.minuman_tradisional,
        "Minuman adat",
        "Rp 15.000 - 25.000",
        "Minuman yang disajikan sesuai dengan warisan budaya suatu daerah atau negara, seringkali menggunakan bahan-bahan lokal dan memiliki nilai historis serta tradisional."),
    Drink(
        2,
        R.drawable.minuman_bersoda,
        "Minuman soda",
        "Rp 10.000 - 20.000",
        "Minuman yang mengandung gas karbonat yang memberikan rasa berbuih dan segar, seperti cola, soda krim, dan minuman bersoda buatan lainnya."),
    Drink(
        3,
        R.drawable.minuman_panas,
        "Minuman Hangat",
        "Rp 12.000 - 15.000",
        "Minuman yang biasanya disajikan dalam keadaan panas, seperti kopi, teh, cokelat panas."),
    Drink(
        4,
        R.drawable.minuman_berenergi,
        "Minuman energi",
        "Rp 17.000 - 20.000",
        "Minuman yang mengandung bahan-bahan seperti kafein, ginseng, atau taurin untuk meningkatkan energi dan daya tahan tubuh."),
    Drink(5,
        R.drawable.minuman_manis,
        "Minuman Manis",
        "Rp 10.000 - 17.000",
        "Minuman yang memiliki rasa manis yang dominan dan umumnya mengandung gula atau pemanis tambahan."),
    Drink(6,
        R.drawable.air_mineral,
        "Air Mineral",
        "Rp 3.000 - 7.000",
        "Air mineral adalah air yang berasal dari sumber alami, seperti mata air atau sumur, yang kemudian dikemas dan dijual."),
    Drink(
        7,
        R.drawable.minuman_teh,
        "Minuman Teh",
        "Rp 5.000 - 10.000",
        "Minuman yang diseduh dari daun-daunan tanaman teh, seperti teh hitam, teh hijau, atau teh herbal."),
    Drink(
        8,
        R.drawable.minuman_susu,
        "Minuman Susu",
        "Rp 14.000 - 25.000",
        "Minuman yang dibuat dengan campuran susu, baik susu sapi maupun susu nabati. Minuman susu mengandung nutrisi penting seperti kalsium, protein, dan vitamin D, dan sering dianggap sebagai minuman yang baik untuk kesehatan tulang dan gigi."),
    Drink(
        9,
        R.drawable.minuman_buah_segar,
        "Minuman Buah",
        "Rp 10.000 - 17.000",
        "Minuman yang dibuat dari jus atau sari buah-buahan segar. Minuman buah segar kaya akan vitamin, mineral, dan serat alami, serta memberikan rasa segar dan menyegarkan."),
    Drink(
        10,
        R.drawable.minuman_herbal,
        "Minuman Herbal",
        "Rp 10.000 - 13.000",
        "Minuman yang dibuat dari campuran atau infus berbagai jenis rempah-rempah, tumbuhan, atau bahan alami lainnya."),
)