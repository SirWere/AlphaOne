package com.example.myspacealphaoneapartents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var myEmail: TextInputEditText
    lateinit var myPass1: TextInputEditText
    lateinit var mySignUp: TextView
    lateinit var forgotPass: TextView
    lateinit var login: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        myEmail=findViewById(R.id.email_edit)
        myPass1=findViewById(R.id.pwd_edit)
        mySignUp=findViewById(R.id.no_account)
        forgotPass=findViewById(R.id.forgot_password)
        login=findViewById(R.id.btn_login1)
        auth= FirebaseAuth.getInstance()

        login.setOnClickListener {
            login1()
        }

        mySignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        forgotPass.setOnClickListener {
            val intent = Intent(this, ForgotPaswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun login1() {
        val email = myEmail.text.toString()
        val pass = myPass1.text.toString()

        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }

            else{
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}