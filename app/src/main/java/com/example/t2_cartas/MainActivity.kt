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

    private lateinit var botonEmpezar: AppCompatButton
    private lateinit var textoNombre: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        botonEmpezar.setOnClickListener(this)
    }

    private fun instancias() {
        botonEmpezar = findViewById(R.id.botonEmpezar)
        textoNombre = findViewById(R.id.textoNombre)
    }


    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.botonEmpezar -> {
                if(textoNombre.text!!.isEmpty()){
                    Snackbar.make(v, resources.getString(R.string.fallo), Snackbar.LENGTH_LONG).show()
                }else{
                    Snackbar.make(v,"Perfecto "+textoNombre.text+", quieres empezar", Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK"){
                            val intent = Intent(applicationContext, SecondActivity::class.java)
                            intent.putExtra("nombre",textoNombre.text)
                            startActivity(intent)
                        }.show()

                }

            }
        }

    }
}