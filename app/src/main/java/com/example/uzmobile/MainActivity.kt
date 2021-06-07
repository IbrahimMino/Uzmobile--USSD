package com.example.uzmobile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.example.uzmobile.fragments.BannerFragment
import com.example.uzmobile.fragments.PageFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBalans = findViewById<ImageView>(R.id.img1_balans)
        btnBalans.setOnClickListener {
            Log.d("TAG", "onCreateView: BtnBalans")
            this.startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "*100*1#", null)))
        }


       // Operator icon
        val btnOperator = findViewById<ImageView>(R.id.img2_operator)
        btnOperator.setOnClickListener {
            this.startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "1099", null)))
        }

        //Yangiliklar icon
        val btnNews = findViewById<ImageView>(R.id.img3_news)
        btnNews.setOnClickListener {
            //requireContext().startActivity(Intent(context,Intent.ACTION_VIEW,"http://google.com"))
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://google.com")
            startActivity(intent)
        }

        //MainFragmentg
        val btnHome = findViewById<FloatingActionButton>(R.id.btn_home)
        btnHome.setOnClickListener {
            frame_container.clearFocus()
            supportFragmentManager?.beginTransaction().replace(R.id.frame_container, PageFragment()).commit()
        }


        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
       transaction.replace(R.id.frame_container,PageFragment()).commit()
    }


}