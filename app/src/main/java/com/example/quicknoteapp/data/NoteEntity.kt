package com.example.quicknoteapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

const val NEW_NOTE_ID = 0

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var date: Date,
    var text: String
) {
    constructor() : this(NEW_NOTE_ID, Date(), "")
    constructor(date: Date, text: String) : this(NEW_NOTE_ID, date, text)
}