package com.example.t2_cartas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var botonUp: AppCompatButton
    private lateinit var botonDown: AppCompatButton
    private lateinit var fondoCartas: LinearLayoutCompat
    private var nombre: String = ""
    private var contador: Int = 0
    private var carta: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle = intent.extras
        nombre = bundle?.getString("nombre").toString() ?: "Invitado"
        instancias()
        acciones()
        Snackbar.make(fondoCartas, "Bienvenido a la aplicación " + nombre, Snackbar.LENGTH_INDEFINITE)
            .setAction("OK") {
                jugar()
            }.show()
    }


    private fun acciones() {
        botonUp.setOnClickListener(this)
        botonDown.setOnClickListener(this)
    }

    private fun instancias() {
        botonUp = findViewById(R.id.botonUp)
        botonDown = findViewById(R.id.botonDown)
        fondoCartas = findViewById(R.id.fondoCartas)
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.botonUp -> {
                val cartaAntigua = carta
                carta = jugar()
                if (cartaAntigua>carta) {
                    Snackbar.make(fondoCartas, "Has fallado, tu puntuacion es "+contador, Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK") {
                            onDestroy()
                        }.show()
                }else if(cartaAntigua==carta){

                }else {
                    contador++
                }
            }
            R.id.botonDown ->{
                val cartaAntigua = carta
                carta = jugar()
                if (cartaAntigua<carta) {
                    Snackbar.make(fondoCartas, "Has fallado, tu puntuacion es "+contador, Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK") {
                            onDestroy()
                        }.show()
                }else if(cartaAntigua==carta){

                }else {
                }
                    contador++
                }
            }
        }
        fun jugar(): Int {
            var carta: Int = (Math.random() * 13).toInt() + 1
            when (carta) {
                1 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c1, null)
                }

                2 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c2, null)
                }

                3 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c3, null)
                }

                4 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c4, null)
                }

                5 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c5, null)
                }

                6 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c6, null)
                }

                7 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c7, null)
                }

                8 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c8, null)
                }

                9 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c9, null)
                }

                10 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c10, null)
                }

                11 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c11, null)
                }

                12 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c12, null)
                }

                13 -> {
                    fondoCartas.background = resources.getDrawable(R.drawable.c13, null)
                }
            }
            return carta
        }
}