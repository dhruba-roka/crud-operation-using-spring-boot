package com.dhruba.crud_demo.repository;

import com.dhruba.crud_demo.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer> {
}
