package kr.hs.emirim.julianneyi.myandlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var mProfile : ImageView
    lateinit var mButton1: Button
    lateinit var mButton2: Button
    lateinit var mButton3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mProfile = findViewById(R.id.profile)
        mButton1 = findViewById(R.id.btn1)
        mButton2 = findViewById(R.id.btn2)
        mButton3 = findViewById(R.id.p112number7)

        mButton1.setOnClickListener {
            val intent = Intent(this, FourbuttonActivity::class.java)
            startActivity(intent)
        }

        mButton2.setOnClickListener {
            val intent = Intent(this, Fourbutton2Activity::class.java)
            startActivity(intent)
        }

        mButton3.setOnClickListener {
            val intent = Intent(this, SettingImageActivity::class.java)
            startActivity(intent)
        }
    }
}