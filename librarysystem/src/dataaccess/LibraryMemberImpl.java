package dataaccess;

import java.util.List;

import business.models.LibraryMember;

public class LibraryMemberImpl extends DataAccess implements LibraryMemberIn {

	@Override
	public void addLibraryMember(LibraryMember newLibraryMember) {
		List<LibraryMember> allLibraryMember = getAllItems();
		allLibraryMember.add(newLibraryMember);
		save(allLibraryMember);

	}

	@Override
	public void editLibraryMember(LibraryMember currentMember) {
		List<LibraryMember> allLibraryMember = getAllItems();

		for (int i = 0; i < allLibraryMember.size(); i++) {
			if (allLibraryMember.get(i).getMemberId().equals(currentMember.getMemberId())) {
				allLibraryMember.remove(i);
				allLibraryMember.add(i, currentMember);
			}
		}

		save(allLibraryMember);
	}

	@Override
	public LibraryMember searchLibraryMember(String requestId) {
		List<LibraryMember> allLibraryMember = getAllItems();
		for (LibraryMember member : allLibraryMember) {
			if (member.getMemberId().toString().equals(requestId)) {
				return member;
			}
		}

		return null;
	}

	@Override
	public void deleteLibraryMember(int index) {
		List<LibraryMember> allLibraryMember = getAllItems();
		allLibraryMember.remove(index);
		save(allLibraryMember);
	}

}
