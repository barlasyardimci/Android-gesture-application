package com.example.smarthome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.smarthome.GestureActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gestures = resources.getStringArray(R.array.Gestures)

        val spinner = findViewById<Spinner>(R.id.gesture_spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gestures)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    //val intent = Intent(this@MainActivity, GestureActivity::class.java)
                    //startActivity(intent)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
            val button = findViewById<Button>(R.id.select_button)
            button.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val intent = Intent(this@MainActivity, GestureActivity::class.java)
                    intent.putExtra("GESTURE", spinner.selectedItem.toString())
                    startActivity(intent)
                }
            })
        }
    }
}