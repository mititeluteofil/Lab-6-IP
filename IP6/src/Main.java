public class Main {
    public static void main(String[] args) {
        Library library=new Library();
        Book book = new Book("testTitle", "testAuthor");
        Book book2 = new Book("test","test");
        library.addNewBook(book);
        System.out.println(library.getInventory());

        Librarian librarian= new Librarian(library);

        Reader reader = new Reader(librarian);

        reader.rentBook(book);
        reader.returnBook(book);

        reader.rentBook(book2);
    }
}
