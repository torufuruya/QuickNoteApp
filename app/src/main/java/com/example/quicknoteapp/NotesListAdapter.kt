package com.example.quicknoteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quicknoteapp.data.NoteEntity
import com.example.quicknoteapp.databinding.ListItemBinding

class NotesListAdapter(
    private val notesList: List<NoteEntity>,
    private val listener: ListItemListener
) :
    RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {

    val selectedNotes = arrayListOf<NoteEntity>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notesList[position]
        with(holder.binding) {
            noteText.text = note.text
            root.setOnClickListener {
                listener.onItemClick(note.id)
            }
            floatingActionButton.setOnClickListener {
                if (selectedNotes.contains(note)) {
                    selectedNotes.remove(note)
                    floatingActionButton.setImageResource(R.drawable.ic_notes)
                } else {
                    selectedNotes.add(note)
                    floatingActionButton.setImageResource(R.drawable.ic_check)
                }
                listener.onItemSelectionChanged()
            }
            floatingActionButton.setImageResource(
                if (selectedNotes.contains(note)) {
                    R.drawable.ic_check
                } else {
                    R.drawable.ic_notes
                }
            )
       }
    }

    override fun getItemCount(): Int = notesList.size

    interface ListItemListener {
        fun onItemClick(noteId: Int)
        fun onItemSelectionChanged()
    }
}