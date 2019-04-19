package models;

import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;

public class GameSubScene extends SubScene	{
	
	public GameSubScene() {
		super(new AnchorPane(), 700, 500);
		prefWidth(700);
		prefHeight(500);
	}
}
