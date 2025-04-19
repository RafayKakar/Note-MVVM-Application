package com.example.mynotesapplication.domain.adapters

import androidx.lifecycle.LiveData
import com.example.mynotesapplication.adapters.NoteEntity
import com.rafaykakar.notetakingapplication.database.NotesDao
import javax.inject.Inject


class DatabaseRepository @Inject constructor(
    private val notesDao: NotesDao
){
    suspend fun allNotes() = notesDao.getAllNotes()

    suspend fun addNote(noteEntity: NoteEntity) = notesDao.insertNote(noteEntity)

    suspend fun getNoteById(id:Int) = notesDao.getNoteById(id)

    suspend fun deleteNote(noteEntity: NoteEntity) = notesDao.deleteNote(noteEntity)

    suspend fun deleteAllNotes():Int = notesDao.deleteAllNotes()

    suspend fun getNotesCount(): LiveData<Int> = notesDao.getCount()
}