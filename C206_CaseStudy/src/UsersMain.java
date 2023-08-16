
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22037707, Aug 11, 2023 7:07:01 PM
 */

import java.util.ArrayList;

public class UsersMain {
	public static ArrayList<User> userList = new ArrayList<User>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		userList.add(new User("Alice", "Student", false, "22023303"));
		userList.add(new User("Bob", "Admin", true, "22013456"));
		userList.add(new User("Charli", "Student", false, "22347890"));
		userList.add(new User("Dave", "Student", false, "21034675"));

		currMenu();
		int subOpt = Helper.readInt("Please choose an option: ");
		while (subOpt != 6) {
			switch (subOpt) {
			case 1:
				viewAllUser(userList);
				break;
			case 2:
				addUser(userList, getUser(1, userList));
				break;
			case 3:
				editUser(userList);
				break;
			case 4:
				deleteUser(userList, getUser(2, userList));
				break;
			default:
				System.out.println("Invalid choice entered");
				break;
			}
			userMenu();
			subOpt = Helper.readInt("Please choose an option: ");
		}

		System.out.println("Exited");
	}
}

	public static void userMenu() {
		System.out.println("1. View all Users");
		System.out.println("2. Add a new User");
		System.out.println("3. Edit an existing Usr");
		System.out.println("4. Delete an existing User");
		System.out.println("6. Exit");
		System.out.println(" ");
	}

	public static void addUser(ArrayList<User> userList, User user) {
		if (user != null) {
			userList.add(user);
			System.out.println("User successfully added");
		} else {
			System.out.println("User unable to add.");
		}
	}

	public static void editUser(ArrayList<User> userList) {
		String userId = Helper.readString("Enter the user ID of the user you want to edit: ");
		boolean found = false;

		for (User user : userList) {
			if (user.getUserId().equalsIgnoreCase(userId)) {
				found = true;
				boolean admin = true;
				String newName = Helper.readString("Enter new name: ");
				String newRole = Helper.readString("Enter new role: ");
				char newAdminStatus = Helper.readChar("Is the user an admin? (Y/N): ");

				user.setName(newName);
				user.setRole(newRole);
				user.setAdmin(newAdminStatus);

				System.out.println("User " + userId + " details updated.");
				break;
			}
		}

		if (!found) {
			System.out.println("User not found.");
		}
	}



	public static void deleteUser(ArrayList<User> userList, User user) {
		if (user != null) {
			userList.remove(user);
			System.out.println(user.getName() + " successfully deleted.");
		} else {
			System.out.println("User not found.");
		}
	}

	public static User getUser(int function, ArrayList<User> userList) {
		User user = null;
		if (function == 1) {
			String name = Helper.readString("Enter user's name: ");
			String role = Helper.readString("Enter user's role: ");
			boolean admin = Helper.readBoolean("Is the user an admin? (true/false): ");
			String userId = Helper.readString("Enter user's ID: ");
			user = new User(name, role, admin, userId);
		} else if (function == 2) {
			boolean found = false;
			String userId = Helper.readString("Enter user ID to delete: ");
			for (User existingUser : userList) {
				if (existingUser.getUserId().equalsIgnoreCase(userId)) {
					user = existingUser;
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("User not found.");
			}
		}

		return user;
	}

	public static void viewAllUser(ArrayList<User> userList) {
		String output = String.format("%-15s %-15s %-10s %-15s\n", "NAME", "ROLE", "ADMIN", "USER ID");

		for (User user : userList) {
			String adminStatus = user.isAdmin() ? "Yes" : "No";
			output += String.format("%-15s %-15s %-10s %-15s\n", user.getName(), user.getRole(), adminStatus, user.getUserId());
		}

		System.out.println(output);
	}

}
