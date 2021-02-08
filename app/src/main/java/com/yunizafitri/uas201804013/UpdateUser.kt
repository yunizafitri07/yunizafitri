package com.yunizafitri.uas201804013

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateUser : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputemail: EditText
    lateinit var inputpass: EditText
    lateinit var inputnama: EditText
    lateinit var inputalamat: EditText
    lateinit var inputjk: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_user)
        inputemail = findViewById(R.id.input_emailu)
        inputpass = findViewById(R.id.input_passu)
        inputnama = findViewById(R.id.input_namau)
        inputalamat = findViewById(R.id.input_alamatu)
        inputjk = findViewById(R.id.input_jku)
        userDBHelper = DBHelper(this)
        val bundle = intent.extras
        if (bundle!=null){
            inputemail.setText(bundle.getString("emailk"))
            inputpass.setText(bundle.getString("passk"))
            inputnama.setText(bundle.getString("namak"))
            inputalamat.setText(bundle.getString("alamatk"))
            inputjk.setText(bundle.getString("jkk"))

        }
    }
    fun updateData(v: View){
        var emailin = inputemail.text.toString()
        var passin = inputpass.text.toString()
        var namain = inputnama.text.toString()
        var alamatin = inputalamat.text.toString()
        var jkin = inputjk.text.toString()
        userDBHelper.updateUser(emailin, passin, namain, alamatin, jkin)
        var pindah = Intent(this, RvDataUser::class.java)
        startActivity(pindah)
    }
    fun cancelData(v: View){
        var pindah = Intent(this, RvDataUser::class.java)
        startActivity(pindah)
    }
}