package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
//    operators
    lateinit var buttonpercentage: android.widget.Button
    lateinit var buttonclear: android.widget.Button
    lateinit var buttondot: android.widget.Button
    lateinit var buttonequal: android.widget.Button
    lateinit var buttonadd: android.widget.Button
    lateinit var buttonsub: android.widget.Button
    lateinit var buttonmul: android.widget.Button
    lateinit var buttondivide: android.widget.Button
    lateinit var buttonbackspace: android.widget.Button
    lateinit var inpuText: EditText
    lateinit var resultText: EditText

    var check =0







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0=findViewById(R.id.button0)
        button00=findViewById(R.id.button00)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)

        buttonpercentage =findViewById(R.id.buttonPercentage)
        buttonclear =findViewById(R.id.buttonClear)
        buttondot =findViewById(R.id.buttondot)
        buttonequal  =findViewById(R.id.buttonEqual)
        buttonadd =findViewById(R.id.buttonAdd)
        buttonsub  =findViewById(R.id.buttonSub)
        buttonmul  =findViewById(R.id.buttonMultiply)
        buttondivide  =findViewById(R.id.buttonDivide)
        buttonbackspace  =findViewById(R.id.buttonbackspace)
        inpuText =findViewById(R.id.inputnumber)
        resultText =findViewById(R.id.resultview)

        inpuText.movementMethod=ScrollingMovementMethod()
        inpuText.isActivated = true
        inpuText.isPressed = true

        var text: String

        button1.setOnClickListener {
            text=inpuText.text.toString()+"1"
            inpuText.setText(text)
            result(text)
        }
        button2.setOnClickListener {
            text=inpuText.text.toString()+"2"
            inpuText.setText(text)
            result(text)
        }
        button3.setOnClickListener {
            text=inpuText.text.toString()+"3"
            inpuText.setText(text)
            result(text)
        }
        button4.setOnClickListener {
            text=inpuText.text.toString()+"4"
            inpuText.setText(text)
            result(text)
        }
        button5.setOnClickListener {
            text=inpuText.text.toString()+"5"
            inpuText.setText(text)
            result(text)
        }
        button6.setOnClickListener {
            text=inpuText.text.toString()+"6"
            inpuText.setText(text)
            result(text)
        }
        button7.setOnClickListener {
            text=inpuText.text.toString()+"7"
            inpuText.setText(text)
            result(text)
        }
        button8.setOnClickListener {
            text=inpuText.text.toString()+"8"
            inpuText.setText(text)
            result(text)
        }
        button9.setOnClickListener {
            text=inpuText.text.toString()+"9"
            inpuText.setText(text)
            result(text)
        }
        button0.setOnClickListener {
            text=inpuText.text.toString()+"0"
            inpuText.setText(text)
            result(text)
        }
        button00.setOnClickListener {
            text=inpuText.text.toString()+"00"
            inpuText.setText(text)
            result(text)
        }
        buttondot.setOnClickListener {
            text=inpuText.text.toString()+"."
            inpuText.setText(text)
            result(text)
        }
//          OPERATORs
        buttonadd.setOnClickListener {
            text=inpuText.text.toString()+"+"
            inpuText.setText(text)
            check += 1
        }
        buttonsub.setOnClickListener {
            text=inpuText.text.toString()+"-"
            inpuText.setText(text)
            check += 1
        }
        buttonmul.setOnClickListener {
            text=inpuText.text.toString()+"*"
            inpuText.setText(text)
            check += 1
        }
        buttondivide.setOnClickListener {
            text=inpuText.text.toString()+"/"
            inpuText.setText(text)
            check += 1
        }
        buttonpercentage.setOnClickListener {
            text=inpuText.text.toString()+"%"
            inpuText.setText(text)
            check += 1
        }

//        Equal
        buttonequal.setOnClickListener {
            text=resultText.text.toString()
            inpuText.setText(text)
            resultText.text = null
        }
//        CLEAR
        buttonclear.setOnClickListener {
            resultText.text=null
            inpuText.text=null
        }
//        Backspace
        buttonbackspace.setOnClickListener {
            var backSpace: String?=null
            if(inpuText.text.isNotEmpty()){
                val stringBuilder: StringBuilder= StringBuilder(inpuText.text)
                val finder=inpuText.text.toString()
                val lastfinder=finder.last()

                if(lastfinder == '+' || lastfinder == '-' || lastfinder == '/' || lastfinder == '*' || lastfinder == '%'){
                    check -=1
                }

                stringBuilder.deleteCharAt(inpuText.text.length-1)
                backSpace=stringBuilder.toString()
                inpuText.setText(backSpace)
                result(backSpace)
            }
        }

    }

    private fun result(text: String) {

        val engine: ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try{
            val result:Any=engine.eval(text)
            var mainr=result.toString()
            if(check ==0){
                resultText.setText(null)
            }
            else{
                resultText.setText(mainr)
            }
        }
        catch (e: ScriptException){
            Log.d("TAG","ERROR")
        }






    }
}
