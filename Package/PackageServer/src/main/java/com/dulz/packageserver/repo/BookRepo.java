package com.dulz.packageserver.repo;

import com.dulz.packageserver.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity,String> {
}
