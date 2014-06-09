package com.namoo.club.entity.shared.type;

public class IdName {
	//
	private String id;
	private String name;
	//------------------------------------------------------------------------------------------
	//constructor
	public IdName() {
		//
	}
	
	public IdName(String id, String name) {
		//
		this.id = id;
		this.name = name;
	}
	//------------------------------------------------------------------------------------------
	//getter, setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
