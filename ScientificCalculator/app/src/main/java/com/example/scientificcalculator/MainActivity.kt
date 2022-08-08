package com.example.scientificcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.scientificcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            // adding on click listener to our all buttons.
            b1.setOnClickListener {
                // on below line we are appending
                // the expression to our text view.
                idTVprimary.text = (idTVprimary.text.toString() + "1")

            }
            b2.setOnClickListener {
                // on below line we are appending
                // the expression to our text view.
                idTVprimary.text = (idTVprimary.text.toString() + "2")
            }
            b3.setOnClickListener {
                // on below line we are appending
                // the expression to our text view.
                idTVprimary.text = (idTVprimary.text.toString() + "3")
            }
            b4.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "4")
            }
            b5.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "5")
            }
            b6.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "6")
            }
            b7.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "7")
            }
            b8.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "8")
            }
            b9.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "9")
            }
            b0.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "0")
            }
            bdot.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + ".")
            }
            bplus.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "+")
            }
            bdiv.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "/")
            }
            bbrac1.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "(")
            }
            bbrac2.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + ")")
            }
            bpi.setOnClickListener {
                // on clicking on pi button we are adding
                // pi value as 3.142 to our current value.
                idTVprimary.text = (idTVprimary.text.toString() + "3.142")
                idTVSecondary.text = (bpi.text.toString())
            }
            bsin.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "sin")
            }
            bcos.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "cos")
            }
            btan.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "tan")
            }
            binv.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "^" + "(-1)")
            }
            bln.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "ln")
            }
            blog.setOnClickListener {
                idTVprimary.text = (idTVprimary.text.toString() + "log")
            }

            bminus.setOnClickListener {
                // on clicking on minus we are checking if
                // the user has already a minus operation on screen.
                // if minus operation is already present
                // then we will not do anything.
                val str: String = idTVprimary.text.toString()
                if (!str.get(index = str.length - 1).equals("-")) {
                    idTVprimary.text = (idTVprimary.text.toString() + "-")
                }
            }
            bmul.setOnClickListener {
                // if mul sign is not present in our
                // text view then only we are adding
                // the multiplication operator to it.
                val str: String = idTVprimary.text.toString()
                if (!str.get(index = str.length - 1).equals("*")) {
                    idTVprimary.text = (idTVprimary.text.toString() + "*")
                }
            }
            bsqrt.setOnClickListener {
                if (idTVprimary.text.toString().isEmpty()) {
                    // if the entered number is empty we are displaying an error message.
                    Toast.makeText(this@MainActivity, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
                } else {
                    val str: String = idTVprimary.text.toString()
                    // on below line we are calculation
                    // square root of the given number.
                    val r = Math.sqrt(str.toDouble())
                    // on below line we are converting our double
                    // to string and then setting it to text view.
                    val result = r.toString()
                    idTVprimary.setText(result)
                }
            }
            bequal.setOnClickListener {
                val str: String = idTVprimary.text.toString()
                // on below line we are calling an evaluate
                // method to calculate the value of expressions.
                val result: Double = evaluate(str)
                // on below line we are getting result
                // and setting it to text view.
                val r = result.toString()
                idTVprimary.setText(r)
                idTVSecondary.text = str
            }
            bac.setOnClickListener {
                // on clicking on ac button we are clearing
                // our primary and secondary text view.
                idTVprimary.setText("")
                idTVSecondary.setText("")
            }
            bc.setOnClickListener {
                // on clicking on c button we are clearing
                // the last character by checking the length.
                var str: String = idTVprimary.text.toString()
                if (!str.equals("")) {
                    str = str.substring(0, str.length - 1)
                    idTVprimary.text = str
                }
            }
            bsquare.setOnClickListener {
                if (idTVprimary.text.toString().isEmpty()) {
                    // if the entered number is empty we are displaying an error message.
                    Toast.makeText(this@MainActivity, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
                } else {
                    // on below line we are getting the expression and then calculating the square of the number
                    val d: Double = idTVprimary.getText().toString().toDouble()
                    // on below line we are calculating the square.
                    val square = d * d
                    // after calculating the square we
                    // are setting it to text view.
                    idTVprimary.setText(square.toString())
                    // on below line we are setting
                    // the d to secondary text view.
                    idTVSecondary.text = "$d²"
                }
            }
            bfact.setOnClickListener {
                if (idTVprimary.text.toString().isEmpty()) {
                    // if the entered number is empty we are displaying an error message.
                    Toast.makeText(this@MainActivity, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
                } else {
                    // on below line we are getting int value
                    // and calculating the factorial value of the entered number.
                    val value: Int = idTVprimary.text.toString().toInt()
                    val fact: Int = factorial(value)
                    idTVprimary.setText(fact.toString())
                    idTVSecondary.text = "$value`!"
                }

            }
        }
    }


    fun factorial(n: Int): Int {
        // this method is use to find factorial
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }

    fun evaluate(str: String): Double {
        return object : Any() {
            // on below line we ar creating variable
            // for tracking the position and char pos.
            var pos = -1
            var ch = 0

            // below method is for moving to next character.
            fun nextChar() {
                // on below line we are incrementing our position
                // and moving it to next position.
                ch = if (++pos < str.length) str[pos].toInt() else -1
            }

            // this method is use to check the extra space
            // present int the expression and removing it.
            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()
                // on below line we are checking the char pos
                // if both is equal then we are returning it to true.
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            // below method is to parse our
            // expression and to get the ans
            // in this we are calling a parse
            // expression method to calculate the value.
            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            // in this method we will only perform addition and
            // subtraction operation on the expression.
            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.toInt())) x += parseTerm() // addition
                    else if (eat('-'.toInt())) x -= parseTerm() // subtraction
                    else return x
                }
            }

            // in below method we will perform
            // only multiplication and division operation.
            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.toInt())) x *= parseFactor() // multiplication
                    else if (eat('/'.toInt())) x /= parseFactor() // division
                    else return x
                }
            }

            // below method is use to parse the factor
            fun parseFactor(): Double {
                //on below line we are checking for addition
                // and subtraction and performing unary operations.
                if (eat('+'.toInt())) return parseFactor() // unary plus
                if (eat('-'.toInt())) return -parseFactor() // unary minus
                // creating a double variable for ans.
                var x: Double
                // on below line we are creating
                // a variable for position.
                val startPos = pos
                // on below line we are checking
                // for opening and closing parenthesis.
                if (eat('('.toInt())) { // parentheses
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) {
                    // numbers
                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()
                    // on below line we are getting sub string from our string using start and pos.
                    x = str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) {
                    // on below function we are checking for the operator in our expression.
                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func = str.substring(startPos, pos)
                    // calling a method to parse our factor.
                    x = parseFactor()
                    // on below line we are checking for square root.
                    x =
                        if (func == "sqrt") Math.sqrt(x)
                        // on below line we are checking for sin function
                        // and calculating sin function using Math class.
                        else if (func == "sin") Math.sin(
                            Math.toRadians(x)
                            // on below line we are calculating the cos value
                        ) else if (func == "cos") Math.cos(
                            Math.toRadians(x)
                            // on below line we are calculating
                            // the tan value of our expression.
                        ) else if (func == "tan")
                            Math.tan(Math.toRadians(x))
                        // on below line we are calculating
                        // log value of the expression.
                        else if (func == "log")
                            Math.log10(x)
                        // on below line we are calculating
                        // ln value of expression.
                        else if (func == "ln") Math.log(x)
                        // f we get any error then
                        // we simply return the exception.
                        else throw RuntimeException(
                            "Unknown function: $func"
                        )
                } else {
                    // if the condition not satisfy then we are returning the exception
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                // on below line we are calculating the power of the expression.
                if (eat('^'.toInt())) x = Math.pow(x, parseFactor()) // exponentiation
                return x
            }
            // at last calling a parse for our expression.
        }.parse()
    }

}