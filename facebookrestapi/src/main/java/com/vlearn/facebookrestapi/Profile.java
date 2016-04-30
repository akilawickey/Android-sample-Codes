package com.vlearn.facebookrestapi;

public class Profile {
	
	private int profileID;
	private FacebookCredentials credentials;
	
	
	public int getProfileID() {
		return profileID;
	}


	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}


	public FacebookCredentials getCredentials() {
		return credentials;
	}


	public void setCredentials(FacebookCredentials credentials) {
		this.credentials = credentials;
	}


	public Profile(int profileID,FacebookCredentials credentials){
		this.profileID = profileID;
		this.credentials = credentials;		
		
	}
	

}
