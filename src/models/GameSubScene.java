package models;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class GameSubScene extends SubScene	{
	
	private boolean isHidden;
	
	public GameSubScene() {
		super(new AnchorPane(), 700, 500);
		prefWidth(700);
		prefHeight(500);
		
		setLayoutX(300);
		setLayoutY(1000);
		
		isHidden = true;
	}
	
	public void gameSceneTransition() {
		TranslateTransition gameTransition = new TranslateTransition();
		gameTransition.setDuration(Duration.seconds(0.6));
		gameTransition.setNode(this);
		if(isHidden) {
			gameTransition.setToY(-950);
			isHidden = false;
		}
		else {
			gameTransition.setToY(950);
			isHidden = true;
		}
		gameTransition.play();
	}
}
