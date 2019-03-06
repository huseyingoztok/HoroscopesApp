package com.example.husgo.burclarapp

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_horoscope_detail.*

class HoroscopeDetail : AppCompatActivity() {
    var context:Context=this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horoscope_detail)
    /*
        var msg=intent.getStringExtra("poskey")
        var allHoroscopeInfo=intent.extras.get("allHoroscopeInfo") as ArrayList<Horoscope>
        */
        var currHoroscope:Horoscope=intent.extras.get("selectedHoroscope") as Horoscope
        //Toast.makeText(context,""+currHoroscope.horoscopeName+" "+currHoroscope.horoscopeDateInfo,Toast.LENGTH_SHORT).show()
        tvBurcDetay.setText(currHoroscope.horoscopeDetail)
        Glide.with(this).load(currHoroscope.horoscopeBigIms).into(header)

        collapsing_toolbar.title=currHoroscope.horoscopeName
        setSupportActionBar(anim_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        var bitmap=BitmapFactory.decodeResource(resources,currHoroscope.horoscopeBigIms)

        Palette.from(bitmap).generate(object :Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette) {
                var color=palette?.getVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color!!)
                window.statusBarColor=color
            }



        })



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
