package com.example.registeractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var edtName : EditText? = null
    var spnnerGender : Spinner? = null
    var edtEmail : EditText? = null
    var edtTelp : EditText? = null
    var edtAlamat : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.editNama)
        spnnerGender = findViewById(R.id.spinnergender)
        edtEmail = findViewById(R.id.editEmail)
        edtTelp = findViewById(R.id.editTelp)
        edtAlamat = findViewById(R.id.editAddress)

        buttonSave.setOnClickListener{
            validasiInput()
        }

        setDataSpinner()

    }
        fun setDataSpinner(){
            val adapter = ArrayAdapter.createFromResource(this,R.array.gender_list,android.R.layout.simple_spinner_item)

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinnergender?.adapter = adapter
        }

        fun validasiInput(){

            val namaInput = edtName?.text.toString()
            val emailInput = edtEmail?.text.toString()
            val telpInput = edtTelp?.text.toString()
            val alamatInput = edtAlamat?.text.toString()
            val genderInput = spnnerGender?.selectedItem.toString()

            when{
                genderInput.equals("Pilih jenis kelamin") ->
                    Toast.makeText(this,"kelamin harus dipilih",Toast.LENGTH_SHORT).show()
                namaInput.isEmpty() ->edtName?.error = "Tidak boleh kosong"
                emailInput.isEmpty() ->edtEmail?.error = "Tidak boleh kosong"
                telpInput.isEmpty() ->edtTelp?.error = "Tidak boleh kosong"
                alamatInput.isEmpty() ->edtAlamat?.error = "Tidak boleh kosong"

             else -> {
                 Toast.makeText(this, "Berhasil Dikirim",Toast.LENGTH_SHORT).show()
             }
            }
        }

}
