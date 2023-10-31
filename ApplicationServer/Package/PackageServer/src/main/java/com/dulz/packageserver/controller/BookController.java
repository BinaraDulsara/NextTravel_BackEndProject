package com.dulz.packageserver.controller;

import com.dulz.packageserver.dto.BookDTO;
import com.dulz.packageserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<String>bookSave(@RequestBody BookDTO bookDTO){
        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(bookDTO.getBookingId()+ " Book Saved !! ", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>updateBook(@RequestBody BookDTO bookDTO){
        bookService.updateBook(bookDTO);
        return new ResponseEntity<>(bookDTO.getPackageId()+" Book Updated !! ",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String>deleteBook(String id){
        bookService.deleteBook(id);
        return  new ResponseEntity<>(id+" Book Deleted !!",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<BookDTO>findById(String id){
        return new ResponseEntity<>(bookService.findById(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<BookDTO>>getAll(){
        return new ResponseEntity<>(bookService.getAll(),HttpStatus.OK);
    }
}
