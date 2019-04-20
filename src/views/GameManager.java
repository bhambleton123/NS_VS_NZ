package views;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameManager {
	private AnchorPane gamePane;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private boolean sprint;
	
	public GameManager(){
		gamePane = new AnchorPane();
		
		initializeKeyListeners();
	}
	
	public AnchorPane getGamePane() {
		return gamePane;
	}
	
	private void initializeKeyListeners() {
		gamePane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@SuppressWarnings("incomplete-switch")
			@Override
			public void handle(KeyEvent event) {
				switch(event.getCode()) {
					case A: left = true; break;
					case S: down = true; break;
					case D: right = true; break;
					case W: up = true; break;
					case SHIFT: sprint = true; break;
				}
			}
		});
		
		gamePane.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@SuppressWarnings("incomplete-switch")
			@Override
			public void handle(KeyEvent event) {
				switch(event.getCode()) {
					case A: left = false; break;
					case S: down = false; break;
					case D: right = false; break;
					case W: up = false; break;
					case SHIFT: sprint = false; break;
				}
			}
		});
	}
}
