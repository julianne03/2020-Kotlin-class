package kr.hs.emirim.julianneyi.myandlab.ch09canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import kr.hs.emirim.julianneyi.myandlab.R

class PainterActivity : AppCompatActivity() {

    companion object{
        const val LINE = 100
        const val CIRCLE = 200
        const val RECTANGLE = 300
        const val COLOR = 400
        const val COLOR_RED = 500
        const val COLOR_BLUE = 600
        lateinit var contentView : View
        var curShape = LINE
        var curColor = Color.RED
        const val TAG = "페인터액티비티"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentView = MyGraphicView(this)
        setContentView(contentView)
        title = "간단 그림판"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, LINE,0,"선 그리기")
        menu.add(0, CIRCLE,0,"원 그리기")
        menu.add(0, RECTANGLE,0,"네모 그리기")
        val sMenu : SubMenu = menu.addSubMenu("색깔 바꾸기")
        sMenu.add(0, COLOR_RED, 0, "빨간색")
        sMenu.add(0, COLOR_BLUE, 0, "파란색")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId) {
            LINE -> {
                curShape = LINE
                Toast.makeText(this,"선 그리기 모드",Toast.LENGTH_SHORT).show()
                return true
            }
            CIRCLE -> {
                curShape = CIRCLE
                Toast.makeText(this,"원 그리기 모드",Toast.LENGTH_SHORT).show()
                return true
            }
            COLOR_RED -> {
                curColor = Color.RED
                contentView.invalidate()
            }
            COLOR_BLUE -> {
                curColor = Color.BLUE
                contentView.invalidate()
            }
        }
        return false
    }

    private class MyGraphicView(context:Context) : View(context) {

        var startX = -1
        var startY = -1
        var stopX = -1
        var stopY = -1

        override fun onTouchEvent(event: MotionEvent): Boolean {
            super.onTouchEvent(event)
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x.toInt()
                    startY = event.y.toInt()
                    Log.e(TAG,"startX:"+startX+"startY:"+startY)
                }
                MotionEvent.ACTION_MOVE -> {
                    stopX = event.x.toInt()
                    stopY = event.y.toInt()
                    Log.e(TAG,"stopX:"+stopX+"stopY:"+stopY)
                    this.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    stopX = event.x.toInt()
                    stopY = event.y.toInt()
                    Log.e(TAG,"stopX:"+stopX+"stopY:"+stopY)
                    this.invalidate()
                }
            }
            return true
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val curPaint = Paint()
            curPaint.isAntiAlias = true
            curPaint.strokeWidth = 1f
            curPaint.style = Paint.Style.FILL_AND_STROKE
            curPaint.color = curColor
            canvas.drawRect(10f,10f,20f,20f,curPaint)

            when(curShape) {
                LINE -> {
                    canvas.drawText(
                        "모드" + ": 선그리기",
                    130f,10f,curPaint)
                }
                CIRCLE -> {
                    canvas.drawText(
                        "모드" + ": 원그리기",
                        130f,10f,curPaint)
                }
                RECTANGLE -> {
                    canvas.drawText(
                        "모드" + ": 네모그리기",
                        130f,10f,curPaint)
                }
            }


            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = curColor
            when(curShape) {
                LINE -> canvas.drawLine(startX.toFloat(), startY.toFloat(),
                    stopX.toFloat(), stopY.toFloat(), paint)
                CIRCLE -> {
                    var radius = Math.sqrt(
                        Math.pow((stopX - startX).toDouble(), 2.0)
                            +   Math.pow((stopY - startY).toDouble(), 2.0))

                    canvas.drawCircle(startX.toFloat(),startY.toFloat(),
                    radius.toFloat(), paint)
                }
                RECTANGLE -> {
                    canvas.drawRect(startX.toFloat(), startY.toFloat(),
                        stopX.toFloat(), stopY.toFloat(), paint)
                }
            }
        }
    }
}