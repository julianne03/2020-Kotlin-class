package kr.hs.emirim.julianneyi.myandlab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SettingImageActivity : AppCompatActivity() {

    lateinit var userText : EditText
    lateinit var showTextBtn : Button
    lateinit var showUri : Button
    lateinit var oreo : RadioButton
    lateinit var pie : RadioButton
    lateinit var userImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_image)

        userText = findViewById(R.id.userText)
        showTextBtn = findViewById(R.id.ShowTextBtn)
        showUri = findViewById(R.id.ShowHpBtn)
        oreo = findViewById(R.id.Oreo)
        pie = findViewById(R.id.Pie)
        userImage = findViewById(R.id.userImage)

        showTextBtn.setOnClickListener {
            Toast.makeText(applicationContext, userText.text, Toast.LENGTH_SHORT).show()
        }

        showUri.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse(userText.text.toString()))
            startActivity(intent)
        }

        oreo.setOnClickListener {
            userImage.setImageResource(R.drawable.oreo)
        }

        pie.setOnClickListener {
            userImage.setImageResource(R.drawable.pie)
        }

    }
}