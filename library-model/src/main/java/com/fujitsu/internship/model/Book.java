package com.fujitsu.internship.model;

/**
 * This class is Book object.
 *
 * @author Filipp Zaripov
 */
public class Book {
    /**
     * Field for book name
     */
    private String name;
    /**
     * Field for book id
     */
    private long id;
    /**
     * Field for book category name
     */
    private String categoryName;

    /**
     * Constructor that creates Book object
     *
     * @param name          Name of the Book
     * @param categoryName Category of the Book
     */
    public Book(String name, String categoryName) {
        setName(name);
        setCategoryName(categoryName);
    }

    /**
     * Constructor that creates Book object
     *
     * @param id            id of the Book
     * @param name          Name of the Book
     * @param categoryName Category of the Book
     */
    public Book(long id, String name, String categoryName) {
        setId(id);
        setName(name);
        setCategoryName(categoryName);
    }

    /**
     * Method returns name of the Book
     *
     * @return name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the book
     *
     * @param name Name of the book that should be changed
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get id of the Book
     *
     * @return id of the Book
     */
    public long getId() {
        return id;
    }

    /**
     * Set id of the Book
     *
     * @param id id of the book that should be changed
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Shows name of the category of book
     *
     * @return name of the category
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * change name of the category of book
     *
     * @param categoryName name of the category that should be set for Book
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return
                "id='" + id + "', " +
                        "name='" + name + '\'' +
                        ", categoryName='" + categoryName + '\'' ;
    }
}

