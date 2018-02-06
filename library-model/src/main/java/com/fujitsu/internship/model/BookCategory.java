package com.fujitsu.internship.model;

public class BookCategory {
    private String name;

    public BookCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return '{' + name + '}';
    }
}
