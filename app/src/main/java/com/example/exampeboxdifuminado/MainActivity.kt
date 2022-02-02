package com.example.exampeboxdifuminado


import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.exampeboxdifuminado.ui.theme.ExampeBoxDifuminadoTheme
import com.ondev.imageblurkt_lib.ImageBlur


@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampeBoxDifuminadoTheme {
                // A surface container using the 'background' color from the theme
                Desenfocar(resources)

            }
        }
    }
}


@ExperimentalCoilApi
@Composable
fun Desenfocar(resources: Resources) {

    val imageUrl = "https://www.sistecredito.com/assets/images/image-personas-slider.png"
    val blurhash = "LQC7iq*._8;35b9i9uEP%2sTx-wg"

    Column(modifier = Modifier
        .width(500.dp)) {
        Box() {
            Image(
                painterResource(R.drawable.personas),
                contentDescription = null,
                )
        }

        Column(modifier = Modifier
            .offset((0).dp,(-40).dp)
            .height(600.dp)) {
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                ImageBlur(
                    modifier = Modifier.fillMaxWidth(),
                    blurhash = blurhash,
                    imageUrl = imageUrl,
                    10000000,
                    resources = resources,
                    contentDescription = "Usar Image Blurhash"
                )
            }
        }

    }


}


@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExampeBoxDifuminadoTheme {
        Desenfocar(resources = Resources.getSystem())
    }
}