package com.dulz.packageserver.controller;

import com.dulz.packageserver.dto.BookDTO;
import com.dulz.packageserver.dto.BookGetDTO;
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
    public ResponseEntity<String> saveBooking(@RequestBody BookDTO bookDTO){
        System.out.println(bookDTO.getBookingId());
        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(bookDTO.getBookingId()+" Book is saved !!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateBooking(@RequestBody BookDTO bookDTO) {
        if (bookService.isValidToUpdate(bookDTO.getBookingId())) {
            bookService.updateBook(bookDTO);
            return new ResponseEntity<>(bookDTO.getBookingId() + " Book is Updated..!!", HttpStatus.OK);
        } else
            throw new RuntimeException(bookDTO.getBookingId() + " Book is not valid to update..!!");
    }


    @DeleteMapping(params = "Id")
        public ResponseEntity<String> deleteBooking(String bookingId){
            bookService.deleteBook(bookingId);
            return new ResponseEntity<>(bookingId+" Booking is Deleted..!!",HttpStatus.OK);
        }

    @GetMapping(params = "id")
    public ResponseEntity<BookGetDTO>findById(String id){
        return new ResponseEntity<>(bookService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookGetDTO>>getAll(){
        return new ResponseEntity<>(bookService.getAll(),HttpStatus.OK);
    }


    @GetMapping(params = "userId",path = "/getBookingByUserId")
    public ResponseEntity<BookGetDTO> getBookingByUserId(String userId){
        return new ResponseEntity<>(bookService.getBookingByUserId(userId),HttpStatus.OK);
    }

    //get booking ids using user id
    @GetMapping(params = "userId",path = "/getBookingIdsByUserId")
    public ResponseEntity<List<String>> getBookingIdsByUserId(String userId){
        List<String> bookingIds = null;
        List<BookGetDTO> bookingsByUserId = bookService.getBookingsByUserId(userId);
        for(BookGetDTO bookingGetDTO : bookingsByUserId){
            bookingIds.add(bookingGetDTO.getBookingId());
        }
        return new ResponseEntity<>(bookingIds,HttpStatus.OK);
    }

    @GetMapping(path = "/getLastId")
    public ResponseEntity<String> getLastId(){
        return new ResponseEntity<>(bookService.getLastIndex(),HttpStatus.OK);
    }

    @GetMapping(path = "/getCountOfPackage")
    public ResponseEntity<Integer> getCountOfPackage(){
        return new ResponseEntity<>(bookService.getCountOfPackage(),HttpStatus.OK);
    }

}
