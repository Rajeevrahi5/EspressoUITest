package com.example.basiccalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var result: Int
            var num1 by remember {
                mutableStateOf("0")
            }
            var num2 by remember {
                mutableStateOf("0")
            }
            var num3 by remember {
                mutableStateOf("0")
            }
            Column {
                Spacer(modifier = Modifier.height(64.dp))
                Row {
                    Text(text = "Enter 1st number: ", fontSize = 30.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    TextField(modifier = Modifier
                        .height(60.dp)
                        .width(120.dp)
                        .testTag("first_number"),
                        value = num1,
                        onValueChange = {
                            num1 = it
                        }
                    )
                }
                Row {
                    Text(text = "Enter 2nd number: ", fontSize = 30.sp)
                    TextField(modifier = Modifier
                        .height(60.dp)
                        .width(120.dp)
                        .testTag("second_number"),
                        value = num2, onValueChange = {
                            num2 = it
                        }
                    )
                }
                Row {
                    Text(text = "Your Result: ", fontSize = 30.sp)
                    Spacer(modifier = Modifier.width(83.dp))
                    TextField(modifier = Modifier
                        .height(60.dp)
                        .width(120.dp)
                        .testTag("populated_result"),
                        value = num3, onValueChange = {
                            num3 = it
                        }
                    )
                }

                Row {
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(modifier = Modifier.testTag("add_button"),
                        onClick = {
                            result = num1.toInt() + num2.toInt()
                            num3 = result.toString()
                            Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(text = "Add")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(modifier = Modifier.testTag("sub_button"),onClick = {
                        result = num1.toInt() - num2.toInt()
                        num3 = result.toString()
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Sub")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(modifier = Modifier.testTag("mul_button"), onClick = {
                        result = num1.toInt() * num2.toInt()
                        num3 = result.toString()
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Mul")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(modifier = Modifier.testTag("div_button"), onClick = {
                        result = num1.toInt() / num2.toInt()
                        num3 = result.toString()
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Div")
                    }
                }
            }
        }
    }
}