package views;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.characters.Character;
import models.characters.Ninja;

public class GameManager {
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	boolean up, down, left, right, sprint;
	private ImageView node;
	private Character newCharacter;
	private long startNanoTime = System.nanoTime();
	
	public GameManager(){
		initializeScene();
		newCharacter = new Ninja(6,2, 100);
		node = newCharacter.getCharacterImageView();
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
				else if(event.getCode() == KeyCode.SHIFT) {
					sprint = true;
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
				else if(event.getCode() == KeyCode.SHIFT) {
					sprint = false;
				}
			}
		});
	}
	
	private void createGameLoop() {
		AnimationTimer gameTimer = new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {
				double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
				moveObject();
				if(left || right) {
				node.setImage(newCharacter.getMovementAnimationLeftRight().getFrame(t));
				}
				else {
					node.setImage(newCharacter.getCharacterImage());
				}
			}
		};
		gameTimer.start();
	}
	
	private void moveObject() {
		double speed = newCharacter.getMovementSpeed();
		if(sprint) {
			speed *= newCharacter.getMovementSpeedMultiplier();
		}
		if(up && !down) {
			node.setLayoutY(node.getLayoutY()-speed);
		}
		if(down && !up) {
			node.setLayoutY(node.getLayoutY()+speed);
		}
		if(right && !left) {
			node.setScaleX(1);
			node.setLayoutX(node.getLayoutX()+speed);
		}
		if(left && !right) {
			node.setScaleX(-1);
			node.setLayoutX(node.getLayoutX()-speed);
		}
	}
	
}
