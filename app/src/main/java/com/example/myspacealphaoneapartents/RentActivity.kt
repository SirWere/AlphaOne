package com.example.myspacealphaoneapartents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class RentActivity : AppCompatActivity() {

   private lateinit var rentDetails: CardView
   private  lateinit var addRentDetails: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent)

        rentDetails=findViewById(R.id.RentDetails)
        addRentDetails=findViewById(R.id.AddRent)


        rentDetails.setOnClickListener {
            val intent = Intent(this, RentDetails::class.java)
            startActivity(intent)
        }

        addRentDetails.setOnClickListener {
            val intent = Intent(this, AddRentDetails::class.java)
            startActivity(intent)
        }
    }
}