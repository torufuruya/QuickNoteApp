package com.example.quicknoteapp.data

import java.util.*

class SampleDataProvider {

    companion object {
        private val sampleText1 = "A simple note"
        private val sampleText2 = "A note a\nline feed"
        private val sampleText3 = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam a viverra justo. Duis scelerisque ligula sollicitudin velit luctus, faucibus condimentum eros pellentesque. Integer et vestibulum eros, sit amet vulputate quam. Proin et orci sed est euismod vestibulum at quis enim. In neque diam, accumsan in nisl ac, dignissim dapibus est. Sed sit amet eros sit amet dolor tristique molestie. Sed ex mauris, dapibus nec hendrerit ut, tempor sed sem. Maecenas pulvinar nunc turpis, commodo mattis mauris mattis eget. Maecenas efficitur, tortor at facilisis posuere, lorem tellus condimentum elit, eget vulputate sem massa a enim. Donec sagittis, metus id interdum sagittis, risus diam dapibus ipsum, id pharetra odio ligula non eros. Aenean sem velit, efficitur at sem in, posuere cursus dolor. Quisque faucibus, dolor eu pretium dictum, mauris risus mattis augue, eget tincidunt dolor justo vitae urna.

            Sed sodales pretium laoreet. Quisque venenatis lectus eu turpis viverra, lacinia molestie diam hendrerit. Sed ultricies purus sed metus dignissim, sed dapibus nibh pulvinar. Fusce feugiat viverra finibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut mi mi, accumsan in erat ac, vehicula efficitur urna. Nulla non pharetra ligula. Aenean vel feugiat nulla. Praesent ornare placerat justo, in aliquet elit convallis vel. Nunc placerat posuere orci in rhoncus. Praesent laoreet feugiat lectus quis volutpat. Nulla in urna id sem finibus scelerisque sit amet id nisi. Curabitur quis pharetra lorem.
        """.trimIndent()

        private fun getDate(diff: Long): Date {
            return Date(Date().time + diff)
        }

        fun getNotes() = arrayListOf(
            NoteEntity(getDate(0), sampleText1),
            NoteEntity(getDate(1), sampleText2),
            NoteEntity(getDate(2), sampleText3),
        )
    }
}