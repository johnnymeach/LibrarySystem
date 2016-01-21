package dataaccess;

import java.util.List;
import business.models.User;

public class UserImpl extends DataAccess implements UserIn {

	@Override
	public void editUser(User currentUser) {
		List<User> allUser = getAllItems();

		for (int i = 0; i < allUser.size(); i++) {
			if (allUser.get(i).getUserID().equals(currentUser.getUserID())) {
				allUser.remove(i);
				allUser.add(i, currentUser);
			}
		}

		save(allUser);
	}
	
	//Search user by ID
	@Override
	public User searchUser(String requestId) {
		List<User> allUser = getAllItems();
		for (User user : allUser) {
			if (user.getUserID().toString().equals(requestId)) {
				return user;
			}
		}

		return null;

	}

	public void addUser(User user) {
		List<User> allUser = getAllItems();
		allUser.add(user);
		save(allUser);
	}
	
	@Override
	public void deleteUser(int index) {
		List<User> allUser = getAllItems();
		allUser.remove(index);
		save(allUser);
	}

}
