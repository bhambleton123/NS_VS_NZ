package views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import models.GameSubScene;
import models.MenuButton;

public class ViewManager {
	private AnchorPane mainPane;
	private Stage mainStage;
	private Scene mainScene;
	private final int WIDTH = 1200;
	private final int HEIGHT = 600;
	
	private GameSubScene scoresSubScene;
	
	public ViewManager() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButtons();
		createBackgroundImage();
		createSubScenes();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void createSubScenes()	{
		scoresSubScene = new GameSubScene();
		mainPane.getChildren().add(scoresSubScene);
	}
	
	private void createButtons() {
		createStartButton();
		createScoresButton();
		createExitButton();
	}
	
	private void createStartButton() {
		MenuButton start = new MenuButton("Start");
		start.setLayoutX(30);
		start.setLayoutY(30);
		mainPane.getChildren().add(start);
	}
	
	private void createScoresButton() {
		MenuButton scores = new MenuButton("High Scores");
		scores.setLayoutX(30);
		scores.setLayoutY(230);
		
		scores.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				scoresSubScene.gameSceneTransition();
			}
			
		});
		mainPane.getChildren().add(scores);
	}
	
	private void createExitButton() {
		MenuButton exit = new MenuButton("Quit");
		exit.setLayoutX(30);
		exit.setLayoutY(430);
		exit.setOnAction(e -> Platform.exit());
		mainPane.getChildren().add(exit);
	}
	
	private void createBackgroundImage() {
		Image brickWall = new Image("/views/resources/brick_wall.png");
		BackgroundImage BrickWallBackgroundImage = new BackgroundImage(brickWall, null, null, null, null);
		Background brickWallBackground = new Background(BrickWallBackgroundImage);
		mainPane.setBackground(brickWallBackground);
	}
}
