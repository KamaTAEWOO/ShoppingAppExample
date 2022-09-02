package com.example.shoppingapp.staggeredGrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoppingapp.R
import com.example.shoppingapp.User.Join

class ShoppingMart : AppCompatActivity() {
    var recycler_view: RecyclerView? = null
    var btn_myCart: Button? = null

    private var userList = arrayListOf<MartVo>(
        MartVo("Balcony repair", "img1", "서울특별시", 24, "img1"),
        MartVo("Redecorating", "img2", "서울특별시", 20, "img2"),
        MartVo("Painting works", "img3", "서울특별시", 30, "img3"),
        MartVo("Lucy", "img4", "서울특별시", 20, "img4"),
        MartVo("pure", "img5", "서울특별시", 20, "img5"),
        MartVo("purity", "img6", "서울특별시", 20, "img6"),
        MartVo("Seraphic", "img7", "서울특별시", 20, "img9"),
        MartVo("bijou", "img8", "서울특별시", 60, "img8"),
        MartVo("Melody", "img9", "서울특별시", 20, "img7"),
        MartVo("iris", "img10", "서울특별시", 20, "img10"),
        MartVo("Lovable", "img11", "서울특별시", 20, "img11"),
        MartVo("blossom", "img12", "서울특별시", 20, "img12"),
        MartVo("shine", "img13", "서울특별시", 20, "img16"),
        MartVo("stella", "img14", "서울특별시", 20, "img14"),
        MartVo("twilight", "img15", "서울특별시", 20, "img15"),
        MartVo("ideale", "img16", "서울특별시", 20, "img13")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_mart)

        recycler_view = findViewById(R.id.recycler_view_mart)
        btn_myCart = findViewById(R.id.btn_myCart)

        val mAdapter = MartAdapter(this, userList)
        recycler_view!!.adapter = mAdapter

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recycler_view!!.layoutManager = staggeredGridLayoutManager

        btn_myCart!!.setOnClickListener{
            startActivity(Intent(this, ShoppingCart::class.java)) //intent와 같음!
            finish()
        }
    }
}