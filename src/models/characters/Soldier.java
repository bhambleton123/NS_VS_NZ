package models.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.characters.tools.AnimatedImage;

public class Soldier extends Character{
	
	private static double movementSpeed = 4;
	private static double movementSpeedMultiplier = 1.5;
	private static double health;

	public Soldier(double movementSpeed, double movementSpeedMultiplier, double health) {
		super(movementSpeed, movementSpeedMultiplier, health);
	}
	
	public Soldier() {
		super(movementSpeed, movementSpeedMultiplier, health);
	}
	@Override
	public AnimatedImage getMovementAnimationLeftRight() {
		Image[] images = new Image[4];
		images[0] = new Image("/models/resources/soldier/soldier_1.png");
		images[1] = new Image("/models/resources/soldier/soldier_2.png");
		images[2] = new Image("/models/resources/soldier/soldier_3.png");
		images[3] = new Image("/models/resources/soldier/soldier_2.png");
		AnimatedImage newAnimation = new AnimatedImage(images, .1);
		return newAnimation;
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
		return new ImageView(new Image(("/models/resources/soldier/soldier_2.png")));
	}

	@Override
	public Image getCharacterImage() {
		return new Image("/models/resources/soldier/soldier_2.png");
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
