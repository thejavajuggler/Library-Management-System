package factory;

import entities.Book;

public class BookFactory {

    public static Book createBook(int id, String title, String author, String status, int copies) {
        return new Book(id, title, author, status, copies);
    }
}
