package dataaccess;

import business.models.LibraryMember;

public interface LibraryMemberIn {

	public void addLibraryMember(LibraryMember currentMember);

	public void editLibraryMember(LibraryMember currentMember);

	public LibraryMember searchLibraryMember(String requestId);

	public void deleteLibraryMember(int index);
}
