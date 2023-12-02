package perez.david.pokeappandroid.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import perez.david.pokeappandroid.R


@Composable
fun AboutPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray) // Light blue background color
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header with a birthday cake emoji
        Text("¡Mi primera app\nen Jetpack Compose!\n🎂", color = Color.Black,textAlign = TextAlign.Center,fontSize = 24.sp, fontWeight = FontWeight.Bold)

        // Author image
        AsyncImage(

            model = "https://media.licdn.com/dms/image/D4D03AQH01tCVa3MkTw/profile-displayphoto-shrink_800_800/0/1698511621643?e=1706745600&v=beta&t=0tpJna_ISkKqLo2PiN-rtOOdEWcnPkVuwzpJMsxeDuc",
            contentDescription = "Author Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
                .clip(shape = CircleShape),
        )

        // Author name and description
        Text(
            text = stringResource(R.string.author_name),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF01579B), // Dark blue color
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Desarrollador de software apasionado por la programación y la tecnología. ¡Gracias por un increíble primer año juntos en Compose!",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}