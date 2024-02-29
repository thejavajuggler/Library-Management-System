package entities;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registrarMember(Member member) {
        members.add(member);
    }

    public void borrowBook(int memberId, int bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member != null && book != null && book.getStatus().equalsIgnoreCase("Available")) {
            book.setStatus("Borrowed");
            member.borrowBook(bookId);
            System.out.println(bookId + " is borrowed by: "+ member.getName());
        }
        else {
            System.out.println("Book cannot be borrowed");
        }
    }

    public void returnBook(int memberId, int bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);
        if (member != null && book != null
                && book.getStatus().equalsIgnoreCase("Borrowed")
                && member.getBookBorrowedIds().contains(bookId)) {
            book.setStatus("Available");
            member.returnBook(bookId);
            System.out.println("Book " + bookId + " is available");
        }
        else {
            System.out.println("Book cannot be returned");
        }
    }

    public void isBookAvailable(int bookId) {
        Book book = findBook(bookId);
        if (book != null) {
            System.out.println("Book " + bookId + " is " + book.getStatus());
        }
        else {
            System.out.println("Book is not found");
        }
    }

    public void booksMemberHolding(int memberId) {
        Member member = findMember(memberId);
        if (member != null) {
            List<String> borrowedBooks = new ArrayList<>();
            List<Integer> bookBorrowedIds = member.getBookBorrowedIds();
            for (int bookId: bookBorrowedIds) {
                Book book = findBook(bookId);
                if (null != book) {
                    borrowedBooks.add(book.getTitle());
                }
            }
            System.out.println("Books borrowed by " + memberId + " " + borrowedBooks);
        }
        else
            System.out.println("Member not found");
    }

    private Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId)
                return book;
        }
        return null;
    }

    private Member findMember(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId)
                return member;
        }
        return null;
    }

    public void  rateBook(int bookId, int ratings) {
        Book book = findBook(bookId);

        if (book != null && book.getStatus().equalsIgnoreCase("Available")) {
            book.updateRating(ratings);
            System.out.println("Book " + bookId + " is successfully rated with rating: " + ratings);
        }
        else {
            System.out.println("Book not found");
        }
    }
}
