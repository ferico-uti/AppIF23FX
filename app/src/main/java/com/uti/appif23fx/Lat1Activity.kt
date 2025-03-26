package com.uti.appif23fx

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Lat1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lat1)

//        variabel untuk object
        val edt_nilai1 = findViewById<EditText>(R.id.edt_nilai1)
        val edt_nilai2 = findViewById<EditText>(R.id.edt_nilai2)
        val edt_hasil = findViewById<EditText>(R.id.edt_hasil)
        val btn_hitung = findViewById<Button>(R.id.btn_hitung)
        val btn_reset = findViewById<Button>(R.id.btn_reset)

//        setup btn_hitung dan btn_reset
        btn_hitung.isEnabled = true
        btn_reset.isEnabled = false


//        buat event
//        1. untuk btn_hitung
            btn_hitung.setOnClickListener {
//                jika nilai 1, nilai 2 tidak diisi
                if(edt_nilai1.text.toString().isEmpty() ||
                    edt_nilai2.text.toString().isEmpty())
                {
                    Toast.makeText(this@Lat1Activity, "Nilai 1 dan Nilai 2 Harus Diisi !", Toast.LENGTH_SHORT).show()
                }
//                jika nilai1, nilai2 terisi
                else
                {

//              ambil nilai 1 dan nilai 2 (input)
                    val nilai1 = edt_nilai1.text.toString().toInt()
                    val nilai2 = edt_nilai2.text.toString().toInt()

//              hitung proses (nilai 1 + nilai 2)
                    val hasil = nilai1 + nilai2

//                tampilkan variabel "hasil" ke edt_hasil
//                edt_hasil.setText(hasil.toString())
                    edt_hasil.text = Editable.Factory.getInstance().newEditable(hasil.toString())

                    btn_hitung.isEnabled = false
                    btn_reset.isEnabled = true
                }



            }

//        2. untuk btn_reset
        btn_reset.setOnClickListener {
            edt_nilai1.setText("")
            edt_nilai2.setText("")
            edt_hasil.text = Editable.Factory.getInstance().newEditable("")

//            focus cursor ke edt_nilai1
            edt_nilai1.requestFocus()

            btn_hitung.isEnabled = true
            btn_reset.isEnabled = false
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}