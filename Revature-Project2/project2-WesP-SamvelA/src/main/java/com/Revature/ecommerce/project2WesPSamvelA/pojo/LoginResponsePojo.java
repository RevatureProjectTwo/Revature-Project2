package com.Revature.ecommerce.project2WesPSamvelA.pojo;

public class LoginResponsePojo {

	private String token;
  
	public LoginResponsePojo() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginResponsePojo(String token) 
	{
		super();
		this.token = token;
	}


	public String getToken() 
	{
		return token;
	}

  public void setToken(String token)
  {
    this.token = token;
  }
}
