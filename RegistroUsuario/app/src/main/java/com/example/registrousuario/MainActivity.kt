package com.example.registrousuario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtcodigo = findViewById<EditText>(R.id.txtCodigo)
        val edtnombre = findViewById<EditText>(R.id.txtNombre)
        val edtapellido = findViewById<EditText>(R.id.txtApellido)
        val edtemail = findViewById<EditText>(R.id.txtEmail)
        val edturl = findViewById<EditText>(R.id.txtUrl)
        val btnregistrar = findViewById<Button>(R.id.btnRegistrar)

        btnregistrar.setOnClickListener{
            val cod = edtcodigo.text.toString()
            val nom = edtnombre.text.toString()
            val ape = edtapellido.text.toString()
            val em = edtemail.text.toString()
            val url = edturl.text.toString()
            //Crear el intenta para envar a la siguiente activity
            //Intent: direccionar una actividad a otra
            val intent = Intent(this,Verdatos::class.java).apply {
                putExtra("Codigo",cod)
                putExtra("Nombre",nom)
                putExtra("Apellido",ape)
                putExtra("Email",em)
                putExtra("Url",url)
            }
            //Enviatodo el intent a starActivity
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}