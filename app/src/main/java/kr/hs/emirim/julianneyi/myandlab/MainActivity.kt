package kr.hs.emirim.julianneyi.myandlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kr.hs.emirim.julianneyi.myandlab.chap04widget.BasicWidgetActivity
import kr.hs.emirim.julianneyi.myandlab.chap04widget.CalActivity
import kr.hs.emirim.julianneyi.myandlab.chap04widget.PetsActivity

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent : Intent? = null
        when(v?.id) {
            R.id.btn1 -> intent = Intent(this, FourbuttonActivity::class.java)
            R.id.btn2 -> intent = Intent(this, Fourbutton2Activity::class.java)
            R.id.btn3 -> intent = Intent(this, SettingImageActivity::class.java)
            R.id.btn4 -> intent = Intent(this, CalActivity::class.java)
            R.id.btn5 -> intent = Intent(this, BasicWidgetActivity::class.java)
            R.id.btn6 -> intent = Intent(this, PetsActivity::class.java)
            else -> return
        }

        startActivity(intent)

    }
}