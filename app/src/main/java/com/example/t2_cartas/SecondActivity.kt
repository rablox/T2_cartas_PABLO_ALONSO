package com.example.t2_cartas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var arriba: AppCompatButton
    private lateinit var abajo: AppCompatButton
    private lateinit var cartas: LinearLayoutCompat
    private var nombre: String = ""
    private var contador: Int = 0
    private var carta: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle = intent.extras
        nombre = bundle?.getString("nombre") ?: "Invitado"
        instancias()
        acciones()
        Snackbar.make(cartas, "Bienvenido a la aplicación " + nombre, Snackbar.LENGTH_INDEFINITE)
            .setAction("OK") {
                arriba.isEnabled = true
                abajo.isEnabled = true
                jugar()
            }.show()
    }


    private fun acciones() {
        arriba.setOnClickListener(this)
        abajo.setOnClickListener(this)
    }

    private fun instancias() {
        arriba = findViewById(R.id.arriba)
        abajo = findViewById(R.id.abajo)
        cartas = findViewById(R.id.cartas)
        arriba.isEnabled = false
        abajo.isEnabled = false
    }

    override fun onClick(v: View?) {
        val cartaAntigua = carta  // Guardamos la carta antigua antes de obtener una nueva

        when (v!!.id) {
            R.id.arriba -> {
                val nuevaCarta = jugar()
                if (cartaAntigua >= nuevaCarta) {
                    Snackbar.make(cartas, "Has fallado, tu puntuacion es " + contador, Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK") {
                            finish()
                        }.show()
                } else {
                    contador++
                }
                carta = nuevaCarta
            }

            R.id.abajo -> {
                val nuevaCarta = jugar()
                if (cartaAntigua <= nuevaCarta) {
                    Snackbar.make(cartas, "Has fallado, tu puntuacion es " + contador, Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK") {
                            finish()
                        }.show()
                } else {
                    contador++
                }
                carta = nuevaCarta
            }
        }
    }


    fun jugar(): Int {
            var carta: Int = (Math.random() * 13).toInt() + 1
            when (carta) {
                1 -> {
                    cartas.background = resources.getDrawable(R.drawable.c1, null)
                }

                2 -> {
                    cartas.background = resources.getDrawable(R.drawable.c2, null)
                }

                3 -> {
                    cartas.background = resources.getDrawable(R.drawable.c3, null)
                }

                4 -> {
                    cartas.background = resources.getDrawable(R.drawable.c4, null)
                }

                5 -> {
                    cartas.background = resources.getDrawable(R.drawable.c5, null)
                }

                6 -> {
                    cartas.background = resources.getDrawable(R.drawable.c6, null)
                }

                7 -> {
                    cartas.background = resources.getDrawable(R.drawable.c7, null)
                }

                8 -> {
                    cartas.background = resources.getDrawable(R.drawable.c8, null)
                }

                9 -> {
                    cartas.background = resources.getDrawable(R.drawable.c9, null)
                }

                10 -> {
                    cartas.background = resources.getDrawable(R.drawable.c10, null)
                }

                11 -> {
                    cartas.background = resources.getDrawable(R.drawable.c11, null)
                }

                12 -> {
                    cartas.background = resources.getDrawable(R.drawable.c12, null)
                }

                13 -> {
                    cartas.background = resources.getDrawable(R.drawable.c13, null)
                }
            }
            return carta
        }
}