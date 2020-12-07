package kr.hs.emirim.julianneyi.myandlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kr.hs.emirim.julianneyi.myandlab.ch05layout.NoXmlActivity
import kr.hs.emirim.julianneyi.myandlab.ch06advwidget.*
import kr.hs.emirim.julianneyi.myandlab.ch07menu.MyWidgetActivity
import kr.hs.emirim.julianneyi.myandlab.ch07menu.OptionMenuActvity
import kr.hs.emirim.julianneyi.myandlab.ch07menu.SnackbarActivity
import kr.hs.emirim.julianneyi.myandlab.ch09canvas.CanvasActivity
import kr.hs.emirim.julianneyi.myandlab.chap04widget.BasicWidgetActivity
import kr.hs.emirim.julianneyi.myandlab.chap04widget.CalActivity
import kr.hs.emirim.julianneyi.myandlab.chap04widget.PetsActivity
import kr.hs.emirim.julianneyi.myandlab.chap04widget.RotateImageActivity

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
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)
        findViewById<Button>(R.id.btn10).setOnClickListener(this)
        findViewById<Button>(R.id.btn11).setOnClickListener(this)
        findViewById<Button>(R.id.btn12).setOnClickListener(this)
        findViewById<Button>(R.id.btn13).setOnClickListener(this)
        findViewById<Button>(R.id.btn14).setOnClickListener(this)
        findViewById<Button>(R.id.btn15).setOnClickListener(this)
        findViewById<Button>(R.id.btn16).setOnClickListener(this)
        findViewById<Button>(R.id.btn17).setOnClickListener(this)
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
            R.id.btn7 -> intent = Intent(this, RotateImageActivity::class.java)
            R.id.btn8 -> intent = Intent(this, NoXmlActivity::class.java)
            R.id.btn9 -> intent = Intent(this, DateTimeBookActivity::class.java)
            R.id.btn10 -> intent = Intent(this,ViewFilpperActivity::class.java)
            R.id.btn11 -> intent = Intent(this,TabWidgetActivity::class.java)
            R.id.btn12 -> intent = Intent(this,TabFragmentActivity::class.java)
            R.id.btn13 -> intent = Intent(this,WebViewActivity::class.java)
            R.id.btn14 -> intent = Intent(this,OptionMenuActvity::class.java)
            R.id.btn15 -> intent = Intent(this,SnackbarActivity::class.java)
            R.id.btn16 -> intent = Intent(this,MyWidgetActivity::class.java)
            R.id.btn17 -> intent = Intent(this,CanvasActivity::class.java)
            else -> return
        }

        startActivity(intent)

    }
}