package com.example.myspacealphaoneapartents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    lateinit var myName: TextInputEditText
    lateinit var myPhone: TextInputEditText
    lateinit var myEmail1: TextInputEditText
    lateinit var myPass: TextInputEditText
    lateinit var myConfPass: TextInputEditText
    lateinit var myLogin: TextView
    lateinit var signup: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        myName=findViewById(R.id.name_edit)
        myPhone=findViewById(R.id.phone_edit)
        myEmail1=findViewById(R.id.email1_edit)
        myPass=findViewById(R.id.pwd1_edit)
        myConfPass=findViewById(R.id.confirm_pwd_edit)
        myLogin=findViewById(R.id.yes_account)
        signup=findViewById(R.id.btn_sign_up1)
        auth= Firebase.auth

        myLogin.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        signup.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser(){
        val name=myName.text.toString()
        val phone=myPhone.text.toString()
        val email=myEmail1.text.toString()
        val pass=myPass.text.toString()
        val confirmpass=myConfPass.text.toString()

        if (name.isBlank() || phone.isBlank() || email.isBlank() || pass.isBlank() || confirmpass.isBlank()){
            Toast.makeText(this,"Please Email and password cant be blank", Toast.LENGTH_LONG).show()
            return
        }
        else if (pass != confirmpass){
            Toast.makeText(this,"Password do not match", Toast.LENGTH_LONG).show()
            return
        }

        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Signed up successfully", Toast.LENGTH_LONG).show()
                val intent= Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"Failed to create", Toast.LENGTH_LONG).show()
            }
        }
    }
}