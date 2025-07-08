package com.clean_circuit.renewit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

val InterFontFamily = FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_bold, FontWeight.Bold)
)

@Composable
fun ForgotPasswordScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_recycle_logo), // Your logo resource
                contentDescription = "Logo",
                modifier = Modifier
                    .height(100.dp)
                    .width(160.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color(0xFF00B300),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(Color(0xFFF0FFF0), shape = RoundedCornerShape(12.dp))
                    .padding(20.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "FORGOT PASSWORD",
                        fontFamily = InterFontFamily,
                        color = Color(0xFF00B300),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                    Text(
                        text = "Provide the email address you would like\nyour password reset information to be sent to.",
                        fontSize = 15.sp,
                        fontFamily = InterFontFamily,
                        color = Color(0xFF222222),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = "Enter email address",
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(bottom = 8.dp)
                    )
                    var email by remember { mutableStateOf(TextFieldValue("")) }
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = {
                            Text(
                                text = "example@gmail.com",
                                fontFamily = InterFontFamily,
                                color = Color(0xFF8D8D8D),
                                fontSize = 16.sp
                            )
                        },
                        textStyle = TextStyle(fontSize = 16.sp),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 18.dp)
                            .background(
                                Color.White,
                                shape = RoundedCornerShape(7.dp)
                            ),
                        shape = RoundedCornerShape(7.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Button(
                        onClick = { /* Reset logic */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(bottom = 12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00B300)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Reset Password",
                            fontFamily = InterFontFamily,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                color = Color(0xFF174A17)
                            )
                        )
                    }
                    TextButton(
                        onClick = { /* Navigate back to login */ }
                    ) {
                        Text(
                            text = "Back to Login",
                            fontFamily = InterFontFamily,
                            color = Color(0xFF00B300),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}