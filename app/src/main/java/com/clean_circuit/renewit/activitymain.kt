package com.clean_circuit.renewit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clean_circuit.renewit.ui.theme.RenewitTheme

@Composable
fun RenewItScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal =32.dp)
                .padding( top=90.dp),

            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.teaser_image),
                contentDescription = stringResource(id = R.string.teaser_one_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(310.dp)
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF00DB00))
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Row(
                modifier = Modifier.padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Dot(isActive = true)
                Spacer(modifier = Modifier.width(38.dp))
                Dot(isActive = true)
                Spacer(modifier = Modifier.width(38.dp))
                Dot(isActive = true)
            }

            Text(
                text = stringResource(id = R.string.page_text),
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = stringResource(id = R.string.description_text),
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(bottom = 40.dp)
            )

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(bottom = 64.dp)
                    .wrapContentWidth()
                    .height(56.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.continue_button_text),
                    color = Color(0xFF1E1E1E),
                    fontSize = 24.sp
                )
            }
        }
    }
}
@Composable
fun Dot(isActive: Boolean) {
    Box(

        modifier = Modifier
            .size(8.dp)
            .clip(CircleShape)
            .background(if (isActive) Color.White else Color(0xFFA9A9A9))
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewRenewItScreen() {

    RenewitTheme{
        RenewItScreen()
    }
}