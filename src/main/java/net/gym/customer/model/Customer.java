package net.gym.customer.model;


public class Customer {
	private String id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
	public Customer(String id2,String firstName2, String lastName2, String password2, String email2) {
		id = id2;
		firstName = firstName2;
		lastName = lastName2;
		password = password2;
		email = email2;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getId() {
		return id;	}
	public void setId(String input)
	{
		id= input; 
	}
}
