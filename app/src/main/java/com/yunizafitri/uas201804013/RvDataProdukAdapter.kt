package com.yunizafitri.uas201804013

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvDataProdukAdapter(private val listDataku: ArrayList<DataModelProduk>): RecyclerView.Adapter<RvDataProdukAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvidku: TextView = itemV.findViewById(R.id.tv_idku)
        var tvnameku: TextView = itemV.findViewById(R.id.tv_nameku)
        var tvpriceku: TextView = itemV.findViewById(R.id.tv_priceku)
        var btndelete: Button = itemV.findViewById(R.id.btn_deletecard)
        var btnupdate: Button = itemV.findViewById(R.id.btn_updatecard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rvdata_produk_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvidku.text = dataku.id
        holder.tvnameku.text = dataku.name
        holder.tvpriceku.text = dataku.price

        holder.btndelete.setOnClickListener {
            var adapterDBHelper: DBHelper
            adapterDBHelper = DBHelper(holder.itemView.context)
            adapterDBHelper.deleteProduk(dataku.id)
            listDataku.removeAt(position)
            notifyDataSetChanged()
        }

        holder.btnupdate.setOnClickListener {
            val pindahUpdAc = Intent(holder.itemView.context, UpdateProduk::class.java)
            val bundle = Bundle()
            bundle.putString("idk", dataku.id)
            bundle.putString("namek", dataku.name)
            bundle.putString("pricek", dataku.price)
            pindahUpdAc.putExtras(bundle)
            holder.itemView.context.startActivity(pindahUpdAc)
        }

    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}