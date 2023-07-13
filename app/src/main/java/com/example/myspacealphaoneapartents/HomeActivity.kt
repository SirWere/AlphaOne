package com.example.myspacealphaoneapartents

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    lateinit var cardAbout:CardView
    lateinit var cardRent:CardView
    lateinit var cardWater:CardView
    lateinit var cardElectrical:CardView
    lateinit var cardLogout:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        cardAbout=findViewById(R.id.card_about)
        cardRent=findViewById(R.id.card_rent)
        cardWater=findViewById(R.id.card_water)
        cardElectrical=findViewById(R.id.card_electrical)
        cardLogout=findViewById(R.id.card_logout)

        cardAbout.setOnClickListener {
            val intent = Intent(this,AboutActivity::class.java)
            startActivity(intent)
        }

        cardRent.setOnClickListener {
            val intent = Intent(this,RentActivity::class.java)
            startActivity(intent)
        }

        cardWater.setOnClickListener {
            val intent = Intent(this,WaterActivity::class.java)
            startActivity(intent)
        }

        cardElectrical.setOnClickListener {
            val intent = Intent(this,ElectricityActivity::class.java)
            startActivity(intent)
        }

        cardLogout.setOnClickListener {
            var box = AlertDialog.Builder(this)

            box.setMessage("Do you want to logout?")
            box.setPositiveButton("PROCEED", DialogInterface.OnClickListener { dialog, id -> finish() })
            box.setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, id -> onVisibleBehindCanceled()})

            var alert = box.create()
            alert.setTitle("Logout")
            alert.show()
        }
    }
}