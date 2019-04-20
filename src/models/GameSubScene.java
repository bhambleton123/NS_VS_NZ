package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameSubScene extends SubScene	{
	
	private boolean isHidden;
	private final String BACKGROUND_PATH = "/models/resources/game_sub_scene.png";
	private final String FONT_PATH = "src/models/resources/youmurdererbb_reg.ttf";
	private AnchorPane root2;
	private int i = 0;
	
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
		root2 = (AnchorPane) this.getRoot();
		root2.setBackground(anchorPaneBackground);
	}
	
	public void addText(String text) {
		Text score = new Text(text);
		try {
			score.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 40));
		} catch (FileNotFoundException e) {
			score.setFont(Font.font("Verdana", 40));
		}
		score.setLayoutX(100);
		score.setLayoutY(115+i);
		root2.getChildren().add(score);
		i += 55;
	}
}
