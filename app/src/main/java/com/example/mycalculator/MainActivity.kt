package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.mycalculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnZero.setOnClickListener {
            updateInputText("0")
        }

        binding.btnOne.setOnClickListener {
            updateInputText("1")
        }

        binding.btnTwo.setOnClickListener {
            updateInputText("2")
        }

        binding.btnThree.setOnClickListener {
            updateInputText("3")
        }

        binding.btnFour.setOnClickListener {
            updateInputText("4")
        }

        binding.btnFive.setOnClickListener {
            updateInputText("5")
        }

        binding.btnSix.setOnClickListener {
            updateInputText("6")
        }

        binding.btnSeven.setOnClickListener {
            updateInputText("7")
        }

        binding.btnEight.setOnClickListener {
            updateInputText("8")
        }

        binding.btnNine.setOnClickListener {
            updateInputText("9")
        }

        binding.btnAdd.setOnClickListener {
            updateInputText("+")
        }

        binding.btnSubtract.setOnClickListener {
            updateInputText("-")
        }

        binding.btnMultiply.setOnClickListener {
            updateInputText("*")
        }

        binding.btnDivision.setOnClickListener {
            updateInputText("÷")
        }

        binding.btnDot.setOnClickListener {
            updateInputText(".")
        }

        binding.btnStartBracket.setOnClickListener {
            updateInputText("(")
        }

        binding.btnEndBracket.setOnClickListener {
            updateInputText(")")
        }

        binding.btnClear.setOnClickListener {
            binding.txtInput.text = ""
            binding.txtResult.text = ""
        }

        binding.btnEqual.setOnClickListener {
            displayOutput()
        }
    }

    private fun updateInputText(s: String) {
        binding.txtInput.text = "${binding.txtInput.text}$s"
    }

    private fun displayOutput() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()

            if(result.isNaN()) {
                binding.txtResult.text = "Error"
                binding.txtResult.setTextColor(ContextCompat.getColor(this, R.color.purple_200))
            } else {
                binding.txtResult.text = DecimalFormat("0.#####").format(result).toString()
            }
        } catch (e : Exception) {
            binding.txtResult.text = "Error"
            binding.txtResult.setTextColor(ContextCompat.getColor(this, R.color.purple_200))
            Log.i("ExceptionOccured", e.toString())
        }
    }

    private fun getInputExpression(): String {
        val expression = binding.txtInput.text.replace(Regex("x"), "*")
            .replace(Regex("÷"), "/")

        return expression
    }
}