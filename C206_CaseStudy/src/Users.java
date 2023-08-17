public class Users {
	private String name; private String role;
	private boolean admin; private String userID;
	private char newAdminStatus; 
	
	public Users(String name, String role, boolean admin,String userID) {  
	this.name = name;
	this.admin = admin;  
	this.role = role;
	this.userID = userID; 
	}
	
	
	public String getName() 
	{  return name;
	} 
	public void setName(String name) {
		this.name = name; }
	
	public String getRole() {  
		return role;
	} 
	public void setRole(String role) {
		this.role = role; }
	
	public String getUserID() 
	{  return userID;
	} 
	public void setUserID(String userID) {
		this.userID = userID; }
	
	public boolean getAdmin() {
		return admin;
	} 
	public void setAdmin(char newAdminStatus) {  // TODO Auto-generated method stub
		this.newAdminStatus = newAdminStatus; }


}