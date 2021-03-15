package com.aiwa.bookstore.service

import com.aiwa.bookstore.dao.BookRepository
import com.aiwa.bookstore.model.Book
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookServiceImpl(val bookRepository: BookRepository) : BookService {

    override fun add(book: Book): Book = bookRepository.save(book)

    override fun getBooks(): List<Book> = bookRepository.findAll()

    override fun remove(bookId: Long) {
        bookRepository.deleteById(bookId)
    }

    override fun getBook(bookId: Long): Book = bookRepository
            .findById(bookId)
            .orElseThrow { NoSuchElementException("Book with id: $bookId not found!") }
}
