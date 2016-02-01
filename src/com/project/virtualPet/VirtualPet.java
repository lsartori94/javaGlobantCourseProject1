package com.project.virtualPet;

public class VirtualPet {

	private String name;
	private Energy energy;
	private State state;
	private Humor humor;
	private final int sleepRate = 25;
	private final int upRate = 15;
	private final int downRate = 16;
	private final int actionLimit = 3;
	private final int upLimit = 5;
	private int currentActionCount;
	private int currentUpCount;
	
	public VirtualPet(String name) {
		setName(name);
		setEnergy(Energy.max);
		setHumor(Humor.NORMAL);
		setState(State.ALIVE);
		setCurrentActionCount(0);
		setCurrentUpCount(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergy() {
		return energy.getCurrent();
	}

	public boolean setEnergy(int energy) {
		evaluateEnergy(energy);
		return this.energy.setCurrent(energy);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Humor getHumor() {
		return humor;
	}

	public void setHumor(Humor humor) {
		this.humor = humor;
		System.out.println(getName()+" now is "+getHumor().toString());
	}

	public int getCurrentActionCount() {
		return currentActionCount;
	}

	public void setCurrentActionCount(int toAdd) {
		if( this.currentActionCount < actionLimit) {
			this.currentActionCount += toAdd;
		}
		else {
			this.currentActionCount = 0;
			sleep();
		}
	}

	public int getCurrentUpCount() {
		return currentUpCount;
	}

	public void setCurrentUpCount(int toAdd) {
		if( this.currentUpCount < upLimit) {
			this.currentUpCount += toAdd;
		}
		else {
			this.currentActionCount = 0;
			die();
		}
	}
	
	public void sleep() {
		setState(State.ASLEEP);
		setEnergy(sleepRate*100/getEnergy());
		setCurrentActionCount(0);
		setCurrentUpCount(0);
		System.out.println(getName()+" is asleep, you must wake it up before doing something.");
	}
	
	public void die() {
		setState(State.DEAD);
		System.out.println(getName()+" has died.");
	}
	
	public void eat() {
		if (getState() != State.ASLEEP) {
			setEnergy(upRate*100/getEnergy());
			setCurrentActionCount(1);
			setCurrentUpCount(1);
			System.out.println(getName()+" is eating.");
		}
		else {
			System.out.println(getName()+ " is sleeping. You must wake it up first");
		}
	}
	
	public void drink() {
		if (getState() != State.ASLEEP) {
			setEnergy(upRate*100/getEnergy());
			setCurrentActionCount(1);
			setCurrentUpCount(1);
			System.out.println(getName()+" is drinking.");
		}
		else {
			System.out.println(getName()+ " is sleeping. You must wake it up first");
		}
	}
	
	public void wakeUp() {
		if (getState() != State.ASLEEP) {
			setState(State.ALIVE);
			System.out.println(getName()+" is awake. Now you can tell it to do something.");
		}
		else {
			System.out.println(getName()+ " is not sleeping.");
		}		
	}
	
	public void walk() {
		if (getState() != State.ASLEEP) {
			setEnergy(-(downRate*100/getEnergy()));
			setCurrentActionCount(1);
			System.out.println(getName()+" is walking.");
		}
		else {
			System.out.println(getName()+ " is sleeping. You must wake it up first");
		}
	}
	
	public void run() {
		if (getState() != State.ASLEEP) {
			setEnergy(-(downRate*100/getEnergy()));
			setCurrentActionCount(1);
			System.out.println(getName()+" is running.");
		}
		else {
			System.out.println(getName()+ " is sleeping. You must wake it up first");
		}
	}
	
	public void jump() {
		if (getState() != State.ASLEEP) {
			setEnergy(-(downRate*100/getEnergy()));
			setCurrentActionCount(1);
			System.out.println(getName()+" is jumping.");
		}
		else {
			System.out.println(getName()+ " is sleeping. You must wake it up first");
		}
	}
	
	private void evaluateEnergy(int num) {
		if (num >= 90){
			// Very happy
			if (getHumor() != Humor.VERY_HAPPY){
				setHumor(Humor.VERY_HAPPY);
			}
		}
		if (num < 90 && num > 79) {
			// Happy
			if (getHumor() != Humor.HAPPY){
				setHumor(Humor.HAPPY);
			}
		}
		if (num < 80 && num > 29) {
			// Normal
			if (getHumor() != Humor.NORMAL){
				setHumor(Humor.NORMAL);
			}
		}
		if (num < 30 && num > 9) {
			// Sad
			if (getHumor() != Humor.SAD){
				setHumor(Humor.SAD);
			}
		}
		if (num < 10 && num > 0) {
			// Very Sad
			if (getHumor() != Humor.VERY_SAD){
				setHumor(Humor.VERY_SAD);
			}
		}
	}
	
}
