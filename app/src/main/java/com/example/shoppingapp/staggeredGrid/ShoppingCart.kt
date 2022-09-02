package com.example.shoppingapp.staggeredGrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoppingapp.R
import com.example.staggeredgridtest.CartAdapter
import com.example.staggeredgridtest.CartVo

class ShoppingCart : AppCompatActivity() {
    var recycler_view: RecyclerView? = null

    private var userList = arrayListOf<CartVo>(
        CartVo("Balcony repair", 24, "img1"),
        CartVo("Redecorating", 20, "img2"),
        CartVo("Painting works",30, "img3"),
        CartVo("Lucy",20, "img4"),
        CartVo("pure", 20, "img5"),
        CartVo("purity",20, "img6"),
        CartVo("Seraphic",20, "img9")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        recycler_view = findViewById(R.id.recycler_view_cart)

        val mAdapter = CartAdapter(this, userList)
        recycler_view!!.adapter = mAdapter

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        recycler_view!!.layoutManager = staggeredGridLayoutManager

    }
}