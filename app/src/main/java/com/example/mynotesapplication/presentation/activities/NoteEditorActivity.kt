package com.example.mynotesapplication.presentation.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mynotesapplication.R
import com.example.mynotesapplication.adapters.NoteEntity
import com.example.mynotesapplication.databinding.ActivityNoteEditorBinding
import com.rafaykakar.notetakingapplication.presentation.viewmodels.NoteEditorViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*


@AndroidEntryPoint
class NoteEditorActivity : AppCompatActivity() {

    lateinit var binding: ActivityNoteEditorBinding
    val viewModel by viewModels<NoteEditorViewModel>()
    var updatenoteEntity: NoteEntity? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@NoteEditorActivity, R.layout.activity_note_editor)
        inits()
    }

    private fun inits() {

        //Note Object
        if (intent.getSerializableExtra("NOTE_OBJECT") != null) {
            updatenoteEntity = intent.getSerializableExtra("NOTE_OBJECT") as NoteEntity
        }

        binding.apply {
            if (updatenoteEntity != null) {
                headingEditText.setText(updatenoteEntity?.heading)
                noteEditText.setText(updatenoteEntity?.text)
            }
        }
    }


    //Add or Update existing note
    fun addNote() {

        GlobalScope.launch {

            binding.apply {
                if (!noteEditText.text.toString().isEmpty() ||
                    !headingEditText.text.toString().isEmpty()
                )
                    if (updatenoteEntity != null) {
                        updatenoteEntity?.apply {
                            heading = headingEditText.text.toString()
                            text = noteEditText.text.toString()
                            date = Date()
                            viewModel.addNote(this)
                        }
                    } else {
                        viewModel.addNote( NoteEntity(
                            headingEditText.text.toString(),
                            noteEditText.text.toString(),
                            Date())
                        )
                    }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        addNote()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //Save note on backpressed
    }
}

