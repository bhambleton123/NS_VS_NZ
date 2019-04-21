package models.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Character extends ImageView {
	
	private double movementSpeed;
	private double movementSpeedMultiplier;
	
	public Character(double movementSpeed, double movementSpeedMultiplier){
		this.movementSpeed = movementSpeed;
		this.movementSpeedMultiplier = movementSpeedMultiplier;
	}
	
	public double getMovementSpeed() {
		return movementSpeed;
	}
	public double getMovementSpeedMultiplier() {
		return movementSpeedMultiplier;
	}
	
	public abstract void movementAnimation();
	//The weapons and associated logic may be different depending on the character
	public abstract void createWeapons();
	public abstract void chooseWeapon();
	public abstract ImageView getCharacterImage();
	//This method is for both increasing and decreasing player health
	public abstract void changePlayerHealth();
	public abstract void killCharacter();

}
