package com.example.shoppingapp.User

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.shoppingapp.R
import com.example.shoppingapp.staggeredGrid.ShoppingCart
import com.example.shoppingapp.staggeredGrid.ShoppingMart

class Login : AppCompatActivity() {
    var txtID: EditText? = null
    var txtPassword: EditText? = null
    var btnLogin: Button? = null //로그인 버튼
    var btnSignUp: Button? = null //회원가입 버튼
    var isLoginCheck: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtID = findViewById(R.id.et_id)
        txtPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        btnSignUp = findViewById(R.id.btn_signUp)

        btnSignUp!!.setOnClickListener {
            startActivity(Intent(this, Join::class.java)) //intent와 같음!
        }

        // id, password 입력 받고  원하는 id, password맞는 지 확인 후
        Log.d("Login ID, Password -> ", Join.joinInfo.toString())

        btnLogin!!.setOnClickListener {
            if (Join.joinInfo?.ID != null && Join.joinInfo!!.ID == txtID!!.text.toString() && Join.joinInfo!!.password == txtPassword!!.text.toString()) {
                //id 와 password가 같다면.
                // intent -> 다음 페이지
                isLoginCheck = true
            }

            // Test용
            if (txtID!!.text.toString() == "id" && txtPassword!!.text.toString() == "pass") {
                isLoginCheck = true
            }

            if (isLoginCheck) {
                startActivity(Intent(this, ShoppingMart::class.java)) //intent와 같음!
            } else {
                Toast.makeText(applicationContext, "아이디와 비밀번호가 맞지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}