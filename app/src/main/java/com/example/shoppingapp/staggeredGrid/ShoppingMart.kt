package com.example.shoppingapp.staggeredGrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoppingapp.R
import com.example.staggeredgridtest.CustomAdapter
import com.example.staggeredgridtest.DataVo

class ShoppingMart : AppCompatActivity() {
    var recycler_view: RecyclerView? = null

    private var userList = arrayListOf<DataVo>(
        DataVo("Balcony repair", "img1", "서울특별시", 24, "img1"),
        DataVo("Redecorating", "img2", "서울특별시", 20, "img2"),
        DataVo("Painting works", "img3", "서울특별시", 30, "img3"),
        DataVo("Lucy", "img4", "서울특별시", 20, "img4"),
        DataVo("pure", "img5", "서울특별시", 20, "img5"),
        DataVo("purity", "img6", "서울특별시", 20, "img6"),
        DataVo("Seraphic", "img7", "서울특별시", 20, "img9"),
        DataVo("bijou", "img8", "서울특별시", 60, "img8"),
        DataVo("Melody", "img9", "서울특별시", 20, "img7"),
        DataVo("iris", "img10", "서울특별시", 20, "img10"),
        DataVo("Lovable", "img11", "서울특별시", 20, "img11"),
        DataVo("blossom", "img12", "서울특별시", 20, "img12"),
        DataVo("shine", "img13", "서울특별시", 20, "img16"),
        DataVo("stella", "img14", "서울특별시", 20, "img14"),
        DataVo("twilight", "img15", "서울특별시", 20, "img15"),
        DataVo("ideale", "img16", "서울특별시", 20, "img13")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_mart)

        recycler_view = findViewById(R.id.recycler_view)

        val mAdapter = CustomAdapter(this, userList)
        recycler_view!!.adapter = mAdapter

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recycler_view!!.layoutManager = staggeredGridLayoutManager
    }
}