package dev.joawhi.lab_5_listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var arrSO = arrayOf(
        "Android", "iPhone", "Windows Phone", "BlackBerry", "Firefox OS", "Amazon World", "Nokia"
    )




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lsvSO: ListView = findViewById(R.id.lsvSO) as ListView

        val adaptor: Any? =
            ArrayAdapter<Any?>(this,android.R.layout.simple_list_item_1, arrSO)

        lsvSO.adapter = adaptor as ListAdapter?

        lsvSO.setOnItemClickListener { parent, view, position, l ->
            Toast.makeText(
                applicationContext,
                "Posición: ${arrSO[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}