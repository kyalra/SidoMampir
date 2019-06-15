package com.android.projectara.chatServices

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.projectara.R
import android.view.View
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.support.annotation.NonNull




class Register : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private var fStateListener: FirebaseAuth.AuthStateListener? = null
    private val TAG = Register::class.java!!.getSimpleName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        mAuth = FirebaseAuth.getInstance()
        fStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                // User sedang login
                Log.w(TAG, "onAuthStateChanged:signed_in:" + user.uid)
            } else {
                // User sedang logout
                Log.w(TAG, "onAuthStateChanged:signed_out")
            }
        }

        var BtsignUp = findViewById<View>(R.id.btn_regis) as Button
        var password = findViewById<View>(R.id.et_password) as EditText
        var email = findViewById<View>(R.id.et_email) as EditText
        BtsignUp.setOnClickListener {
            signUp(
                email.getText().toString(), password.getText().toString()
            )
        }
    }
    private fun signUp(email: String, password: String) {

        mAuth!!.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{ task ->
                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful)

                if (!task.isSuccessful) {
                    task.exception!!.printStackTrace()
                    Toast.makeText(
                        this@Register, "Proses Pendaftaran Gagal",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    var intent = Intent(this@Register , SignInFirebase::class.java)
                    startActivity(intent)
                }


            }

    }
}