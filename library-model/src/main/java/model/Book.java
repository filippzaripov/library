package model;

/**
 * This class is Book object.
 * @author Filipp Zaripov
 *
 */
public class Book {
    /** Field for book name */
    private String name;
    /** Field for book ID */
    private long ID;
    /** Field for book category name */
    public String category_name;

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
     * @param ID ID of the Book
     * @param name Name of the Book
     * @param category_name Category of the Book
     */
    public Book(long ID, String name, String category_name){
        setID(ID);
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
     * Get ID of the Book
     * @return ID of the Book
     */
    public long getID() {
        return ID;
    }

    /**
     * Set ID of the Book
     * @param ID ID of the book that should be changed
     */
    public void setID(long ID){
        this.ID = ID;
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
        return "model.Book{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}

