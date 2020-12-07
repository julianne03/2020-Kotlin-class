package kr.hs.emirim.julianneyi.myandlab.ch08io

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kr.hs.emirim.julianneyi.myandlab.R
import java.nio.charset.Charset

class ReadWriteActivity : AppCompatActivity() {

    val FILENAME = "file.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_write)

        findViewById<Button>(R.id.btnWrite).setOnClickListener {
            var outFs = openFileOutput(FILENAME, Context.MODE_PRIVATE)
            var str = "Hello 쿡북 안드로이드"
                outFs.write(str.toByteArray())
        }

        findViewById<Button>(R.id.btnRead).setOnClickListener {
            var inFs = openFileInput(FILENAME)
            var txt = ByteArray(30)
            inFs.read(txt)
            var str = txt.toString(Charsets.UTF_8)
            Toast.makeText(applicationContext,
                str, Toast.LENGTH_SHORT).show()
        }
    }
}