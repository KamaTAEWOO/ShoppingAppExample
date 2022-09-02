package com.example.shoppingapp.staggeredGrid

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Preference.PreferenceManager
import com.example.shoppingapp.R


class MartAdapter(
    private val context: Context, private val dataList: ArrayList<MartVo>
) : RecyclerView.Adapter<MartAdapter.ItemViewHolder>() {

    var mPosition = 0

    companion object {
        var number: Int = 0
        var myCartDataArr: ArrayList<String> = ArrayList<String>()
    }

    inner class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val userPhoto = itemView.findViewById<ImageView>(R.id.userImg)
        private val userName = itemView.findViewById<TextView>(R.id.userNameTxt)
        private val userPay = itemView.findViewById<TextView>(R.id.payTxt)
        private val userAddress: TextView = itemView.findViewById<TextView>(R.id.addressTxt)

        fun bind(dataVo: MartVo, context: Context) {
            if (dataVo.photo != "") {
                val resourceId =
                    context.resources.getIdentifier(dataVo.photo, "drawable", context.packageName)

                if (resourceId > 0) {
                    userPhoto.setImageResource(resourceId)
                } else {
                    userPhoto.setImageResource(R.mipmap.ic_launcher_round)
                }
            } else {
                userPhoto.setImageResource(R.mipmap.ic_launcher_round)
            }

            //TextView에 데이터 세팅
            userName.text = dataVo.name
            userPay.text = "$" + dataVo.pay.toString()
            userAddress.text = dataVo.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_mart, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
       
        holder.itemView.setOnClickListener { view -> 
            Toast.makeText(view.context, "$position Cart Add", Toast.LENGTH_SHORT).show()
            // 1. String으로 만든다.
            var saveData: String = dataList[position].photo + "@" + dataList[position].name + "@" + dataList[position].pay
            Log.d("MartAdapter -> " , saveData) //img1 Balcony repair 24

            // 2. list를 만들어서 리스트 더하기
            myCartDataArr.add(saveData)

            // 3. 들어올때마다 claer 및 shared preferences 삭제
            PreferenceManager.clear(context)
            number = 0

            // 4. String을 저장시킨다.
            for(str in myCartDataArr) {
                PreferenceManager.setString(context, number.toString(), str)
                number++
            }
        }

        holder.itemView.setOnLongClickListener { view ->
            Toast.makeText(view.context, "$position Cart Remove", Toast.LENGTH_SHORT).show()
            myCartDataArr.clear() // 리스트 전체 삭제
            PreferenceManager.clear(context)
            number = 0

            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}