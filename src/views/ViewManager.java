package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewManager {
	private AnchorPane mainPane;
	private Stage mainStage;
	private Scene mainScene;
	private final int HEIGHT = 600;
	private final int WIDTH = 600;
	
	public ViewManager() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, HEIGHT, WIDTH);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButton();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	public void createButton() {
		Button testButton = new Button();
		testButton.setLayoutX(30);
		testButton.setLayoutY(30);
		mainPane.getChildren().add(testButton);
	}
}
