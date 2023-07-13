package com.example.myspacealphaoneapartents

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddElectricalDetails : AppCompatActivity() {

    private lateinit var addName : EditText
    private lateinit var addHouseNo : EditText
    private lateinit var addMeterNo : EditText
    private lateinit var dbRef: DatabaseReference
    private lateinit var submitDetails : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_electrical_details)

        addName=findViewById(R.id.nameElectrical)
        addHouseNo=findViewById(R.id.HouseNoElectrical)
        addMeterNo=findViewById(R.id.MeterNoElectrical)
        submitDetails=findViewById(R.id.btnSaveAddElectrical)

        dbRef = FirebaseDatabase.getInstance().getReference("Tenant Electrical")

        submitDetails.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {

        //getting values
        val empName = addName.text.toString()
        val empHouseNo = addHouseNo.text.toString()
        val empMeterNo = addMeterNo.text.toString()


        if (empName.isEmpty()) {
            addName.error = "Please enter Name"
        }
        if (empHouseNo.isEmpty()) {
            addHouseNo.error = "Please enter House Number"
        }
        if (empMeterNo.isEmpty()) {
            addMeterNo.error = "Please enter Meter No"
        }

        val empName2 = dbRef.push().key!!

        val tenant = PersonalModel(empName,empHouseNo,empMeterNo)

        dbRef.child(empName).setValue(tenant).addOnCompleteListener {
            Toast.makeText(this, "Data has been inserted successfully", Toast.LENGTH_LONG).show()

            addName.text.clear()
            addHouseNo.text.clear()
            addMeterNo.text.clear()

        }.addOnFailureListener { err ->
            Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
        }

    }
}