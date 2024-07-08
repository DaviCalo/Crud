package crud.example.com.models

import java.util.UUID

data class TodoModel(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val data: String,
    val time: String,
    val status: String,
)