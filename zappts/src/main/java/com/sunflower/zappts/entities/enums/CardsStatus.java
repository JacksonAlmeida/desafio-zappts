package com.sunflower.zappts.entities.enums;

public enum CardsStatus {

	LAMINATED(1),
	NOLAMINATED(2);
	
	private int code;
	
	private CardsStatus(int code ) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static CardsStatus valueOf(int code) {
		for (CardsStatus value: CardsStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid CardStatus code.");
	}
}