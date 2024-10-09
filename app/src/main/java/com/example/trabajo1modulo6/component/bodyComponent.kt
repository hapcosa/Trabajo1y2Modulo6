package com.example.trabajo1modulo6.component

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.trabajo1modulo6.models.Contacto
import com.example.trabajo1modulo6.utils.dateFunc

import com.example.trabajo1modulo6.viewModel.contactoViewModel
import java.io.File


@Composable
fun contactCard(navController: NavController, contacto:Contacto, viewModel: contactoViewModel) {
    val imageruta by rememberSaveable {
        mutableStateOf(contacto.imagenRuta) }
    Card(modifier = Modifier
        .width(200.dp)
        .fillMaxHeight()
        .padding(4.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = rememberAsyncImagePainter(contacto.imagenRuta),
                contentDescription = contacto.nombre,
                modifier = Modifier
                    .size(100.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column() {
                Row(){
                    Text(text = "Nombre: ", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = contacto.nombre,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))
                Row(){
                    Text(text = "Telefono: ", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = contacto.telefono,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Correo: ", style = MaterialTheme.typography.bodyMedium)
                Text(
                        text = contacto.correo,
                        style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "Fecha de nacimiento: ", style = MaterialTheme.typography.bodyMedium)
                Text(
                        text = contacto.fechaCreacion,
                        style = MaterialTheme.typography.bodySmall
                    )
                Spacer(modifier = Modifier.height(4.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    IconButton(onClick = {navController.navigate("edit/${contacto.contactoId}") }, modifier = Modifier.padding(4.dp)) {
                        Icon(Icons.Filled.Edit , contentDescription ="edit" )
                    }
                    IconButton(onClick = {viewModel.deleteContacto(contacto)}, modifier = Modifier.padding(4.dp)) {
                        Icon(Icons.Filled.Delete , contentDescription ="delete" )
                    }
                }



            }
        }
    }
}

@Composable
fun PhotoView(imagePath: String) {
    val bitmap = remember {
        val file = File(imagePath)
        BitmapFactory.decodeFile(file.absolutePath)
    }
    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .padding(15.dp)
            .shadow(10.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Fit
    )
}