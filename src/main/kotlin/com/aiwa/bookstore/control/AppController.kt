package com.aiwa.bookstore.control

import com.aiwa.bookstore.model.Book
import com.aiwa.bookstore.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.InetAddress

@RestController
@RequestMapping(path = ["/api/v1/books"])
class AppController(val bookService: BookService) {

    @GetMapping
    fun getBooks(): ResponseEntity<List<Book>> = ResponseEntity(bookService.getBooks(), HttpStatus.OK)

    @PostMapping
    fun addBook(@RequestBody book: Book): ResponseEntity<Book> = ResponseEntity(bookService.add(book), HttpStatus.CREATED)

    @GetMapping(path = ["/{id}"])
    fun getBook(@PathVariable id: Long): ResponseEntity<Book> = ResponseEntity(bookService.getBook(id), HttpStatus.OK)

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        bookService.remove(id)
        return ResponseEntity("Book with ID $id removed!", HttpStatus.OK)
    }

    @GetMapping(path = ["/app-status"])
    fun getAppStatus(): ResponseEntity<String> = ResponseEntity("Application UP & RUNNING from: ${InetAddress.getLocalHost()}", HttpStatus.OK)
}
