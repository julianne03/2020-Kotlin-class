package kr.hs.emirim.julianneyi.myandlab.chap04widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kr.hs.emirim.julianneyi.myandlab.R

class PetsActivity : AppCompatActivity() {

    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var chkAgree : CheckBox
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton
    lateinit var btnOk : Button
    lateinit var imgPet : ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pets)

        title = "애완동물 사진 보기"

        text1 = findViewById(R.id.textView)
        text2 = findViewById(R.id.textView2)
        chkAgree = findViewById(R.id.cb_start)
        rGroup1 = findViewById(R.id.petRadioGroup)
        rdoDog = findViewById(R.id.dog_btn)
        rdoCat = findViewById(R.id.cat_btn)
        rdoRabbit = findViewById(R.id.rabbit_btn)
        btnOk = findViewById(R.id.btn_select)
        imgPet = findViewById(R.id.ImgPet)

        chkAgree.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnOk.visibility = android.view.View.VISIBLE
            } else {
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnOk.visibility = android.view.View.INVISIBLE
            }
        }

        btnOk.setOnClickListener {
            when (rGroup1.checkedRadioButtonId) {
                R.id.dog_btn -> imgPet.setImageResource(R.drawable.dog)
                R.id.cat_btn -> imgPet.setImageResource(R.drawable.cat)
                R.id.rabbit_btn -> imgPet.setImageResource(R.drawable.rabbit)
            }
        }
    }
}