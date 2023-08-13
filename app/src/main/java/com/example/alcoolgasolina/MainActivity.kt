package com.example.alcoolgasolina

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.alcoolgasolina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener{
            val alcool =  binding.editPrecoAlcool.text.toString()
            val  gasolina = binding.editPrecoGasosa.text.toString()
           val validar = validarCampos(alcool, gasolina)
            if(validar){
                calcular(alcool,gasolina)
            }else{
                Toast.makeText(this@MainActivity, "Preenca os campos", Toast.LENGTH_LONG).show()
            }
        }



    }

    @SuppressLint("SetTextI18n")
    fun calcular(alcool: String, gasolina: String){
        val precoAlcool = alcool.toDouble()
        val precogasolina = gasolina.toDouble()
        val resulatdo = precoAlcool/precogasolina
        if(resulatdo >= 0.7 ){
            binding.res.text = "melhor utilizar gasosa"
        }else{
            binding.res.text = "melhor utilizar alcool"
        }
    }

    fun validarCampos(alcool: String?, gasolina: String?): Boolean {
        var validar: Boolean = true
        if (alcool.isNullOrEmpty() || gasolina.isNullOrEmpty()) {
            validar = false
        }
        return validar
    }

}