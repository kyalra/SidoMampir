package com.android.projectara.email

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.projectara.R
import com.google.firebase.auth.FirebaseAuth
import android.util.Log
import com.android.projectara.Drawer
import com.android.projectara.MainActivity


class LoginWithEmail : AppCompatActivity(){
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        mAuth = FirebaseAuth.getInstance()
        var Login = findViewById<View>(R.id.btn_login) as Button
        var password = findViewById<View>(R.id.et_password_login) as EditText
        var email = findViewById<View>(R.id.et_email_login) as EditText
        Login.setOnClickListener {
            login(
                email.getText().toString(), password.getText().toString()
            )
        }
    }
    private fun login(email:String,password:String){
        mAuth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{

                if (!it.isSuccessful){ return@addOnCompleteListener
                    val intent = Intent (this, LoginWithEmail::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Succesfully Login", Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener{
                Log.d("Main", "Failed Login: ${it.message}")
                Toast.makeText(this, "Email/Password incorrect", Toast.LENGTH_SHORT).show()
            }
    }

}