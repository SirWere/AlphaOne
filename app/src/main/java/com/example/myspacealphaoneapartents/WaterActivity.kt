package com.example.myspacealphaoneapartents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class WaterActivity : AppCompatActivity() {

    private lateinit var waterDetails: CardView
    private  lateinit var addWaterDetails: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)

        waterDetails=findViewById(R.id.WaterDetails)
        addWaterDetails=findViewById(R.id.AddWater)


        waterDetails.setOnClickListener {
            val intent = Intent(this, WaterDetails::class.java)
            startActivity(intent)
        }

        addWaterDetails.setOnClickListener {
            val intent = Intent(this, AddWaterDetails::class.java)
            startActivity(intent)
        }

    }
}
