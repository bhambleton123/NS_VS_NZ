package views;

import javafx.scene.layout.AnchorPane;

public class GameManager {
	private AnchorPane gamePane;
	
	public GameManager(){
		gamePane = new AnchorPane();
	}
	
	public AnchorPane getGamePane() {
		return gamePane;
	}
}
