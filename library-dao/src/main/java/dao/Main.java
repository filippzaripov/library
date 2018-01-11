package dao;

import dao.pg.PostgreSQLBookDAO;

public class Main {


    public static void main(String[] args) {
        BookDAO bookDAO = new PostgreSQLBookDAO();
        System.out.println(bookDAO.getAll());
    }

}
