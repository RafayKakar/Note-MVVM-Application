package com.rafaykakar.notetakingapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotesapplication.R
import com.example.mynotesapplication.adapters.NoteEntity
import com.example.mynotesapplication.databinding.NoteItemBinding

class NotesAdapter(
    var context: Context,
    var noteslist: ArrayList<NoteEntity>,
    var noteSelection: NoteSelection
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.note_item,
            parent,
            false
        ) as NoteItemBinding
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = noteslist.size

    inner class NotesViewHolder(var binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {

                //Note Entity
                model = noteslist[position]

                //Note Item Selection
                root.setOnClickListener {
                    noteSelection.note(noteslist[position])
                }

            }
        }
    }


    interface NoteSelection {
        fun note(noteEntity: NoteEntity)
    }
}