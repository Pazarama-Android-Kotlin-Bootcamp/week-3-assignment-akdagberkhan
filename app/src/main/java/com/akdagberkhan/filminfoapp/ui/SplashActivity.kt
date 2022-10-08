package com.akdagberkhan.filminfoapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.akdagberkhan.filminfoapp.R
import com.akdagberkhan.filminfoapp.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {


    //Layoutta bulunan öğelerimize daha kolay ve hızlı erişşenilmek için ViewBinding kullanıyoruz. Bir splash screen olduğu için ActivitySplashBinding oluşturdum
    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater) //layoutu bir kerelik binding içerisine attım
        setContentView(binding.root) ////top level view ögesine erişmek için binding.root ekledim

        //SplashActivity de kullandığım imageview bileşenini tanıttım.

        //Alpha değeri 0 ile 1 arasında değişir. 0 a yaklaştıkça imageview görünmez olur. tersi şekilde görünür hale gelir.
        binding.ivSplashIcon.alpha = 0f

        //imageview a bir animate ekleyerek 2 saniye duraksayacağını ve alpha değeri 1 olacağını söyledim.
        //withEndAction fonksiyonu ile animate bitince neler olması gerektiğini scope arasına yazdım
        binding.ivSplashIcon.animate().setDuration(2000).alpha(1f).withEndAction{

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            //ekranıma fade_in ve fade_out namiasyonlarını çalıştırmasını söyledim.
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()

        }



    }
}