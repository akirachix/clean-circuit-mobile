package com.clean_circuit.renewit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.clean_circuit.renewit.R

@Composable
fun SignUpScreen() {
    val primaryColor = Color(0xFF00DB00)
    val borderColor = Color(0xFF00DB00)
    val buttonColor = Color(0xFF00DB00)


    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val isAgreedToTerms = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your logo resource
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Sign Up", style = MaterialTheme.typography.displayMedium)
        Spacer(modifier = Modifier.height(32.dp))


        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
//                .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(5.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
//                .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(5.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
//                .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(5.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
//                .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(5.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isAgreedToTerms.value,
                onCheckedChange = { isAgreedToTerms.value = it }
            )
            Text("I agree to the terms", fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(buttonColor),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Already have an account? ")
                }
                withStyle(style = SpanStyle(color = primaryColor)) {
                    append("Sign In")
                }
            },
            modifier = Modifier.clickable {  }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen()
}
