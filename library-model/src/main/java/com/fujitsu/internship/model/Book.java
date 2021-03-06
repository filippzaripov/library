package com.fujitsu.internship.model;

/**
 * Book object.
 *
 * @author Filipp Zaripov
 */
public class Book {
    /**
     * book name
     */
    private String name;
    /**
     * book id
     */
    private Long id;
    /**
     * category name
     */
    private BookCategory category;
    /**
     * author of the book
     */
    private Author author;

    public Book() {

    }

    public Book(String name, BookCategory category) {
        this.name = name;
        this.category = category;
    }

    public Book(long id, String name, BookCategory category) {
        this.name = name;
        this.id = id;
        this.category = category;
    }

    public Book(String name, BookCategory category, Author author) {
        this.name = name;
        this.category = category;
        this.author = author;
    }

    public Book(long id, String name, BookCategory category, Author author) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.author = author;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return
                "id='" + id + "', " +
                        "name='" + name + '\'' +
                        ", category='" + category.toString() + '\'';
    }
}

