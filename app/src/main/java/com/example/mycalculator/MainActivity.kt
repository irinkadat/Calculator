package com.example.mycalculator

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mycalculator.R


class MainActivity : AppCompatActivity() {


    private lateinit var resultTextView: TextView
    private var operand: Double=0.0
    private var operation: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()



        setContentView(R.layout.activity_main)

        resultTextView=findViewById(R.id.resultTextView)

    }

    fun numberClick(clickedView: View) {
        if(clickedView is TextView) {
            var result:String=resultTextView.text.toString()
            val number:String=clickedView.text.toString()

            if (result=="0") {
                result = ""
            }
            resultTextView.text=result + number

        }

    }

    fun operationClick(clickedView: View) {
        if(clickedView is TextView) {

            val result:String=resultTextView.text.toString()
            if(result.isNotEmpty())  {
                this.operand=result.toDouble()

            }
            resultTextView.text=""

            this.operation=clickedView.text.toString()
        }

    }

    fun equalsClick(clickedView: View) {
        val result: String = resultTextView.text.toString()
        var secoperand: Double = 0.0

        if (result.isNotEmpty()) {
            secoperand = result.toDouble()
        }

        when (operation) {
            "+" -> {
                if ((operand + secoperand) % 1 == 0.0) {
                    resultTextView.text = (operand + secoperand).toInt().toString()
                } else {
                    resultTextView.text = (operand + secoperand).toString()
                }
            }

            "/" -> {
                if ((operand / secoperand) % 1 == 0.0) {
                    resultTextView.text = (operand / secoperand).toInt().toString()
                } else {
                    resultTextView.text = (operand / secoperand).toString()
                }
            }
            "*" -> {
                if ((operand * secoperand) % 1 == 0.0) {
                    resultTextView.text = (operand * secoperand).toInt().toString()
                } else {
                    resultTextView.text = (operand * secoperand).toString()
                }
            }
            "-" -> {
                if ((operand - secoperand) % 1 == 0.0) {
                    resultTextView.text = (operand - secoperand).toInt().toString()
                } else {
                    resultTextView.text = (operand - secoperand).toString()
                }
            }
            "%" -> {
                if ((operand / 100 *secoperand) % 1 == 0.0) {
                    resultTextView.text = (operand % secoperand).toInt().toString()
                } else {
                    resultTextView.text = (operand /100 * secoperand).toString()
                }
            }

            "^" -> {
                if ((Math.pow(operand, secoperand)) % 1 == 0.0) {
                    resultTextView.text = (Math.pow(operand, secoperand)).toInt().toString()
                } else {
                    resultTextView.text = (Math.pow(operand, secoperand)).toString()
                }

            }

            "AC" -> { resultTextView.text= ""  }
        }
    }
    fun onClick(v:View?) {
        var tv= v as TextView
        var oldText=resultTextView.text.toString()
        var resultTV= findViewById<TextView>(R.id.resultTextView)

        when(tv.text.toString()) {
            "DEL"-> {
                if (oldText.length>0) {
                    var newText=oldText.substring(0,oldText.length - 1)
                    resultTV.setText(newText)
                }
            }
        }
    }

}