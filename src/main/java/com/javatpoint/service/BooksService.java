package com.javatpoint.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;
//defining the business logic
@Service
public class BooksService
{
    @Autowired
    BooksRepository booksRepository;
    //getting all books record by using the method findaAll() of CrudRepository
    public List<Books> getAllBooks()
    {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Books getBooksById(int id)
    {
        return booksRepository.findById(id).get(id);
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Books books)
    {
        booksRepository.save(books);
    }
    public List<Books> getBooksByName(String bookname){
        return booksRepository.findByBookname(bookname);
    }

    public List<Books> getBooksByAuthor(String author){
        return booksRepository.findByAuthor(author);
    }



    public void update(Books books){
        int id = books.getBookid();
        Books books1 = booksRepository.findById(id).get(id);
        books1.setWorthy(books.getWorthy());
        books1.setAuthor(books.getAuthor());
        books1.setBookname(books.getBookname());
        books1.setPrice(books.getPrice());
        booksRepository.save(books1);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        booksRepository.deleteById(id);
    }
    //Get sum all prices
    public int getSumOfPrices(){
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(books1 -> books.add(books1));
        int total =0;
        for(Books books1:books){
            int total1 = books1.getPrice();
            total = total+total1;
        }

        return total;
    }
}