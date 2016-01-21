package dataaccess;

import business.models.User;

public interface UserIn {

	public void addUser(User currentUser);
	public void editUser(User currentUser);
	public User searchtUser(String requestId);
	public void deleteUser(int index);
}
