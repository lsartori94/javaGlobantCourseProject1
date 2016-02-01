package com.project.virtualPet;

/*
 * Energy of the pet. It has a max and min value where the current value
 * can be.
 */
class Energy {

	public static final int max = 100;
	public static final int min = 0;
	private int current;
	
	public Energy(int value) {
		current = value;
	}

	public int getCurrent() {
		return current;
	}

	/*
	 * Set the current energy level.
	 * Return true if the energy is 0
	 */
	public boolean setCurrent(int value) {
		current = value+current;
		boolean energyIsCero = false;
		if (current <= min) {
			current = min;
			energyIsCero = true;
		}
		else if (current > max) {
			current = max;
		}
		return energyIsCero;
	}
	
}
