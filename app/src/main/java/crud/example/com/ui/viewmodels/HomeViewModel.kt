package crud.example.com.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import crud.example.com.models.TodoModel
import crud.example.com.repositories.TodoRepository
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel(
    private val repository: TodoRepository
) : ViewModel() {
    var selectedItem by mutableIntStateOf(1)
    var listAll by mutableStateOf<Array<TodoModel>?>(null)
    var listStatus by mutableStateOf(listOf("Pendente", "Em progresso", "Terminado"))
    private val tempList = mutableListOf<TodoModel>()
    var isShownSearch by mutableStateOf(false)
    var filteredTodo = mutableListOf<TodoModel>()
    var searchStatus = mutableListOf<String>()
    var search by mutableStateOf("")

    init {
        viewModelScope.launch {
            findAllTask()
            search("")
        }
    }

    fun search(
        search: String
    ){
        filteredTodo = if(search.isNotEmpty()){
            listAll?.filter {
                it.title.contains(search, ignoreCase = true) ||
                it.description.contains(search, ignoreCase = true)
            }!!.toMutableList()
        } else listAll?.toMutableList()!!
    }

    private suspend fun findAllTask(){
        try {
            val listResult = repository.findAllList()
            for (i in listResult.indices){
                tempList.add(listResult[i])
            }
            listAll = tempList.toTypedArray()
        }catch (e:Exception){
            println(e.message)
        }
    }

    suspend fun delete(id: String){
        repository.delete(id)
        listAll = listAll?.filter{it.id != id }!!.toTypedArray()
        filteredTodo = filteredTodo.filter{ it.id != id }.toMutableList()
    }

    suspend fun insert(
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