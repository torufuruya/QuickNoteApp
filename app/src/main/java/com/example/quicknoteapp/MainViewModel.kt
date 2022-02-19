package com.example.quicknoteapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quicknoteapp.data.NoteEntity
import com.example.quicknoteapp.data.SampleDataProvider

class MainViewModel : ViewModel() {

    val notesList = MutableLiveData<List<NoteEntity>>()

    init {
        notesList.value = SampleDataProvider.getNotes()
    }
}