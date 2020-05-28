package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxBoardListJSON {
	
	int count ;
	String status;
	
	@JsonIgnore
	String memo;
	
	@JsonProperty("data")
	List<WriteDTO> list;
	
	
	

	public AjaxBoardListJSON() {
	}

	public AjaxBoardListJSON(int count, String status, String memo, List<WriteDTO> list) {
		super();
		this.count = count;
		this.status = status;
		this.memo = memo;
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<WriteDTO> getList() {
		return list;
	}

	public void setList(List<WriteDTO> list) {
		this.list = list;
	}
	
	
	
}
