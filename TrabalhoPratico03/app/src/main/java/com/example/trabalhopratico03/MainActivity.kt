package com.example.trabalhopratico03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.msgapp2.data.local.database.AppDataBase
import com.example.msgapp2.repository.MessageRepository
import com.example.msgapp2.ui.view.MessageApp
import com.example.msgapp2.viewModel.MessageViewModel
import com.example.msgapp2.viewModel.MessageViewModelFactory
import com.example.trabalhopratico03.ui.theme.TrabalhoPratico03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "messages-db"
        ).fallbackToDestructiveMigration().build()

        val repository = MessageRepository(db.messageDao())

        enableEdgeToEdge()
        setContent {
            TrabalhoPratico03Theme {
                val viewModel: MessageViewModel =
                    viewModel(factory = MessageViewModelFactory(repository = repository))
                MessageApp(viewModel = viewModel)
            }
        }
    }
}