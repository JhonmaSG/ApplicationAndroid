package com.example.conversionnumeros

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.zip.ZipFile

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val num1: EditText = findViewById(R.id.edtnum)
        val select: RadioGroup = findViewById(R.id.roper)
        val btncalular: Button = findViewById(R.id.btncal)
        val result: TextView = findViewById(R.id.txtresult)
        btncalular.setOnClickListener{
            val n1 = num1.text.toString().toDoubleOrNull()
            val selectOperationId = select.checkedRadioButtonId
            if ( n1 == null){
                Toast.makeText(this,"Digite el Número",Toast.LENGTH_SHORT).show()
            }else{
                val res = when (selectOperationId) {
                    R.id.rbin -> {
                        val bin = binario(n1.toInt())
                        "Binario: $bin"
                    }
                    R.id.roct -> {
                        val oct = octal(n1.toInt())
                        "Octal: $oct"
                    }
                    R.id.rhex -> {
                        val hex = hexadecimal(n1.toInt())
                        "Hexadecimal: $hex"
                    }
                    else -> null
                }
                result.text = if(res != null) "\n$res" else "Resultado: Error"
            }
        }
    }
    private fun binario(num: Int): String {
        var entero = num
        var result = ""
        do {
            var residuo = entero % 2
            result += residuo.toString()
            entero /= 2
        }while(entero != 0)
        return result.reversed()
    }

    private fun octal(num: Int): String {
        var entero = num
        var result = ""
        do {
            var residuo = entero % 8
            result += residuo.toString()
            entero /= 8
        }while(entero != 0)
        return result.reversed()
    }
 
    private fun hexadecimal(num: Int): String {
        var entero = num
        var result = ""
        do {
            var residuo = entero % 16
            val valorHexa = when (residuo){
                in 0..9 -> residuo.toString()
                10 -> "A"
                11 -> "B"
                12 -> "C"
                13 -> "D"
                14 -> "E"
                15 -> "F"
                else -> throw IllegalArgumentException("Valor de residuo fuera de rango")
            }
            result += valorHexa
            entero /= 16
        }while(entero != 0)
        return result.reversed()
    }
}