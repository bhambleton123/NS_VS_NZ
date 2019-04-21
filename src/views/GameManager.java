package views;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
	private Node node;
	
	public GameManager(){
		initializeScene();
		node = new Circle(30);
		node.setLayoutX(300);
		node.setLayoutY(300);
		gamePane.getChildren().add(node);
		initializeKeyListeners();
		createGameLoop();
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
					// Just a test to see how the listeners work
					left = true;
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
	
	private void createGameLoop() {
		AnimationTimer gameTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				moveObject();
			}
		};
		gameTimer.start();
	}
	
	private void moveObject() {
		int speed = 6;
		if(up && !down) {
			node.setLayoutY(node.getLayoutY()-speed);
		}
		if(down && !up) {
			node.setLayoutY(node.getLayoutY()+speed);
		}
		if(right && !left) {
			node.setLayoutX(node.getLayoutX()+speed);
		}
		if(left && !right) {
			node.setLayoutX(node.getLayoutX()-speed);
		}
	}
}
