package com.dulz.packageserver.service;

import com.dulz.packageserver.dto.BookDTO;
import com.dulz.packageserver.repo.BookRepo;
import com.dulz.packageserver.util.DataConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class BookServiceIMPL implements BookService {

    @Autowired
    DataConverter dataConverter;

    @Autowired
    BookRepo bookRepo;

    @Override
    public void saveBook(BookDTO bookDTO) {
        if (bookRepo.existsById(bookDTO.getBookingId())){
            throw new RuntimeException(bookDTO.getBookingId()+" Book Id Already Exists !!");
        }
        bookRepo.save(dataConverter.bookDTOToBookEntity(bookDTO));
    }


    @Override
    public void updateBook(BookDTO bookDTO) {
        if (!bookRepo.existsById(bookDTO.getBookingId())){
            throw new RuntimeException(bookDTO.getBookingId()+" Vehicle Id Does Not Exists !! ");
        }
        bookRepo.save(dataConverter.bookDTOToBookEntity(bookDTO));

    }

    @Override
    public void deleteBook(String id) {
        if (!bookRepo.existsById(id)){
            throw new RuntimeException(id+" Vehicle Id Does Not Exists !! ");
        }
        bookRepo.deleteById(id);
    }

    @Override
    public BookDTO findById(String id) {
        if (!bookRepo.existsById(id)){
            throw new RuntimeException(id+" Vehicle Id Does Not Exists !! ");
        }
      return dataConverter.bookEntityTobookDTO(bookRepo.findById(id).get());
    }

    @Override
    public List<BookDTO> getAll() {
        return dataConverter.bookEntityListTobookDTOList(bookRepo.findAll());
    }
}
