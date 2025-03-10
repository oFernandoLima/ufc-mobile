package com.example.msgapp2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msgapp2.model.Message
import com.example.msgapp2.repository.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MessageViewModel(private val repository: MessageRepository) : ViewModel() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages.asStateFlow()

    init {
        viewModelScope.launch {
            repository.allMessages.collect {
                _messages.value = it
            }
        }
    }

    fun addMessage(content: String) {
        viewModelScope.launch {
            val newMessage = Message(content = content, timestamp = System.currentTimeMillis())
            _messages.value += newMessage
            repository.addMessage(content)
        }
    }

}