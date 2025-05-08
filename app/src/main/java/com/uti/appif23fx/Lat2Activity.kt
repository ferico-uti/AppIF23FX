package com.uti.appif23fx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.appif23fx.databinding.ActivityLat2Binding

class Lat2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        definisi "binding"
        val binding = ActivityLat2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        deklarasi variabel komponen
        val btn_menu1 = findViewById<Button>(R.id.btn_menu1)
//        val btn_menu2 = findViewById<Button>(R.id.btn_menu2)
//        val btn_uti = findViewById<Button>(R.id.btn_uti)

//        buat event
//        1. event btn_menu1

        btn_menu1.setOnClickListener {
//            buat variabel intent
            val intent = Intent(this, MainActivity::class.java)
//            buka activity
            startActivity(intent)
//            finish()
        }

//        2. event btn_menu2
        binding.btnMenu2.setOnClickListener {
//            buka activity
            val intent = Intent(this, Lat1Activity::class.java)
//            kirim parameter "nilai1" dan "nilai2"
            intent.putExtra("nilai1", "10")
            intent.putExtra("nilai2", 17)

            startActivity(intent)
//            finish()
        }

//        3. event btn_uti
        binding.btnUti.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, "https://teknokrat.ac.id".toUri()))
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}