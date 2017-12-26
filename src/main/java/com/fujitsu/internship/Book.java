package com.fujitsu.internship;

public class Book {

    public String name;
    public long ID;



    public String category_name;

    public Book(String name, String category_name){
        setName(name);
        setCategory_name(category_name);
    }
    public Book(Long ID, String name, String category_name){
        setID(ID);
        setName(name);
        setCategory_name(category_name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID){
        this.ID = ID;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}

