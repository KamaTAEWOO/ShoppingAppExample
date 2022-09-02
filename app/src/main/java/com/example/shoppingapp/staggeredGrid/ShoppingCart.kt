package com.example.shoppingapp.staggeredGrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoppingapp.Preference.PreferenceManager
import com.example.shoppingapp.R
import org.w3c.dom.Text

class ShoppingCart : AppCompatActivity() {
    var recycler_view: RecyclerView? = null
    var btnCheckOut: Button? = null
    var txtSum: TextView? = null
    private var sum: Int = 0

    private var userList = arrayListOf<CartVo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        recycler_view = findViewById(R.id.recycler_view_cart)
        btnCheckOut = findViewById(R.id.btn_checkout)
        txtSum = findViewById(R.id.txt_total)

        val cartCount = MartAdapter.number
        // Shared Preferences에서 Data를 가지고 와서 파싱 후 CartVo에 넣어주기.
        for(i in 0..cartCount-1) {
            var str: String? = PreferenceManager.getString(this, i.toString())
            // parsing
            var arrStr = str!!.split("@")
            userList.add(CartVo(arrStr[1], arrStr[2].toInt(), arrStr[0]))
            sum += arrStr[2].toInt()
        }

        // 총합
        txtSum!!.text = "$" + sum.toString()

        val mAdapter = CartAdapter(this, userList)
        recycler_view!!.adapter = mAdapter

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        recycler_view!!.layoutManager = staggeredGridLayoutManager

        btnCheckOut!!.setOnClickListener{
            PreferenceManager.clear(this)
            MartAdapter.number = 0
            MartAdapter.myCartDataArr.clear()
            startActivity(Intent(this, ShoppingMart::class.java)) //intent와 같음!
            finish()
        }
    }
}