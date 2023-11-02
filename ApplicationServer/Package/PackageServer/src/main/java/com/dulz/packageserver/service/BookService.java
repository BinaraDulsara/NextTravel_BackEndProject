package com.dulz.packageserver.service;

import com.dulz.packageserver.dto.BookDTO;
import com.dulz.packageserver.dto.BookGetDTO;

import java.util.List;

public interface BookService {

    void saveBook(BookDTO bookDTO);

    void updateBook(BookDTO bookDTO);

    void deleteBook(String id);

    BookGetDTO findById(String id);

    List<BookGetDTO>getAll();

    String getLastIndex();
    BookGetDTO getBookingByUserId(String userId);

    List<BookGetDTO> getBookingsByUserId(String userId);
    int getCountOfPackage();
    boolean isValidToUpdate(String bookingId);


}
