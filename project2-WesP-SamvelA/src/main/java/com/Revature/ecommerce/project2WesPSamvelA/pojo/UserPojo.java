package com.Revature.ecommerce.project2WesPSamvelA.pojo;

public class UserPojo 
{
	private int userId;
	private String userUserName;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userAddress;
	private String userEmail;
	private String userContact;
	private boolean userEmployee;
	
	public UserPojo() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPojo(String userUserName, String userPassword) 
	{
		super();
		this.userUserName = userUserName;
		this.userPassword = userPassword;
	}

	public UserPojo(int userId, String userUserName, String userPassword, 
					String userFirstName, String userLastName,String userAddress, 
					String userEmail, String userContact, boolean userEmployee) 
	{
		super();
		this.userId = userId;
		this.userUserName = userUserName;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userEmployee = userEmployee;
	}

	public int getUserId() 
	{
		return userId;
	}

	public void setUserId(int userId) 
	{
		this.userId = userId;
	}

	public String getUserUserName() 
	{
		return userUserName;
	}

	public void setUserUserName(String userUserName) 
	{
		this.userUserName = userUserName;
	}

	public String getUserPassword() 
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}

	public String getUserFirstName() 
	{
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) 
	{
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() 
	{
		return userLastName;
	}

	public void setUserLastName(String userLastName) 
	{
		this.userLastName = userLastName;
	}

	public String getUserAddress() 
	{
		return userAddress;
	}

	public void setUserAddress(String userAddress) 
	{
		this.userAddress = userAddress;
	}

	public String getUserEmail() 
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail) 
	{
		this.userEmail = userEmail;
	}

	public String getUserContact() 
	{
		return userContact;
	}

	public void setUserContact(String userContact) 
	{
		this.userContact = userContact;
	}

	public boolean isUserEmployee() 
	{
		return userEmployee;
	}

	public void setUserEmployee(boolean userEmployee) 
	{
		this.userEmployee = userEmployee;
	}

	@Override
	public String toString() 
	{
		return "UserPojo [userId=" + userId + ", userUserName=" + userUserName + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userAddress=" + userAddress + ", userEmail=" + userEmail
				+ ", userContact=" + userContact + ", userEmployee=" + userEmployee + "]";
	}

	
}
