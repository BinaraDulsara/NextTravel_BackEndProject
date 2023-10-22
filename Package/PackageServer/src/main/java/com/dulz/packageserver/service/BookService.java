package com.dulz.packageserver.service;

import com.dulz.packageserver.dto.BookDTO;

import java.util.List;

public interface BookService {

    void saveBook(BookDTO bookDTO);

    void updateBook(BookDTO bookDTO);

    void deleteBook(String id);

    BookDTO findById(String id);

    List<BookDTO>getAll();




}
