package plat.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import plat.lab6.ui.theme.Lab6Theme

data class Movimiento(
    val valor: Int,
    val incremento: Boolean
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab6Theme {
                ContadorApp()
            }
        }
    }
}

@Composable
fun ContadorApp() {

    var contador by remember { mutableStateOf(0) }
    var totalIncrementos by remember { mutableStateOf(0) }
    var totalDecrementos by remember { mutableStateOf(0) }
    var valorMaximo by remember { mutableStateOf(0) }
    var valorMinimo by remember { mutableStateOf(0) }

    val historial = remember {
        mutableStateListOf<Movimiento>()
    }

    fun incrementar() {
        contador++
        totalIncrementos++

        historial.add(
            Movimiento(contador, true)
        )

        if (historial.size == 1) {
            valorMaximo = contador
            valorMinimo = contador
        } else {
            if (contador > valorMaximo) {
                valorMaximo = contador
            }

            if (contador < valorMinimo) {
                valorMinimo = contador
            }
        }
    }

    fun decrementar() {
        contador--
        totalDecrementos++

        historial.add(
            Movimiento(contador, false)
        )

        if (historial.size == 1) {
            valorMaximo = contador
            valorMinimo = contador
        } else {
            if (contador > valorMaximo) {
                valorMaximo = contador
            }

            if (contador < valorMinimo) {
                valorMinimo = contador
            }
        }
    }

    fun reiniciar() {
        contador = 0
        totalIncrementos = 0
        totalDecrementos = 0
        valorMaximo = 0
        valorMinimo = 0
        historial.clear()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Junior Lancerio",
            fontSize = 34.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(45.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = { decrementar() },
                modifier = Modifier.size(42.dp),
                shape = CircleShape,
                contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    text = "−",
                    fontSize = 25.sp,
                    color = Color.White
                )
            }

            Text(
                text = contador.toString(),
                modifier = Modifier.padding(horizontal = 28.dp),
                fontSize = 72.sp,
                color = Color.Black
            )

            Button(
                onClick = { incrementar() },
                modifier = Modifier.size(42.dp),
                shape = CircleShape,
                contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    text = "+",
                    fontSize = 25.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(18.dp))

        Estadistica("Total incrementos:", totalIncrementos)
        Estadistica("Total decrementos:", totalDecrementos)
        Estadistica("Valor máximo:", valorMaximo)
        Estadistica("Valor mínimo:", valorMinimo)
        Estadistica("Total cambios:", totalIncrementos + totalDecrementos)

        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {

            Text(
                text = "Historial:",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(14.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                items(historial) { movimiento ->

                    Box(
                        modifier = Modifier
                            .size(58.dp, 46.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (movimiento.incremento) {
                                    Color.Green
                                } else {
                                    Color.Red
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = movimiento.valor.toString(),
                            color = Color.White,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { reiniciar() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .height(52.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            )
        ) {
            Text(
                text = "Reiniciar",
                fontSize = 14.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(18.dp))
    }
}

@Composable
fun Estadistica(
    nombre: String,
    valor: Int
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 23.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = nombre,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = valor.toString(),
            fontSize = 21.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContadorAppPreview() {
    Lab6Theme {
        ContadorApp()
    }
}