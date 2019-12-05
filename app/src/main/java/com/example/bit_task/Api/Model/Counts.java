package com.example.bit_task.Api.Model;

import com.google.gson.annotations.SerializedName;

public class Counts{

	@SerializedName("followers")
	private int followers;

	@SerializedName("following")
	private int following;

	@SerializedName("posts")
	private int posts;

	public void setFollowers(int followers){
		this.followers = followers;
	}

	public int getFollowers(){
		return followers;
	}

	public void setFollowing(int following){
		this.following = following;
	}

	public int getFollowing(){
		return following;
	}

	public void setPosts(int posts){
		this.posts = posts;
	}

	public int getPosts(){
		return posts;
	}

	@Override
 	public String toString(){
		return 
			"Counts{" + 
			"followers = '" + followers + '\'' + 
			",following = '" + following + '\'' + 
			",posts = '" + posts + '\'' + 
			"}";
		}
}