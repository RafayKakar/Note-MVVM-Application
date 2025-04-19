package com.rafaykakar.notetakingapplication.data.database

import androidx.room.*
import com.example.mynotesapplication.adapters.NoteEntity
import com.rafaykakar.notetakingapplication.database.NotesDao


@Database(
      entities = [NoteEntity::class],
      version = 1,
      exportSchema = true
)
@TypeConverters(DBDataConverter::class)
abstract class AppDatabase : RoomDatabase() {
      abstract fun notesDao(): NotesDao
}

