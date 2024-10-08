package com.javatpoint.model;
import javax.persistence.*;

//mark class as an Entity
@Entity
@Table(name = "BOOKS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "BOOK_SEQ", allocationSize = 1)
    @Column
    private int bookid;

    @Column
    private String bookname;
    @Column
    private String author;
    @Column
    private int price;
    @Column
    private String worthy;

    public int getBookid()
    {
        return bookid;
    }
    public void setBookid(int bookid)
    {
        this.bookid = bookid;
    }
    public String getBookname()
    {
        return bookname;
    }
    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getWorthy() {
        return worthy;
    }

    public void setWorthy(String worthy) {
        this.worthy = worthy;
    }

    public Books(){
    }

    public Books(int bookid, String bookname, String author, int price, String worthy) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.worthy = worthy;
    }
}