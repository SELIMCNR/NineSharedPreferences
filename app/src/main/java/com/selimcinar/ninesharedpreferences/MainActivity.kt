package com.selimcinar.ninesharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit  var sharedPreferences:SharedPreferences // obje eklendi ama sonra yüklenecek lateinit sonra yüklenecek


    var alinanKullaniciAdi : String ? = null //String null olsun





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences
         sharedPreferences =this.getSharedPreferences("com.selimcinar.ninesharedpreferences",Context.MODE_PRIVATE)


        //SharedPrefrences değer kaydetme hafızaya
        alinanKullaniciAdi=sharedPreferences.getString("kullanici","")




        if(alinanKullaniciAdi != null){
            textView.text = "Kaydedilen kullanıcı adı : ${alinanKullaniciAdi}"
        }




    }

    fun Kaydet(view:View){
        val kullaniciAdi = editText.text.toString()
        if(kullaniciAdi==""){
            Toast.makeText(this,"Lütfen bir değer giriniz!",Toast.LENGTH_LONG).show()
        }
        else{
            sharedPreferences.edit().putString("kullanici",kullaniciAdi).apply()
            textView.text = "Kaydedilen kullanıcı ad : ${kullaniciAdi}"
        }



    }
    fun Sil(view: View){
           alinanKullaniciAdi=sharedPreferences.getString("kullanici","")
        if (alinanKullaniciAdi != null){
            textView.text="Kaydedilen Kullanıcı Adı:"
            sharedPreferences.edit().remove("kullanici").apply()
        }





    }
}