package kr.hs.emirim.julianneyi.myandlab.chap04widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kr.hs.emirim.julianneyi.myandlab.R
import java.lang.Exception
import java.lang.NumberFormatException

class CalActivity : AppCompatActivity(){

    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var textResult : TextView
    var result : Int? = null

    var TAG = "코틀린 방과후"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)

        title = "초간단 계산기"
        edit1 = findViewById(R.id.edNum1)
        edit2 = findViewById(R.id.edNum2)
        textResult = findViewById(R.id.tvResult)

        edit1.setText(0)
        edit2.setText(0)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            try {
                textResult.text = (Integer.parseInt(edit1.text.toString())
                        + Integer.parseInt(edit2.text.toString())).toString()
            }catch (e: NullPointerException) {
                Toast.makeText(this,"입력하지 않은 사항이 있습니다.",Toast.LENGTH_LONG).show()
            }
            catch (e:NumberFormatException) {
                Toast.makeText(this,"숫자를 입력하세요",Toast.LENGTH_LONG).show()
            }
            catch(e:Exception) {
                Toast.makeText(this,"뭔지 알 수 없는 에러",Toast.LENGTH_LONG).show()
                Log.e(TAG, "에러 : " + e.message)
            }

        }

    }
}