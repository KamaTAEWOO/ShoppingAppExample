package com.example.shoppingapp.staggeredGrid

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.R


class CartAdapter(
    private val context: Context, private val dataList: ArrayList<CartVo>
) : RecyclerView.Adapter<CartAdapter.ItemViewHolder>() {

    var mPosition = 0


    inner class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val cartPhoto = itemView.findViewById<ImageView>(R.id.img_picture)
        private val cartName = itemView.findViewById<TextView>(R.id.txt_name)
        private val cartPay = itemView.findViewById<TextView>(R.id.txt_price)

        fun bind(cartVo: CartVo, context: Context) {
            if (cartVo.photo != "") {
                val resourceId =
                    context.resources.getIdentifier(cartVo.photo, "drawable", context.packageName)

                if (resourceId > 0) {
                    cartPhoto.setImageResource(resourceId)
                } else {
                    cartPhoto.setImageResource(R.mipmap.ic_launcher_round)
                }
            } else {
                cartPhoto.setImageResource(R.mipmap.ic_launcher_round)
            }

            //TextView에 데이터 세팅
            cartName.text = cartVo.name
            cartPay.text = "$" + cartVo.pay.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_cart, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)

        holder.itemView.setOnClickListener { view ->
            Toast.makeText(view.context, "$position 아이템 클릭!", Toast.LENGTH_SHORT).show()

            // open another activity on item click
            val intent = Intent(context, ShoppingCart::class.java)
            intent.putExtra("image_name", dataList[position].photo) // image
            // name, price 같이 보내주면 됨.
            context.startActivity(intent) // start Intent
        }

        holder.itemView.setOnLongClickListener { view ->
            Toast.makeText(view.context, "$position 아이템 롱클릭!", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}