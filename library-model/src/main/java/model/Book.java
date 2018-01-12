package model;

/**
 * This class is Book object.
 * @author Filipp Zaripov
 *
 */
public class Book {
    /** Field for book name */
    private String name;
    /** Field for book id */
    private long id;
    /** Field for book category name */
    private String category_name;

    /**
     * Constructor that creates Book object
     * @param name Name of the Book
     * @param category_name Category of the Book
     */
    public Book(String name, String category_name){
        setName(name);
        setCategory_name(category_name);
    }

    /**
     * Constructor that creates Book object
     * @param id id of the Book
     * @param name Name of the Book
     * @param category_name Category of the Book
     */
    public Book(long id, String name, String category_name){
        setId(id);
        setName(name);
        setCategory_name(category_name);
    }

    /**
     * Method returns name of the Book
     * @return name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the book
     * @param name Name of the book that should be changed
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get id of the Book
     * @return id of the Book
     */
    public long getId() {
        return id;
    }

    /**
     * Set id of the Book
     * @param id id of the book that should be changed
     */
    public void setId(long id){
        this.id = id;
    }

    /**
     * Shows name of the category of book
     * @return name of the category
     */
    public String getCategory_name() {
        return category_name;
    }
    /**
     * change name of the category of book
     * @param category_name name of the category that should be set for Book
     */
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return
                "id=" + id + ", " +
                "name='" + name + '\'' +
                ", category_name='" + category_name + '\'' + " | ";
    }
}

