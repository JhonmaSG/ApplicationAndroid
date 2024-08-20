package com.example.operadores

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //R : clase principal : busca el id del componente
        val num1: EditText = findViewById(R.id.edtnum1);
        val num2: EditText = findViewById(R.id.edtnum2);
        val select: RadioGroup = findViewById(R.id.roper);
        val btncal: Button = findViewById(R.id.btncalcular);
        val result: TextView = findViewById(R.id.txtresult);
        btncal.setOnClickListener{
            val n1 = num1.text.toString().toDoubleOrNull()
            val n2 = num2.text.toString().toDoubleOrNull()
            val selectOperationId = select.checkedRadioButtonId
            if( n1 == null || n2 == null){
                Toast.makeText(this,"Digite los dos Numeros",Toast.LENGTH_SHORT).show();
                //return@setOnClickListener
            }else {
                val res = when (selectOperationId) {
                    R.id.rsuma -> n1 + n2
                    R.id.rresta -> n1 - n2
                    R.id.rmult -> n1 * n2
                    R.id.rdiv -> {
                        if (n2 != 0.0) n1 / n2
                        else {
                            Toast.makeText(
                                this,
                                "ERROR!! No se puede dividir por cero",
                                Toast.LENGTH_SHORT
                            ).show()
                            null
                        }
                    }
                    R.id.rfact -> {
                        val fact1 = factorial(n1.toInt())
                        val fact2 = factorial(n2.toInt())
                        "Factorial de $n1: $fact1\nFactorial de $n2: $fact2"
                    }
                    else -> null
                }
                result.text = if(res != null) "\n$res" else "Resultado: Error"
            }
        }
    }

    private fun factorial(n: Int): Long {
        return if (n >= 1) n * factorial(n - 1) else 1
    }
}