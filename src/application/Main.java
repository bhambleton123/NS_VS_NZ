package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import views.ViewManager;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
			ViewManager manager = new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
