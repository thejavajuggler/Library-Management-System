package entities;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private int id;

    private String name;

    private List<Integer> bookBorrowedIds;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.bookBorrowedIds = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getBookBorrowedIds() {
        return bookBorrowedIds;
    }

    public void setBookBorrowedIds(List<Integer> bookBorrowedIds) {
        this.bookBorrowedIds = bookBorrowedIds;
    }

    public void borrowBook(int bookId) {
        bookBorrowedIds.add(bookId);
    }

    public void returnBook(int bookId) {
        bookBorrowedIds.remove(bookId);
    }
}
