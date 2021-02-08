package com.yunizafitri.uas201804013

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvDataUserAdapter(private val listDataku: ArrayList<DataModelUser>): RecyclerView.Adapter<RvDataUserAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvemailku: TextView = itemV.findViewById(R.id.tv_emailku)
        var tvpassku: TextView = itemV.findViewById(R.id.tv_passku)
        var tvnamaku: TextView = itemV.findViewById(R.id.tv_namaku)
        var tvalamatku: TextView = itemV.findViewById(R.id.tv_alamatku)
        var tvjkku: TextView = itemV.findViewById(R.id.tv_jkku)
        var btndelete: Button = itemV.findViewById(R.id.btn_deletecard)
        var btnupdate: Button = itemV.findViewById(R.id.btn_updatecard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rvdata_user_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvemailku.text = dataku.email
        holder.tvpassku.text = dataku.pass
        holder.tvnamaku.text = dataku.fullname
        holder.tvalamatku.text = dataku.alamat
        holder.tvjkku.text = dataku.jeniskelamin

        holder.btndelete.setOnClickListener {
            var adapterDBHelper: DBHelper
            adapterDBHelper = DBHelper(holder.itemView.context)
            adapterDBHelper.deleteUser(dataku.email)
            listDataku.removeAt(position)
            notifyDataSetChanged()
        }

        holder.btnupdate.setOnClickListener {
            val pindahUpdAc = Intent(holder.itemView.context, UpdateUser::class.java)
            val bundle = Bundle()
            bundle.putString("emailk", dataku.email)
            bundle.putString("passk", dataku.pass)
            bundle.putString("namak", dataku.fullname)
            bundle.putString("alamatk", dataku.alamat)
            bundle.putString("jkk", dataku.jeniskelamin)
            pindahUpdAc.putExtras(bundle)
            holder.itemView.context.startActivity(pindahUpdAc)
        }

    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}