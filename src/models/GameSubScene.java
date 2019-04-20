package models;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.util.Duration;

public class GameSubScene extends SubScene	{
	
	private boolean isHidden;
	private final String BACKGROUND_PATH = "/models/resources/game_sub_scene.png";
	
	public GameSubScene() {
		super(new AnchorPane(), 575, 700);
		
		prefWidth(575);
		prefHeight(700);
		
		setLayoutX(300);
		setLayoutY(1000);
		
		createBackground(); 
		
		isHidden = true;
	}
	
	public void gameSceneTransition() {
		TranslateTransition gameTransition = new TranslateTransition();
		gameTransition.setDuration(Duration.seconds(0.6));
		gameTransition.setNode(this);
		if(isHidden) {
			gameTransition.setToY(-993);
			isHidden = false;
		}
		else {
			gameTransition.setToY(993);
			isHidden = true;
		}
		gameTransition.play();
	}
	
	private void createBackground() {
		Image background = new Image(BACKGROUND_PATH);
		BackgroundImage backgroundImage = new BackgroundImage(background, null, null, null, null);
		Background anchorPaneBackground = new Background(backgroundImage);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(anchorPaneBackground);
	}
}
