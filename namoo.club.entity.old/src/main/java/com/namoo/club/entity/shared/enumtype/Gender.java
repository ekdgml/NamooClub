package com.namoo.club.entity.shared.enumtype;

public enum Gender {
	//
	Male("M", "남자")
	,Female("F", "여자");
	
	private String code;
	private String codeName;
	
	private Gender(String code, String name) {
		//
		this.code = code;
		this.codeName = name;
	}
	
	public String code() {
		return this.code;
	}
	
	public String codeName() {
		return this.codeName;
	}

	public static Gender findBy(String genderCode) {
		// 
		for (Gender gender : values()) {
			if (gender.code().equals(genderCode)) {
				return gender;
			}
		}
		return null;
	}
}
