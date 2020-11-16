package kr.hs.emirim.julianneyi.myandlab.ch06advwidget

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
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

        tPicker.visibility = View.GONE
        calView.visibility = View.GONE

        rdoTime.setOnClickListener {
            calView.visibility = View.GONE
            tPicker.visibility = View.VISIBLE
        }

        rdoCal.setOnClickListener {
            tPicker.visibility = View.GONE
            calView.visibility = View.VISIBLE
        }

        btnStart.setOnClickListener {

            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
        }

        btnEnd.setOnClickListener {
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            tvDatetime.text = ""+ selectYear +"년" + selectMonth+"월"+selectDay+"일"+tPicker.currentHour+"시" +tPicker.currentMinute +"분 예약됨"
        }

        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month+1
            selectDay = dayOfMonth
            Log.d("test","오늘은 : "+ selectYear + "/" + selectMonth + "/" + selectDay)
        }
    }
}