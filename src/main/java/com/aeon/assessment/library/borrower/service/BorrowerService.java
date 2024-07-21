package com.aeon.assessment.library.borrower.service;

import com.aeon.assessment.library.book.entity.BookEntity;
import com.aeon.assessment.library.borrower.entity.BorrowerEntity;
import com.aeon.assessment.library.borrower.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository repository;

    public BorrowerEntity addBorrower(BorrowerEntity borrower){
        return repository.save(borrower);
    }
}
