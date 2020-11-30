package kr.hs.emirim.julianneyi.myandlab.ch07menu

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import kr.hs.emirim.julianneyi.myandlab.R

class SnackbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        findViewById<ConstraintLayout>(R.id.clickme).setOnClickListener {
            Snackbar.make(it, "과자 하나 드실?", Snackbar.LENGTH_SHORT)
                .setAction("여기 클릭", View.OnClickListener {
                    Toast.makeText(this,"나를 클릭하다니",Toast.LENGTH_SHORT).show()
                })
                .show()
        }

        findViewById<Button>(R.id.showmethedialog).setOnClickListener {
            val dlg = AlertDialog.Builder(this)
            dlg.setTitle("Show me the money!")
            dlg.setMessage("용돈 좀 주세요오오오")
            dlg.setIcon(R.drawable.dog)
            dlg.setPositiveButton("긍정긍정OK",DialogInterface.OnClickListener{
                dialog, which -> Snackbar.make(it, "긍정마인드!", Snackbar.LENGTH_SHORT)
                .show()
            })
            dlg.show()
        }

        findViewById<Button>(R.id.showmelistdialog).setOnClickListener {
            val versionArray = arrayOf("짜장면","짬뽕","탕수육","군만두")
            val checkArray = booleanArrayOf(true,false,false,false)
            val dlg = AlertDialog.Builder(this@SnackbarActivity)
            dlg.setTitle("종아하는 중국집 메뉴는?")
                .setIcon(R.mipmap.ic_launcher_round)
//                .setItems(versionArray) {
//                    dialog, which -> (it as Button).text = versionArray[which]
//                }
                .setSingleChoiceItems(versionArray, 0) {
                    dialog, which ->
                    (it as Button).text = versionArray[which]
                }
                .setPositiveButton("닫기",null)
                .show()
        }
    }
}