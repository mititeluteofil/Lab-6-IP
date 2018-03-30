import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    private final String EXPECTED_INVENTORY = "{Book{title='testTitle', author='testAuthor'}=true}";
    private Book book = new Book("testTitle", "testAuthor");
    private Book phantomBook = new Book("test", "test");
    private Library sut;

    @Before
    public void init() {
        this.sut = new Library();
    }

    @Test(expected = IllegalStateException.class)
    public void Given_Library_When_RentingBookTwice_Then_ShouldReturnError() {
        sut.addNewBook(book);
        sut.rentBook(book);
        sut.rentBook(book);
    }

    @Test(expected = IllegalStateException.class)
    public void Given_Library_When_RentingBookThatDoesNotExist_Then_ShouldReturnError() {
        sut.addNewBook(book);
        sut.rentBook(phantomBook);
    }

    @Test
    public void Given_Library_When_AddNewBook_Then_ItShouldBeAvailable() {
        sut.addNewBook(book);
        assertTrue(sut.getAvailability(book));
    }

    @Test
    public void Given_Library_When_ReturnBook_Then_ShouldBeAvailable() {
        sut.addNewBook(book);
        sut.returnBook(book);
        assertTrue(sut.getAvailability(book));
    }

    @Test
    public void Given_Library_When_GettingInventory_Then_ShouldReturnString() {
        sut.addNewBook(book);
        assertEquals(EXPECTED_INVENTORY, sut.getInventory());
    }
}