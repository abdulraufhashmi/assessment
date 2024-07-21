package com.aeon.assessment.library.borrower.controller;

import com.aeon.assessment.library.book.entity.BookEntity;
import com.aeon.assessment.library.borrower.entity.BorrowerEntity;
import com.aeon.assessment.library.borrower.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("library/borrower")
public class BorrowerController {
    @Autowired
    private BorrowerService borrowerService;
    @PostMapping("add")
    public BorrowerEntity addBorrower(@RequestBody()BorrowerEntity borrower){
        return borrowerService.addBorrower(borrower);
    }


}
