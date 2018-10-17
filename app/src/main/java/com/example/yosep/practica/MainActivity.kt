package com.example.yosep.practica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent



class MainActivity : AppCompatActivity() {

    var listaDatos : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var seekBar = findViewById<SeekBar>(R.id.seekbar1)
        var seekBar2 = findViewById<SeekBar>(R.id.seekbar2)
        var seekBar3 = findViewById<SeekBar>(R.id.seekbar3)
        var seekbarValue = findViewById<TextView>(R.id.valor1)
        var seekbarValue2 = findViewById<TextView>(R.id.valor2)
        var seekbarValue3 = findViewById<TextView>(R.id.valor4TV)
        var spinnerAdapter=ArrayAdapter.createFromResource(this,R.array.operador,android.R.layout.simple_spinner_item)
        operador.adapter=spinnerAdapter

        operador.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                seekbarValue.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })
        seekBar2?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                seekbarValue2.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })
        seekBar3?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                seekbarValue3.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })
    }

    fun operacion(v : View){

        var intent = Intent(this, ResultadoActivity::class.java)

        var total = 0
        var operar = operador.getSelectedItem().toString();

        when(operar){

            "Sumar" -> {

                total = seekbar1.progress + seekbar2.progress

            }
            "Restar" -> {

                total = seekbar1.progress - seekbar2.progress

            }
            "Multiplicar" -> {

                total = seekbar1.progress * seekbar2.progress

            }
            "Dividir" -> {

                total = seekbar1.progress / seekbar2.progress

            }

        }


        // Pasar datos a la otra actividad
        intent.putExtra("Result", total)
        startActivity(intent)

    }

    fun displayMessage(v : View){

        var intent = Intent(this, MessageActivity::class.java)

        for (i in 1..seekbar3.progress){

            listaDatos.add(editText.text.toString() + i)

        }

        // Pasar datos a la otra actividad
        intent.putExtra("array", listaDatos)
        startActivity(intent)

    }

}
