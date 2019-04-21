package views;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameManager {
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	boolean up, down, left, right, sprint;
	
	public GameManager(){
		initializeScene();
		initializeKeyListeners();
	}
	
	public void showGameStage(Stage stageToBeHidden) {
		stageToBeHidden.hide();
		gameStage.setResizable(false);
		gameStage.show();
	}
	
	private void initializeScene() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 1200, 800);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
	}
	
	private void initializeKeyListeners() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.A) {
					Circle circle = new Circle(30);
					circle.setLayoutX(100);
					circle.setLayoutY(100);
					gamePane.getChildren().add(circle);
					TranslateTransition move = new TranslateTransition();
					move.setDuration(Duration.seconds(.5));
					move.setNode(circle);
					move.setByY(300);
					move.play();
				}
				else if(event.getCode() == KeyCode.W) {
					up = true;
				}
				else if(event.getCode() == KeyCode.D) {
					right = true;
				}
				else if(event.getCode() == KeyCode.S) {
					down = true;
				}
			}
		});
		
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.A) {
					left = false;
				}
				else if(event.getCode() == KeyCode.W) {
					up = false;
				}
				else if(event.getCode() == KeyCode.D) {
					right = false;
				}
				else if(event.getCode() == KeyCode.S) {
					down = false;
				}
			}
		});
	}
}
