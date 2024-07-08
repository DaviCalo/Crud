package crud.example.com.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import crud.example.com.database.entities.ToDoTaksEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM ToDoTaksEntity")
    fun findAll(): Flow<List<ToDoTaksEntity>>

    @Query("SELECT * FROM ToDoTaksEntity WHERE id = :id")
    fun getById(id: String): Flow<ToDoTaksEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: ToDoTaksEntity)

    @Query("DELETE FROM ToDoTaksEntity WHERE id = :id")
    suspend fun delete(id: String)

    @Query("DELETE FROM ToDoTaksEntity")
    suspend fun deleteAll()
}

// Responsavel por acessar o banco de dados e falar os comportamentos do banco de dados