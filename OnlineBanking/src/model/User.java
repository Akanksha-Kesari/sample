package model;



public class User {
String fName;
String lName;
String address;


String userId;
String que;
String ans;
String password;
String confirmPassword;
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getQue() {
	return que;
}
public void setQue(String que) {
	this.que = que;
}
public String getAns() {
	return ans;
}
public void setAns(String ans) {
	this.ans = ans;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String fName, String lName, String address,  String userId, String que, String ans,
		String password, String confirmPassword) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.address = address;
	this.userId = userId;
	this.que = que;
	this.ans = ans;
	this.password = password;
	this.confirmPassword = confirmPassword;
}
@Override
public String toString() {
	return "User [fName=" + fName + ", lName=" + lName + ", address=" + address + ", userId="
			+ userId + ", que=" + que + ", ans=" + ans + ", password=" + password + ", confirmPassword="
			+ confirmPassword + "]";
}

}
