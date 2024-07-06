package crud.example.com.ui.viewmodels

import androidx.lifecycle.ViewModel
import crud.example.com.repositories.TodoRepository

class CreateViewModelViewModel(
    private val repository: TodoRepository
) : ViewModel() {

}