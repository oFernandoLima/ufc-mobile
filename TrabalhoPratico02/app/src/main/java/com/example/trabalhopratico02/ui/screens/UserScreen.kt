package com.example.trabalhopratico02.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apppost2.ui.screens.PostItem
import com.example.trabalhopratico02.data.models.User
import com.example.trabalhopratico02.viewmodel.PostViewModel

@Composable
fun UserScreen(viewModel: PostViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var editingUser by remember { mutableStateOf<User?>(null) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchUsers()
        isLoading = false
    }

    Column(modifier = Modifier.padding(16.dp)) {

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                isLoading = true
                viewModel.createUser(name, email, onSuccess = {
                    Toast.makeText(context, "Usuário criado com sucesso!", Toast.LENGTH_SHORT).show()
                    isLoading = false
                }, onError = {
                    Toast.makeText(context, "Erro ao criar usuário!", Toast.LENGTH_SHORT).show()
                    isLoading = false
                })
                name = ""
                email = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Criar Usuário")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn(
                modifier = Modifier.padding(bottom = 38.dp)
            ) {
                items(viewModel.users) { user ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        elevation = 4.dp,
                        backgroundColor = Color(0xFFEDE7F6)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Nome: ${user.name}",
                                style = MaterialTheme.typography.h6
                            )
                            Text(
                                text = "Email: ${user.email}",
                                style = MaterialTheme.typography.body1
                            )
                        }
                    }
                }
            }
        }
    }

    if (editingUser != null) {
        AlertDialog(
            onDismissRequest = { editingUser = null },
            title = { Text(text = "Editar Post") },
            text = {
                Column {
                    TextField(
                        value = editingUser!!.name,
                        onValueChange = { newTitle ->
                            editingUser = editingUser!!.copy(name = newTitle)
                        },
                        label = { Text(text = "Nome") },
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = editingUser!!.email,
                        onValueChange = { newContent ->
                            editingUser = editingUser!!.copy(email = newContent)
                        },
                        label = { Text(text = "Email") },
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.updatePost(
                            editingUser!!.id,
                            editingUser!!.name,
                            editingUser!!.email
                        )
                        editingUser = null
                    }
                ) {
                    Text(text = "Salvar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { editingUser = null }
                ) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}

@Preview
@Composable
private fun UserScreenPreview() {
    UserScreen()
}