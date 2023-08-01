package app;

import java.util.Objects;

public class Book {
	private int isbn;
	private String title;
	private String category;
	public Book(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}
	
	public int getIsbn()
	{
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, isbn, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(category, other.category) && isbn == other.isbn && Objects.equals(title, other.title);
	}
	
	
	
}
