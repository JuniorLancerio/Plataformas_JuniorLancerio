package plat.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PortadaUVG()
        }
    }
}

@Composable
fun PortadaUVG() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 5.dp,
                    color = Color.Green
                )
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.uvg_escudo_referencia
                ),
                contentDescription = "Escudo UVG",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(300.dp)
                    .alpha(0.16f),
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 25.dp,
                        end = 25.dp,
                        top = 110.dp,
                        bottom = 35.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Universidad del Valle\nde Guatemala",
                    color = Color.Black,
                    fontSize = 31.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 36.sp
                )

                Spacer(
                    modifier = Modifier.height(42.dp)
                )

                Text(
                    text = "Programación de plataformas\nmóviles, Sección 30",
                    color = Color.Black,
                    fontSize = 21.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 27.sp
                )

                Spacer(
                    modifier = Modifier.height(50.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "INTEGRANTES",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )

                    Column(
                        modifier = Modifier.weight(1.4f)
                    ) {
                        Text(
                            text = "Junior Lancerio",
                            color = Color.Black,
                            fontSize = 16.sp
                        )

                        Text(
                            text = "Axel Xitumul",
                            color = Color.Black,
                            fontSize = 16.sp
                        )

                        Text(
                            text = "Kenett Ortega",
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(45.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "CATEDRÁTICO",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "Juan Carlos Durini",
                        color = Color.Black,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1.4f)
                    )
                }

                Spacer(
                    modifier = Modifier.height(50.dp)
                )

                Text(
                    text = "Junior Noé Lancerio López",
                    color = Color.Black,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = "25789",
                    color = Color.Black,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 412,
    heightDp = 915
)
@Composable
fun PortadaUVGPreview() {
    PortadaUVG()
}