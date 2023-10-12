package seminars.fourth.book;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookService bookService = new BookService(bookRepositoryMock);
    Book book1 = new Book("1", "title1", "author1");
    Book book2 = new Book("2", "title2", "author2");
    List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2));
    @BeforeEach
    @Test
    public void BookServiceFindAllTest() {

        when(bookRepositoryMock.findAll()).thenReturn(bookList);
        assertEquals(bookService.findAllBooks(), bookList);

    }

    @Test
    public void BookServiceFindByIdTest() {
        String idBook = "2";

        when(bookRepositoryMock.findById(idBook)).thenReturn(bookList.get(Integer.parseInt(idBook) - 1));
        assertEquals(bookService.findBookById(idBook), book2);

    }


}