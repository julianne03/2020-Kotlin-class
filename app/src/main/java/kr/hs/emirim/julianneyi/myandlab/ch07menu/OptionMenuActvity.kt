package kr.hs.emirim.julianneyi.myandlab.ch07menu

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.*
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import kr.hs.emirim.julianneyi.myandlab.R

class OptionMenuActvity : AppCompatActivity() {

    lateinit var baseLayout : ConstraintLayout
    lateinit var btnThis : Button
    lateinit var vibrator : Vibrator

    enum class ITEM(val id:Int, title:String){
        RED(1,"배경색(빨강)"),
        GREEN(2,"배경색(초록)"),
        BLUE(3,"배경색(파랑)"),
        ROTATE(4,"45도 회전하기"),
        SIZEUP(5,"2배로 키우기")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu_actvity)
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        initFindViewById()

        registerForContextMenu(findViewById<Button>(R.id.btnBackColor))
        registerForContextMenu(findViewById<Button>(R.id.btnButton))

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var mInflater = this.menuInflater
        when(v!!.id) {
            R.id.btnBackColor -> {
                menu!!.setHeaderTitle("배경색 변경")
                mInflater.inflate(R.menu.menu_back_color, menu)
            }
            R.id.btnButton -> {
                menu!!.setHeaderTitle("버튼 변경")
                mInflater.inflate(R.menu.menu_button, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        vibrator.vibrate(1000)
        vibrator.vibrate(longArrayOf(100,300,100,300,100,10), -1)
        when(item.itemId) {
            R.id.itemRed -> {
                baseLayout.setBackgroundColor(Color.RED)
                return true
            }
            R.id.itemGreen -> {
                baseLayout.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.itemBlue -> {
                baseLayout.setBackgroundColor(Color.BLUE)
                return true
            }
            R.id.subRotate -> {
                btnThis.rotation = btnThis.rotation + 45f
                return true
            }
            R.id.subSize -> {
                btnThis.scaleX = btnThis.scaleX * 2f
                btnThis.scaleY = btnThis.scaleY * 2f
                return true
            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        var mInflater:MenuInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
//        menu!!.add(0, ITEM.RED.id,0,ITEM.RED.name)
//        menu!!.add(0, ITEM.GREEN.id,0,ITEM.GREEN.name)
//        menu!!.add(0, ITEM.BLUE.id,0,ITEM.BLUE.name)
//        var sMenu : SubMenu = menu.addSubMenu("버튼 변경 >>")
//        sMenu!!.add(0,ITEM.ROTATE.id,0,ITEM.ROTATE.name)
//        sMenu!!.add(0,ITEM.SIZEUP.id,0,ITEM.SIZEUP.name)
//        menu!!.add(0,R.id.item1,0,"한라산")
//        menu!!.add(0,R.id.item2,0,"추자도")
//        menu!!.add(0,R.id.item3,0,"범섬")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        vibrator.vibrate(longArrayOf(100,300,100,300,100,10), -1)
        when(item.itemId) {
            R.id.item1, R.id.itemRed, ITEM.RED.id -> {
                baseLayout.setBackgroundColor(Color.RED)
                if(item.isCheckable)
                    item.setChecked(true)
                return true
            }
            R.id.item2, R.id.itemGreen, ITEM.GREEN.id -> {
                baseLayout.setBackgroundColor(Color.GREEN)
                if(item.isCheckable)
                    item.setChecked(true)
                return true
            }
            R.id.item3, R.id.itemBlue, ITEM.BLUE.id -> {
                baseLayout.setBackgroundColor(Color.BLUE)
                if(item.isCheckable)
                    item.setChecked(true)
                return true
            }
            R.id.subRotate, ITEM.ROTATE.id -> {
                btnThis.rotation = btnThis.rotation + 45f
            }
            R.id.subSize, ITEM.SIZEUP.id -> {
                btnThis.scaleX = btnThis.scaleX * 2f
                return true
            }
        }
        return false

    }

    private fun initFindViewById() {
        baseLayout = findViewById(R.id.baseLayout)
        btnThis = findViewById(R.id.btnThis)
    }
}