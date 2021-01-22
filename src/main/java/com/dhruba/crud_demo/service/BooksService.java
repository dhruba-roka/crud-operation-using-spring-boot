package com.dhruba.crud_demo.service;

import com.dhruba.crud_demo.model.Books;
import com.dhruba.crud_demo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//defining the business logic
@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    //getting all books record by using the method findaAll() of CrudRepository
    public List<Books> listAll()
    {
      return (List<Books>) booksRepository.findAll();
    }

    //creating a specific record by using the method save() of CrudRepository
    public void save(Books books)
    {
        booksRepository.save(books);
    }

    //update
    public Books get(int bookid){
        return booksRepository.findById(bookid).get();
    }

    //delete
    public void delete(int bookid){
        booksRepository.deleteById(bookid);
    }


}
