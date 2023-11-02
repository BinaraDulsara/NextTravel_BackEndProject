package com.dulz.packageserver.service;

import com.dulz.packageserver.dto.BookDTO;
import com.dulz.packageserver.dto.BookGetDTO;
import com.dulz.packageserver.dto.PackageDTO;
import com.dulz.packageserver.repo.BookRepo;
import com.dulz.packageserver.util.DataConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional

public class BookServiceIMPL implements BookService {

    @Autowired
    DataConverter dataConverter;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    PackageService packageService;

    @Override
    public void saveBook(BookDTO bookDTO) {
        if (bookRepo.existsById(bookDTO.getBookingId())){
            throw new RuntimeException(bookDTO.getBookingId()+" Book Id Already Exists !!");
        }

        PackageDTO packageDTO = packageService.findById(bookDTO.getPackageId());
        bookRepo.save(dataConverter.bookDTOToBookEntity(bookDTO , packageDTO));

    }


    @Override
    public void updateBook(BookDTO bookDTO) {
        if (!bookRepo.existsById(bookDTO.getBookingId())){
            throw new RuntimeException(bookDTO.getBookingId()+" Book Does Not Exists !! ");
        }
      PackageDTO packageDTO = packageService.findById(bookDTO.getPackageId());
      bookRepo.save(dataConverter.bookDTOToBookEntity(bookDTO , packageDTO));

    }

    @Override
    public void deleteBook(String id) {
        if (!bookRepo.existsById(id)){
            throw new RuntimeException(id+" Book Does Not Exists !! ");
        }
        bookRepo.deleteById(id);
    }

    @Override
    public BookGetDTO findById(String id) {
        if (!bookRepo.existsById(id)){
            throw new RuntimeException(id+" Book Does Not Exists !! ");
        }
        return dataConverter.bookEntityToBookGetDTO(bookRepo.findById(id).get());
    }

    @Override
    public List<BookGetDTO> getAll() {
        return dataConverter.bookEntityListToBookGetDTOList(bookRepo.findAll());
    }

    @Override
    public String getLastIndex() {
        return bookRepo.getLastIndex();
    }

    @Override
    public BookGetDTO getBookingByUserId(String userId) {
      //  return dataConverter.bookingEntityToBookingGetDto(bookingREPO.findBookingByUserId(userId));
        return dataConverter.bookEntityToBookGetDTO(bookRepo.findBookingByUserId(userId));
    }

    @Override
    public List<BookGetDTO> getBookingsByUserId(String userId) {
       // return dataConverter.bookEntityListToBookGetDTOList(bookRepo.findBookingsByUserId(userId));
            return dataConverter.bookEntityListToBookGetDTOList(bookRepo.findBookingsByUserId(userId));

    }

    @Override
    public int getCountOfPackage() {
        return bookRepo.getCountOfBookings();
    }

    @Override
    public boolean isValidToUpdate(String bookingId) {
        return findById(bookingId).getCurrentlyDate().plusDays(3).isBefore(LocalDate.now());
    }
}
