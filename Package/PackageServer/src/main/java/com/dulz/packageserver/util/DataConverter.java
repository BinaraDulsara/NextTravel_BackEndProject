package com.dulz.packageserver.util;

import com.dulz.packageserver.dto.BookDTO;
import com.dulz.packageserver.dto.PackageDTO;
import com.dulz.packageserver.entity.BookEntity;
import com.dulz.packageserver.entity.PackageEntity;
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

    public BookEntity bookDTOToBookEntity(BookDTO bookDTO){
        return modelMapper.map(bookDTO, BookEntity.class);
    }

    public BookDTO bookEntityTobookDTO(BookEntity bookEntity){
        return modelMapper.map(bookEntity, BookDTO.class);
    }

    public List<BookDTO> bookEntityListTobookDTOList(List<BookEntity> books){
        return modelMapper.map(books,new TypeToken<List<BookDTO>>(){}.getType());
    }

}
