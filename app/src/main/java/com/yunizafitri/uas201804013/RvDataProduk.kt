package com.yunizafitri.uas201804013

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RvDataProduk : AppCompatActivity() {
    private lateinit var rv_tampilanku: RecyclerView
    lateinit var produkDBHelper: DBHelper
    private  var list: ArrayList<DataModelProduk> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rvdata_produk)
        rv_tampilanku = findViewById(R.id.rv_tampilkan)
        rv_tampilanku.setHasFixedSize(true)
        produkDBHelper = DBHelper(this)
        list.addAll(produkDBHelper.fullDataProduk())
        rv_tampilanku.layoutManager = LinearLayoutManager(this)
        var cardData = RvDataProdukAdapter(list)
        rv_tampilanku.adapter = cardData
    }
}