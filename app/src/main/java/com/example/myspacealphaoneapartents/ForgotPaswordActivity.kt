package com.example.myspacealphaoneapartents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPaswordActivity : AppCompatActivity() {

    private lateinit var forgotPassword: EditText
    private lateinit var btnForgotPassword: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pasword)

        forgotPassword=findViewById(R.id.email_edit2)
        btnForgotPassword=findViewById(R.id.btn_reset)

        auth= FirebaseAuth.getInstance()

        btnForgotPassword.setOnClickListener {
            val forgot = forgotPassword.text.toString()
            auth.sendPasswordResetEmail(forgot)
                .addOnSuccessListener {
                    Toast.makeText(this,"Please check your email", Toast.LENGTH_LONG).show()
                    val intent= Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"Password failed to reset", Toast.LENGTH_LONG).show()
                }
        }
    }
}