package models.characters;

public interface Character {
	
	public double getMovementSpeed();
	public double getMovementSpeedMultiplier();
	
	void movementAnimation();
	//The weapons and associated logic may be different depending on the character
	void createWeapons();
	void chooseWeapon();
	void getCharacterImage();
	//This method is for both increasing and decreasing player health
	void changePlayerHealth();
	void killCharacter();

}
