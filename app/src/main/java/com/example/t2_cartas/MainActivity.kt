package com.example.t2_cartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var empezar: AppCompatButton
    private lateinit var nombre: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        empezar.setOnClickListener(this)
    }

    private fun instancias() {
        empezar = findViewById(R.id.empezar)
        nombre = findViewById(R.id.nombre)
    }


    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.empezar -> {
                if(nombre.text!!.isEmpty()){
                    Snackbar.make(v, resources.getString(R.string.fallo), Snackbar.LENGTH_LONG).show()
                }else{
                    Snackbar.make(v,"Perfecto "+nombre.text+", quieres empezar", Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK"){
                            val intent = Intent(applicationContext, SecondActivity::class.java)
                            intent.putExtra("nombre",nombre.text.toString())
                            startActivity(intent)
                        }.show()

                }

            }
        }

    }
}