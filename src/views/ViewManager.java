package views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.GameSubScene;
import models.MenuButton;

public class ViewManager {
	private AnchorPane mainPane;
	private Stage mainStage;
	private Scene mainScene;
	private final int WIDTH = 1200;
	private final int HEIGHT = 600;
	private final String buttonFont = "src/models/resources/youmurdererbb_reg.ttf";
	
	private GameSubScene scoresSubScene;
	private GameSubScene startSubScene;
	private GameSubScene sceneToHide;
	
	public ViewManager() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButtons();
		createBackgroundImage();
		createSubScenes();
		createTitle();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void createSubScenes()	{
		createScoresSubScene();
		createStartSubScene();
	}
	
	private void showSubScene(GameSubScene subScene) {
		if(sceneToHide != null) {
			sceneToHide.gameSceneTransition();
		}
		subScene.gameSceneTransition();
		sceneToHide = subScene;
	}
	
	private void createScoresSubScene() {
		scoresSubScene = new GameSubScene();
		File scoresFile = new File("./src/views/data/scores.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(scoresFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Integer> scoresArray = new ArrayList<Integer>();
		
		while(sc.hasNextLine() && scoresArray.size() != 10) {
			scoresArray.add(Integer.parseInt(sc.nextLine()));
		}
		
		Collections.sort(scoresArray);
		Collections.reverse(scoresArray);
		
		for(int i=0; i<8; i++) {
			scoresSubScene.addScore(Integer.toString(i+1) + ". " + Integer.toString(scoresArray.get(i)));
		}
		
		mainPane.getChildren().add(scoresSubScene);
	}
	
	private void createStartSubScene() {
		startSubScene = new GameSubScene();
		startSubScene.addStartButton(mainStage);
		startSubScene.addText("Choose character:", 85, 95);
		startSubScene.createCharacterSelection();
		mainPane.getChildren().add(startSubScene);
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
		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(startSubScene);
			}
		});
		mainPane.getChildren().add(start);
	}
	
	private void createScoresButton() {
		MenuButton scores = new MenuButton("High Scores");
		scores.setLayoutX(30);
		scores.setLayoutY(230);
		
		scores.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoresSubScene);
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
	
	private void createTitle() {
		Text titleText = new Text("NS VS NZ");
		try {
			titleText.setFont(Font.loadFont(new FileInputStream(buttonFont), 100));
		} catch (FileNotFoundException e) {
			titleText.setFont(Font.font("Verdana", 100));
		}
		titleText.setLayoutX(900);
		titleText.setLayoutY(100);
		mainPane.getChildren().add(titleText);
	}
}
