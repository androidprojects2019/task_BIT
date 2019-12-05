package com.example.bit_task.Api.Model;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("full_name")
	private String fullName;

	@SerializedName("counts")
	private Counts counts;

	@SerializedName("bio")
	private String bio;

	@SerializedName("profile_picture")
	private String profilePicture;

	@SerializedName("location")
	private String location;

	@SerializedName("id")
	private int id;

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setCounts(Counts counts){
		this.counts = counts;
	}

	public Counts getCounts(){
		return counts;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setProfilePicture(String profilePicture){
		this.profilePicture = profilePicture;
	}

	public String getProfilePicture(){
		return profilePicture;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"full_name = '" + fullName + '\'' + 
			",counts = '" + counts + '\'' + 
			",bio = '" + bio + '\'' + 
			",profile_picture = '" + profilePicture + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}