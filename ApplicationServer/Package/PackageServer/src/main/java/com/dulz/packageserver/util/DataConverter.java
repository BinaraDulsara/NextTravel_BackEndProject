package com.dulz.packageserver.util;

import com.dulz.packageserver.dto.BookDTO;
import com.dulz.packageserver.dto.BookGetDTO;
import com.dulz.packageserver.dto.PackageDTO;
import com.dulz.packageserver.dto.PaymentDTO;
import com.dulz.packageserver.entity.BookEntity;
import com.dulz.packageserver.entity.PackageEntity;
import com.dulz.packageserver.entity.PaymentEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataConverter {

    @Autowired
    ModelMapper modelMapper;

    public PackageEntity packageDTOToPackageEntity(PackageDTO packageDTO){
        return modelMapper.map(packageDTO, PackageEntity.class);
    }
    public PackageDTO packageEntityToPackageDTO(PackageEntity packageEntity){
        return modelMapper.map(packageEntity, PackageDTO.class);
    }
    public List<PackageDTO> packageEntityListToPackageDTOList(List<PackageEntity> packages){
        return modelMapper.map(packages,new TypeToken<List<PackageDTO>>(){}.getType());
    }


    public BookEntity bookDTOToBookEntity(BookDTO bookDTO , PackageDTO packageDTO){
        PackageEntity aPackage = packageDTOToPackageEntity(packageDTO);
        BookEntity bookEntity = modelMapper.map(bookDTO,BookEntity.class);
        bookEntity.setAPackage(aPackage);
        return bookEntity;
         }

    public BookGetDTO bookEntityToBookGetDTO(BookEntity bookEntity){

        BookGetDTO bookGetDTO = modelMapper.map(bookEntity, BookGetDTO.class);
        bookGetDTO.setPackageDTO(packageEntityToPackageDTO(bookEntity.getAPackage()));
        return bookGetDTO;
    }

    public List<BookGetDTO> bookEntityListToBookGetDTOList(List<BookEntity> books){
        return modelMapper.map(books,new TypeToken<List<BookDTO>>(){}.getType());
    }


    public PaymentEntity paymentDtoToPaymentEntity(PaymentDTO paymentDTO) {
        return modelMapper.map(paymentDTO,PaymentEntity.class);
    }
    public PaymentDTO paymentEntityToPaymentDto(PaymentEntity payment) {
        return modelMapper.map(payment,PaymentDTO.class);
    }
    public List<PaymentDTO> paymentEntityListToPaymentDTOList(List<PaymentEntity> payments){
        return modelMapper.map(payments,new TypeToken<List<PaymentDTO>>(){}.getType());
    }
}
