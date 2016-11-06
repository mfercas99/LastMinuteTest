package org.lastminute.services.pojo;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

	private String message;
	private List<ResultItem> resulList = new ArrayList<ResultItem>();
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ResultItem> getResulList() {
		return resulList;
	}
	public void setResulList(List<ResultItem> resulList) {
		this.resulList = resulList;
	}
	

	
}
