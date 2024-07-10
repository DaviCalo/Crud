package crud.example.com.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import crud.example.com.models.TodoModel
import crud.example.com.repositories.TodoRepository
import kotlinx.coroutines.launch
import java.util.UUID

class CreateViewModel(
    private val repository: TodoRepository
) : ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var data by mutableStateOf("")
    var timer by mutableStateOf("")
    var status by mutableStateOf("")
    var listStatus by mutableStateOf(listOf("Pendente", "Em progresso", "Terminado"))
    var isDone by mutableStateOf(false)
    var isId by mutableStateOf(false)
    var showDialog by mutableStateOf(false)

    fun clear(){
        title = ""
        description = ""
        data = ""
        timer = ""
        status = ""
    }

    suspend fun edit(id: String){
        val todo = repository.getById(id)
        title = todo.title
        description = todo.description
        data = todo.data
        timer = todo.time
        status = todo.status
    }

    fun insertTodo(){
        if(
            title.isNotEmpty() &&
            description.isNotEmpty() &&
            data.isNotEmpty() &&
            timer.isNotEmpty() &&
            status.isNotEmpty()
        ){
            viewModelScope.launch {
                insert(title, description, data, timer, status)
                isDone = true
                println(isDone)
            }
        }else showDialog = true
    }

    private suspend fun insert(
        title: String,
        description: String,
        data: String,
        time: String,
        status: String
    ){
        repository.insert(
            TodoModel(
                id = UUID.randomUUID().toString(),
                title = title,
                description = description,
                data = data,
                time = time,
                status = status
            )
        )
    }
}