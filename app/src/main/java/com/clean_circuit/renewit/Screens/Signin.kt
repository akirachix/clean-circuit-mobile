
package com.clean_circuit.renewit.Screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight

import com.clean_circuit.renewit.R
import com.clean_circuit.renewit.ui.theme.GreenOnPrimary
import com.clean_circuit.renewit.ui.theme.GreenPrimary
import com.clean_circuit.renewit.ui.theme.GreenSecondary



@Composable
fun Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = GreenPrimary,
            onPrimary = GreenOnPrimary,
            secondary = GreenSecondary,
        ),
        typography = Typography(
            displayLarge = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
            displayMedium = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            displaySmall = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
            bodyLarge = TextStyle(fontSize = 12.sp),
            bodyMedium = TextStyle(fontSize = 24.sp),
            bodySmall = TextStyle(fontSize = 20.sp)
        ),
        content = content
    )
}

@Composable
fun LoginScreen(
    onClickSignup:()->Unit,onClickForgotPassword:()->Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var checkedState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_app),
            contentDescription = "App Logo",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(top = 26.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Sign In", fontFamily = InterFontFamily, style = MaterialTheme.typography.displayMedium)

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            },
            label = { Text("Email") },
            isError = emailError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        if (emailError) {
            Text("Invalid email format", color = Color.Red, style = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = password.length < 6
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordError,
            modifier = Modifier.fillMaxWidth()
        )

        if (passwordError) {
            Text("Password must be at least 6 characters", color = Color.Red, style = MaterialTheme.typography.bodySmall, fontFamily = InterFontFamily)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it }
            )
            Text(text = "Keep me logged in", fontFamily = InterFontFamily)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { }) {
            Text(text = "Forgot password?", fontFamily = InterFontFamily,
                modifier = Modifier.clickable { onClickForgotPassword() }
                )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (!emailError && !passwordError) {

                } else {

                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
            modifier = Modifier
                .width(135.dp)
                .height(58.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Sign In", color = GreenOnPrimary, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = {  },
            colors = ButtonDefaults.textButtonColors(contentColor = GreenPrimary)
        ) {
            Text(text = "Don't have an account? Sign Up", fontFamily = InterFontFamily,
                modifier = Modifier.clickable { onClickSignup() }
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    Theme {
        LoginScreen({},{})
    }
}
