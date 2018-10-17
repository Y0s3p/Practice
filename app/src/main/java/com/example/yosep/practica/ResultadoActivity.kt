package com.example.yosep.practica

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var bundle = intent.extras
        var resultadoTotal = bundle.getInt ("Result")
        resultado.text = resultadoTotal.toString()

    }

    fun back(v : View){

        var intent = Intent(this, MainActivity::class.java)
        // Pasar datos a la otra actividad
        startActivity(intent)

    }

}

