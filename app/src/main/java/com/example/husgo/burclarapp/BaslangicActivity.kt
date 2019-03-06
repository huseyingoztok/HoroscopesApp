package com.example.husgo.burclarapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_baslangic.*

class BaslangicActivity : AppCompatActivity() {
    var context:Context=this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baslangic)
        //android:background="@drawable/bgimage"
        imageViewLogo.animation=AnimationUtils.loadAnimation(context,R.anim.logodondur)


    }

    override fun onResume() {
        imageViewLogo.animation=AnimationUtils.loadAnimation(context,R.anim.logodondur)
        object :CountDownTimer(5000,1000){
            override fun onFinish() {
                var intent:Intent=Intent(context,MainActivity::class.java)
                startActivity(intent)
            }

            override fun onTick(millisUntilFinished: Long) {

            }

        }.start()


        super.onResume()
    }
}
