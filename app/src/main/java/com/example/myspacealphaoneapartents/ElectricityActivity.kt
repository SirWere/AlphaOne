package com.example.myspacealphaoneapartents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class ElectricityActivity : AppCompatActivity() {

    private lateinit var electricalDetails: CardView
    private  lateinit var addElectricalDetails: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electricity)

        electricalDetails=findViewById(R.id.ElectricalDetails)
        addElectricalDetails=findViewById(R.id.AddElectricity)


        electricalDetails.setOnClickListener {
            val intent = Intent(this, ElectricalDetails::class.java)
            startActivity(intent)
        }

        addElectricalDetails.setOnClickListener {
            val intent = Intent(this, AddElectricalDetails::class.java)
            startActivity(intent)
        }

    }
}