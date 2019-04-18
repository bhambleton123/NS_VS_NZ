package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.MenuButton;

public class ViewManager {
	private AnchorPane mainPane;
	private Stage mainStage;
	private Scene mainScene;
	private final int WIDTH = 1200;
	private final int HEIGHT = 600;
	
	public ViewManager() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButtons();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	public void createButtons() {
		MenuButton button = new MenuButton("Start");
		button.setLayoutX(30);
		button.setLayoutY(30);
		
		MenuButton button2 = new MenuButton("High Scores");
		button2.setLayoutX(30);
		button2.setLayoutY(200);
		
		MenuButton button3 = new MenuButton("Quit");
		button3.setLayoutX(30);
		button3.setLayoutY(370);
		mainPane.getChildren().addAll(button, button2, button3);
	}
}
