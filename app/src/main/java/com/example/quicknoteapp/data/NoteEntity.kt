package com.example.quicknoteapp.data

import java.util.*

const val NEW_NOTE_ID = 0

data class NoteEntity(
    var id: Int,
    var date: Date,
    var text: String
) {
    constructor() : this(NEW_NOTE_ID, Date(), "")
    constructor(date: Date, text: String) : this(NEW_NOTE_ID, date, text)
}