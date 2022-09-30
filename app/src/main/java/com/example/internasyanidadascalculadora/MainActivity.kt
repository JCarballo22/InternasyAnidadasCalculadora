package com.example.internasyanidadascalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var etn_Valor1:EditText?=null
    lateinit var etn_Valor2:EditText
    lateinit var tv_Resultado:TextView
    lateinit var rb_Suma:RadioButton
    lateinit var rb_Resta:RadioButton
    lateinit var rb_Multiplicacion:RadioButton
    lateinit var rb_Division:RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //claseAnidadasyInternas()
        etn_Valor1 = findViewById(R.id.etn_Valor1)
        etn_Valor2 = findViewById(R.id.etn_Valor2)
        tv_Resultado = findViewById(R.id.tv_Resultado)
        rb_Suma = findViewById(R.id.rb_Suma)
        rb_Resta = findViewById(R.id.rb_Resta)
        rb_Multiplicacion = findViewById(R.id.rb_Multiplicacion)
        rb_Division = findViewById(R.id.rb_Division)
    }

    fun calcular(vista:View){
        val valor1_String = etn_Valor1?.text.toString()
        val valor2_String = etn_Valor2.text.toString()

        val valor1_Int = valor1_String.toInt()
        val valor2_Int = Integer.parseInt(valor2_String)

        if(rb_Suma.isChecked==true){
            val suma = valor1_Int+valor2_Int
            val resultado = suma.toString()
            tv_Resultado.setText(resultado)
        }else if(rb_Resta.isChecked==true){
            val resta = valor1_Int-valor2_Int
            val resultado = resta.toString()
            tv_Resultado.setText(resultado)
        }else if(rb_Multiplicacion.isChecked==true){
            val multi = valor1_Int*valor2_Int
            val resultado = multi.toString()
            tv_Resultado.setText(resultado)
        }else if(rb_Division.isChecked==true){
            if(valor2_Int != 0 && valor1_Int !=0 ){
            val division = valor1_Int/valor2_Int
            val resultado = division.toString()
            tv_Resultado.setText(resultado)
            }else{
                Toast.makeText(this,"No puede dividir por un valor O",Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun claseAnidadasyInternas(){
        //clase anidad (nested class)
        val miClaseAnidada = miClaseAnidadayInterna.miClaseAnidada()
        val sumarDosNum = miClaseAnidada.suma(5,6)
        println("El resultados de la suma es $sumarDosNum")

        //clase interna (Inner class)
        val miClaseInterna1 = miClaseAnidadayInterna().miClaseInterna()
        val sumarDos = miClaseInterna1.sumarDos(3)
        println("El resultado de la suma dos es $sumarDos")
    }

    fun btnSeguiente(Vista:View){
        val ventanaSiguente:Intent = Intent(applicationContext,ListViewApp::class.java)
        startActivity(ventanaSiguente)
    }



}