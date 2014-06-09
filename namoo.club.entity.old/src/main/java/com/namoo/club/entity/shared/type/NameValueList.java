package com.namoo.club.entity.shared.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class NameValueList {
	//
	private List<NameValue> nameValues;
	
	//--------------------------------------------------------------------------
	
	public NameValueList() {
		//
		this.nameValues = new ArrayList<NameValue>();
	}
	
	public NameValueList(List<NameValue> nameValues) {
		// 
		this.nameValues = nameValues;
	}
	
	//--------------------------------------------------------------------------

	public void addNameValue(String name, String value) {
		//
		this.nameValues.add(new NameValue(name, value));
	}
	
	public void addNameValue(NameValue pair) {
		//
		this.nameValues.add(pair);
	}
	
	public List<NameValue> getNameValues() {
		//
		return nameValues;
	}
	
	public String getValue(String name) {
		//
		NameValue pair = findNameValue(name);
		if (pair != null) {
			return pair.getValue();
		}
		return null;
	}
	
	public boolean hasName(String name) {
		//
		return findNameValue(name) != null ? true : false;
	}
	
	public String toJson() {
		//
		return new Gson().toJson(nameValues);
	}
	
	public static NameValueList fromJson(String json) {
		//
		NameValue[] nameValues = new Gson().fromJson(json, NameValue[].class);
		return new NameValueList(Arrays.asList(nameValues));
	}
	
	//--------------------------------------------------------------------------
	
	private NameValue findNameValue(String name) {
		//
		for (NameValue nameValue : nameValues) {
			//
			if (nameValue.getName().equals(name)) {
				return nameValue;
			}
 		}
		return null;
	}
	
}
