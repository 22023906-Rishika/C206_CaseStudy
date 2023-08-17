import java.util.ArrayList;

public class UsersMain {

	public static ArrayList<Users> userList = new ArrayList<Users>();

		// TODO Auto-generated method stub



    public static void main(String[] args) {
        initializeUserList();

        userMenu();
        int subOpt = Helper.readInt("Please choose an option: ");
        while (subOpt != 6) {
            switch (subOpt) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    editUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                default:
                    System.out.println("Invalid choice entered");
                    break;
            }
            userMenu();
            subOpt = Helper.readInt("Please choose an option: ");
        }

<<<<<<< HEAD
		userMenu();
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


    private static void initializeUserList() {
        userList.add(new User("Alice", "Student", false, "22023303"));
        userList.add(new User("Bob", "Admin", true, "22013456"));
        userList.add(new User("Charli", "Student", false, "22347890"));
        userList.add(new User("Dave", "Student", false, "21034675"));
    }

    private static void userMenu() {
        System.out.println("1. View all Users");
        System.out.println("2. Add a new User");
        System.out.println("3. Edit an existing User");
        System.out.println("4. Delete an existing User");
        System.out.println("6. Exit");
        System.out.println();
    }

    private static void addUser() {
        User user = getUserInput(1);
        if (user != null) {
            userList.add(user);
            System.out.println("User successfully added");
        } else {
            System.out.println("User unable to add.");
        }
    }

    private static void editUser() {
        String userId = Helper.readString("Enter the user ID of the user you want to edit: ");
        User user = getUserById(userId);
        if (user != null) {
            updateUserDetails(user);
            System.out.println("User " + userId + " details updated.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void deleteUser() {
        String userId = Helper.readString("Enter the user ID to delete: ");
        User user = getUserById(userId);
        if (user != null) {
            userList.remove(user);
            System.out.println(user.getName() + " successfully deleted.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static User getUserById(String userId) {
        for (User user : userList) {
            if (user.getUserID().equalsIgnoreCase(userId)) {
                return user;
            }
        }
        return null;
    }

    private static void updateUserDetails(User user) {
        String newName = Helper.readString("Enter new name: ");
        String newRole = Helper.readString("Enter new role: ");
        char newAdminStatus = Helper.readChar("Is the user an admin? (Y/N): ");

        user.setName(newName);
        user.setRole(newRole);
        user.setAdmin(newAdminStatus);
    }

    private static User getUserInput(int function) {
        User user = null;
        if (function == 1) {
            String name = Helper.readString("Enter user's name: ");
            String role = Helper.readString("Enter user's role: ");
            boolean admin = Helper.readBoolean("Is the user an admin? (true/false): ");
            String userId = Helper.readString("Enter user's ID: ");
            user = new User(name, role, admin, userId);
        }
        return user;
    }

    private static void viewAllUsers() {
        String format = "%-15s %-15s %-10s %-15s%n";
        String header = String.format(format, "NAME", "ROLE", "ADMIN", "USER ID");
        StringBuilder output = new StringBuilder(header);

        for (User user : userList) {
            String adminStatus = user.getAdmin() ? "Yes" : "No";
            String userLine = String.format(format, user.getName(), user.getRole(), adminStatus, user.getUserID());
            output.append(userLine);
        }

        System.out.println(output);
    }
}
