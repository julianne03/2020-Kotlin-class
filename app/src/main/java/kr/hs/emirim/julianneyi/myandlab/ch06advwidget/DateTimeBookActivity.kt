package kr.hs.emirim.julianneyi.myandlab.ch06advwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kr.hs.emirim.julianneyi.myandlab.R

class DateTimeBookActivity : AppCompatActivity() {

    lateinit var chrono : Chronometer
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calView : CalendarView
    lateinit var tPicker : TimePicker
    lateinit var tvDatetime : TextView

    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_book)

        btnStart = findViewById(R.id.btn_start)
        btnEnd = findViewById(R.id.btnEnd)
        chrono = findViewById(R.id.chronometer1)
        rdoCal = findViewById(R.id.rdoCal)
        rdoTime = findViewById(R.id.rdoTime)
        calView = findViewById(R.id.calendarView1)
        tPicker = findViewById(R.id.timePicker1)
        tvDatetime = findViewById(R.id.tv_date_time)
    }
}