package com.aiwa.bookstore.service

import com.aiwa.bookstore.model.Book

interface BookService {
    fun add(book: Book): Book
    fun getBooks(): List<Book>
    fun remove(bookId: Long)
    fun getBook(bookId: Long): Book
}
