package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.characters.Character;
import models.characters.Ninja;
import models.characters.Soldier;
import views.GameManager;

public class GameSubScene extends SubScene	{
	
	private boolean isHidden;
	private final String BACKGROUND_PATH = "/models/resources/game_sub_scene.png";
	private final String FONT_PATH = "src/models/resources/youmurdererbb_reg.ttf";
	private AnchorPane root2;
	private int i = 0;
	private Character characterToReturn;
	
	public GameSubScene() {
		super(new AnchorPane(), 575, 650);
		
		prefWidth(575);
		prefHeight(650);
		
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
	
	public void addScore(String text) {
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
	
	public void addText(String text, int xPosition, int yPosition) {
		Text score = new Text(text);
		try {
			score.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 40));
		} catch (FileNotFoundException e) {
			score.setFont(Font.font("Verdana", 40));
		}
		score.setLayoutX(xPosition);
		score.setLayoutY(yPosition);
		root2.getChildren().add(score);
	}
	
	
	public void addStartButton(Stage hideStage) {
		MenuButton startButton = new MenuButton("Begin");
		startButton.setLayoutX(290);
		startButton.setLayoutY(455);
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameManager newGame = new GameManager(characterToReturn);
				newGame.showGameStage(hideStage);
				
			}
		});
		root2.getChildren().add(startButton);
	}
	
	public void createCharacterSelection() {
		VBox characterSelectionBox = new VBox(100);
		
		characterSelectionBox.setLayoutX(195);
		characterSelectionBox.setLayoutY(175);
		
		ToggleButton ninja = new ToggleButton();
		ninja.setGraphic(new Ninja().getCharacterImageView());
		ninja.setOnAction(e -> {
			characterToReturn = new Ninja();
		});
		
		ninja.setUserData("Ninja");
		
		ToggleButton soldier = new ToggleButton();
		soldier.setGraphic(new Soldier().getCharacterImageView());
		soldier.setUserData("Soldier");
		soldier.setOnAction(e -> {
			characterToReturn = new Soldier();
		});
		
		
		characterSelectionBox.getChildren().addAll(ninja, soldier);
		
		root2.getChildren().add(characterSelectionBox);
	}
}
