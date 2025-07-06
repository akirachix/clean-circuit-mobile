package com.clean_circuit.renewit

//package com.clean_circuit.renewit


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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
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
        Spacer(modifier = Modifier.height(1.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Name",
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Start
            )
        }








        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
//                .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(5.dp))
        )


        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Email",
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Start
            )
        }





        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("email@example.com") },
            modifier = Modifier
                .fillMaxWidth()
//                .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(5.dp))
        )


        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Password",
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Start
            )
        }





        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("enter password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
//                .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(5.dp))
        )


        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Confirm Password",
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Start
            )
        }





        OutlinedTextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            label = { Text("re-enter password") },
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
            Text("I agree to the terms and conditions and privacy policy", fontSize = 14.sp)
        }


        Spacer(modifier = Modifier.height(16.dp))




        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally  // Center children horizontally
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(buttonColor),
                shape = RoundedCornerShape(10.dp)  // Smaller corner radius for less curvature
            ) {
                Text("Sign Up", color = Color.White)
            }
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
