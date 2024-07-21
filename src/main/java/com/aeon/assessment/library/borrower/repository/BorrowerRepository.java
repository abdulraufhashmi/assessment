package com.aeon.assessment.library.borrower.repository;

import com.aeon.assessment.library.borrower.entity.BorrowerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends CrudRepository<BorrowerEntity,Long> {
}
