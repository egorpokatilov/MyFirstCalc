package com.example.myfirstcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.Switch
import com.example.myfirstcalc.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivityMainBinding
    var v_txMnozh1: Int = 0
    var v_txMnozh2: Int = 0
    var v_txResult: Int = 0
    var dummy_text = "Текст"
    var b : Boolean =  false

    var rnd1: Int = 0
    var rnd2: Int = 0
    var resultF: Float = 0f
    var resultInt: Int = 0

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)



        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.txMnozh1.text = v_txMnozh1.toString()
        bindingClass.txMnozh2.text = v_txMnozh2.toString()
        bindingClass.txResult.text = v_txResult.toString()

        bindingClass.bRnd.setOnClickListener {
            Log.d( "MyApp" , "Кнопка \"Рандом\" нажата")

            rnd1 = Random.nextInt(0, 100)
            rnd2 = Random.nextInt(0, 100)

            bindingClass.txMnozh1.text = rnd1.toString()
            bindingClass.txMnozh2.text = rnd2.toString()

        }
        dummy_text = "Кнопка \"Расчет\" нажата"
        bindingClass.bCalc.setOnClickListener {
            Log.d( "MyApp" , dummy_text)


            //bindingClass.txResult.text = result.toString()
            when (b) {
                true  -> Summ( )

                false -> Dell( )
            }




        }
        bindingClass.switch1.setOnCheckedChangeListener {
                compoundButton: CompoundButton, b ->
            when (b) {
                true  -> SwitchOn( )
                false -> SwitchOff( )
            }

        }

    }

    private fun SwitchOff() {
        bindingClass.txMark.text = "x"
        Log.d( "MyApp" , "Свич выключен")
    }

    private fun SwitchOn() {
        bindingClass.txMark.text = "/"
        Log.d( "MyApp" , "Свич включен")
    }

    private fun Summ() {
        resultInt = rnd1 * rnd2
        bindingClass.txResult.text = resultInt.toString()

    }
    private fun Dell() {
        resultF = (rnd1 / rnd2).toFloat()
        bindingClass.txResult.text = resultF.toString()
    }


}