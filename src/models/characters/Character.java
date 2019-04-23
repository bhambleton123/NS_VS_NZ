package models.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.characters.tools.AnimatedImage;

public abstract class Character extends ImageView {
	
	private double movementSpeed;
	private double movementSpeedMultiplier;
	private double health;
	
	public Character(double movementSpeed, double movementSpeedMultiplier, double health){
		this.movementSpeed = movementSpeed;
		this.movementSpeedMultiplier = movementSpeedMultiplier;
		this.health = health;
	}
	
	public Character() {
		
	}
	
	public double getMovementSpeed() {
		return movementSpeed;
	}
	
	public double getMovementSpeedMultiplier() {
		return movementSpeedMultiplier;
	}
	
	public abstract AnimatedImage getMovementAnimationLeftRight();
	//The weapons and associated logic may be different depending on the character
	public abstract void createWeapons();
	public abstract void chooseWeapon();
	public abstract ImageView getCharacterImageView();
	public abstract Image getCharacterImage();
	//This method is for both increasing and decreasing player health
	public abstract void changePlayerHealth();
	public abstract void killCharacter();

}
