package models.characters;

import javafx.scene.image.Image;

public class Ninja implements Character {
	
	private double movementSpeed;
	private double movementSpeedMultiplier;
	
	public Ninja(double movementSpeedInput, double movementSpeedMultiplierInput) {
		this.movementSpeed = movementSpeedInput;
		this.movementSpeedMultiplier = movementSpeedMultiplierInput;
	}

	@Override
	public double getMovementSpeed() {
		return movementSpeed;
	}

	@Override
	public double getMovementSpeedMultiplier() {
		return movementSpeedMultiplier;
	}

	@Override
	public void movementAnimation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createWeapons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseWeapon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getCharacterImage() {
		return null;
		
	}

	@Override
	public void changePlayerHealth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killCharacter() {
		// TODO Auto-generated method stub
		
	}

}
