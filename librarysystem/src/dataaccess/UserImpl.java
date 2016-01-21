package dataaccess;

import java.util.List;
import business.models.User;


public class UserImpl extends DataAccess implements UserIn {

	@Override
	public void deleteUser(int index)
	{
		List<User> allUser = getAllItems();
		allUser.remove(index);
		save(allUser);
        	}
	
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
	// get user by ID 

	@Override
	public User getUser(String requestId) {
		User returnResult = null;
		List<User> allUser = getAllItems();
		for(User user:allUser){
			if(user.getUserID().toString().equals(requestId)){
				returnResult = user;
			}else{
				returnResult = null;
			}
		}
		
		return returnResult;
		
	}

	public void addUser(User user) {
		List<User> allUser = getAllItems();
		allUser.add(user);
		save(allUser);
	}
	
	
}
