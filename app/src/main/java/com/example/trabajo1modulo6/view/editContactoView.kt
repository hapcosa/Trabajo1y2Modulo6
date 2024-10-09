package com.example.trabajo1modulo6.view

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.trabajo1modulo6.component.bottomAppBar
import com.example.trabajo1modulo6.component.topBar
import com.example.trabajo1modulo6.models.Contacto
import com.example.trabajo1modulo6.viewModel.contactoViewModel
import kotlinx.coroutines.job

@Composable
fun editContactoView (navController: NavController, viewModel: contactoViewModel, id: Int){
    Scaffold(
        topBar = { topBar("Editar contacto", navController) },
        content = { ContentEditView(it, navController, viewModel, id) },
        bottomBar = { bottomAppBar(navController) },
    )
}

@Composable
fun ContentEditView(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: contactoViewModel, id :Int){

    val contacto = viewModel.getContactById(id)
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>( Uri.EMPTY ) }
    var birthDateString by remember { mutableStateOf("") }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri= uri
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        imageUri?.let {
            val painter = rememberImagePainter(
                data = ImageRequest.Builder(context)
                    .data(it)
                    .build()
            )
                Image(
                    painter = if (imageUri != null) painter else rememberAsyncImagePainter(contacto.imagenRuta),
                    contentDescription = "Selected image",
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
            IconButton(onClick = { launcher.launch("image/*") }) {
                Icon(Icons.Filled.Face, contentDescription = "Select image")
            }
        OutlinedTextField(
            value = if(name != "") name else contacto.nombre,
            onValueChange = { name = it },
            label = { Text("Nombre: ") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value =if(phone != "") phone else contacto.telefono,
            onValueChange = { phone = it },
            label = { Text("telefono: ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = if(email != "") email else contacto.correo,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = if(birthDateString != "")  birthDateString else contacto.fechaCreacion,
            onValueChange = { birthDateString = it },
            label = { Text("Fecha de nacimiento (dd/MM/yyyy)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.EditContacto(Contacto(birthDateString, imageUri.toString(),email,phone,name))
            navController.navigate("home")} )
        {
            Text("Guardar")
        }
        }


    }
