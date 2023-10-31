package com.example.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterDisaster = DisasterAdapter(generateDummy()){
            disaster -> Toast.makeText(this@MainActivity,
            "You clicked on ${disaster.typeDisaster}",
                Toast.LENGTH_SHORT).show()}

            with(binding) {
                rvDisaster.apply {
                    adapter = adapterDisaster
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
//                rvDisaster.apply {
//                    adapter = adapterDisaster
//                    layoutManager = GridLayoutManager(this@MainActivity, 2)
//                }
            }
        }
    }

    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(imageResId = R.drawable.musashi, typeDisaster = "Musashi", affiliate = "Miyamoto", wafat = "13 Juni 1645"),
            Disaster(imageResId = R.drawable.hondatadakatsu, typeDisaster = "Honda Tadakatsu", affiliate = "Tokugawa", wafat = "3 Desember 1610" ),
            Disaster(imageResId = R.drawable.odanobunaga, typeDisaster = "Oda Nobunaga", affiliate = "Oda", wafat = "21 Juni 1582"),
            Disaster(imageResId = R.drawable.ieyasu_tokugawa, typeDisaster = "Ieyasu Tokugawa", affiliate = "Tokugawa", wafat = "1 Juni 1616"),
            Disaster(imageResId = R.drawable.shingentakeda, typeDisaster = "Shingen Takeda", affiliate = "Takeda", wafat = "13 Mei 1573"),
            Disaster(imageResId = R.drawable.chosokabe, typeDisaster = "Chosokabe Motochika", affiliate = "Chosokabe", wafat = "11 Juli 1599"),
            Disaster(imageResId = R.drawable.motonari, typeDisaster = "Mori Motonari", affiliate = "Mori", wafat = "6 Juli 1571"),
        )
    }

