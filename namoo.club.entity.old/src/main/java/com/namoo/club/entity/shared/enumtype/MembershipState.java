package com.namoo.club.entity.shared.enumtype;

public enum MembershipState {
	//
	Requested("01", "가입신청중"),
	Rejected("02", "가입거절"),
	Active("03", "정상"),
	RequestWithdrawal("04", "탈퇴신청중"),
	Closed("05", "탈퇴");
	
	private String code;
	private String codeName;
	
	private MembershipState(String code, String codeName) {
		//
		this.code = code;
		this.codeName = codeName;
	}
	
	public String codeName() {
		return codeName;
	}

	public String code() {
		//
		return code;
	}

	public static MembershipState findBy(String code) {
		// 
		for (MembershipState state : values()) {
			if (state.code().equals(code)) {
				return state;
			}
		}
		return null;
	}
}
