package dataaccess;

import java.util.List;

import business.models.Book;

public class BookImpl extends DataAccess implements BookIn {

	// Search book by ISBN
	@Override
	public Book searchBook(String requestId) {
		List<Book> allBook = getAllItems();
		for (Book book : allBook) {
			if (book.getISBN().toString().equals(requestId)) {
				return book;
			}
		}

		return null;

	}

	@Override
	public void addBook(Book book) {
		List<Book> allBook = getAllItems();
		allBook.add(book);
		save(allBook);
	}

}
