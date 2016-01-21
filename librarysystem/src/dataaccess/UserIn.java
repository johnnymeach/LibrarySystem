package dataaccess;

import business.models.User;

public interface UserIn {

	public void deleteUser(int index);
	public void addUser(User currentUser);
	public void editUser(User currentUser);
	public User getUser(String requestId);
}
