package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.addpeso)
        val tvResultado: TextView = findViewById(R.id.txtMsg)
        val edtAltura: EditText = findViewById(R.id.addAltura)

        btnCalcular.setOnClickListener{
            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()
                val resultado: Float = peso / (altura * altura)


                tvResultado.text = resultado.toString()

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", resultado)
                    }
                startActivity(intent)

            } else{
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }

        }



    }
}