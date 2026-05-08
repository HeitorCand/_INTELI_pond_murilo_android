package carvalho.zanini.ponderada1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

import androidx.compose.ui.tooling.preview.Preview
import carvalho.zanini.ponderada1.ui.theme.Ponderada1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LancadorDeDadosApp()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LancadorDeDadosApp() {
    var dadoSelecionado by remember { mutableStateOf("D6") }
    var resultado by remember { mutableStateOf("Clique no botão para lançar o dado") }
    var valorSorteado by remember { mutableStateOf(0) }
    val dados = listOf("D6", "D10", "D20", "D100") // Adicionei os novos dados

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Lançador de Dados",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Escolha o tipo de dado:")

        dados.forEach { dado ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = dadoSelecionado == dado,
                    onClick = { dadoSelecionado = dado }
                )
                Text(text = dado)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                val dN = dadoSelecionado.replace("D", "").toInt()
                valorSorteado = when (dadoSelecionado) {
                    "D6" -> Random.nextInt(dN) + 1 // Faltava somar +1 pq vai de 0-5, agora vai de 1-6
                    "D10" -> Random.nextInt(dN) + 1 // Novos dados
                    "D20" -> Random.nextInt(dN) + 1
                    "D100" -> (Random.nextInt(dN ) + 1)
                    else -> 0
                }

                if (valorSorteado > dN) valorSorteado = dN

                resultado = "Resultado do $dadoSelecionado: $valorSorteado"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Lançar dado")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = resultado,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(modifier = Modifier.size(400.dp)) {
            Image(
                painter = painterResource(id = R.drawable.dice),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = valorSorteado.toString(),
                modifier = Modifier.align(Alignment.TopCenter).padding(0.dp,80.dp,0.dp,0.dp),
                fontSize = 50.sp,
            )
        }
    }
}