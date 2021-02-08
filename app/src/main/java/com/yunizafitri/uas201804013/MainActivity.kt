package com.yunizafitri.uas201804013

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_activity.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLogout: Button = findViewById(R.id.btnLogout)
        val savedLogin = getSharedPreferences("Login", MODE_PRIVATE)
        val editSavedLogin = savedLogin.edit()
        val btn_user: Button = findViewById(R.id.btn_user)
        val btn_produk: Button = findViewById(R.id.btn_produk)
        btnLogout.setOnClickListener {
            editSavedLogin.putString("Email", null)
            editSavedLogin.putString("Password", null)
            editSavedLogin.putString("Status", "Off")
            editSavedLogin.commit()
            startActivity(Intent(this, LoginActivity::class.java))
        }
        btn_user.setOnClickListener{
            val intent = Intent(this, RvDataUser::class.java)
            startActivity(intent)
        }
        btn_produk.setOnClickListener{
            val intent = Intent(this, ProdukMain::class.java)
            startActivity(intent)
        }
    }


}