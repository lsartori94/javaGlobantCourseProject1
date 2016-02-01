package com.project.virtualPet;

enum Humor {

	VERY_HAPPY(5),
	HAPPY(4),
	NORMAL(3),
	SAD(2),
	VERY_SAD(1);
	
	int value;
	
	private Humor(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		switch (value) {
		case 1:
			return "very sad";
		case 2:
			return "sad";
		case 3:
			return "normal";
		case 4:
			return "happy";
		default:
			return "very happy";
		}
	}
}
