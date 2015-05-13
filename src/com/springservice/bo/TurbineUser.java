package com.springservice.bo;

import java.util.Date;




public class TurbineUser {
	
	
	//private int user_id;
    
    /**
     * The value for the login_name field
     */
    private String loginname;
          
    /**
     * The value for the password_value field
     */
    private String password_value;
          
    /**
     * The value for the first_name field
     */
    private String first_name;
          
    /**
     * The value for the last_name field
     */
    private String last_name;
          
    /**
     * The value for the email field
     */
    private String email;
          
    /**
     * The value for the confirm_value field
     */
    private String confirm_value;
          
    /**
     * The value for the modified field
     */
    private Date modified;
          
    /**
     * The value for the created field
     */
    private Date created;
          
    /**
     * The value for the last_login field
     */
    private Date last_login;
          
    /**
     * The value for the disabled field
     */
    private String disabled;
          
    /**
     * The value for the objectdata field
     */
    private byte[] objectdata;
          
    /**
     * The value for the password_changed field
     */
    private Date password_changed;
  
  

		public TurbineUser(){
		   	
	    }
		/*
		public int getUserID() {
			return user_id;
		}

		public void setUserID(int userID) {
			this.user_id = userID;
		}
		*/
		public String getLoginName() {
			return loginname;
		}

		public void setLoginName(String name) {
			this.loginname = name;
		}

		public String getFName() {
			return first_name;
		}
		
		public void setFName(String fName) {
			this.first_name = fName;
		}
		
		public String getLName() {
			return last_name;
		}
		
		public void setLName(String lName) {
			this.last_name = lName;
		}


		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getConfirmValue() {
			return confirm_value;
		}

		public void setConfirmValue(String confirmvalue) {
			this.confirm_value = confirmvalue;
		}

		public Date getModified() {
			return modified;
		}

		public void setModified(Date modified) {
			this.modified = modified;
		}
		
		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}

		public Date getLastLogin() {
			return last_login;
		}

		public void setLastLogin(Date lastlogin) {
			this.last_login = lastlogin;
		}
		
		public String getDisabled() {
			return disabled;
		}

		public void setDisabled(String disabled) {
			this.disabled = disabled;
		}
		
		public byte[] getObjectdata() {
			return objectdata;
		}

		public void setObjectdata(byte[] objectdata) {
			this.objectdata = objectdata;
		}
		
		public Date getPasswordChanged() {
			return password_changed;
		}

		public void setPasswordChanged(Date passwordchanged) {
			this.password_changed = passwordchanged;
		}		
		
		public TurbineUser(int userID1, String name1, String fName1,String lName1, String email1, String confirmvalue1, Date modified1, Date created1, Date lastlogin1, String disabled1, byte[] objectdata1, Date passwordchanged1){
			super();
			//user_id = userID1;
			login_name =name1 ;
			first_name = fName1;
			last_name = lName1 ;
			email=email1;
			confirm_value = confirmvalue1;
			modified=modified1;
			created=created1;
			last_login=lastlogin1;
			disabled=disabled1;
			objectdata=objectdata1;
			password_changed=passwordchanged1;
		}

		public String getPassword_value() {
			return password_value;
		}

		public void setPassword_value(String password_value) {
			this.password_value = password_value;
		}
	}