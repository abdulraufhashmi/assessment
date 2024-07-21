package com.aeon.assessment.library.book.controller;

import com.aeon.assessment.library.book.dto.BookDTO;
import com.aeon.assessment.library.book.entity.BookEntity;
import com.aeon.assessment.library.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("library/book/")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("{id}/borrow/{borrowerId}")
    public BookDTO borrowBook(@PathVariable("borrowerId")Long borrowerId,@PathVariable("id")Long id){
        return bookService.borrowBook(id,borrowerId);
    }

    @PostMapping("add")
    public BookDTO addBook(@RequestBody()BookEntity book){
        return bookService.addBook(book);
    }

    @PatchMapping("{id}/return")
    public BookDTO returnBook(@PathVariable("id")Long id){
        return bookService.returnBook(id);
    }


    @GetMapping("all")
    public List<BookDTO> getAllBook(){
        return bookService.getAllBooks();
    }

}
