package models.characters;

import java.util.concurrent.TimeUnit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Ninja extends Character {
	
	public Ninja(double movementSpeed, double movementSpeedMultiplier, double health) {
		super(movementSpeed, movementSpeedMultiplier, health);
	}

	@Override
	public Image getMovementAnimationLeftRight() {
		return new Image("/models/resources/ninja.gif");
		
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
	public ImageView getCharacterImageView() {
			return new ImageView(new Image(("/models/resources/standing_ninja.png")));
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
