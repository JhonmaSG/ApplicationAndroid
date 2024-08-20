package com.example.calcular_tipo_triangulo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val lado1: EditText = findViewById(R.id.edtnum1);
        val lado2: EditText = findViewById(R.id.edtnum2);
        val lado3: EditText = findViewById(R.id.edtnum3);
        val result: TextView = findViewById(R.id.txtresul);
        val btnCal: Button = findViewById(R.id.btncal);
        btnCal.setOnClickListener{
            val l1 = lado1.text.toString().toDoubleOrNull();
            val l2 = lado2.text.toString().toDoubleOrNull();
            val l3 = lado3.text.toString().toDoubleOrNull();
            var res = ""
            if ( l1 == null || l2 == null || l3 == null){
                Toast.makeText(this,
                    "Complete todos los lados del triangulo",
                    Toast.LENGTH_LONG)
                    .show()
            }else if( l1 == 0.0 || l2 == 0.0 || l3 == 0.0){
                Toast.makeText(this,
                    "Los lados del triangulo no deben ser 0",
                    Toast.LENGTH_LONG)
                    .show()
            }else {
                if ( l1 == l2 && l1 == l3){
                    res = "Equilátero"
                }else if ( l1 == l2 || l1 == l3 || l2 == l3 ){
                    res = "Isósceles"
                }else {
                    res = "Escaleno"
                }
            }
            result.text = if(res != "") "El triangulo es $res" else "¡ERROR!"
        }
    }
}