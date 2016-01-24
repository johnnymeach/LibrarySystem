package dataaccess;

import java.util.List;

import business.models.Author;

public class AuthorImpl extends DataAccess implements AuthorIn{

	@Override
	public void addAuthor(Author newAuthor) {
		List<Author> allAuthor = getAllItems();
		allAuthor.add(newAuthor);
		save(allAuthor);
		
	}

	@Override
	public void editAuthor(Author currentUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Author searchAuthor(String requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAuthor(int index) {
		// TODO Auto-generated method stub
		
	}

}
