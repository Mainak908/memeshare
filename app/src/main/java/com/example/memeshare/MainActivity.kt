package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadmeme()
    }
    private fun loadmeme(){
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                val url=response.getString("url")
                Glide.with(this).load(url).into(imageView)
            },
            { error ->

            }
        )

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }
    fun sharememe(view: View) {}
    fun nextmeme(view: View) {
        loadmeme()
    }
}