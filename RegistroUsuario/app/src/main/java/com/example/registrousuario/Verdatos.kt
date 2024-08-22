package com.example.registrousuario

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Verdatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_verdatos)
        val tvcod = findViewById<TextView>(R.id.txtDoc)
        val tvnom = findViewById<TextView>(R.id.txtNom)
        val tvape = findViewById<TextView>(R.id.txtApel)
        val tvem = findViewById<TextView>(R.id.txtEm)
        val tvurl = findViewById<TextView>(R.id.txturl)
        val btnvar = findViewById<Button>(R.id.btnMostrarURL)
        val web = findViewById<WebView>(R.id.wvNav)
        //Traer los datos de la Activity Anterior
        val cod = intent.getStringExtra("Codigo")
        val nom = intent.getStringExtra("Nombre")
        val apel = intent.getStringExtra("Apellido")
        val em = intent.getStringExtra("Email")
        val url = intent.getStringExtra("Url")
        // Imprimir los Datos en el Activity
        tvcod.text = "Documento: $cod"
        tvnom.text = "Nombre: $nom"
        tvape.text = "Apellido: $apel"
        tvem.text = "Email: $em"
        tvurl.text = "URL: $url"
        // Activar el evento Click de Mostrar URL
        btnvar.setOnClickListener{
            web.webViewClient = WebViewClient()
            if(url != null){
                web.loadUrl(url)
                web.visibility = View.VISIBLE
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}