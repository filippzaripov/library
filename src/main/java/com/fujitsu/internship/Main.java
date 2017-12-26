package com.fujitsu.internship;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        PostgreSQLBookDAO booksDB = new PostgreSQLBookDAO();
        try{
            System.out.println(booksDB.getBook(2));
            System.out.println(booksDB.getAll());
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
