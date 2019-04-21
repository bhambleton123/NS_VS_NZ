package models.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ninja extends Character {
	
	private double movementSpeed;
	private double movementSpeedMultiplier;
	
	public Ninja(double movementSpeed, double movementSpeedMultiplier) {
		super(movementSpeed, movementSpeedMultiplier);
		getCharacterImage();
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
	public ImageView getCharacterImage() {
		return new ImageView(new Image(("/models/resources/ninja_run.png")));
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
