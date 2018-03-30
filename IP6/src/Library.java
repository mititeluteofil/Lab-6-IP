import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<Book, Boolean> inventory;


    public Library() {
        this.inventory = new HashMap<>();
    }

    public void addBooks(List<Book> bookList){
        for (Book book :
                bookList) {
            inventory.put(book, true);
        }
    }

    public String getInventory() {
        return inventory.toString();
    }

    public void addNewBook(Book book) {
        this.inventory.put(book, true);
    }

    public void rentBook(Book book) {
        if(this.inventory.containsKey(book)){
            if(this.inventory.get(book)){
                inventory.replace(book, false);
            }
            else{
                throw new IllegalStateException("The book is already rented");
            }
        }
        else throw new IllegalStateException("The book does not exist");

    }

    public Boolean getAvailability(Book book){
        return this.inventory.get(book);
    }

    public void returnBook(Book book){
        this.inventory.replace(book,true);
    }



}
