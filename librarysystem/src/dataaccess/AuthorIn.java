package dataaccess;

import business.models.Author;

public interface AuthorIn {

	public void addAuthor(Author currentUser);
	public void editAuthor(Author currentUser);
	public Author searchAuthor(String requestId);
	public void deleteAuthor(int index);
}
