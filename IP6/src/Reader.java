import java.util.ArrayList;

public class Reader {

    private String rentedBooks;
    private String Name;
    private String ID;
    private ArrayList<Book> myBooks;
    private Librarian boss;

    public String getBooks() {
        rentedBooks = "";
        for (Book book : myBooks) {
            rentedBooks += book.getTitle();
        }
        return rentedBooks;
    }

    public void rentBook(Book myBook){
        try{
            boss.rentBook(myBook, this);
        }
        catch(IllegalStateException e) {
            System.out.println("Cartea nu este disponibila!");
        }

        myBooks.add(myBook);
    }

    public void returnBook(Book myBook) throws IllegalStateException{
        boss.returnBook(myBook, this);
//        int i;
//        for(i=0; i<myBooks.size(); i++){
//            if(myBooks.get(i).getTitle() == myBook.getTitle()){
//                myBooks.remove(i);
//                break;
//            }
//        }
//        if(i == myBooks.size())
//            throw new IllegalStateException();
    }

    public Reader(Librarian boss){
        myBooks = new ArrayList<Book>();
        this.boss = boss;
    }
}
