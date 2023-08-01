package app;

import java.util.ArrayList;
import java.util.List;

public class Library {

	BookDB db;
	
	public Library(BookDB db)
	{
		this.db= db;
	}
	
	public List<Book> getBooksByCetegory(String category)
	{
		if(category.equals("Fiction"))
		{
			return db.getFictionBooks();
		}
		else
			return null;
	}
}
