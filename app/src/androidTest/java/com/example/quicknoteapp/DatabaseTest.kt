package com.example.quicknoteapp

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.quicknoteapp.data.AppDatabase
import com.example.quicknoteapp.data.NoteDao
import com.example.quicknoteapp.data.NoteEntity
import com.example.quicknoteapp.data.SampleDataProvider
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var dao: NoteDao
    private lateinit var database: AppDatabase

    @Before
    fun createDatabase() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java)
            .allowMainThreadQueries().build()
        dao = database.noteDao()!!
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun insertNotes() {
        dao.insertAll(SampleDataProvider.getNotes())
        val count = dao.getCount()
        assertEquals(count, SampleDataProvider.getNotes().size)
    }

    @Test
    fun insertNote() {
        val note = NoteEntity()
        note.text = "Test text"
        dao.insertNote(note)

        val savedNote = dao.getNoteById(1)
        assertEquals(savedNote?.id ?: 0, 1)
    }
}