package dataaccess;

import business.models.User;

public interface UserIn {

	public void addUser(User currentUser);
	public void editUser(User currentUser);
	public User searchUser(String requestId);
	public void deleteUser(int index);
}
