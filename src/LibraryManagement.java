import entities.Library;
import factory.BookFactory;
import factory.MemberFactory;

public class LibraryManagement {

    public static void main(String[] args) {

        Library library = new Library();

        //Adding Books
        library.addBook(BookFactory.createBook(1, "Java Fundamentals", "John Dee", "Available", 2));
        library.addBook(BookFactory.createBook(2, "Advanced Java", "Jane Smith", "Borrowed", 1));
        library.addBook(BookFactory.createBook(3, "Data Structures and Algorithms", "John Smith", "Available", 3));

        //Registering Members
        library.registrarMember(MemberFactory.createMember(1, "Alice"));
        library.registrarMember(MemberFactory.createMember(2, "Bob Smith"));

        //Borrow Book
        library.borrowBook(1, 3);
        //Return Book
        library.returnBook(1, 2);

        //Check Book availability
        library.isBookAvailable(2);

        //Books Member is holding
        library.booksMemberHolding(1);

        //Rate book
        library.rateBook(1, 4);
    }
}
