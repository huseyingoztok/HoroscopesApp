package com.example.husgo.burclarapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.husgo.burclarapp.R.id.listBurclar
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.tek_satir_layout.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var allHoroscopeInfo: ArrayList<Horoscope> =getHoroscopeData()
        //window.statusBarColor=resources.get(android.R.color.holo_green_light)

    /*

        Bu tür atamaların main activity tarafında yapılması önerilmiyor

        var burclarListesi = resources.getStringArray(R.array.burclarArray)
        var tarihler = resources.getStringArray(R.array.burcTarihleriArray)
        var burcResimleri = arrayOf(R.drawable.koc1, R.drawable.boga2, R.drawable.ikizler3, R.drawable.yengec4, R.drawable.aslan5, R.drawable.basak6, R.drawable.terazi7, R.drawable.akrep8, R.drawable.yay9, R.drawable.oglak10, R.drawable.kova11, R.drawable.balik12)
*/
        /*

        var myAdapter = MySpecialAdapter(context, R.layout.tek_satir_layout, R.id.tvBurcAdi, burclarListesi,tarihler,burcResimleri)

        listBurclar.adapter = myAdapter
        */


        var myadapter=BurclarBaseAdapter(context,allHoroscopeInfo)

        listBurclar.adapter=myadapter


        listBurclar.setOnItemClickListener { adapterView, view, i, l ->
            var intent:Intent= Intent(context,HoroscopeDetail::class.java)

            /*
            intent.putExtra("poskey",i.toString())
            intent.putExtra("allHoroscopeInfo",allHoroscopeInfo)
            */
            intent.putExtra("selectedHoroscope",allHoroscopeInfo[i])
            startActivity(intent)


        }

    }

     fun getHoroscopeData() :ArrayList<Horoscope>{
         var listAllHoroscope:ArrayList<Horoscope> = ArrayList<Horoscope>(12)

         var horoscopeImgs=arrayOf(R.drawable.koc1, R.drawable.boga2, R.drawable.ikizler3, R.drawable.yengec4, R.drawable.aslan5, R.drawable.basak6, R.drawable.terazi7, R.drawable.akrep8, R.drawable.yay9, R.drawable.oglak10, R.drawable.kova11, R.drawable.balik12)
         var horoscopeBigImgs= arrayOf(R.drawable.koc_buyuk1,R.drawable.boga_buyuk2,R.drawable.ikizler_buyuk3,R.drawable.yengec_buyuk4,R.drawable.aslan_buyuk5,R.drawable.basak_buyuk6,R.drawable.terazi_buyuk7,R.drawable.akrep_buyuk8,R.drawable.yay_buyuk9,R.drawable.oglak_buyuk10,R.drawable.kova_buyuk11,R.drawable.balik_buyuk12)

         var horoscopeNames=context.resources.getStringArray(R.array.burclarArray)
         var horoscopeDateInfos=context.resources.getStringArray(R.array.burcTarihleriArray)
         var horoscopeDetail=resources.getStringArray(R.array.burcGenelOzellikler)

         for (i in 0..11){


             var currHoroscope=Horoscope(horoscopeNames[i],horoscopeDateInfos[i],horoscopeImgs[i],horoscopeBigImgs[i],horoscopeDetail[i])
             listAllHoroscope.add(currHoroscope)
         }
         return listAllHoroscope
    }


}

