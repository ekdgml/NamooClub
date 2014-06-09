package com.namoo.club.entity.shared.type;

import java.util.ArrayList;
import java.util.List;

public class IdNameList {
	//
	private List<IdName> idNames;
	//------------------------------------------------------------------------------------------
	//constructor
	public IdNameList() {
		//
		this.idNames = new ArrayList<IdName>();
	}
	
	public IdNameList(List<IdName> pairs) {
		//
		this.idNames = pairs;
	}
	//------------------------------------------------------------------------------------------
	
	public void addIdName(String id, String name) {
		//
		this.idNames.add(new IdName(id, name));
	}
	
	public void addIdName(IdName pair) {
		//
		this.idNames.add(pair);
	}
	
	public List<IdName> getIdNames() {
		//
		return idNames;
	}
	
	public String getName(String id) {
		//
		IdName pair = findIdName(id);
		if (pair != null) {
			return pair.getName();
		}
		return null;
	}
	
	public boolean hasId(String id) {
		//
		return findIdName(id) != null ? true : false;
	}
	
	//--------------------------------------------------------------------------
	
		private IdName findIdName(String id) {
			//
			for (IdName idName : idNames) {
				//
				if (idName.getName().equals(id)) {
					return idName;
				}
	 		}
			return null;
		}
}
