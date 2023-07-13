package com.example.myspacealphaoneapartents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddRentDetails : AppCompatActivity() {

    private lateinit var addName : EditText
    private lateinit var addHouseNo : EditText
    private lateinit var submitDetails : Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_rent_details)

        addName=findViewById(R.id.name)
        addHouseNo=findViewById(R.id.HouseNo)
        submitDetails=findViewById(R.id.btnSaveAddRent)

        dbRef = FirebaseDatabase.getInstance().getReference("Tenant")

        submitDetails.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {

        //getting values
        val empName = addName.text.toString()
        val empHouseNo = addHouseNo.text.toString()


        if (empName.isEmpty()) {
            addName.error = "Please enter Name"
        }
        if (empHouseNo.isEmpty()) {
            addHouseNo.error = "Please enter House Number"
        }

        val empName2 = dbRef.push().key!!

        val tenant = PersonalModel(empName,empHouseNo)

        dbRef.child(empName).setValue(tenant).addOnCompleteListener {
            Toast.makeText(this, "Data has been inserted successfully", Toast.LENGTH_LONG).show()

            addName.text.clear()
            addHouseNo.text.clear()

        }.addOnFailureListener { err ->
            Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
        }

    }
}