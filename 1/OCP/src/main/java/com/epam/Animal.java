package com.epam;

public enum Animal {

	DOG ("Woof"),
	CAT("Meow"),
	DUCK("Quack");

	private final String sound;

	Animal(String sound){
		this.sound = sound;
	}

	String speak(){
		return this.sound;
	}
}
