package com.rafaykakar.notetakingapplication.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mynotesapplication.adapters.NoteEntity
import com.example.mynotesapplication.domain.adapters.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteEditorViewModel @Inject constructor(private val dbrepository: DatabaseRepository) :
    ViewModel() {


    suspend fun addNote(noteEntity: NoteEntity) {
        return dbrepository.addNote(noteEntity)
    }

    suspend fun deleteNote(noteEntity: NoteEntity) {
        return dbrepository.deleteNote(noteEntity)
    }
}