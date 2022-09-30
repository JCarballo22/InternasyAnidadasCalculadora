package com.example.internasyanidadascalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ListViewApp : AppCompatActivity() {
    private var lvLenguajes:ListView?=null
    private var tvSeleccion:TextView?=null

    private val lenguaje= arrayOf("Kotlin","Java","C++","PHP","C#","VB.Net")
    private val posiciones= arrayOf("1","5","3","2","6","4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_app)

        lvLenguajes=findViewById(R.id.lv_Lenguajes)
        tvSeleccion=findViewById(R.id.tv_Seleccion)

        var adaptador:ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.list_items_claseprogramacion,lenguaje)
        lvLenguajes?.adapter=adaptador

        lvLenguajes?.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tvSeleccion?.text="La posicion del lenguaje ${lvLenguajes?.getItemAtPosition(position)} es ${posiciones[position]}"
            }

        }

        /*
        lvLenguajes?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tvSeleccion?.text="La posicion del lenguaje ${lvLenguajes?.getItemAtPosition(position)} es ${posiciones[position]}"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }*/

    }
}