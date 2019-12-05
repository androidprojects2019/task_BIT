package com.example.bit_task.Api.Model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("image")
	private String image;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"image = '" + image + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}