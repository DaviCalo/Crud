package crud.example.com.database

import androidx.room.Database
import androidx.room.RoomDatabase
//import org.koin.android.ext.koin.androidContext
import crud.example.com.database.dao.ToDoDao
import crud.example.com.database.entities.ToDoEntity


@Database(entities = [ToDoEntity::class], version = 1)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun todoDao(): ToDoDao
}