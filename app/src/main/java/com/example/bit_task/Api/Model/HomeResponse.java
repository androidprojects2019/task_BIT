package com.example.bit_task.Api.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HomeResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
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
			"HomeResponse{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}