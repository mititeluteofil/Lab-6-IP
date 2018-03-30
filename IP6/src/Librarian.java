import java.util.HashMap;
import java.util.Map;

public class Librarian {
    private Map<Book, Reader> rentingList;
    private Library library;

    public Librarian(Library library) {
        this.rentingList = new HashMap<>();
        this.library=library;
    }

    public void rentBook(Book book, Reader reader){
        try{
            library.rentBook(book);
            rentingList.put(book,reader);
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
    public void returnBook(Book book, Reader reader){
        rentingList.remove(book);
        library.returnBook(book);
    }
}
