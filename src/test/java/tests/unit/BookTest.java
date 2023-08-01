package tests.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import app.Book;
import app.BookDB;
import app.Library;

public class BookTest {

	@Test
	public void test() {
		//Mock object
		BookDB db = Mockito.mock(BookDB.class);
		Library lib = new Library(db);
		List<Book> fictionBooks = new ArrayList<>();
		Book book1 = new Book("abc", "Fiction");
		Book book2 = new Book("xyx", "Fiction");
		fictionBooks.add(book1);
		fictionBooks.add(book2);
		
		//Stub
		when(db.getFictionBooks()).thenReturn(fictionBooks);
		List<Book> actlist = lib.getBooksByCetegory("Fiction");
		assertEquals(fictionBooks, actlist);
	}

}
