package com.yunizafitri.uas201804013

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RvDataUser : AppCompatActivity() {
    private lateinit var rv_tampilanku: RecyclerView
    lateinit var userDBHelper: DBHelper
    private  var list: ArrayList<DataModelUser> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rvdata_user)
        rv_tampilanku = findViewById(R.id.rv_tampilkan)
        rv_tampilanku.setHasFixedSize(true)
        userDBHelper = DBHelper(this)
        list.addAll(userDBHelper.fullDataUser())
        rv_tampilanku.layoutManager = LinearLayoutManager(this)
        var cardData = RvDataUserAdapter(list)
        rv_tampilanku.adapter = cardData
    }
}