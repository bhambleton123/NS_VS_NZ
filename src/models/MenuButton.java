package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class MenuButton extends Button {
	
	private final String buttonPressedStyle = "-fx-background-color:transparent; -fx-background-image: url('/models/resources/clicked_on.png')";
	private final String buttonReleasedStyle = "-fx-background-color:transparent; -fx-background-image: url('/models/resources/unclicked.png')";
	private final String buttonFont = "src/models/resources/youmurdererbb_reg.ttf";
	
	public MenuButton(String text) {
		setText(text);
		setMenuButtonFont();
		setMinWidth(205);
		setMinHeight(58);
		setStyle(buttonReleasedStyle);
		mouseButtonListener();
	}
	
	private void setMenuButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(buttonFont), 30));
		}
		catch(FileNotFoundException e) {
			setFont(Font.font("Verdana", 23));
		}
	}
	
	private void menuButtonReleasedStyle() {
		setStyle(buttonReleasedStyle);
		setLayoutY(getLayoutY()-4);
	}
	
	private void menuButtonPressedStyle() {
		setStyle(buttonPressedStyle);
		setLayoutY(getLayoutY()+4);
	}

	private void mouseButtonListener() {
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					menuButtonPressedStyle();
				}
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					menuButtonReleasedStyle();
				}
			}
		});
	}
}