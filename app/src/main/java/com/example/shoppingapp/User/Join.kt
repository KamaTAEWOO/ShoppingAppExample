package com.example.shoppingapp.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.shoppingapp.R

class Join : AppCompatActivity() {
    private var txtID: EditText? = null
    private var txtPassword: EditText? = null
    private var txtConfirmPassword: EditText? = null
    private var btnSignUp: Button? = null

    companion object {
        var joinInfo: UserInfo? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        txtID = findViewById(R.id.et_id)
        txtPassword = findViewById(R.id.et_password)
        txtConfirmPassword = findViewById(R.id.et_confirmPassword)
        btnSignUp = findViewById(R.id.btn_join)

        // dataClass에 저장만 해놓기.
        btnSignUp!!.setOnClickListener {
            joinInfo = UserInfo(txtID!!.text.toString(), txtPassword!!.text.toString(), txtConfirmPassword!!.text.toString())
            startActivity(Intent(this, Login::class.java)) //intent와 같음!
            finish()
        }
    }
}