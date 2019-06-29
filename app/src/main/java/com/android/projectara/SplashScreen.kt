package com.android.projectara

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.android.projectara.chatServices.SignInFirebase


class SplashScreen:AppCompatActivity() {
    private var mDelayHandler: Handler? = null
    private val SPLAS_DELAY :Long =3000//3 detik

    internal val mRunnable:Runnable= Runnable {
        if(!isFinishing){
            val intent=Intent(applicationContext,SignInFirebase::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        //inisialisasi handler
        mDelayHandler=Handler()

        //Delay
        mDelayHandler!!.postDelayed(mRunnable,SPLAS_DELAY)
    }

    override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }
    }
