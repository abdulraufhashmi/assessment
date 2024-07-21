package com.aeon.assessment.library.book.repository;

import com.aeon.assessment.library.book.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity,Long> {
}
