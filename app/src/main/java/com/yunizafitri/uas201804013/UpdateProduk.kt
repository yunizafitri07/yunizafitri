package com.yunizafitri.uas201804013

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateProduk : AppCompatActivity() {
    lateinit var produkDBHelper: DBHelper
    lateinit var inputid: EditText
    lateinit var inputname: EditText
    lateinit var inputprice: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_produk)
        inputid = findViewById(R.id.input_idu)
        inputname = findViewById(R.id.input_nameu)
        inputprice = findViewById(R.id.input_priceu)
        produkDBHelper = DBHelper(this)
        val bundle = intent.extras
        if (bundle!=null){
            inputid.setText(bundle.getString("idk"))
            inputname.setText(bundle.getString("namek"))
            inputprice.setText(bundle.getString("pricek"))

        }
    }
    fun updateData(v: View){
        var idin = inputid.text.toString()
        var namein = inputname.text.toString()
        var pricein = inputprice.text.toString()
        produkDBHelper.updateProduk(idin, namein, pricein)
        var pindah = Intent(this, RvDataProduk::class.java)
        startActivity(pindah)
    }
    fun cancelData(v: View){
        var pindah = Intent(this, RvDataProduk::class.java)
        startActivity(pindah)
    }
}