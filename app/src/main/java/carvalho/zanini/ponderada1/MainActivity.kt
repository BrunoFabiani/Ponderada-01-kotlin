package carvalho.zanini.ponderada1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.tooling.preview.Preview

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



    val context = LocalContext.current
    var imageId by remember { mutableStateOf(R.drawable.mao_rolando_dado) }

    val dados = listOf("D6", "D10", "D20", "D100")



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
            onClick = { //server para mudar o estado não da pra so colocar algo como Image nele.
                val valorSorteado = when (dadoSelecionado) {
                    "D6" -> Random.nextInt(6) + 1
                    "D10" -> Random.nextInt(10) + 1
                    "D20" -> Random.nextInt(20) + 1
                    "D100" -> Random.nextInt(100) + 1
                    else -> 0
                }

                resultado = "Resultado do $dadoSelecionado: $valorSorteado"

                val numeroImagem = when (valorSorteado) {
                    in 7..10 -> 7
                    in 11..20 -> 8
                    in 21..100 -> 9
                    else -> valorSorteado
                }

                val nomeImagem = "dice_$numeroImagem"

                val novoImageId = context.resources.getIdentifier(
                    nomeImagem,
                    "drawable",
                    context.packageName
                )

                if (novoImageId != 0) {
                    imageId = novoImageId
                }



            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Lançar dado")
        }


        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))


        Text(
            text = resultado,
            fontSize = 20.sp
        )
    }
}