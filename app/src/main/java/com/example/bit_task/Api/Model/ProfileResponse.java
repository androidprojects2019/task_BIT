package com.example.bit_task.Api.Model;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private boolean status;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ProfileResponse{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}