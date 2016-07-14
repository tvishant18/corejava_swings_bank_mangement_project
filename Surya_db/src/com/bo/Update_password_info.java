package com.bo;

public class Update_password_info {
	private String Username;
	private String Old_password;
	private String New_password;
	private String Retype_password;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getOld_password() {
		return Old_password;
	}
	public void setOld_password(String old_password) {
		Old_password = old_password;
	}
	public String getNew_password() {
		return New_password;
	}
	public void setNew_password(String new_password) {
		New_password = new_password;
	}
	public String getRetype_password() {
		return Retype_password;
	}
	public void setRetype_password(String retype_password) {
		Retype_password = retype_password;
	}
}
