package com.example.husgo.burclarapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir_layout.view.*
import kotlin.math.log

class MySpecialAdapter(context: Context?, var resource: Int, textViewResourceId: Int, var burclarList: Array<String>
                       , var burcTarihleriList: Array<String>, var burcResimleriList: Array<Int>) : ArrayAdapter<String>(context, resource, textViewResourceId, burclarList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var inflateView = convertView
        var myViewHolder:ViewHolder
        if (inflateView == null) {
            var inflater = LayoutInflater.from(context)
            inflateView = inflater.inflate(resource, parent, false)
            //Log.e("Huseyin", "Inflate Edildim " + burclarList[position])
            myViewHolder=ViewHolder(inflateView)
           inflateView.tag=myViewHolder
        }
        else{
            myViewHolder=inflateView.getTag() as ViewHolder
        }





        myViewHolder.tvTarihP.setText(burcTarihleriList[position])
        myViewHolder.imgBurcResimP.setImageResource(burcResimleriList[position])
        myViewHolder.tvBurcP.setText(burclarList[position])



        return inflateView
    }

    class ViewHolder(v: View) {
        var tvBurcP: TextView
        var tvTarihP: TextView
        var imgBurcResimP: ImageView

        init {
            tvBurcP = v.tvBurcAdi
            tvTarihP = v.tvBurcTarih
            imgBurcResimP = v.imgBurcResim

        }

    }

}