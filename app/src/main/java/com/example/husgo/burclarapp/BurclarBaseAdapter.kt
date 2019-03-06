package com.example.husgo.burclarapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.tek_satir_layout.view.*
import java.util.zip.Inflater

class BurclarBaseAdapter(context:Context,var allHoroscopeInfoList:ArrayList<Horoscope>):BaseAdapter() {



    var context:Context
    init {



        this.context=context


    }

    override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View? {

        var mySpecialView=convertView
        var holdView:HoldView
        if (mySpecialView==null){
            var myInflater=LayoutInflater.from(context)
            mySpecialView=myInflater.inflate(R.layout.tek_satir_layout,parent, false)
            holdView =HoldView(mySpecialView)
            mySpecialView.tag=holdView
        }
        else{
            holdView=mySpecialView.getTag() as HoldView
        }





        holdView.tvBurcP.setText(allHoroscopeInfoList[p0].horoscopeName)
        holdView.tvBurcTarihP.setText(allHoroscopeInfoList[p0].horoscopeDateInfo)
        Glide.with(context).load(allHoroscopeInfoList[p0].horoscopeImg).into(holdView.imgBurcP)
        //holdView.imgBurcP.setImageResource(allHoroscopeInfoList[p0].horoscopeImg)



        return mySpecialView
    }

    override fun getItem(p0: Int): Any {
        return allHoroscopeInfoList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return allHoroscopeInfoList.size
    }


    class HoldView(sView :View)
    {
        var tvBurcP:TextView
        var tvBurcTarihP:TextView
        var imgBurcP:ImageView
        init {
            tvBurcP=sView.tvBurcAdi
            tvBurcTarihP=sView.tvBurcTarih
            imgBurcP=sView.imgBurcResim
        }
    }
}

