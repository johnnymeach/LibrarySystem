package dataaccess;

import business.models.User;

public interface LibraryMemberIn {

	public void addLibraryMember(User currentMember);
	public void editLibraryMember(User currentMember);
	public User searchLibraryMember(String requestId);
	public void deleteLibraryMember(int index);
}
