package com.clean_circuit.renewit.Screens



import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.clean_circuit.renewit.R
import com.clean_circuit.renewit.Screen


val InterFontFamily = FontFamily(
    Font(R.font.inter_regular)
)

@Composable
fun SignUpScreen(onClickSignup: () -> Unit,onClickSignIn:()->Unit) {
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
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_app),
            contentDescription = "Logo",
            modifier = Modifier.size(70.dp)
        )

        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.displayMedium.copy(fontSize = 24.sp),
            fontWeight = FontWeight.Bold,fontFamily = InterFontFamily,


            )

        Spacer(modifier = Modifier.height(1.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Name",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Start
            )
        }

        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            placeholder = { Text("name", fontFamily = InterFontFamily, fontSize = 12.sp, fontStyle = FontStyle.Italic) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Email",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Start
            )
        }

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            placeholder = { Text("email@example.com", fontFamily = InterFontFamily,fontSize = 12.sp, fontStyle = FontStyle.Italic) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Password",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Start
            )
        }

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = { Text("enter password", fontFamily = InterFontFamily,fontSize = 12.sp, fontStyle = FontStyle.Italic) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Confirm Password",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Start
            )
        }

        OutlinedTextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            placeholder = { Text("re-enter password", fontFamily = InterFontFamily,fontSize = 12.sp, fontStyle = FontStyle.Italic) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isAgreedToTerms.value,
                onCheckedChange = { isAgreedToTerms.value = it }
            )
            Text(
                "I agree to the terms and conditions and privacy policy",
                fontSize = 12.sp,
                fontFamily = InterFontFamily
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {onClickSignup()},
                colors = ButtonDefaults.buttonColors(buttonColor),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
            ) {
                Text(
                    "Sign Up",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = InterFontFamily,

                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Already have an account? ")
                }
                withStyle(style = SpanStyle(color = primaryColor)) {
                    append("Sign In",)
                }
            },
            modifier = Modifier.clickable {onClickSignIn ()},
            fontFamily = InterFontFamily,fontSize = 20.sp

        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen({},{})
}
