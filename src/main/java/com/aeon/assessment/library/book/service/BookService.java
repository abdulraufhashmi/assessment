package com.aeon.assessment.library.book.service;

import com.aeon.assessment.library.book.dto.BookDTO;
import com.aeon.assessment.library.book.entity.BookEntity;
import com.aeon.assessment.library.book.repository.BookRepository;
import com.aeon.assessment.library.borrower.entity.BorrowerEntity;
import com.aeon.assessment.library.borrower.repository.BorrowerRepository;
import com.aeon.assessment.library.common.error.DataNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookRepository repository;
    @Autowired
    private BorrowerRepository borrowerRepository;
    public BookDTO borrowBook(Long id,Long borrower){
        Optional<BookEntity> bookEntityOptional = repository.findById(id);
        if (bookEntityOptional.isPresent()){
            BookEntity book = bookEntityOptional.get();
            if (book.getIsBorrowed()
                    || ObjectUtils.isEmpty(book.getBorrowerEntity())){
                throw new DataNotFoundException("All book copies are borrowed");
            }
            book.setIsBorrowed(Boolean.TRUE);
            Optional<BorrowerEntity> borrowerEntity = borrowerRepository.findById(borrower);
            if (borrowerEntity.isEmpty()){
                throw new DataNotFoundException("Borrower not found!");
            }
            book.setBorrowerEntity(borrowerEntity.get());
            return modelMapper.map(repository.save(book),BookDTO.class);

        }
        throw new DataNotFoundException("Book not found");
    }

    public BookDTO addBook(BookEntity book){
        return modelMapper.map(repository.save(book),BookDTO.class);
    }

    public BookDTO returnBook(Long id) {
        Optional<BookEntity> bookEntityOptional = repository.findById(id);
        if (bookEntityOptional.isPresent()){
            BookEntity book = bookEntityOptional.get();
            book.setIsBorrowed(Boolean.FALSE);
            book.setBorrowerEntity(null);
            return modelMapper.map(repository.save(book),BookDTO.class);

        }
        throw new DataNotFoundException("Book not found");
    }
    public List<BookDTO> getAllBooks(){
        List<BookDTO> bookDTOS = new ArrayList<>();
        repository.findAll().forEach(book -> {
            bookDTOS.add(modelMapper.map(book,BookDTO.class));
        });
        return bookDTOS;
    }
}
