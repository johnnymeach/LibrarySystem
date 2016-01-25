package dataaccess;

import business.models.Book;

public interface BookIn {

	public void addBook(Book currentUser);
	public Book searchBook(String requestId);
//	public void editBook(Book currentUser);
//	public void deleteBook(int index);
}
