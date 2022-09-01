package com.example.staggeredgridtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.shoppingapp.R

class ShoppingCart : AppCompatActivity() {
    var imageView1: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

//        var receiveData1 = intent.getStringExtra("data1")
//        var receiveData2 = intent.getIntExtra("data2", 0)
        imageView1 = findViewById(R.id.imageView1)

        var receiveData1 = intent.getStringExtra("image_name")

        if (receiveData1 != "") {
            val resourceId =
                resources.getIdentifier(receiveData1, "drawable", packageName)

            if (resourceId > 0) {
                imageView1!!.setImageResource(resourceId)
            } else {
                imageView1!!.setImageResource(R.mipmap.ic_launcher_round)
            }
        } else {
            imageView1!!.setImageResource(R.mipmap.ic_launcher_round)
        }

    }
}